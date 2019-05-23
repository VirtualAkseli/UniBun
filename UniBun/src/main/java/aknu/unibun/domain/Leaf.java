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

    String symbol;
    double probability;
    double combinedProb;
    Leaf leafLeft;
    Leaf leafRight;
    
    public Leaf(String c, double d) {
        this.symbol = c;
        this.probability = d;
        this.combinedProb = 0;
        this.leafLeft = null;
        this.leafRight = null;
        
    }
    
    public void setSymbol(String input) {
        this.symbol = input;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setProbability(Double prob) {
        this.probability = prob;
    }
    
    public Double getProbability() {
        return this.probability;
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
