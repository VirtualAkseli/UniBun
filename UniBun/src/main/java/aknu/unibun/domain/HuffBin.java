/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

import java.util.Arrays;

/**
 *
 * @author aknu
 */
public class HuffBin {
    String bitSequence;
    char[] array;
   public HuffBin() {
       String bitSequence = "";
       int ptr = 0;
       int overFlow = 0;
   }
   
   public String readHuff(int index) {
       array = bitSequence.toCharArray();
       if (array[index] == '1' ) {
           return "1";
       }
       else {
           return "0";
       }
   }

}
