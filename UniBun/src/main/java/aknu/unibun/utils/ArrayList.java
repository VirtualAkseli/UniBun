/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.utils;

import java.util.Arrays;

/**
 *
 * @author aknu
 */
public class ArrayList {
    private Object[] array;
    private int size = 0;
    
    public ArrayList() {
        array = new Object[10];
    }
    
    public Object get(int i) {
        if (i < size) {
            return array[i];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void add(Object o) {
        if (array.length - size <= 5) {
            sizeGrow();
        }
        array[size++] = o;
    }
    
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (array[i] == null) {
                return false;
            }
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    
    public Object remove(int i) {
        if (i < size) {
            Object o = array[i];
            array[i] = null;
            int temp = i;
            while(temp < size) {
                array[temp] = array[temp + 1];
                array[temp + 1] = null;
                temp++;
            }
            size--;
            return o;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public int size() {
        return size;
    }
    
    public void sizeGrow() {
        array = Arrays.copyOf(array, array.length*2);
    }
    
    
    
}
