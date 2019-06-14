/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.io;

import aknu.unibun.domain.Node;

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
import sun.misc.IOUtils;



/**
 * This class is intended to manage Input and transform any given 
 * file to a byte-array
 * @author aknu
 */
public class UniBunInput {

    PriorityQueue<Node> frequencyHeap;
    ArrayList<Character> seenChars;
    String input;
    String encodeString;
    byte[] bytes;
    File testImg = new File("hb.jpeg");
    File testWav = new File("musa.wav");
    File testText1 = new File("kalevala.txt");
   
    File testText = new File("test.txt");
    File testFile = new File("IMG_9684.CR2");
   Path path;
Path path2;
    public byte[] GetUniBunInput() throws Exception {
        
            
        
        
      return getBytes();
       
    }
    
   public byte[] getBytes() throws FileNotFoundException, IOException {
        
        
         int length = (int) testText.length();
       FileInputStream fis = new FileInputStream(testText);
       BufferedInputStream bis = new BufferedInputStream(fis);
       
       byte[] input = IOUtils.readNBytes(bis, length);
       
       return input;
    }
    
   
    
    
    
}
