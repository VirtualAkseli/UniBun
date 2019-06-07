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
    Character[] form;
    
    public HuffBin(int param) {
        
       this.form = new Character[8];
       if (param == 1) {
           this.form[0] = '1';
       } else {
           this.form[0] = '0';
       }
    }
    
    public void add(Character cha) {
        for (int i = 1; i < this.form.length ; i++) {
            if (this.form[i] != '0' && this.form[i] != '1') {
                this.form[i] = cha;
                break;
            } 
            if (i == this.form.length -1) {
                this.form = Arrays.copyOf(this.form, this.form.length*2);
            }
        }
    }
    
    public Character[] getBinary() {
        return this.form;
    }

    
}
