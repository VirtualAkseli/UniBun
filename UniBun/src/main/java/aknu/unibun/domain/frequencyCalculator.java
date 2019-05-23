/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.util.HashMap;
import aknu.unibun.domain.Leaf;
import aknu.unibun.io.UniBunInput;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
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

    public frequencyCalculator() throws Exception {
        UniBunInput newInput = new UniBunInput();
         input = newInput.GetUniBunInput();
        setInput(input);
    }

    public PriorityQueue frequencyCalculator(String input) throws Exception {
        seenChars = new ArrayList();
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
