/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import java.util.ArrayList;

/**
 *
 * @author Stu
 */
public class Diet implements Organism{

    public ArrayList<Food> diet;
    
    public static int targetA = 0, targetB = 0, targetC = 0;
    public static Food[] foods;
    public static int maxSize;
    public static Convenience c;

    public Diet() {
        diet = new ArrayList<>();
    }

    public void add(Food food) {
        diet.add(food);
    }

    public void remove(Food food) {
        diet.remove(food);
    }

    public void removeRandom() {
        if (diet.size() > 0) {
            diet.remove(c.random(0, diet.size() - 1));
        }
    }
    
    public int getSize(){
        return diet.size();
    }
    
    public int totalVitA(){
        int total = 0;
        for (Food food : diet){
            total += food.getVitA();
        }
        return total;
    }
    
    public int totalVitB(){
        int total = 0;
        for (Food food : diet){
            total += food.getVitB();
        }
        return total;
    }
    
    public int totalVitC(){
        int total = 0;
        for (Food food : diet){
            total += food.getVitC();
        }
        return total;
    }
    
    public double avgRating(){
        int total = 0;
        for (Food food : diet){
            total += food.getRating();
        }
        return ((double)total)/diet.size();
    }

    @Override
    public String toString() {
        return "Diet: " + diet.toString();
    }
    
    public String formattedString(){
        String s = "Eat nothing";
        if (diet.size() > 0){
            s = diet.get(0).toString();
            for (int i = 1; i < diet.size(); i++){
                s += "\n" + diet.get(i);
            }
        }
        return s;
    }
    
    @Override
    public void mutate() {
        if(getSize() < maxSize && c.random(0, 1) == 0){
            add(foods[c.random(0, foods.length - 1)]);
        } else {
            removeRandom();
        }
    }
    
     public Diet copy() {
        Diet temp = new Diet();
        for (Food food : diet) {
            temp.add(food);
        }
        return temp;
    }

    @Override
    public Organism reproduceWith(Organism o, int GeneSwaps) {
        return copy(); //Nah, don't feel like swapping genes
    }
    
    public double cost() {
        int ratingImportance = 10;
        int targetRating = 10;

        if (getSize() > 0) {

            double totalCost = Math.abs(targetRating - avgRating()) * ratingImportance + Math.abs(targetA - totalVitA()) + Math.abs(targetB - totalVitB()) + Math.abs(targetC - totalVitC());

            return totalCost;
        } else {
            return targetA + targetB + targetC + (targetRating/2) * ratingImportance;
        }
    }
    
    @Override
    public int compareTo(Object o) {
        double myCost = cost();
        double oCost = ((Diet)o).cost();
        
        if (myCost < oCost) {
            return -1;
        } else if (myCost == oCost) {
            return 0;
        } else {
            return 1;
        }
    }
}
