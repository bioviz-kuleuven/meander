/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import processing.core.PApplet;

/**
 *
 * @author gpavlopo
 */
public class Normalization extends PApplet {

    /**
     * @param args the command line arguments
     */
    static String filename = "/Users/gpavlopo/Desktop/Meander/Thierry_story/chromosomes/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr20.txt";
    static StringBuffer str_buf = new StringBuffer();
    static String output_file = filename.replace(".txt", "_normalization.txt");

    public static void write_file(String buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer);
            out.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void append_file(String buffer, String filename) {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(filename, append);

            fw.write(buffer);//appends the string to the file
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            write_file("", output_file);
            //Read File Line By Line
            int cnt = 0;
            while ((strLine = br.readLine()) != null) {
                if (cnt == 0) {
                    str_buf.append(strLine + "\n");
                   
                }
                if (cnt != 0) {
                    String[] str = strLine.split("\t");

                    float value_ref = map(Float.parseFloat(str[1]), 0f, 140f, 0f, 10f);
                    float value_s1 = map(Float.parseFloat(str[2]), 0f, 10f, 0f, 10f);
                    float value_s2 = map(Float.parseFloat(str[3]), 0f, 10f, 0f, 10f);
                    float value_s3 = map(Float.parseFloat(str[4]), 0f, 10f, 0f, 10f);
                    float value_s4 = map(Float.parseFloat(str[5]), 0f, 10f, 0f, 10f);
                    
                    str_buf.append(str[0] + "\t" + (int) value_ref + "\t" + (int)value_s1+ "\t" + (int)value_s2 + "\t" + (int)value_s3 + "\t"+(int)value_s4+ "\n");
       
                }
                cnt++;

                if (cnt % 100000 == 0) {
                    append_file(str_buf.toString(), output_file);
                    str_buf.setLength(0);
                }

            }
            append_file(str_buf.toString(), output_file);
            str_buf.setLength(0);
            //Close the input stream
            in.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
