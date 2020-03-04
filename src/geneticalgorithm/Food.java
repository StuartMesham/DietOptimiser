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
public class Food {
    private String name;
    private int rating;
    private int vitA;
    private int vitB;
    private int vitC;

    public Food(String name, int rating, int vitA, int vitB, int vitC) {
        this.name = name;
        this.rating = rating;
        this.vitA = vitA;
        this.vitB = vitB;
        this.vitC = vitC;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVitA() {
        return vitA;
    }

    public int getVitB() {
        return vitB;
    }

    public int getVitC() {
        return vitC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setVitA(int vitA) {
        this.vitA = vitA;
    }

    public void setVitB(int vitB) {
        this.vitB = vitB;
    }

    public void setVitC(int vitC) {
        this.vitC = vitC;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Rating: " + getRating() + ", Vitamin A: " + getVitA() + ", Vitamin B: " + getVitB() + ", Vitamin C: " + getVitC();
    }
}
