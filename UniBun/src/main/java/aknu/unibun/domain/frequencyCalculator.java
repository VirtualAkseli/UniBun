/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.util.HashMap;
import aknu.unibun.domain.Leaf;
import aknu.unibun.io.UniBunInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.PriorityQueue;
import javafx.scene.image.Image;

/**
 *
 * @author aknu
 */
public class frequencyCalculator {

    PriorityQueue<Leaf> frequencyHeap;
    ArrayList<Character> seenChars;
    String input;
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
    public PriorityQueue frequencyCalculator(String progInput) throws Exception {
        seenChars = new ArrayList();

        setInput(progInput);
        Comparator<Leaf> comp = new LeafComparator();
        frequencyHeap = new PriorityQueue<Leaf>(50, comp);

        for (int i = 0; i < this.input.length(); i++) {
            Character c = this.input.charAt(i);
            if (seenChars.contains(c)) {
                continue;
            } else {
                countCharOccurrence(this.input, c);
            }
        }

        return frequencyHeap;
    }

    /**
     * The method counts the occurennce of individual characters in a
     * given input and then forms nodes with an unique character and it's
     * probability as parameters.
     *
     * @param input the input (in String at the moment,) from which
     * the huffman tree is built of
     * @param c
     */
    public void countCharOccurrence(String input, Character c) {
        double count = 0;
        double freq = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == c) {
                count++;

            }
        }

        freq = count / input.length();

        Leaf newLeaf = new Leaf(c.toString(), freq);
        frequencyHeap.add(newLeaf);
        seenChars.add(c);

    }

    public void setInput(String in) {
        this.input = in;

    }

    public String getInput() {

        return this.input;
    }

}
