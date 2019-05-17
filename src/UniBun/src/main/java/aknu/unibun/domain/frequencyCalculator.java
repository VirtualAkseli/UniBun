/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.util.HashMap;
import aknu.unibun.domain.Leaf;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.PriorityQueue;

/**
 *
 * @author aknu
 */
public class frequencyCalculator {

    PriorityQueue<Leaf> frequencyHeap;
    ArrayList<Character> seenChars;
    String input;
    
    public frequencyCalculator() {
          String input = "Time is a flat circle. Everything we have done or will do we will do over and over and over again- forever.";;
          setInput(input);
    }
    public PriorityQueue frequencyCalculator(String input) {
        this.input = "Time is a flat circle. Everything we have done or will do we will do over and over and over again- forever.";
        
        
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
