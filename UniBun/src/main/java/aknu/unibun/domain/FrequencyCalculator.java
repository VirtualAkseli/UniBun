/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.util.HashMap;
import aknu.unibun.domain.Node;
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
public class FrequencyCalculator {

    PriorityQueue<Node> frequencyHeap;
    ArrayList seenChars;
    int[] occurrences;
    byte[] input;
    UniBunInput newInput;

    public FrequencyCalculator() throws Exception {
        newInput = new UniBunInput();
        occurrences = new int[256];

        for (int i = 0; i < occurrences.length; i++) {
            occurrences[i] = 0;
        }

    }

    /**
     ** The method counts the occurrence of individual characters in a given
     * input and then forms nodes with an unique character and it's probability
     * as parameters.
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
        Comparator<Node> comp = new LeafComparator();
        frequencyHeap = new PriorityQueue<Node>(50, comp);
        Byte c;
        int tempByte;
        for (int i = 0; i < this.input.length; i++) {

            tempByte = Byte.toUnsignedInt(this.input[i]);
            occurrences[tempByte] += 1;

        }

        for (int j = 0; j < occurrences.length; j++) {
            if (occurrences[j] != 0) {
            Node newLeaf = new Node((byte) j, occurrences[j]);

            frequencyHeap.add(newLeaf);
            }
        }
        return frequencyHeap;
    }

   

    public void setInput(byte[] in) {
        this.input = in;

    }

    public byte[] getInput() {

        return this.input;
    }

}
