/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gpavlopo
 */
public class GenericMethods {

    public static String[] fastSplit(String line, char split) {
        String[] temp = new String[line.length() / 2];
        int wordCount = 0;
        int i = 0;
        int j = line.indexOf(split);  // First substring
        while (j >= 0) {
            temp[wordCount++] = line.substring(i, j);
            i = j + 1;
            j = line.indexOf(split, i);   // Rest of substrings
        }
        temp[wordCount++] = line.substring(i); // Last substring
        String[] result = new String[wordCount];
        System.arraycopy(temp, 0, result, 0, wordCount);
        return result;
    }//end fastSplit

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

    public static int giveFilename_getZoom(String filename) {
        String[] str = filename.split("_zoom_");
        String s = str[1].substring(0, str[1].indexOf("_part"));
        return Integer.parseInt(s);
    }

    public static int giveFilename_getIndex(String filename) {
        String[] str = filename.split("_part_");
        String s = str[1].substring(0, str[1].indexOf("_.txt"));
        return Integer.parseInt(s);
    }

    public static void append_file(StringBuffer buffer, String filename) {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(filename, append);

            fw.write(buffer.toString());//appends the string to the file
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean file_exists(String path) {
        boolean exists;
        File f = new File(path);
        if (f.exists()) {
            exists = true;
        } else {
            exists = false;
        }
        return exists;
    }

    public static void create_folder(String path) {
        try {
            File f = new File(path);
            if (f.exists() == false) {
                f.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void copyfile(String srFile, String dtFile) {
        try {
            File f1 = new File(srFile);
            File f2 = new File(dtFile);
            InputStream in = new FileInputStream(f1);

            //For Append the file.
//  OutputStream out = new FileOutputStream(f2,true);

            //For Overwrite the file.
            OutputStream out = new FileOutputStream(f2);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("File copied.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get_shorter_double(double val) {
        String s = "" + val;
        int length = 1;
        int pos = s.indexOf(".") + 1;

        if ((s.length() - pos) == 1) {
            length = 1;
        }
        if ((s.length() - pos) == 2) {
            length = 2;
        }
        if ((s.length() - pos) == 3) {
            length = 3;
        }
        if ((s.length() - pos) >= 4) {
            length = 4;
        }


        if (s.contains(".")) {
            s = s.substring(0, s.indexOf(".") + (length + 1));
        }

        return s;
    }

    static boolean isNumber(String txt) {
        try {
            Double.parseDouble(txt);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static int random_number_within_range(int minimum, int maximum) {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        return randomNum;
    }

    static int get_lines_of_file(String filename) {
        int counter = 0;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                counter++;
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }

        return counter;
    }

    static int get_start_reported_position_in_file(String filename) {
        int counter = 0;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                strLine=strLine.replaceAll(" ", "");
                if (!strLine.startsWith("position")&& strLine.length()>=2) {
                    String[] str = strLine.split("\t");
                    counter = Integer.parseInt(str[0]);
                    break;
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }

        return counter;
    }
       /*
     * The reads that have value 0 are not included interface the file.
     * This methods creates a second extended file containing all of the zeros
     */
    public static int get_number_of_columns(String filename) {
        int columns = 0;
        int cnt = 0;
        try {

            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                strLine=strLine.replaceAll(" ", "");
                String[] str = strLine.split("\t");
                columns = str.length;
                cnt++;
                if (cnt == 2) {
                    break;
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
       }



        return columns;
    }
    
    public static int get_last_reported_position_in_file(String filename) 
    {
        int position=-1;
        String strLine = lastNlines(filename,10);
        String[] str = strLine.split("\t");
        position = Integer.parseInt(str[0].trim());
        return position;
    }
    
    
        public static int get_last_reported_position_in_file_extensive(String filename) {
        int counter = 0;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                
                if (!strLine.startsWith("position")&& strLine.length()>=2) {
                    strLine=strLine.replaceAll(" ", "");
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

    public static String giveNumber_getHumanformat(int number) {

        return Variables.formatter.format(number);

    }

    public static String giveNumber_getHumanformat(double number) {

        return Variables.formatter.format(number);

    }

    public static String giveNumber_getHumanformat(float number) {

        return Variables.formatter.format(number);

    }

    public static int give2D_coordinates_get1D(int x, int y, int grid_size) {
        int counter = 1;

        for (int i = 1; i <= grid_size; i++) {
            for (int j = 1; j <= grid_size; j++) {

                if (i == x && j == y) {
                    return counter;
                }

                counter++;
            }

        }
        return counter;
    }

    public static List<String> splitLines(String string) {
        try {
            ArrayList<String> list = new ArrayList<String>();

            LineNumberReader reader = new LineNumberReader(new StringReader(string));
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
            return list;
        } catch (IOException e) {
            // I don't think this can really happen with a StringReader.
            throw new RuntimeException(e);
        }
    }

    public static void delete_file(String filename) {

        File f = new File(filename);
        f.delete();

    }
    
    public static String lastNlines( String file, int lines) {
    
      
        StringBuffer sss = new StringBuffer();
        try {
            Iterator<String> it = new MMapFile(file).tail(lines);
            while (it.hasNext()) {
                sss.append(it.next());
                sss.append("\n");
            }
            
            return sss.toString();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
}

    
    
     public static void split_File(String filename, int parts, int zoom) {

        int file_counter = 1;

        int columns = get_number_of_columns(filename);

        if (!filename.endsWith(".txt")) {
            filename += ".txt";
        }

        int lines = GenericMethods.get_lines_of_file(filename) - 2;//header
        // System.out.println("lines:" + lines);

        int breakpoint = lines / parts;

        String filename_2 = "";
        StringBuffer sss = new StringBuffer();

        boolean created = false;

        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String firstLine = "";
            int cnt = 0;
            while ((strLine = br.readLine()) != null) {
                if (strLine.startsWith("position")) {
                    firstLine = strLine;
                }
                if (!strLine.startsWith("position") && file_counter <= parts) {
                    cnt++;

                    sss.append(strLine + "\n");


                    filename_2 = filename.replace(".txt", "_zoom_" + zoom + "_part_" + file_counter + "_.txt");



                    if (created == false) {
                        GenericMethods.write_file(firstLine + "\n", filename_2);
                        created = true;
                    }


                    if (cnt % breakpoint == 0) {
                        file_counter++;
                        if (sss.length() > 0) {
                            GenericMethods.append_file(sss, filename_2);
                        }
                        sss.setLength(0);
                        created = false;
//                        if (!tokenized_files.contains(filename_2)) {
//                            tokenized_files.add(filename_2);
//                        }
                    }


                    if (cnt % 100000 == 0) {
                        System.gc();
                        GenericMethods.append_file(sss, filename_2);
                        sss.setLength(0);
                    }
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }

    }
}
