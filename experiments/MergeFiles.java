package experiments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gpavlopo
 */
public class MergeFiles {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        String filename1 = "/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_Chr19.txt";
        String filename2 = "/Users/gpavlopo/Desktop/Meander/Thierry_story/B8FF4C_Chr19.txt";
        String filename3 = "/Users/gpavlopo/Desktop/Meander/Thierry_story/B8FB3A_chr19.txt";
        String filename4 = "/Users/gpavlopo/Desktop/Meander/Thierry_story/A6GD7A_chr19.txt";
        String filename5 = "/Users/gpavlopo/Desktop/Meander/Thierry_story/A6GE4F_Chr19.txt";

        String output = "/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr19.txt";
        
        int[] list1 = read_second_column_of_file(filename1);
        System.out.println("file 1 loaded");
        int[] list2 = read_second_column_of_file(filename2);
        System.out.println("file 2 loaded");
        int[] list3 = read_second_column_of_file(filename3);
        System.out.println("file 3 loaded");
        int[] list4 = read_second_column_of_file(filename4);
        System.out.println("file 4 loaded");
        int[] list5 = read_second_column_of_file(filename5);
        System.out.println("file 5 loaded");
        
        
//        StringBuffer str = new StringBuffer("position\treference\tsample1\tsample2\tsample3\tsample4\n");
//        
//        
//         write_file("", output);
//      
//        for (int i = 0; i < list5.length; i++) {
//           str.append(""+(i+1)+"\t"+list1[i]+"\t"+list2[i]+"\t"+list3[i]+"\t"+list4[i]+"\t"+list5[i]+"\n");
//           if(i%10000==0){
//                append_file(str.toString(), output);
//                str.setLength(0);
//            }
//        } append_file(str.toString(), output);
    }

    public static int[] read_second_column_of_file(String filename) {

        int[] array = new int[59128983];
        int max=-1;
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int cnt = 0;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                String[] str = strLine.split("\t");
                array[cnt] = (Integer.parseInt(str[1]));
                max=Math.max(max, Integer.parseInt(str[1]));
                cnt++;
            }
            //Close the input stream
            in.close();
            System.out.println(max);
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        return array;
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

    //This method creates a file with the content of the buffer
    public static void write_file(String buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer);
            out.close();


        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();


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
}
