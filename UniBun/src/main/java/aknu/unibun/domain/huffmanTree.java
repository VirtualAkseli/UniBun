/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import aknu.unibun.io.UniBunInput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * This class builds the Huffman Tree.
 *
 * @author aknu
 */
public class huffmanTree {

    HashMap<Byte, Byte> symbolsInBinary = new HashMap();
    Comparator<Leaf> leafComp = new LeafComparatorMax();
    frequencyCalculator freq1;
    Leaf tempLeaf;
    Leaf root;
    PriorityQueue tempHeap1;
    PriorityQueue tempHeap2;
    UniBunInput ubi;
    private byte[] input;
    int recurseCount = 0;
    Byte b0 = new Byte("0");
    Byte b1 = new Byte("1");

    public huffmanTree() throws Exception {
        this.freq1 = new frequencyCalculator();
        UniBunInput ubi = new UniBunInput();

    }

    /**
     * Given a heap of symbol-nodes (Leaf), this method sorts the nodes into a
     * Huffman Tree, so that polling the heap returns the highest probability
     * Leaf.
     *
     * @param tempHeap heap for sorting the input heap's contents into a Huffman
     * Tree.
     * @param tempLeaf temporary Leaf for handling the polled node.
     * @param inputHeap
     */
    public void sortToMaxTree(PriorityQueue inputHeap, byte[] input) {
        this.input = input;
        tempHeap1 = new PriorityQueue(50, leafComp);
        tempHeap2 = new PriorityQueue(50, leafComp);

        while (inputHeap.size() > 1) {
            Byte nb = new Byte("0");
            Leaf combLeaf = new Leaf(new Byte(nb), 0);

            tempLeaf = (Leaf) inputHeap.poll();

            combLeaf.setLeft(tempLeaf);
            this.symbolsInBinary.put(tempLeaf.getSymbol(), b1);

            byte combSymb = tempLeaf.getSymbol();
            Double combProb = tempLeaf.getProbability();
            tempLeaf = (Leaf) inputHeap.poll();

            combLeaf.setRight(tempLeaf);
            this.symbolsInBinary.put(tempLeaf.getSymbol(), b0);

            combProb += tempLeaf.getProbability();
            combLeaf.setProbability(combProb);

            Byte combByte = combineBits(tempLeaf.getSymbol(), combSymb);
            //System.out.println("combByte is: " + Integer.toBinaryString(Byte.toUnsignedInt(combSymb)));
            combLeaf.setSymbol(combByte);

            if (!tempHeap1.contains(combLeaf)) {
                tempHeap1.add(combLeaf);
                tempHeap2.add(combLeaf);
            }
            inputHeap.add(combLeaf);

        }

        encodeTree();

    }

    public Byte combineBits(Byte no1, Byte no2) {
        Byte rb;

        if (no2 == b0) {
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

        if (no2 == b0) {
            int i = (no1 << b1);

            rb = (byte) i;
        } else {
            int i = (no1 << b1);
            i = i + 1;

            rb = (byte) i;
        }

        return rb;
    }

    /**
     * This method gathers the Huffman coded binary strings for every symbol of
     * the tree's nodes.
     *
     */
    public PriorityQueue getMaxTree() {
        return tempHeap1;
    }

    public void recurseTree(Leaf root, Byte huffBin) {
        if (root.getLeft() != null) {
            System.out.println("bin is 1");
            recurseTree(root.getLeft(), combineFunkyBits(huffBin, b1));
        }
        if (root.getRight() != null) {
            System.out.println("bin is 0");
            recurseTree(root.getRight(), combineFunkyBits(huffBin, b0));
        } else {
            System.out.println("GOT HERE! " + " Symbol: " + (char) root.getSymbol() + " Binary: " + Integer.toBinaryString(Byte.toUnsignedInt(huffBin)).substring(1));
            this.symbolsInBinary.put(root.getSymbol(), huffBin);
        }
    }

    /**
     * Gathers an HashMap of the newly Huffmanised symbols
     *
     * @param symbolsInBinary. HashMap containing a symbol as the key and the
     * newly set binary representation as its value
     * @param binary the Huffman-binary that is set as a symbols value in the
     * HashMap
     *
     *
     */
    public void encodeTree() {

        Leaf root = (Leaf) tempHeap1.peek();

        recurseTree(root, b1);

        while (!tempHeap1.isEmpty()) {

            tempLeaf = (Leaf) tempHeap1.poll();

            //test print 
            System.out.println(tempLeaf.toString()
                    + ". Lapset: vasen: "
                    + (char) tempLeaf.getLeft().getSymbol() + ":"
                    + tempLeaf.getLeft().getProbability()
                    + " , oikea: "
                    + (char) tempLeaf.getRight().getSymbol() + ":"
                    + tempLeaf.getRight().getProbability());

        }

        //print final Huffman binary for symbols
        for (Byte name : this.symbolsInBinary.keySet()) {
            String key = name.toString();
            String value = this.symbolsInBinary.get(name).toString();

            System.out.println(key + " : " + value);

        }

    }

    /**
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
            s4 = Integer.toBinaryString(i);
            sb.append(s4.substring(1));
        }
        s4 = sb.toString();
        return s4;
    }

    public byte[] getByteArray() {
        byte[] bytes = new byte[this.input.length];
        Byte c3;

        for (int l = 0; l < this.input.length; l++) {

            bytes[l] = this.symbolsInBinary.get(this.input[l]);

        }

        return bytes;
    }

    /**
     * This method decodes Huffman coded input-string
     *
     * @param s3 is read for the individual '0' and '1' which determine what to
     * look for in the Huffman-tree
     * @param s4 The decoded string.
     * @param tempHeap2 A copy of the Huffman-tree that was built before using
     * the original in the encoding.
     * @param tempLeaf Temporary Leaf for handling the Huffman-tree
     * @return
     * @throws Exception
     */
    public byte[] decodeTree() throws Exception {

        byte[] s3 = getByteArray();
        byte[] s4 = new byte[7];

        int i = 0;
        int j = 1;
        
        tempLeaf = (Leaf) tempHeap2.poll();
        root = tempLeaf;

        while (i < s3.length) {

            
            if (tempLeaf.getLeft() == null && tempLeaf.getRight() == null) {

                s4[i] = tempLeaf.getSymbol();
                System.out.println("taulukkoon lisättiin: " + s4[i]);
                tempLeaf = root;
                i++;
                if (i == s3.length) {
                    break;
                }
                j = 1;
               
            }

            if (((s3[i] >> j) & 1) != 0) {
                System.out.println(s3[i]);
                System.out.println("Left turn");
                tempLeaf = tempLeaf.getLeft();
                j++;
            } else {
                System.out.println(s3[i]);
                System.out.println("Right turn");
                tempLeaf = tempLeaf.getRight();
                j++;
            }

        }
        return s4;
    }
}
