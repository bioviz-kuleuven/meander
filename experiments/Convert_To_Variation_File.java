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
import java.io.InputStreamReader;
import processing.core.PApplet;

/**
 *
 * @author gpavlopo
 */
public class Convert_To_Variation_File extends PApplet{

    /**
     * @param args the command line arguments
     */
    static String filename = "/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/dels_Trio-CEU_20090616.txt";
    static StringBuffer str_buf = new StringBuffer();
    static String output_file = filename.replace(".txt", "_variations.meander");

    public static void write_file(StringBuffer buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer.toString());
            out.close();


        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());


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
            //Read File Line By Line
            int cnt = 0;
            while ((strLine = br.readLine()) != null) {
                if (cnt != 0) {
                    String[] str = strLine.split("\t");

                    String element1 = str[0].replace("chr", "chromosome:");

                    str_buf.append(element1 + "\t" + "variation:deletion" + "\t" + "start:" + str[1] + "\t" + "end:" + str[2]);
                    str_buf.append("\n");

                }cnt++;
            }
            //Close the input stream
            in.close();
            write_file(str_buf, output_file);
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
