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
import aknu.unibun.io.UniBunInput;
import aknu.unibun.io.UniBunOutput;
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

    public static void main(String[] args) throws Exception {
        
        byte[] bytes;
        boolean print = false;
        //bytes = ts1.getBytes();
        
        UniBunInput newInput = new UniBunInput();
        
        frequencyCalculator fq = new frequencyCalculator();
        huffmanTree ht = new huffmanTree();
        Comparator<Leaf> comp = new LeafComparator();
        PriorityQueue freqHeap = new PriorityQueue(50, comp);
        freqHeap = fq.frequencyCalculator(newInput.getBytes());
        
       

        ht.sortToMaxTree(freqHeap, newInput.getBytes());

        
        
        
        
        String compString = ht.getCompString();

       bytes = ht.getByteArray();

        /* System.out.println("bytes= ");
        for (int i = 0; i < bytes.length; i++) {
            String s1 = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
            System.out.print(s1);

        } */
      
        System.out.println("Merkkijonon pituus ennen kompressiota: " + fq.getInput().length*8);
        
        System.out.println("\r Kompressoitu jono: " + compString);
        System.out.println("Pituus kompression jälkeen: " + compString.length());
         
        UniBunOutput out = new UniBunOutput();
        out.UniBunOutput(bytes);
        String output = "";
        
        

        
/*
        
        */
        
        Double d1 = compString.length() / 1.0;
        d1 = d1 / (fq.getInput().length * 8);
        d1 = 1 - d1;

        System.out.println("\b Kompressioaste: " + (d1) * 100 + "%");

        out.decodeFile(ht.decodeTree());

        

        

    }

}
