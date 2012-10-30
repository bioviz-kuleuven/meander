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

/**
 *
 * @author gpavlopo
 */
public class PE_filtering {

    static ArrayList<Integer> startA_tmp = new ArrayList();
    static ArrayList<Integer> startB_tmp = new ArrayList();
    static ArrayList<Integer> startA = new ArrayList();
    static ArrayList<Integer> startB = new ArrayList();
    static int upper_threshold =1000000;
    static int lower_threshold =100;
    static StringBuffer buf = new StringBuffer();
    public static void main(String[] args) {
        load_file("/Users/gpavlopo/Desktop/Meander/Arabidopsis/ICE97_pairs_Chr1_corrected.txt");
        
        for (int i = 0; i < startA_tmp.size(); i++) {
            int distance = Math.abs(startA_tmp.get(i)-startB_tmp.get(i));
            if(distance>=lower_threshold && distance<=upper_threshold)
            {
                startA.add(startA_tmp.get(i));
                startB.add(startB_tmp.get(i));
            }
        }
        
        buf.append("sample\tchromosomeA\tstartA\tchromosomeB\tstartB\n");
        for (int i = 0; i < startA.size(); i++) {
            buf.append("1\t1\t"+startA.get(i)+"\t1\t"+startB.get(i)+"\n"); 
        }
        
        write_file(buf.toString(),"/Users/gpavlopo/Desktop/Meander/Arabidopsis/ICE97_pairs_Chr1_threshold_"+lower_threshold+".meander");
        
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

    public static void load_file(String filename) {
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
                startA_tmp.add(Integer.parseInt(str[0]));
                startB_tmp.add(Integer.parseInt(str[1]));
                
                cnt++;
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}


