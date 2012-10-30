package experiments;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gpavlopo
 */
public class NewMain {

    private ArrayList<Integer> give_position_get_depth_1 = new ArrayList();
    private ArrayList<Integer> give_position_get_depth_2 = new ArrayList();
    private StringBuffer buf = new StringBuffer();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String input1 = null;
            String input2 = null;
            String output=null;
            StringBuffer str = new StringBuffer();
            
            for (int i = 1; i <=262144; i++) {
            str.append(i+"\t1"+"\n");    
                
            }
            write_file(str.toString(), "/Users/gpavlopo/Desktop/test.txt");
                    
//            NewMain a1 = new NewMain();
//            String input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr1.txt";
//            String input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr1.txt";
//            String output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr1.txt";
//            a1.initialize(input1, input2);
//            a1.read_file1(input1);
//            a1.read_file2(input2);
//            a1.write_file("", output);
//            a1.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//
//            NewMain a2 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr2.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr2.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr2.txt";
//            a2.initialize(input1, input2);
//            a2.read_file1(input1);
//            a2.read_file2(input2);
//            a2.write_file("", output);
//            a2.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//            NewMain a3 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr3.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr3.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr3.txt";
//            a3.initialize(input1, input2);
//            a3.read_file1(input1);
//            a3.read_file2(input2);
//            a3.write_file("", output);
//            a3.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//            NewMain a4 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr4.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr4.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr4.txt";
//            a4.initialize(input1, input2);
//            a4.read_file1(input1);
//            a4.read_file2(input2);
//            a4.write_file("", output);
//            a4.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");

//            NewMain a5 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr5.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr5.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr5.txt";
//            a5.initialize(input1, input2);
//            a5.read_file1(input1);
//            a5.read_file2(input2);
//            a5.write_file("", output);
//            a5.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//            //----------------------------------------------------------------------------
//
//            NewMain a6 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr1.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr1.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr1.txt";
//            a6.initialize(input1, input2);
//            a6.read_file1(input1);
//            a6.read_file2(input2);
//            a6.write_file("", output);
//            a6.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//            NewMain a7 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr2.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr2.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr2.txt";
//            a7.initialize(input1, input2);
//            a7.read_file1(input1);
//            a7.read_file2(input2);
//            a7.write_file("", output);
//            a7.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");

//            NewMain a8 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr3.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr3.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr3.txt";
//            a8.initialize(input1, input2);
//            a8.read_file1(input1);
//            a8.read_file2(input2);
//            a8.write_file("", output);
//            a8.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//            NewMain a9 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr4.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr4.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr4.txt";
//            a9.initialize(input1, input2);
//            a9.read_file1(input1);
//            a9.read_file2(input2);
//            a9.write_file("", output);
//            a9.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//
//            NewMain a10 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_Chr5.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr5.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr5.txt";
//            a10.initialize(input1, input2);
//            a10.read_file1(input1);
//            a10.read_file2(input2);
//            a10.write_file("", output);
//            a10.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
            //----------------------------------------------------------------------------

//            NewMain a11 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr1.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr1.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr1.txt";
//            a11.initialize(input1, input2);
//            a11.read_file1(input1);
//            a11.read_file2(input2);
//            a11.write_file("", output);
//            a11.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//            NewMain a12 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr2.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr2.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr2.txt";
//            a12.initialize(input1, input2);
//            a12.read_file1(input1);
//            a12.read_file2(input2);
//            a12.write_file("", output);
//            a12.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");

//            NewMain a13 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr3.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr3.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr3.txt";
//            a13.initialize(input1, input2);
//            a13.read_file1(input1);
//            a13.read_file2(input2);
//            a13.write_file("", output);
//            a13.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//            NewMain a14 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr4.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr4.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr4.txt";
//            a14.initialize(input1, input2);
//            a14.read_file1(input1);
//            a14.read_file2(input2);
//            a14.write_file("", output);
//            a14.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
//
//
//            NewMain a15 = new NewMain();
//            input1 = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_Chr5.txt";
//            input2 = "/Users/gpavlopo/Desktop/Arabidopsis/ICE97_Chr5.txt";
//            output = "/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr5.txt";
//            a15.initialize(input1, input2);
//            a15.read_file1(input1);
//            a15.read_file2(input2);
//            a15.write_file("", output);
//            a15.merge_files(output);
//            System.out.println("produced outut:" + output);
//            System.out.println("\n\n");
        } catch (Exception e) {
        }
    }

    void initialize(String filename1, String filename2) {
        int lines1 = get_last_line_of_file(filename1);
        System.out.println("counted lines of file 1:" + lines1);
        int lines2 = get_last_line_of_file(filename2);
        System.out.println("counted lines of file 2:" + lines2);
        int max = Math.max(lines2, lines1);

        for (int i = 0; i < max; i++) {
            this.give_position_get_depth_1.add(0);
            this.give_position_get_depth_2.add(0);
        }

    }

    void merge_files(String filename) {

        int depth1 = 0;
        int depth2 = 0;

        buf.setLength(0);
        buf.append("position\tsample\treference\n");

        int max = Math.max(this.give_position_get_depth_1.size(), this.give_position_get_depth_2.size());
        System.out.println("max:" + max);
        for (int k = 0; k < max; k++) {
            depth1 = this.give_position_get_depth_1.get(k);
            depth2 = this.give_position_get_depth_2.get(k);

            buf.append((k + 1) + "\t" + depth1 + "\t" + depth2 + "\n");

            if (k % 10000 == 0) {
                append_file(buf, filename);
                buf.setLength(0);
            }

        }

        append_file(buf, filename);
        buf.setLength(0);

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

    int get_last_line_of_file(String filename) {
        int counter = 0;
        System.out.println("filename:" + filename);
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

    void read_file1(String filename) {
        try {


            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!(strLine.startsWith("position") || strLine.startsWith("Position"))) {
                    String[] str = strLine.split("\t");
                    this.give_position_get_depth_1.set(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]));
                }
            }
            in.close();
            System.out.println("Finished index for file 1");
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }

    void read_file2(String filename) {
        try {


            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (!(strLine.startsWith("position") || strLine.startsWith("Position"))) {
                    String[] str = strLine.split("\t");
                    this.give_position_get_depth_2.set(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]));
                }
            }
            in.close();
            System.out.println("Finished index for file 2");
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }

    //This method creates a file with the content of the buffer
   static  void write_file(String buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer);
            out.close();

        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
    }
}
