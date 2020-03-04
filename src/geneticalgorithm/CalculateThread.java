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
public class CalculateThread implements Runnable, ProgressDisplay, OrganismGenerator{
    
    private ProgressDisplayForm progDisplay;
    
    private Evolution evolution;
    
    private Convenience c = new Convenience();

    public CalculateThread() {
        evolution = new Evolution(this, this);
        evolution.setGenerationSize(100);
        evolution.setGenerations(2000);
        evolution.setChildrenPerParent(2);
        
        progDisplay = new ProgressDisplayForm();
    }

    @Override
    public void run() {
        DietDisplay display = new DietDisplay();
        display.displayDiet((Diet) evolution.evolve());
    }

    @Override
    public void show() {
        progDisplay.setVisible(true);
    }

    @Override
    public void hide() {
        progDisplay.dispose();
    }

    @Override
    public void updateProgress(double progress) {
        progDisplay.setProgress((int) progress);
    }
    
    @Override
    public Organism generateOrganism() {
        Diet organism = new Diet();
        for (int i = 0; i < c.random(0, Diet.maxSize); i++){
            organism.add(Diet.foods[c.random(0, Diet.foods.length - 1)]);
        }
        return organism;
    }
}
