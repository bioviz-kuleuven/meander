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
public class Pairs {

    /**
     * @param args the command line arguments
     */
    String input = null;
    String output = null;
    StringBuffer buf = new StringBuffer();
    ArrayList<String> pairs = new ArrayList();

    public static void main(String[] args) {

//        Pairs a1 = new Pairs();
//        a1.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_pairs_Chr1_tmp.txt";
//        a1.output = a1.input.replace("_tmp", "");
//        a1.output = a1.output.replace(".txt", ".meander");
//        a1.read_file("Chr1");
//        a1.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a2 = new Pairs();
//        a2.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_pairs_Chr2_tmp.txt";
//        a2.output = a2.input.replace("_tmp", "");
//        a2.output = a2.output.replace(".txt", ".meander");
//        a2.read_file("Chr2");
//        a2.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a3 = new Pairs();
//        a3.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_pairs_Chr3_tmp.txt";
//        a3.output = a3.input.replace("_tmp", "");
//        a3.output = a3.output.replace(".txt", ".meander");
//        a3.read_file("Chr3");
//        a3.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a4 = new Pairs();
//        a4.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_pairs_Chr4_tmp.txt";
//        a4.output = a4.input.replace("_tmp", "");
//        a4.output = a4.output.replace(".txt", ".meander");
//        a4.read_file("Chr4");
//        a4.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
        
//        Pairs a5 = new Pairs();
//        a5.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_pairs_Chr5_tmp.txt";
//        a5.output = a5.input.replace("_tmp", "");
//        a5.output = a5.output.replace(".txt", ".meander");
//        a5.read_file("Chr5");
//        a5.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//      //  ----------------------------------------------------
//        Pairs a6 = new Pairs();
//        a6.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr1_tmp.txt";
//        a6.output = a6.input.replace("_tmp", "");
//        a6.output = a6.output.replace(".txt", ".meander");
//        a6.read_file("Chr1");
//        a6.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a7 = new Pairs();
//        a7.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr2_tmp.txt";
//        a7.output = a7.input.replace("_tmp", "");
//        a7.output = a7.output.replace(".txt", ".meander");
//        a7.read_file("Chr2");
//        a7.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a8 = new Pairs();
//        a8.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr3_tmp.txt";
//        a8.output = a8.input.replace("_tmp", "");
//        a8.output = a8.output.replace(".txt", ".meander");
//        a8.read_file("Chr3");
//        a8.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
        
//        Pairs a9 = new Pairs();
//        a9.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr4_tmp.txt";
//        a9.output = a9.input.replace("_tmp", "");
//        a9.output = a9.output.replace(".txt", ".meander");
//        a9.read_file("Chr4");
//        a9.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a10 = new Pairs();
//        a10.input = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr5_tmp.txt";
//        a10.output = a10.input.replace("_tmp", "");
//        a10.output = a10.output.replace(".txt", ".meander");
//        a10.read_file("Chr5");
//        a10.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//      //----------------------------------------------------
//
//        
//        Pairs a11 = new Pairs();
//        a11.input = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_pairs_Chr1_tmp.txt";
//        a11.output = a11.input.replace("_tmp", "");
//        a11.output = a11.output.replace(".txt", ".meander");
//        a11.read_file("Chr1");
//        a11.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
//        
//        Pairs a12 = new Pairs();
//        a12.input = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_pairs_Chr2_tmp.txt";
//        a12.output = a12.input.replace("_tmp", "");
//        a12.output = a12.output.replace(".txt", ".meander");
//        a12.read_file("Chr2");
//        a12.control_and_write_file();
//        System.out.println("-------------");
//        System.gc();
        
        Pairs a13 = new Pairs();
        a13.input = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_pairs_Chr3_tmp.txt";
        a13.output = a13.input.replace("_tmp", "");
        a13.output = a13.output.replace(".txt", ".meander");
        a13.read_file("Chr3");
        a13.control_and_write_file();
        System.out.println("-------------");
        System.gc();
        
        Pairs a14 = new Pairs();
        a14.input = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_pairs_Chr4_tmp.txt";
        a14.output = a14.input.replace("_tmp", "");
        a14.output = a14.output.replace(".txt", ".meander");
        a14.read_file("Chr4");
        a14.control_and_write_file();
        System.out.println("-------------");
        System.gc();
        
        Pairs a15 = new Pairs();
        a15.input = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_pairs_Chr5_tmp.txt";
        a15.output = a15.input.replace("_tmp", "");
        a15.output = a15.output.replace(".txt", ".meander");
        a15.read_file("Chr5");
        a15.control_and_write_file();
        System.out.println("-------------");
        System.gc();

    }

    void control_and_write_file() {
        write_file("", output);
        for (int i = 0; i < pairs.size(); i++) {
            String[] str = pairs.get(i).split("\t");

            int pair1_start = Integer.parseInt(str[0]);

            int pair2_start = Integer.parseInt(str[1]);


            if (pair1_start < pair2_start) {
                buf.append(pair1_start + "\t" + pair2_start + "\n");
                if (i % 1000 == 0) {
                    append_file(buf, output);
                    buf.setLength(0);
                }
            } else {
                System.out.println("Error in: " + pairs.get(i));
            }
        }
        append_file(buf, output);
        buf.setLength(0);
    }

    void read_file(String chromosome) {

        System.out.println("filename:" + this.input);
        try {
            FileInputStream fstream = new FileInputStream(this.input);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (strLine.startsWith(chromosome)) {

                    String[] str = strLine.split("\t");
                    if (str[3].compareTo("=") == 0 && Integer.parseInt(str[1]) > 0 && Integer.parseInt(str[4]) > 0) {


                        int pair1_start = Integer.parseInt(str[1]);
                        int pair2_start = Integer.parseInt(str[4]);

                        if (pair2_start > pair1_start) {
                            pairs.add(pair1_start + "\t" + pair2_start);
                        }
                    }
                }
            }
            //Close the input stream
            in.close();
            System.out.println("reads: " + pairs.size());
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }


    }

    //This method creates a file with the content of the buffer
    void write_file(String buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer);
            out.close();

        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }

    void append_file(StringBuffer buffer, String filename) {
        try {

            FileWriter fstream = new FileWriter(filename, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer.toString());
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
