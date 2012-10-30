/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rawsequence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Georgios
 */
public class TestRead {

    static ArrayList <Long> positions = new ArrayList ();
    static ArrayList <Long> reads = new ArrayList ();

    public static void load_expressions(String filename) {
        String line = null;
        long currentLineNo = 1;

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String strLine=null;
            while ((strLine = in.readLine()) != null) {
            String[] str = fastSplit(strLine, '\t');
                long pos = Long.parseLong(str[0]);
                long val = Long.parseLong(str[1]);
                
                positions.add(pos);
                reads.add(val);
                if(currentLineNo%1000000==0)System.gc();
                currentLineNo++;     
            }

        } catch (IOException ex) {
            System.out.println("Problem reading file.\n" + ex.getMessage());
        }
    }
   public static String[] fastSplit(String line, char split){
            String[] temp = new String[line.length()/2];
            int wordCount = 0;
            int i = 0;
            int j = line.indexOf(split);  // First substring
            while( j >= 0){
                temp[wordCount++] = line.substring(i,j);
                i = j + 1;
                j = line.indexOf(split, i);   // Rest of substrings
           }
           temp[wordCount++] = line.substring(i); // Last substring
           String[] result = new String[wordCount];
           System.arraycopy(temp, 0, result, 0, wordCount);
           return result;
       }//end fastSplit



    public static void showLines(String fileName, int startLine, int endLine) {
        String line = null;
        int currentLineNo = 1;

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));

            //read to startLine
            while (currentLineNo < startLine) {
                if (in.readLine() == null) {
                    // oops, early end of file
                    throw new IOException("File too small");
                }
                currentLineNo++;
            }

            //read until endLine
            while (currentLineNo <= endLine) {
                line = in.readLine();
                if (line == null) {
                    // here, we'll forgive a short file
                    // note finally still cleans up
                    return;
                }
                System.out.println(line);
                currentLineNo++;
            }

        } catch (IOException ex) {
            System.out.println("Problem reading file.\n" + ex.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ignore) {
            }
        }
    }

    public static void main(String[] args) {
       // showLines("chr22_pileup_columns.txt", 4173771, 4173791);
        load_expressions("test_raw.txt");
    }
}
