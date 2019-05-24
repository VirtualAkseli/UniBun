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

    HashMap<String, String> symbolsInBinary = new HashMap();
    Comparator<Leaf> leafComp = new LeafComparatorMax();
    frequencyCalculator freq1;
    Leaf tempLeaf;
    Leaf root;
    PriorityQueue tempHeap1;
    PriorityQueue tempHeap2;
    UniBunInput ubi;
    private String input;

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
    public void sortToMaxTree(PriorityQueue inputHeap, String input) {
        this.input = input;
        tempHeap1 = new PriorityQueue(50, leafComp);
        tempHeap2 = new PriorityQueue(50, leafComp);

        while (inputHeap.size() > 1) {

            Leaf combLeaf = new Leaf("", 0);

            tempLeaf = (Leaf) inputHeap.poll();

            combLeaf.setLeft(tempLeaf);
            this.symbolsInBinary.put(tempLeaf.getSymbol(), "1");
           
            String combSymb = tempLeaf.getSymbol().toString();
            Double combProb = tempLeaf.getProbability();
            tempLeaf = (Leaf) inputHeap.poll();

            combLeaf.setRight(tempLeaf);
            this.symbolsInBinary.put(tempLeaf.getSymbol(), "0");
            
            combProb += tempLeaf.getProbability();
            combLeaf.setProbability(combProb);
            combLeaf.setSymbol(tempLeaf.getSymbol() + combSymb);

            if (!tempHeap1.contains(combLeaf)) {
                tempHeap1.add(combLeaf);
                tempHeap2.add(combLeaf);
            }
            inputHeap.add(combLeaf);

        }

        encodeTree();

    }

    /**
     * This method gathers the Huffman coded binary strings for every symbol of
     * the tree's nodes.
     *
     */
    
    public PriorityQueue getMaxTree() {
        return tempHeap1;
    }
    /**
     * Gathers an HashMap of the newly Huffmanized symbols
     * @param symbolsInBinary. HashMap containing a symbol as the key
     * and the newly set binary representation as its value
     * @param binary the Huffman-binary that is set as a symbols value in the 
     * HashMap
     * 
     * 
     */
    public void encodeTree() {

        while (!tempHeap1.isEmpty()) {
            tempLeaf = (Leaf) tempHeap1.poll();

            if (tempLeaf.getLeft() != null) {
                
                for (int j = 0; j < tempLeaf.getLeft().getSymbol().length(); j++) {
                    Character binaryKey = tempLeaf.getSymbol().charAt(j);
                    String binary = this.symbolsInBinary.get(binaryKey.toString());

                    Character s = tempLeaf.getLeft().getSymbol().charAt(j);
                    this.symbolsInBinary.put(s.toString(), binary + "1");

                }
            }
            if (tempLeaf.getRight() != null) {
                
                for (int j = 0; j < tempLeaf.getRight().getSymbol().length(); j++) {
                    Character binaryKey = tempLeaf.getSymbol().charAt(j);
                    String binary = this.symbolsInBinary.get(binaryKey.toString());

                    Character s = tempLeaf.getRight().getSymbol().charAt(j);
                    this.symbolsInBinary.put(s.toString(), binary + "0");

                }
            }

            //test print 
            System.out.println(tempLeaf.toString()
                    + ". Lapset: vasen: "
                    + tempLeaf.getLeft()
                    + " , oikea: "
                    + tempLeaf.getRight());

        }

        //print final Huffman binary for symbols
        for (String name : this.symbolsInBinary.keySet()) {
            String key = name.toString();
            String value = this.symbolsInBinary.get(name).toString();
            if (key.length() < 2) {
                System.out.println(key + " :" + value.substring(1));
            }
        }

    }

    /**
     * @param s3 the original input
     * @param s4 compressed-input string in binary
     * @return returns the compressed string in binary
     */
    public String getCompString() throws Exception {
        String s4 = "";
        String s3 = this.input;
        Character c3;
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < s3.length(); l++) {
            c3 = s3.charAt(l);
            
           
           

            s4 = this.symbolsInBinary.get(c3.toString()).substring(1);
            sb.append(s4);
        }
        s4 = sb.toString();
        return s4;
    }
    /**
     * This method decodes Huffman coded input-string
     * @param s3 is read for the individual '0' and '1' which determine
     * what to look for in the Huffman-tree
     * @param s4 The decoded string.
     * @param tempHeap2 A copy of the Huffman-tree that was built before using
     * the original in the encoding.
     * @param tempLeaf Temporary Leaf for handling the Huffman-tree
     * @return
     * @throws Exception 
     */
    public String decodeTree() throws Exception {
        
        String s3 = getCompString();

        String s4 = "";
        int i = 0;
        tempLeaf = (Leaf) tempHeap2.poll();
        root = tempLeaf;

        while (s3.length() > i) {

            if (s3.charAt(i) == '1') {
                
                tempLeaf = tempLeaf.getLeft();
            } else {
                
                tempLeaf = tempLeaf.getRight();
            }
            i++;

            if (tempLeaf.getSymbol().length() == 1) {
               
                s4 = s4 + tempLeaf.getSymbol();

                tempLeaf = root;
                
            }

        }
        return s4;
    }
}
