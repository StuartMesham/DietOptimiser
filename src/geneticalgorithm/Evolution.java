/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import java.util.Arrays;

/**
 *
 * @author Stu
 */
public class Evolution {

    Convenience c = new Convenience();

    private int generationSize = 100;
    private int childrenPerParent = 10;
    private int maxMutationsPerChild = 1;
    private int generations = 100;
    private int maxGeneSwaps = 1;

    private OrganismGenerator organismGenerator;
    private ProgressDisplay display;

    public Evolution(OrganismGenerator organismGenerator, ProgressDisplay display) {
        this.organismGenerator = organismGenerator;
        this.display = display;
    }

    public boolean setGenerationSize(int size) {
        if (size < 1) {
            return false;
        }

        this.generationSize = size;
        return true;
    }

    public boolean setChildrenPerParent(int children) {
        if (children < 1) {
            return false;
        }

        this.childrenPerParent = children;
        return true;
    }

    public boolean setMaxMutationsPerChild(int maxMutationsPerChild) {
        if (maxMutationsPerChild < 0) {
            return false;
        }

        this.maxMutationsPerChild = maxMutationsPerChild;
        return true;
    }

    public boolean setGenerations(int generations) {
        if (generations < 0) {
            return false;
        }

        this.generations = generations;
        return true;
    }

    public boolean setMaxGeneSwaps(int maxGeneSwaps) {
        if (maxGeneSwaps < 0) {
            return false;
        }
        this.maxGeneSwaps = maxGeneSwaps;
        return true;
    }

    public Organism evolve() {
        Organism[] parents = new Organism[generationSize];
        Organism[] children = new Organism[generationSize * childrenPerParent];
        
        display.updateProgress(0);
        display.show();

        for (int i = 0; i < parents.length; i++) {
            parents[i] = organismGenerator.generateOrganism();
        }

        for (int i = 0; i < generations; i++) {
            display.updateProgress(((i + 1.0) * 100) / generations);

            int count = 0;
            for (Organism parent : parents) {
                for (int j = 0; j < childrenPerParent; j++) {
                    //Have child
                    Organism child = parent.reproduceWith(parents[c.random(0, parents.length - 1)], c.random(0, maxGeneSwaps));

                    //Mutate child
                    int childMutations = c.random(0, maxMutationsPerChild);
                    for (int k = 0; k < childMutations; k++) {
                        child.mutate();
                    }

                    children[count] = child;
                    count++;
                }
            }

            Arrays.sort(children);
            
            //The best children become the next generation's parents
            for (int j = 0; j < parents.length; j++){
                parents[j] = children[j];
                
            }
        }
        display.hide();
        return parents[0];
    }
}
