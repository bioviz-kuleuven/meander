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
public class Temporary_for_parsing_files {

    public static ArrayList<Integer> give_position_get_depth_1 = new ArrayList();
    public static ArrayList<Integer> give_position_get_depth_2 = new ArrayList();
    public static StringBuffer buf = new StringBuffer();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {


            read_file1("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr1.txt");
            read_file2("/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr1.txt");
            String output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr1.txt";
            write_file(buf, output);
            merge_files(output);

        } catch (Exception e) {
        }
    }

    static void flush() {
        give_position_get_depth_1.clear();
        give_position_get_depth_2.clear();
        buf.setLength(0);

    }

    static void merge_files(String filename) {

     
 

        int depth1 = 0;
        int depth2 = 0;

        buf.setLength(0);
        buf.append("position\tsample\treference\n");

        for (int k = 0; k < Math.max(give_position_get_depth_1.size(), give_position_get_depth_2.size()); k++) {
           

            if (give_position_get_depth_1.get(k) != null) {
                depth1 = give_position_get_depth_1.get(k);
            }
            if (give_position_get_depth_2.get(k) != null) {
                depth2 = give_position_get_depth_2.get(k);
            }

            buf.append((k + 1) + "\t" + depth1 + "\t" + depth2 + "\n");

            if (k % 10000 == 0) {
                append_file(buf, filename);
                buf.setLength(0);
            }
            
            if(k>=30420001)
                System.out.println(k);


        }
        System.out.println("dkjgbkdfbv");
        append_file(buf, filename);
        buf.setLength(0);




    }

    public static void append_file(StringBuffer buffer, String filename) {
        try {

            FileWriter fstream = new FileWriter(filename, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer.toString());
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static int get_last_line_of_file(String filename) {
        int counter = 0;
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (!(strLine.startsWith("position") || strLine.startsWith("Position"))) {

                    String[] str = strLine.split("\t");
                    counter = Integer.parseInt(str[0]);
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }

        return counter;
    }

    static void read_file1(String filename) {
        try {

            int lines = get_last_line_of_file(filename);
            System.out.println("counted lines of file 1:" + lines);
            for (int i = 0; i < lines; i++) {
                give_position_get_depth_1.add(0);
            }
            System.out.println("initialized index for file 1");
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!(strLine.startsWith("position") || strLine.startsWith("Position"))) {
                    String[] str = strLine.split("\t");
                    give_position_get_depth_1.set(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]));
                }
            }
            in.close();
            System.out.println("Finished index for file 1");
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }

    static void read_file2(String filename) {
        try {

            int lines = get_last_line_of_file(filename);
            System.out.println("counted lines of file 2:" + lines);
            for (int i = 0; i < lines; i++) {
                give_position_get_depth_2.add(0);
            }
            System.out.println("initialized index for file 2");
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!(strLine.startsWith("position") || strLine.startsWith("Position"))) {
                    String[] str = strLine.split("\t");
                    give_position_get_depth_2.set(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]));
                }
            }
            in.close();
            System.out.println("Finished index for file 2");
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }

    //This method creates a file with the content of the buffer
    public static void write_file(StringBuffer buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer.toString());
            out.close();

        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }
}
