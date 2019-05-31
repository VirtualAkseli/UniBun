/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.util.HashMap;
import aknu.unibun.domain.Leaf;
import aknu.unibun.io.UniBunInput;
import aknu.unibun.utils.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Comparator;

import java.util.PriorityQueue;
import javafx.scene.image.Image;

/**
 *
 * @author aknu
 */
public class frequencyCalculator {

    PriorityQueue<Leaf> frequencyHeap;
    ArrayList seenChars;
    byte[] input;
    UniBunInput newInput;

    public frequencyCalculator() throws Exception {
        newInput = new UniBunInput();

    }

    /**
     *
     * @param progInput
     * @param seenChars An ArrayList for storing the characters that have
     * already been counted
     * @return
     * @throws Exception
     */
    public PriorityQueue frequencyCalculator(byte[] progInput) throws Exception {
        seenChars = new ArrayList();
        
        setInput(progInput);
        Comparator<Leaf> comp = new LeafComparator();
        frequencyHeap = new PriorityQueue<Leaf>(50, comp);
        Byte c;
        for (int i = 0; i < this.input.length; i++) {
             c = this.input[i];
            if (seenChars.contains(c)) {
                continue;
            } else {
                countCharOccurrence(this.input, c);
            }
        }

        return frequencyHeap;
    }

    /**
     * The method counts the occurrence of individual characters in a
     * given input and then forms nodes with an unique character and it's
     * probability as parameters.
     *
     * @param input the input (in String at the moment,) from which
     * the Huffman tree is built of
     * @param c
     */
    public void countCharOccurrence(byte[] input, byte c) {
        double count = 0;
        double freq = 0;

        for (int i = 0; i < input.length; i++) {

            if (input[i] == c) {
                count++;

            }
        }

        freq = count;
        
       
        Leaf newLeaf = new Leaf(c, freq);
        frequencyHeap.add(newLeaf);
        seenChars.add(c);

    }

    public void setInput(byte[] in) {
        this.input = in;

    }

    public byte[] getInput() {

        return this.input;
    }

}
