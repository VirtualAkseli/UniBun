/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.ui;

import aknu.unibun.domain.Leaf;
import aknu.unibun.domain.LeafComparator;
import aknu.unibun.domain.frequencyCalculator;
import aknu.unibun.domain.huffmanTree;
import com.sun.javafx.fxml.expression.BinaryExpression;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author aknu
 */
public class MainUI {

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    
    public static void main(String[] args) {
        
        frequencyCalculator fq = new frequencyCalculator();
        huffmanTree ht = new huffmanTree();
        Comparator<Leaf> comp = new LeafComparator();
        PriorityQueue freqHeap = new PriorityQueue(50, comp);
        freqHeap = fq.frequencyCalculator("");
        /* freqHeap.forEach((t) -> {
            System.out.println(t);
        }); */
        
        ht.sortToMaxTree(freqHeap);

 
        /*while (!freqHeap.isEmpty()) {
            System.out.println(freqHeap.poll().toString());
        }*/
        byte[] bytes;
        String input = "Time is a flat circle. Everything we have done or will do we will do over and over and over again- forever.";
        bytes = input.getBytes(UTF_8);
        
        
        System.out.println("bytes= ");
        for (int i = 0; i < bytes.length; i++) {
            String s1 = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace( ' ', '0');
            System.out.print(s1);
            
        }
        System.out.println("");
        System.out.println("Merkkijonon pituus ennen kompressiota: " + input.length()*8);
            
        System.out.println("\r Kompressoitu jono: "+  ht.getCompString());
        System.out.println("Pituus: " +  ht.getCompString().length());
        Double d1 = ht.getCompString().length()/1.0;
        d1 = d1/(input.length()*8.0);
        d1 = 1 - d1;
        System.out.println("\b Kompressioaste: " + (d1)*100 + "%");
        
        System.out.println("Alkuperäinen syöte: " + ht.decodeTree());
    }

}
