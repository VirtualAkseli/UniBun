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
        String ts1 = 
                "(Huh, hah, huh, hah Huh, hah, huh, hah Huh, "
               + "hah, huh, hah Huh, hah, huh, hah)"
               + " (Huh-hah-huh-hah Huh-hah-huh-hah)"
               + " Hän Karakorumista ajoi Pekingiin orillaan "
               + "(Hah, huh, hah) Kiinalainen väki joutui"
               + " paniikkiin torillaan (Hah, huh, hah)"
               + " Ja erämaassa Gobin hän totesi vain"
               + " Tän tappamisen jobin, kun lahjaks sain"
               + " Ja sitten, pojat, mennään Persiaan "
               + "(Huh) (Hah) Tsing, Tsing, Tsingis Khan"
               + " Kaikkien naapurikansojen alistaja"
               + " Tsing, Tsing, Tsingis Khan "
               + "Hirveän miekkansa hilpeä kalistaja Sapelia käytti,"
               + " vuoh hoh hoh hoh hoo Maan kauhulla hän täytti,"
               + " ah hah hah hah haa Elintilaa huusi tullessaan"
               + " Tsing, Tsing, Tsingis Khan "
               + "Kaikkien naapurikansojen alistaja "
               + "Tsing, Tsing, Tsingis Khan "
               + "Aikamme valtiomiehien valistaja "
               + "Sapelia käytti, vuoh hoh hoh hoh hoo "
               + "Esimerkin näytti, ah hah hah hah haa "
               + "Hommat niin myös tänään hoidellaan "
               + "Niin moni nytkin elintilaa itselleen pimittää "
               + "(Hah, huh, hah) "
               + "Ja uudet rajat naapurinsa eteiseen nimittää "
               + "(Hah, huh, hah) Mut heikompi jos kysyy, "
               + "tää oikeinko on? Niin päätös on ja pysyy, "
               + "saat lausunnon Jatkuu aina perinne vain tää "
               + "(Huh) (Hah) Tsing, Tsing, Tsingis Khan "
               + "Kaikkien naapurikansojen alistaja "
               + "Tsing, Tsing, Tsingis Khan "
               + "Hirveän miekkansa hilpeä kalistaja "
               + "Sapelia käytti, vuoh hoh hoh hoh hoo "
               + "Maan kauhulla hän täytti, ah hah hah hah haa "
               + "Elintilaa huusi tullessaan Tsing, Tsing, Tsingis Khan "
               + "Kaikkien naapurikansojen alistaja "
               + "Tsing, Tsing, Tsingis Khan "
               + "Aikamme valtiomiehien valistaja Sapelia käytti, "
               + "vuoh hoh hoh hoh hoo Esimerkin näytti, "
               + "ah hah hah hah haa Hommat niin myös tänään hoidellaan ";
        
        boolean print = false;
        
        frequencyCalculator fq = new frequencyCalculator();
        huffmanTree ht = new huffmanTree();
        Comparator<Leaf> comp = new LeafComparator();
        PriorityQueue freqHeap = new PriorityQueue(50, comp);
        freqHeap = fq.frequencyCalculator(ts1);
        /* freqHeap.forEach((t) -> {
            System.out.println(t);
        }); */

        ht.sortToMaxTree(freqHeap, ts1);

        /*while (!freqHeap.isEmpty()) {
            System.out.println(freqHeap.poll().toString());
        }*/
        byte[] bytes;
        UniBunInput newInput = new UniBunInput();
        String input = newInput.GetUniBunInput();
        String compString = ht.getCompString();
        
        bytes = input.getBytes(UTF_8);
        
        
        
        /* System.out.println("bytes= ");
        for (int i = 0; i < bytes.length; i++) {
            String s1 = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
            System.out.print(s1);

        } */
        
        System.out.println("");
        //System.out.println("Merkkijonon pituus ennen kompressiota: " + input.length() * 8);
        /*
        System.out.println("\r Kompressoitu jono: " + compString);
        //System.out.println("Pituus kompression jälkeen: " + compString.length());
         */
        UniBunOutput out = new UniBunOutput();
        String output = "";
        
        output = compString;
        
        System.out.println("Alkuperäisen merkkijonon pituus: " + input.length()*8);
        System.out.println("Lyhenetyn merkkijonon pituus: " + compString.length());
        System.out.println("");
        
        out.UniBunOutput(output);
        
        Double d1 = compString.length() / 1.0;
        d1 = d1 / (input.length() *8);
        d1 = 1 - d1;
       
        System.out.println("\b Kompressioaste: " + (d1) * 100 + "%");

        System.out.println("Alkuperäinen syöte: " + ht.decodeTree());
        
    }

}
