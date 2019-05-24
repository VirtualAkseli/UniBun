/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaintest;

import aknu.unibun.domain.Leaf;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aknu
 */
public class LeafTest {
    Leaf newLeaf; 
    Leaf anotherLeaf; 
    public LeafTest() {
    }
    
    @Before
    public void setUp() {
        newLeaf = new Leaf("a", 0.2);
        anotherLeaf = new Leaf("b", 0.3);
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
        double td = 0.9;
        newLeaf.setProbability(td);
        newLeaf.setSymbol("c");
        
        
        assertEquals(td, newLeaf.getProbability().doubleValue(), td);
        assertEquals("c", newLeaf.getSymbol());
    }
    
    
}
