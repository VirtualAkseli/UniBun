/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Used in creating the max-heap for Huffman code
 * @author aknu
 */
public class LeafComparatorMax implements Comparator<Node> {

    @Override
    public int compare(Node x, Node y) {
        
       
        
        if (y.getProbability() > x.getProbability()) {
            return 1;
        }
        if (y.getProbability() < x.getProbability()) {
            return -1;
        }
        return 0; 
    }
    
}
