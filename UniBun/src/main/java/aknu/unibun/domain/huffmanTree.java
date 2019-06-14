/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import aknu.unibun.io.UniBunInput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * This class builds the Huffman Tree.
 *
 * @author aknu
 */
public class huffmanTree {

    HashMap<Byte, Byte> symbolsInBinary = new HashMap();
    Comparator<Node> leafComp = new LeafComparatorMax();
    frequencyCalculator freq1;
    Node tempLeaf;
    Node root;
    PriorityQueue tempHeap1;
    PriorityQueue tempHeap2;
    UniBunInput ubi;
    private byte[] input;
    int recurseCount = 0;
    Byte b0 = new Byte("0");
    Byte b1 = new Byte("1");
    int recurseHelper = 0;

    public huffmanTree() throws Exception {
        this.freq1 = new frequencyCalculator();
        UniBunInput ubi = new UniBunInput();

    }

    /**
     * Given a heap of symbol-nodes (Node), this method sorts the nodes into a
     * Huffman Tree, so that polling the heap returns the highest probability
     * Node.
     *
     * @param tempHeap heap for sorting the input heap's contents into a Huffman
     * Tree.
     * @param tempLeaf temporary Node for handling the polled node.
     * @param inputHeap
     */
    public void sortToMaxTree(PriorityQueue inputHeap, byte[] input) {
        this.input = input;
        tempHeap1 = new PriorityQueue(50, leafComp);
        tempHeap2 = new PriorityQueue(50, leafComp);

        while (inputHeap.size() > 1) {

            Byte nb = new Byte("0");
            Node combLeaf = new Node(nb, 0);

            tempLeaf = (Node) inputHeap.poll();

            combLeaf.setLeft(tempLeaf);
            this.symbolsInBinary.put(tempLeaf.getSymbol(), b1);

            byte combSymb = tempLeaf.getSymbol();
            Double combProb = tempLeaf.getProbability();
            tempLeaf = (Node) inputHeap.poll();

            combLeaf.setRight(tempLeaf);
            this.symbolsInBinary.put(tempLeaf.getSymbol(), b0);

            combProb += tempLeaf.getProbability();
            combLeaf.setProbability(combProb);

            Byte combByte = combineBits(tempLeaf.getSymbol(), combSymb);
            combLeaf.setSymbol(combByte);

            if (!tempHeap1.contains(combLeaf)) {
                tempHeap1.add(combLeaf);
                tempHeap2.add(combLeaf);
            }
            inputHeap.add(combLeaf);

        }

        encodeTree();

    }

    /**
     * Given bytes no1 and no2, the method makes a combined byte for the tree.
     *
     * @param no1
     * @param no2
     * @return
     */
    public Byte combineBits(Byte no1, Byte no2) {
        Byte rb;

        if (Objects.equals(no2, b0)) {
            int i = (no1 << b1);

            rb = (byte) i;
        } else {
            int i = (no1 << b1);
            i = i + 1;

            rb = (byte) i;
        }
        return rb;
    }

    public Byte combineFunkyBits(Byte no1, Byte no2) {
        Byte rb;

        if (Objects.equals(no2, b0)) {
            int i = (no1 << b1);

            rb = (byte) i;
        } else {
            int i = (no1 << b1);
            i = i + 1;

            rb = (byte) i;
        }

        return rb;
    }

    public PriorityQueue getMaxTree() {
        return tempHeap1;
    }

    /**
     * The method traverses the Huffman tree and forms the Huffman coded
     * bit-sequences of varied length
     *
     * @param root
     * @param huffBin
     */
    public void recurseTree(Node root, Byte huffBin) {

        if (root.getLeft() != null) {
            recurseTree(root.getLeft(), combineFunkyBits(huffBin, b1));
        }
        if (root.getRight() != null) {
            recurseTree(root.getRight(), combineFunkyBits(huffBin, b0));
        } else {
            this.symbolsInBinary.put(root.getSymbol(), huffBin);
        }

    }

    /**
     * With recursion, encodes the tree
     */
    public void encodeTree() {

        Node root = (Node) tempHeap1.peek();

        recurseTree(root, b1);

    }

    /**
     * Returns the original input in a Huffman-coded form for compression rate
     * calculations
     *
     * @param s3 the original input
     * @param s4 compressed-input string in binary
     * @return returns the compressed string in binary
     */
    public String getCompString() throws Exception {
        String s4 = "";
        byte[] s3 = this.input;
        Byte c3;
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < s3.length; l++) {
            c3 = s3[l];
            int i = (int) this.symbolsInBinary.get(c3);
            //System.out.println("Tämmönen tavu löyty tältä " + i + ". indeksiin: " + this.symbolsInBinary.get(c3));
            s4 = Integer.toBinaryString(i);
            sb.append(s4);
        }
        s4 = sb.toString();
        return s4;
    }

    public byte[] getByteArray() {
        byte[] bytes = new byte[this.input.length];
        Byte b;

        for (int l = 0; l < bytes.length; l++) {
            b = this.input[l];
            bytes[l] = this.symbolsInBinary.get(b);

        }

        return bytes;
    }

    /**
     * The method decodes Huffman compressed byte arrays
     *
     * @param s3 is read for the individual '0' and '1' which determine what to
     * look for in the Huffman-tree
     * @param s4 The decoded byte array.
     * @param tempHeap2 A copy of the Huffman-tree that was built before using
     * the original in the encoding.
     * @param tempLeaf Temporary Node for handling the Huffman-tree
     * @param zeroesHandled A boolean for determining whether the long sequence
     * of zeroes has been handled.
     * @return
     * @throws Exception
     */
    public byte[] decodeTree() throws Exception {

        byte[] s3 = getByteArray();

        byte[] s4 = new byte[this.input.length];
        boolean zeroesHandled = false;
        int i = 0;
        int j = 0;
        boolean isFirst = true;
        tempLeaf = (Node) tempHeap2.poll();
        root = tempLeaf;
        System.out.println("");
        while (i < s3.length) {

            while ((((128 >> j) & s3[i]) == 0) && !zeroesHandled) {

                j++;
            }

            zeroesHandled = true;

            if (tempLeaf.getLeft() == null && tempLeaf.getRight() == null) {
                s4[i] = tempLeaf.getSymbol();

                tempLeaf = root;
                i++;

                if (i == s3.length) {
                    break;
                }
                zeroesHandled = false;
                isFirst = true;
                j = 0;

            } else if (((128 >> j) & s3[i]) != 0) {

                if (!isFirst) {

                    tempLeaf = tempLeaf.getLeft();
                }
                isFirst = false;
                j++;
            } else {

                tempLeaf = tempLeaf.getRight();
                j++;
            }

        }
        return s4;
    }
}
