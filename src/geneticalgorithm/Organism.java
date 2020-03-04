/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

/**
 *
 * @author Stu
 */
public interface Organism extends Comparable{
    public abstract void mutate();
    public abstract Organism reproduceWith(Organism o, int GeneSwaps);
}
