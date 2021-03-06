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
public class Node {

    byte symbol;
    int probability;
    int combinedProb;
    Node parent;
    Node leafLeft;
    Node leafRight;
    Boolean ready;
    private boolean isLeaf;
    private int index;
    
    public Node(byte c, int d) {
        this.symbol = c;
        this.probability = d;
        this.combinedProb = 0;
        this.leafLeft = null;
        this.leafRight = null;
        this.parent = null;
        this.ready = false;
        this.isLeaf = false;
        
    }
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return this.index;
    }
    public void setSymbol(byte input) {
        this.symbol = input;
    }

    public byte getSymbol() {
        return this.symbol;
    }

    public void setProbability(int prob) {
        this.probability = prob;
    }
    
    public int getProbability() {
        return this.probability;
    }
    
    public void setParent(Node par) {
        this.parent = par;
    }
    
    public Node getParent() {
        return this.parent;
    }
    
    public void setReady(){
        this.ready = true;
    }
    
    public boolean getReady() {
        return this.ready;
    }
    
    public void setLeaf() {
        this.isLeaf = true;
    }
    
    public boolean IsLeaf(){
        return this.isLeaf;
    
    }

    @Override
    public String toString() {
        return this.symbol + ": " + this.probability;
    }

    public void MergeProb(Node otherLeaf) {
        this.combinedProb = this.probability
                + otherLeaf.getProbability();
        

    }
    
    public void setLeft(Node leftLeaf) {
        this.leafLeft = leftLeaf;
    }
    
    public Node getLeft() {
        return this.leafLeft;
    }
    
    public void setRight(Node rightLeaf) {
        this.leafRight = rightLeaf;
    }
    
    public Node getRight() {
        return this.leafRight;
    }

    


}
