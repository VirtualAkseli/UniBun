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
    String[] huffmanCodes = new String[256];
    Comparator<Node> leafComp = new LeafComparatorMax();
    FrequencyCalculator freq1;
    Node tempLeaf;
    Node root;
    PriorityQueue tempHeap1;
    PriorityQueue tempHeap2;
    UniBunInput ubi;
    byte[] input;
    byte[] array1;
    int recurseCount = 0;
    Byte b0 = new Byte("0");
    Byte b1 = new Byte("1");
    int recurseHelper = 0;
    String s4 = "";

    public huffmanTree(byte[] in) throws Exception {
        this.freq1 = new FrequencyCalculator();
       
        Comparator<Node> comp = new LeafComparator();
        PriorityQueue freqHeap = new PriorityQueue(50, comp);
        this.input = freq1.getInput();
        freqHeap = this.freq1.frequencyCalculator(in);
        sortToMaxTree(freqHeap);

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
    public void sortToMaxTree(PriorityQueue inputHeap) {
        
        tempHeap1 = new PriorityQueue(50, leafComp);
        tempHeap2 = new PriorityQueue(50, leafComp);

        while (inputHeap.size() > 1) {

            Byte nb = new Byte("0");
            Node combLeaf = new Node(nb, 0);

            tempLeaf = (Node) inputHeap.poll();

            combLeaf.setLeft(tempLeaf);
            huffmanCodes[Byte.toUnsignedInt(tempLeaf.getSymbol())] = "1";

            byte combSymb = tempLeaf.getSymbol();
           int combProb = tempLeaf.getProbability();
            tempLeaf = (Node) inputHeap.poll();

            combLeaf.setRight(tempLeaf);
            huffmanCodes[Byte.toUnsignedInt(tempLeaf.getSymbol())] = "0";
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
     * With recursion, encodes the tree
     */
    public void encodeTree() {

        Node root = (Node) tempHeap1.peek();

        recurseTree(root, "");

        
    }
    
    
    /**
     * The method traverses the Huffman tree and forms the Huffman coded
     * bit-sequences of varied length
     *
     * @param root
     * @param huffBin
     */
    public void recurseTree(Node root, String bit) {

        if (root.getLeft() != null) {
            recurseTree(root.getLeft(), combineStringBits(bit, "1"));
        }
        if (root.getRight() != null) {
            recurseTree(root.getRight(), combineStringBits(bit, "0"));
        } else {
            huffmanCodes[Byte.toUnsignedInt(root.getSymbol())] = bit;
        }

    }
    
    /**
     * Given bytes no1 and no2, the method makes a combined nodebyte for the tree.
     *
     * @param no1
     * @param no2
     * @return
     */
    public Byte combineBits(Byte no1, Byte no2) {
        Byte rb;

        if (Objects.equals(Byte.toUnsignedInt(no2), Byte.toUnsignedInt(b0))) {
            int i = (Byte.toUnsignedInt(no1) << Byte.toUnsignedInt(b1));

            rb = (byte) i;
        } else {
            int i = (Byte.toUnsignedInt(no1) << Byte.toUnsignedInt(b1));
            i = i + 1;

            rb = (byte) i;
        }
        return rb;
    }

    public String combineStringBits(String no1, String no2) {
        String rb;
        String temp;
            rb = no1;
            temp = rb + no2;
            rb = temp;
        
        return rb;
    }

    
    public PriorityQueue getMaxTree() {
        return tempHeap1;
    }



    /**
     * Returns the original input in a 
     * Huffman-coded form for compression 
     * rate calculations
     * 
     * @param s3 the original input
     * @param s4 compressed-input string in binary
     * @return returns the compressed string in binary
     */
    public String getCompString() throws Exception {
        
        byte[] s3 = freq1.getInput();
        int c3;
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < s3.length; l++) {
            c3 = Byte.toUnsignedInt(s3[l]);
            String i = huffmanCodes[c3];
           
            sb.append(i);
           
        }
        s4 = sb.toString();
        return s4;
    }

    public String[] getHuffmanStringArray() {
        String[] bytes = new String[freq1.getInput().length];
        int b;
        String c;

        for (int l = 0; l < bytes.length; l++) {
            b = Byte.toUnsignedInt(freq1.getInput()[l]);
            
            c = huffmanCodes[b];
            
            bytes[l] = c;

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

        
        
       
        
        
        String[] s3 = getHuffmanStringArray();
        
        byte[] a1 = new byte[freq1.getInput().length];
        boolean zeroesHandled = false;
        int i = 0;
        int j = 0;
        boolean isFirst = true;
        int soutOutFirsttwenty = 0;
        tempLeaf = (Node) tempHeap2.poll();
        root = tempLeaf;
        System.out.println("");
        
        while (i < s3.length) {
             
            
           
           
           
            if (tempLeaf.getLeft() == null && tempLeaf.getRight() == null) {
                a1[i] = tempLeaf.getSymbol();

                tempLeaf = root;
                i++;

                if (i == s3.length) {
                    break;
                }
                zeroesHandled = false;
                isFirst = true;
                j = 0;
                
                
                
                
            } else if (s3[i].charAt(j) == '1') {
                
                  tempLeaf = tempLeaf.getLeft();
                
           
                j++;
            } else {
                
                tempLeaf = tempLeaf.getRight();
                j++;
            }

        }
        return a1;
    }
    
    public byte[] getCompByteArray() throws Exception {
        String huffBytes = getCompString();
        int size = huffBytes.length() /8;
        int j = 0;
        byte[] compBytes = new byte[size];
        byte temp;
      
        for (int i = 0; i< huffBytes.length(); i++) {
            if (i != 0 && i%8==0) {
                j++;
            }
            if (huffBytes.charAt(i) == '1') {
                temp = (byte) (compBytes[j] << 1);
                temp = (byte) (temp + 1);
                compBytes[j] = temp;
            } else {
                temp = (byte) (compBytes[j] << 1);
                compBytes[j] = temp;
            }
            
        }
        return compBytes;
    }
}
