/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aknu.unibun.domain;

/**
 *The node object that contains
 * @param leafLeft -the left leaf-node
 * @param leafRight -the right leaf-node
 * @param probability -the frequency/probability of the node's symbol
 * @param symbol -the symbol of this node
 * @author aknu
 */
public class Leaf {

    byte symbol;
    double probability;
    double combinedProb;
    Leaf parent;
    Leaf leafLeft;
    Leaf leafRight;
    Boolean ready;
    
    public Leaf(byte c, double d) {
        this.symbol = c;
        this.probability = d;
        this.combinedProb = 0;
        this.leafLeft = null;
        this.leafRight = null;
        this.parent = null;
        this.ready = false;
        
    }
    
    public void setSymbol(byte input) {
        this.symbol = input;
    }

    public byte getSymbol() {
        return this.symbol;
    }

    public void setProbability(Double prob) {
        this.probability = prob;
    }
    
    public Double getProbability() {
        return this.probability;
    }
    
    public void setParent(Leaf par) {
        this.parent = par;
    }
    
    public Leaf getParent() {
        return this.parent;
    }
    
    public void setReady(){
        this.ready = true;
    }
    
    public boolean getReady() {
        return this.ready;
    }

    @Override
    public String toString() {
        return this.symbol + ": " + this.probability;
    }

    public void MergeProb(Leaf otherLeaf) {
        this.combinedProb = this.probability
                + otherLeaf.getProbability();
        

    }
    
    public void setLeft(Leaf leftLeaf) {
        this.leafLeft = leftLeaf;
    }
    
    public Leaf getLeft() {
        return this.leafLeft;
    }
    
    public void setRight(Leaf rightLeaf) {
        this.leafRight = rightLeaf;
    }
    
    public Leaf getRight() {
        return this.leafRight;
    }

    


}
