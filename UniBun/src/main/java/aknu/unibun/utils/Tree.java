/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.utils;

import aknu.unibun.domain.Node;

/**
 *
 * @author aknu
 */
public class Tree {

    Node[] treeArray;
    int r;
    int l;
    int smallest;
    Node temp;
    Node polled;
    int treeSize;
    private int size;

    public Tree(int size) {
        this.size = 0;
        treeArray = new Node[size +1];
        treeArray[0] = new Node(new Byte("1"), Integer.MIN_VALUE);
        
    }
    
    
    

    public Node peek() {
        return treeArray[0];
    }

   
    
   
    
    public Node poll() {

        if (this.size == 0) {
            return null;
        }
       
        polled = treeArray[0];
        this.size = this.size - 1;
        treeArray[0] = treeArray[this.size];
        
        
        sortOrdering(treeArray, 0);

        return polled;
    }

    
    
    public void push(Node node) {
        
        this.size = this.size + 1;
        
        treeArray[this.size] = node;
        
        int i = this.size;
        System.out.println("Size: " + i);
        
        while (treeArray[getParent(i)].getProbability() > treeArray[i].getProbability()) {
            temp = treeArray[i];
            treeArray[i] = treeArray[getParent(i)];
            treeArray[getParent(i)] = temp;
            i = getParent(i);
        }
    }

    public void setSize(int i) {
        this.size = i;
    }

    public int getSize() {
        return this.size;
    }

    public int getParent(int i) {
        if (i % 2 == 0) {
            return (i / 2) - 1;
        } else {
            return i / 2;
        }
    }

    public int getLeft(int i) {
        return (2 * i) + 1;
    }

    public int getRight(int i) {
        return (2 * i) + 2;
    }

    public void buildTree(Node[] arr) {
        treeArray = arr;
        treeSize = treeArray.length;
        for (int i = (size / 2); i >= 0; i--) {
            sortOrdering(treeArray, i);
        }
    }

    public void sortOrdering(Node[] treeArray, int i) {

        l = getLeft(i);
       
        r = getRight(i);
        
        
        if (l < size  && treeArray[l].getProbability() < treeArray[i].getProbability()) {

            smallest = l;
            
        } else {
            smallest = i;
        }
        
         if (r < size  && treeArray[r].getProbability() < treeArray[smallest].getProbability()) {

            smallest = r;
            
        }

        if (smallest != i) {
            temp = treeArray[i];
            
            treeArray[i] = treeArray[smallest];
            treeArray[smallest] = temp; 
            
            sortOrdering(treeArray, smallest);
        }

    }
    
    public Node[] asArray() {
        return treeArray;
    }
    
    public boolean contains(Node obj) {
        for (int i = 0; i < size; i++) {
            
            if (treeArray[i].equals(obj)) {
                return true;
            }
        }
        
        return false;
    }
}
