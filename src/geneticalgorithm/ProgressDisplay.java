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
public interface ProgressDisplay {
    public abstract void show();
    public abstract void hide();
    public abstract void updateProgress(double progress);
}
