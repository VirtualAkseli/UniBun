/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.ui;

import aknu.unibun.domain.Node;
import aknu.unibun.domain.LeafComparator;
import aknu.unibun.domain.FrequencyCalculator;
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
import java.util.Scanner;

/**
 *
 * @author aknu
 */
public class MainUI {

    
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        
        String[] huffBytes;
        
        System.out.println("Please type the name of the file that you wish to compress.");
        String args1 = in.nextLine();
        long fire = System.nanoTime();
        UniBunInput newInput = new UniBunInput();
        byte[] array1 = newInput.getBytes(args1);
        
        huffmanTree ht = new huffmanTree(array1);
        
        
        String compString = ht.getCompString();

        huffBytes = ht.getHuffmanStringArray();

        System.out.println("Tiedoston pituus ennen kompressiota: " + array1.length);

        System.out.println("Pituus kompression jälkeen: " + compString.length() / 8);

        UniBunOutput out = new UniBunOutput();
        //out.CompressToFile(huffBytes, compString.length()/8);
        String output = "";

        
        Double d1 = compString.length() / 8.0;
        d1 = d1 / (array1.length);
        d1 = 1 - d1;

        System.out.println("\b Kompressioaste: " + (d1) * 100 + "%");

        out.decodeFile(ht.decodeTree());
        long end   = System.nanoTime();
        long totalTime = end - fire;
        double dividend = 1000000;
        double millis = (totalTime/dividend);
        System.out.println("Running time: "+ millis + " ms.");
    }

}
