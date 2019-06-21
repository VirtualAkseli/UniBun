/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaintest;

import aknu.unibun.domain.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aknu
 */
public class LeafTest {
    Node newLeaf; 
    Node anotherLeaf; 
    public LeafTest() {
    }
    
    @Before
    public void setUp() {
        newLeaf = new Node(new Byte("0"), 2);
        anotherLeaf = new Node(new Byte("1"), 3);
    }
    
    @Test
    public void LeafInitWorks() {
        
        assertEquals(newLeaf.getClass(), anotherLeaf.getClass());
    }
    
    @Test
    public void LeftLeafIsSet() {
        assertEquals(null, newLeaf.getLeft());
        
        newLeaf.setLeft(anotherLeaf);
        assertEquals(anotherLeaf, newLeaf.getLeft());
    }
    
    @Test
    public void RightLeafIsSet() {
        assertEquals(null, newLeaf.getRight());
        
        newLeaf.setRight(anotherLeaf);
        assertEquals(anotherLeaf, newLeaf.getRight());
    }
    
    @Test
    public void GetAndSetWorks() {
        int td = 2;
        newLeaf.setProbability(td);
        newLeaf.setSymbol(new Byte("1"));
        
        Byte b1 = new Byte("1");
        byte b0 = 0b1;
        assertEquals(td, newLeaf.getProbability(), td);
        assertEquals(b0, newLeaf.getSymbol());
    }
    
    
}
