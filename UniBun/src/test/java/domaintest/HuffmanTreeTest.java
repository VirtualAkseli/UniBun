/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaintest;

import aknu.unibun.domain.LeafComparator;
import aknu.unibun.domain.Node;
import aknu.unibun.domain.FrequencyCalculator;
import aknu.unibun.domain.huffmanTree;
import aknu.unibun.io.UniBunInput;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aknu
 */
public class HuffmanTreeTest {

    byte[] testInput;
    huffmanTree ht;
    FrequencyCalculator freq;
    UniBunInput newInput;

    public HuffmanTreeTest() throws IOException {

    }

    

    
    
    @Test
    public void DecodedFileIsSameAsOriginal() throws Exception {
        newInput = new UniBunInput();

        String args1 = "test.txt";
        
        UniBunInput newInput = new UniBunInput();
        byte[] array1 = newInput.getBytes(args1);
        
        huffmanTree ht = new huffmanTree(array1);
        
        
        
        assertEquals(newInput.getBytes(args1), ht.decodeTree());

    }

}
