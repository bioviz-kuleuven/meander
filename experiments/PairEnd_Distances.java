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
import java.util.Hashtable;

/**
 *
 * @author gpavlopo
 */
public class PairEnd_Distances {

    /**
     * @param args the command line arguments
     */
       public static String input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr1.meander";
       public static String output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr1_pair_end_distances.txt";
       public static StringBuffer buf = new StringBuffer();
       public static Hashtable<Integer, Integer> give_position_get_distance = new Hashtable();
       public static int last_line = 30427665;

    public static void main(String[] args) {
        find_last_line(input);
        read_file(input);
        process();
    }

    public static void process() {
        write_file("position\tsample\n", output);
        for (int i = 1; i <= last_line; i++) {
            int distance=0;
            if(give_position_get_distance.get(i)!=null)
                distance=give_position_get_distance.get(i);
      
                buf.append(i + "\t" + distance + "\n");
                if(i%100000==0)
                {    
                 append_file(buf, output);
                 buf.setLength(0);
                }

        }append_file(buf, output);
    }

     public static void find_last_line(String filename) {

        System.out.println("filename:" + filename);
        try {
            FileInputStream fstream = new FileInputStream(input);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] str = strLine.split("\t");
                last_line = Integer.parseInt(str[0]);
            }
            //Close the input stream
            in.close();
            System.out.println("reads: " + give_position_get_distance.size());
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }


    }
    public static void read_file(String filename) {

        System.out.println("filename:" + filename);
        try {
            FileInputStream fstream = new FileInputStream(input);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] str = strLine.split("\t");
                int pair1_start = Integer.parseInt(str[0]);
                int pair2_start = Integer.parseInt(str[1]);
                give_position_get_distance.put(pair1_start , Math.abs(pair2_start-pair1_start));
            }
            //Close the input stream
            in.close();
            System.out.println("reads: " + give_position_get_distance.size());
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }


    }
    //This method creates a file with the content of the buffer

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
}
