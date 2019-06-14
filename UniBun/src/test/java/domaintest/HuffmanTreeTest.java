/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaintest;

import aknu.unibun.domain.LeafComparator;
import aknu.unibun.domain.Node;
import aknu.unibun.domain.frequencyCalculator;
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
    frequencyCalculator freq;
    UniBunInput newInput;

    public HuffmanTreeTest() throws IOException {

    }

    

    @Test
    public void DecodedFilesizeIsEqualToNormal() throws Exception {
        this.newInput = new UniBunInput();

        frequencyCalculator fq = new frequencyCalculator();
        huffmanTree ht = new huffmanTree();
        Comparator<Node> comp = new LeafComparator();
        PriorityQueue freqHeap = new PriorityQueue(50, comp);
        freqHeap = fq.frequencyCalculator(newInput.getBytes());
        
        ht.sortToMaxTree(freqHeap, newInput.getBytes());
        assertEquals(this.newInput.getBytes().length, ht.decodeTree().length);

    }
    
    @Test
    public void DecodedFileIsSameAsOriginal() throws Exception {
        this.newInput = new UniBunInput();

        frequencyCalculator fq = new frequencyCalculator();
        huffmanTree ht = new huffmanTree();
        Comparator<Node> comp = new LeafComparator();
        PriorityQueue freqHeap = new PriorityQueue(50, comp);
        freqHeap = fq.frequencyCalculator(newInput.getBytes());
        
        ht.sortToMaxTree(freqHeap, newInput.getBytes());
        assertEquals(this.newInput.getBytes(), ht.decodeTree());

    }

}
