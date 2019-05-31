/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaintest;

import aknu.unibun.domain.Leaf;
import aknu.unibun.domain.frequencyCalculator;
import aknu.unibun.domain.huffmanTree;
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

    public HuffmanTreeTest() {

        String test = "Osterit (Ostreidae) on meressä elävä simpukkaheimo, "
                + "johon kuuluu toistakymmentä sukua. "
                + "Joitakin osterilajeja viljellään ja kerätään "
                + "luonnosta ihmisravinnoksi, ja ne ovat "
                + "kulinaarisesti arvostettuja. Syötävien osterien "
                + "levinneisyysalueet ovat istutusten myötä "
                + "laajentuneet suuresti alkuperäisestä. ";
        testInput = test.getBytes();
    }

    @Before
    public void setUp() throws Exception {
        ht = new huffmanTree();
        freq = new frequencyCalculator();
        ht.sortToMaxTree(freq.frequencyCalculator(testInput), testInput);
    }

    @Test
    public void DecodingWorks() throws Exception {

        assertEquals(testInput, ht.decodeTree());

    }

}
