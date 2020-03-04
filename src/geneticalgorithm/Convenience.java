package geneticalgorithm;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stu
 */
public class Convenience {

    public Convenience() {
    }

    public void print(String string) {
        out.print(string);
    }

    public void print(int integer) {
        out.print(integer + "");
    }

    public void println(String string) {
        out.println(string);
    }

    public void println(int integer) {
        out.println(integer + "");
    }

    public int random(int from, int to) {
        return (int) (from + Math.random() * (to - from + 1));
    }

    public String arrayToString(int[] array) {
        String str = "";
        if (array.length > 0) {
            str = array[0] + "";
            for (int i = 1; i < array.length; i++) {
                str += "; " + array[i];
            }
        }
        return str;
    }

    public String arrayToString(String[] array) {
        String str = "";
        if (array.length > 0) {
            str = array[0];
            for (int i = 1; i < array.length; i++) {
                str += "; " + array[i];
            }
        }
        return str;
    }

    public String arrayToString(Double[] array) {
        String str = "";
        if (array.length > 0) {
            str = array[0] + "";
            for (int i = 1; i < array.length; i++) {
                str += "; " + array[i];
            }
        }
        return str;
    }

    public String[] readFile(String file) {
        ArrayList<String> lines = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lines.toArray(new String[lines.size()]);
    }
    
    public boolean writeFile(String file, String string){
        try {
            string = string.replaceAll("\n", System.getProperty("line.separator"));
            PrintWriter pr = new PrintWriter(new FileWriter(file));
            pr.write(string);
            pr.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean isNumber(char c){
        return c > 47 && c < 58;
    }
    
    public boolean isNumber(String s){
        char c = s.charAt(0);
        return c > 47 && c < 58;
    }
}