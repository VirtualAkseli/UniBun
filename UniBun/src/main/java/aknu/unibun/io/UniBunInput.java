/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.io;

import aknu.unibun.domain.Leaf;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;



/**
 *
 * @author aknu
 */
public class UniBunInput {

    PriorityQueue<Leaf> frequencyHeap;
    ArrayList<Character> seenChars;
    String input;
    String encodeString;
    byte[] bytes;
    File testImg = new File("/home/local/aknu/TiraLabra/UniBun/src/UniBun/src/main/resources/hb.jpeg");
    File testText = new File("stockText");
    String outPutName = "/home/local/aknu/TiraLabra/UniBun/src/UniBun/src/main/resources/output2.bun";
Path path;
Path path2;
    public String GetUniBunInput() throws Exception {
        
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
        
       return ts1;
       
    }
    
   
    
   
    
    
    
}
