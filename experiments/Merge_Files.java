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
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author gpavlopo
 */
public class Merge_Files {

    /**
     * @param args the command line arguments
     */
    public static Hashtable<Integer, Integer> give_positionSample_getCoverage = new Hashtable();
    public static Hashtable<Integer, Integer> give_positionReference_getCoverage = new Hashtable();
    public static StringBuffer buf = new StringBuffer();

    public static void main(String[] args) {
        System.out.println("Loading sample");
        load_file("TLE02R.alleleFreq.chr6.bed", 1); //Remission-Sample
        System.out.println("Loading Reference");
        load_file("TLE02.alleleFreq.chr6.bed", 2); //Diagnosis-Reference
        System.out.println("Loaded");
        
        buf.append("position\tsample\treference\n");
        write_file("","TLE02.alleleFreq.chr6.out");
               
        for (int i = 60000; i < 172000000; i++) {
            if(give_positionSample_getCoverage.get(i)!=null && give_positionReference_getCoverage.get(i)!=null)
            {
                buf.append(i+"\t"+give_positionSample_getCoverage.get(i)+"\t"+give_positionReference_getCoverage.get(i)+"\n");
                if(i%3000==0)
                {
                    append_file(buf,"/TLE02.alleleFreq.chr6.out");
                    buf.setLength(0);
                }
            }
        } append_file(buf,"TLE02.alleleFreq.chr6.out");
                    
    }

    //This method creates a file with the content of the buffer
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

    public static void append_file(StringBuffer buffer, String filename) {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(filename, append);

            fw.write(buffer.toString());//appends the string to the file
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void load_file(String filename, int which) { //which=1 sample | which=2 reference
        try {
            // Open the file that is the first 
            // command line parameter
            int cnt = 0;
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String str[] = strLine.split("\t");
                String str2[] = str[3].split(";");
                if (which == 1) {
                    give_positionSample_getCoverage.put(Integer.parseInt(str[1]),Integer.parseInt(str2[0]));
                }
                if (which == 2) {
                       give_positionReference_getCoverage.put(Integer.parseInt(str[1]),Integer.parseInt(str2[0]));
                }
                if (cnt == 0) {
                    System.out.println("position:" + str[1] + "\t" + "coverage:" + str2[0]);
                }
                cnt++;
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
