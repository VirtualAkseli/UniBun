/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilstest;

import aknu.unibun.domain.Node;
import aknu.unibun.utils.Tree;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author aknu
 */
public class TreeTest {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    Node newLeaf1;
    Node newLeaf2;
    Node newLeaf3;
    Node newLeaf4;
    Node newLeaf5;
    Node newLeaf6;
    Node newLeaf7;
    Node newLeaf8;
    Node newLeaf9;
    Node newLeaf10;
    Node newLeaf11;
    Node newLeaf12;
    Node newLeaf13;
    Node[] table;
    

    public TreeTest() {

    }

    

    @Test
    public void LeafInitWorks() {
        Tree testTree1 = new Tree(13);
        Tree testTree2 = new Tree(13);

        newLeaf1 = new Node(new Byte("0"), 1);
        newLeaf2 = new Node(new Byte("0"), 23);
        newLeaf3 = new Node(new Byte("0"), 2);
        newLeaf4 = new Node(new Byte("0"), 121);
        newLeaf5 = new Node(new Byte("0"), 3);
        newLeaf6 = new Node(new Byte("0"), 4);
        newLeaf7 = new Node(new Byte("0"), 11);
        newLeaf8 = new Node(new Byte("0"), 3);
        newLeaf9 = new Node(new Byte("0"), 5);
        newLeaf10 = new Node(new Byte("0"), 6);
        newLeaf11 = new Node(new Byte("0"), 8);
        newLeaf12 = new Node(new Byte("0"), 8);
        newLeaf13 = new Node(new Byte("0"), 2);
        Node[] table = new Node[13];

        table[0] = newLeaf1;
        
        testTree2.push(newLeaf1);
        table[1] = newLeaf2;
        testTree2.push(newLeaf2);
        
        table[2] = newLeaf3;
        testTree2.push(newLeaf3);
        
        table[3] = newLeaf4;
        testTree2.push(newLeaf4);
        table[4] = newLeaf5;
        testTree2.push(newLeaf5);

        table[5] = newLeaf6;
        testTree2.push(newLeaf6);

        table[6] = newLeaf7;
        testTree2.push(newLeaf7);

        table[7] = newLeaf8;
        testTree2.push(newLeaf8);
        table[8] = newLeaf9;

        table[9] = newLeaf10;
        table[10] = newLeaf11;
        table[11] = newLeaf12;
        table[12] = newLeaf13;
        testTree2.push(newLeaf9);
        testTree2.push(newLeaf10);
        testTree2.push(newLeaf11);
        testTree2.push(newLeaf12);
        testTree2.push(newLeaf13);
        
        testTree1.buildTree(table);
        System.out.println(testTree2.getSize());
        testTree2.poll();
        while (testTree2.getSize() > 0) {
            System.out.println(testTree2.poll().toString());
         }
      
        
        Assert.assertArrayEquals(testTree1.asArray(), testTree2.asArray());
    }

}
