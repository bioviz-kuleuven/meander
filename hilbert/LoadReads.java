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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import processing.core.PApplet;

/**
 *
 * @author Georgios
 */
public class LoadReads extends PApplet {

    public static ArrayList<String> readIDs = new ArrayList();
    public static ArrayList<Double> read_depth_sample = new ArrayList();
    public static ArrayList<Double> read_depth_reference = new ArrayList();
    public static ArrayList<Double> read_depth_ratio = new ArrayList();
    private static int buckets = 0;
    private static int columns = 0;
    private static String log_file = "";
    private static String file_resolution = "";
    private static String codebase_zooming = "";
    private static StringBuffer str_buf = new StringBuffer();
    private static double value_to_extend = 0;
    private static int zoom_levels = 5;
    private static int min_position = 999999999;
    private static int max_position = -1;
    private static int max_position_hilbert = -1;
    private static int lines_including_missing_zeros = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // System.out.println(max_hilbert_lines(35161430));
        //        create_zooming_files2("/Users/gpavlopo/Desktop/test.txt");
//        for (int i = 1; i <= 7; i++) {
//            System.out.println(i+"\t"+(int)Math.pow(2, 2*i-2));
//
//        }

        // create_zooming_files2("/Users/gpavlopo/Desktop/Thierry/B8FF4C_PD4198b_Chr19.txt");

        // create_zooming_files2("/Users/gpavlopo/Desktop/Thierry/A6GD7A_B8FF4C_Chr19.txt");
        // create_zooming_files2("/Users/gpavlopo/Desktop/Thierry/B8FF4C_A6GD7A_Chr8.txt");

        //extend_File_with_zeros("/Users/gpavlopo/Desktop/Meander/chr_test/test1.txt");
        // split_File("/Users/gpavlopo/Desktop/Meander/chr_test/test1_zeros.txt", 1, 1);
        //average_File("/Users/gpavlopo/Desktop/Meander/chr_test/test2_zeros.txt", 2);
        //int points=(int)Math.pow(600, 2);
        //System.out.println("points to fit screen:"+points);
        //average_File("chr22.pileup.columns_extended.txt", 135);
        //average_File("chr22.pileup.columns_extended.txt", 58603);
        //extend_File_with_zeros("/Users/gpavlopo/Desktop/chr1_ref.txt");
        //average_File("/Users/gpavlopo/Desktop/chr1_ref.txt", 944);
        //average_File("/Users/gpavlopo/Desktop/Meander/chr22/chr22.txt", 135);
        //int lines = GenericMethods.get_lines_of_file("/Users/gpavlopo/Desktop/Meander/chr22/chr22_zeros.txt");
        // System.out.println(lines/(512*512));
        //     convert_from_range_to_single_columns("/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chr1_test_ref.txt");
//extend_File_with_zeros("/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chr1_test_ref_2.txt");
//create_zooming_files2("/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chr1_test_ref.txt");
        // create_zooming_files("/Users/gpavlopo/Desktop/Meander/chr_test/test1.txt");
        // average_File("/Users/gpavlopo/Desktop/Meander/chr22/chr22.txt", 135);
        // split
        // System.out.println("---"+give_max_number_of_lines_to_extend_zeros(35162345));
        // extend_File_with_zeros("/Users/gpavlopo/Desktop/Meander/chr22/chr22.txt");
        // create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry/pico10K_chromosome5.txt");
        // create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry/pico10K_chromosome2.txt");
        // create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry/pico9K_chromosome5.txt");
        // create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry/pico9K_chromosome2.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr1.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr2.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr3.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr4.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_ICE97_Chr5.txt");
//
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE97_pairs_Chr1_pair_end_distances.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr1.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr2.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr3.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr4.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/ICE153_vs_Star-8_77_Chr5.txt");
//        
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr1.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr2.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr3.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr4.txt");
//        create_zooming_files2("/Users/gpavlopo/Desktop/Arabidopsis/Star-8_77_vs_ICE97_Chr5.txt");
//                    create_zooming_files2("/Users/gpavlopo/Desktop/Meander/chr22/chr_22.txt");
        //       create_zooming_files2("/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chr1_test_ref.txt");
        //      extend_File_with_zeros("/Users/gpavlopo/Desktop/Meander/chr22/chr22_copy.txt",true);
        // extend_File_with_zeros("/Users/gpavlopo/Desktop/Zeynep/sample.txt", false);
//        System.out.println("zeros finished...");
//        lines_of_file_with_zeros=35161431;
//        Zoom_Level z = new Zoom_Level(2, lines_of_file_with_zeros);
//        average_File("/Users/gpavlopo/Desktop/Meander/chr22/chr22_zeros.txt", z);
        Variables.chromosome = "14";
        create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr14_normalized.txt", Variables.chromosome, Variables.organism);
        Variables.chromosome = "12";
        create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr12_normalized.txt", Variables.chromosome, Variables.organism);
        Variables.chromosome = "8";
        create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr8_normalized.txt", Variables.chromosome, Variables.organism);
        Variables.chromosome = "3";
        create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr3_normalized.txt", Variables.chromosome, Variables.organism);
        Variables.chromosome = "2";
        create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr2_normalized.txt", Variables.chromosome, Variables.organism);
        Variables.chromosome = "1";
        create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Thierry_story/PD4198b_B8FF4C_B8FB3A_A6GD7A_A6GE4F_Chr1_normalized.txt", Variables.chromosome, Variables.organism);


        //        Variables.chromosome = "1";
        //  create_zooming_files2("/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chr1_test_ref.txt");
        // convert_from_range_to_single_columns("/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chr1_test_ref.txt");
        //  create_zooming_files2("/Users/gpavlopo/Desktop/Meander/Zeynep/chromosome6.txt");
        //  System.out.println(GenericMethods.giveNumber_getHumanformat(523432332));
    }

    //it return the number=2^(2n-2)*512^2
    public static int give_level_get_maximum_points(int zoom_level) {
        return (int) Math.pow(2, (zoom_level)) * (int) Math.pow(2, zoom_level);
    }

//    public static void convert_from_range_to_single_columns(String filename) {
//        ArrayList<Integer> start = new ArrayList();
//        ArrayList<Integer> end = new ArrayList();
//        ArrayList<Double> test = new ArrayList();
//        ArrayList<Double> ref = new ArrayList();
//_copy
//        int columns = get_number_of_columns(filename);
//
//        try {
//
//            FileInputStream fstream = new FileInputStream(filename);
//            DataInputStream in = new DataInputStream(fstream);
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            String strLine;
//            int counter = 0;
//            while ((strLine = br.readLine()) != null) {
//                if (counter != 0) {
//
//                    String[] str = strLine.split("\t");
//                    start.add(Integer.parseInt(str[1]));
//                    end.add(Integer.parseInt(str[2]));
//                    test.add(Double.parseDouble(str[3]));
//                    ref.add(Double.parseDouble(str[4]));
//                }
//                counter++;
//            }
//            in.close();
//        } catch (Exception e) {//Catch exception if any
//            System.err.println("Error: " + e.getMessage());
//        }
//
//
//
//        int minimum = 999999999;
//        int maximum = -1;
//        for (int i = 0; i < start.size(); i++) {
//            minimum = Math.min(minimum, start.get(i));
//            minimum = Math.min(minimum, end.get(i));
//            maximum = Math.max(minimum, start.get(i));
//            maximum = Math.max(minimum, end.get(i));
//
//        }
//
//        //  System.out.println("minimum:"+minimum+"\t"+"maximum:"+maximum);
//
//
//        String filename2 = filename.replace(".txt", "_2.txt");
//        GenericMethods.write_file("", filename2);
//        StringBuffer str = new StringBuffer("position\tsample\treference\n");
//        for (int i = minimum; i <= maximum; i++) {
//
//            for (int j = 0; j < start.size(); j++) {
//                if (i >= start.get(j) && i <= end.get(j)) {
//                    str.append(i + "\t" + test.get(j) + "\t" + ref.get(j) + "\n");
//                    break;
//                }
//            }
//
//            if (i % 50000 == 0) {
//                GenericMethods.append_file(str, filename2);
//                // System.out.println(i + "/" + maximum);
//                str.setLength(0);
//            }
//
//        }
//
//
//
//    }
    public static int give_max_number_of_lines_to_extend_zeros(int number) {
        int zoom1 = give_level_get_maximum_points(1);
        int zoom2 = give_level_get_maximum_points(2);
        int zoom3 = give_level_get_maximum_points(3);
        int zoom4 = give_level_get_maximum_points(4);
        int zoom5 = give_level_get_maximum_points(5);
        int zoom6 = give_level_get_maximum_points(6);
        int zoom7 = give_level_get_maximum_points(7);
        int x = zoom1;
        if (number > 0 && number <= zoom1) {
            x = zoom1;
        }
        if (number > zoom1 && number <= zoom2) {
            x = zoom2;
        }
        if (number > zoom2 && number <= zoom3) {
            x = zoom3;
        }
        if (number > zoom3 && number <= zoom4) {
            x = zoom4;
        }
        if (number > zoom4 && number <= zoom5) {
            x = zoom5;
        }
        if (number > zoom5 && number <= zoom6) {
            x = zoom6;
        }
        if (number > zoom6 && number <= zoom7) {
            x = zoom7;
        }

        return x;
    }

    public static boolean file_list_exists(String filename) {
        //reads a file that contains the paths of the zoomed files and
        //checks that all of the files exist.
        boolean exists = true;

        try {

            FileInputStream fstream = new FileInputStream("textfile.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                File f = new File(strLine);
                if (f.exists() == false) {
                    exists = false;
                }
            }
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }
        return exists;
    }

    /*
     * The reads that have value 0 are not included interface the file.
     * This methods creates a second extended file containing all of the zeros
     */
    public static ArrayList<String> get_headers(String filename) {
        ArrayList<String> headers = new ArrayList();

        try {

            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] str = strLine.split("\t");
                for (int i = 0; i < str.length; i++) {
                    String string = str[i];
                    headers.add(string);
                }

                break;

            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error interface reading file");
        }



        return headers;
    }

    public static int max_hilbert_lines(int number) {

        double result = 0;
        for (int i = 0; i >= 0; i++) {
            result = (int) Math.pow(4, i);
            if (result >= number) {
                return (int) result;
            }
        }
        return 0;
    }

    public static int max_hilbert_lines2(int number) {

        int result = 0;
        for (int i = number; i >= 0; i++) {
            result = i;
            if (result % (512 * 512) == 0) {
                break;
            }
        }
        return result;
    }

    public static void extend_File_with_zeros(String filename, boolean extend_with_zeros) {

        lines_including_missing_zeros = 0;



        ArrayList<String> headers = get_headers(filename);
        columns = GenericMethods.get_number_of_columns(filename);
        System.out.println("\n" + "file has " + columns + " columns");
        min_position = GenericMethods.get_start_reported_position_in_file(filename);
        System.out.println("Chromosome starts from position : " + min_position);
        max_position = GenericMethods.get_last_reported_position_in_file_extensive(filename);
        System.out.println("Chromosome finishes at position : " + max_position);
        int difference = max_position - min_position;
        System.out.println("Chromosome length:" + difference);
        max_position_hilbert = max_hilbert_lines(difference) - difference + max_position;
        System.out.println("Hilbert finishes at position : " + max_position_hilbert);


        String file2 = "";



        try {



            ArrayList<Integer> read = new ArrayList();
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));


            if (!filename.endsWith(".txt")) {
                filename += ".txt";
            }

            file2 = filename.replace(".txt", "_zeros.txt");


            FileWriter fstream2 = new FileWriter(file2);
            BufferedWriter out = new BufferedWriter(fstream2);


            for (int i = 0; i < headers.size() - 1; i++) {
                out.append(headers.get(i) + "\t");
            }
            out.append(headers.get(headers.size() - 1) + "\n");



            String strLine;
            while ((strLine = br.readLine()) != null) {

                strLine = strLine.replaceAll(" ", "");

                if (strLine.trim().length() >= 2 && !strLine.startsWith("position")) {


                    String[] str = strLine.split("\t");
                    read.add(Integer.parseInt(str[0].trim()));

                    if (read.size() <= 1) {
                        out.append(strLine.trim() + "\n");
                        lines_including_missing_zeros++;
                    }
                    if (read.size() >= 2) {
                        int pos1 = read.get(0);
                        int pos2 = read.get(1);
                        if ((pos2 - pos1) == 1) {
                            out.append(strLine.trim() + "\n");

                            lines_including_missing_zeros++;
                        } else {

                            for (int i = pos1 + 1; i < pos2; i++) {
                                if (columns == 2) {
                                    out.append("" + i + "\t" + "0\n");
                                }
                                if (columns == 3) {
                                    out.append("" + i + "\t" + "0\t0\n");
                                }
                                if (columns == 4) {
                                    out.append("" + i + "\t" + "0\t0\t0\n");
                                }
                                if (columns == 5) {
                                    out.append("" + i + "\t" + "0\t0\t0\t0\n");
                                }
                                if (columns == 6) {
                                    out.append("" + i + "\t" + "0\t0\t0\t0\t0\n");
                                }
                                if (columns == 7) {
                                    out.append("" + i + "\t" + "0\t0\t0\t0\t0\t0\n");
                                }
                                if (columns == 8) {
                                    out.append("" + i + "\t" + "0\t0\t0\t0\t0\t0\t0\n");
                                }
                                if (columns == 9) {
                                    out.append("" + i + "\t" + "0\t0\t0\t0\t0\t0\t0\t0\n");
                                }
                                if (columns == 10) {
                                    out.append("" + i + "\t" + "0\t0\t0\t0\t0\t0\t0\t0\t0\n");
                                }


                                lines_including_missing_zeros++;
                            }
                            out.append(strLine.trim() + "\n");
                            lines_including_missing_zeros++;
                        }
                        read.remove(0);
                    }
                    // System.out.println (strLine);

                }

            }
            //Close the input stream
            in.close();


            if (extend_with_zeros) {
                for (int i = max_position + 1; i <= max_position_hilbert; i++) {
                    if (columns == 2) {
                        out.append(i + "\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 3) {
                        out.append(i + "\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 4) {
                        out.append(i + "\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 5) {
                        out.append(i + "\t0\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 6) {
                        out.append(i + "\t0\t0\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 7) {
                        out.append(i + "\t0\t0\t0\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 8) {
                        out.append(i + "\t0\t0\t0\t0\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 9) {
                        out.append(i + "\t0\t0\t0\t0\t0\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }
                    if (columns == 10) {
                        out.append(i + "\t0\t0\t0\t0\t0\t0\t0\t0\t0\n");
                        lines_including_missing_zeros++;
                    }

                }
            }
            out.close();
            lines_including_missing_zeros--;
            System.out.println("Lines of the file with zeros:" + lines_including_missing_zeros);


        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }

    }

    /*
     * splits the file interface equal parts
     */
    /* this class loads the expressions of the files and stores them
     * into the hilbert curve data structure
     */
    public static void calculate_average_ratio1() {
        double sum = 0;

        for (int i = 0; i < Variables.pixels.size(); i++) {
            sum += Variables.pixels.get(i).getRatio1();
        }
        Variables.average_ratio1 = sum / Variables.pixels.size();
    }

    public static void calculate_average_ratio2() {
        double sum = 0;

        for (int i = 0; i < Variables.pixels.size(); i++) {
            sum += Variables.pixels.get(i).getRatio2();
        }
        Variables.average_ratio2 = sum / Variables.pixels.size();
    }

    public static void calculate_average_ratio3() {
        double sum = 0;

        for (int i = 0; i < Variables.pixels.size(); i++) {
            sum += Variables.pixels.get(i).getRatio3();
        }
        Variables.average_ratio3 = sum / Variables.pixels.size();
    }

    public static void calculate_average_ratio4() {
        double sum = 0;

        for (int i = 0; i < Variables.pixels.size(); i++) {
            sum += Variables.pixels.get(i).getRatio4();
        }
        Variables.average_ratio4 = sum / Variables.pixels.size();
    }

    public static void load_expressions(String filename) {

        Variables.reference_values_exist = false;
        Variables.ratio_values_exist = false;
        Variables.sample_values_exist = false;


        String line = null;
        int line_number = 0;
        int progress = 0;
        //int columns = LoadReads.get_number_of_columns(filename);
        Meander.jLabel_status.setText("Loading File...");
        Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
        Meander.jLabel_status.repaint();
        ArrayList<String> columns = new ArrayList();



        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String strLine = null;
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }

            while ((strLine = in.readLine()) != null) {
                //System.out.println(strLine);
                if (line_number == 0) {
                    String[] str = strLine.split("\t");
                    for (int i = 0; i < str.length; i++) {
                        String string = str[i];
                        if (string.compareToIgnoreCase("sample1") == 0) {
                            Variables.sample_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("sample1");
                            columns.add("sample1");
                            Variables.panel1_has_information = true;
                        }
                        if (string.compareToIgnoreCase("sample2") == 0) {
                            Variables.sample_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("sample2");
                            columns.add("sample2");
                            Variables.panel2_has_information = true;
                        }
                        if (string.compareToIgnoreCase("sample3") == 0) {
                            Variables.sample_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("sample3");
                            columns.add("sample3");
                            Variables.panel3_has_information = true;
                        }
                        if (string.compareToIgnoreCase("sample4") == 0) {
                            Variables.sample_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("sample4");
                            columns.add("sample4");
                            Variables.panel4_has_information = true;
                        }
                        if (string.compareToIgnoreCase("sample") == 0) {
                            Variables.sample_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("sample");
                            columns.add("sample");
                            Variables.panel1_has_information = true;
                        }
                        if (string.compareToIgnoreCase("reference") == 0) {
                            Variables.reference_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("reference");
                            columns.add("reference");
                            Variables.panel1_has_information = true;
                        }
                        if (string.compareToIgnoreCase("ratio") == 0) {
                            Variables.ratio_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("ratio");
                            columns.add("ratio");
                            Variables.panel1_has_information = true;
                        }
                        if (string.compareToIgnoreCase("ratio1") == 0) {
                            Variables.ratio_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("ratio1");
                            columns.add("ratio1");
                            Variables.panel1_has_information = true;
                        }
                        if (string.compareToIgnoreCase("ratio2") == 0) {
                            Variables.ratio_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("ratio2");
                            columns.add("ratio2");
                            Variables.panel2_has_information = true;
                        }
                        if (string.compareToIgnoreCase("ratio3") == 0) {
                            Variables.ratio_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("ratio3");
                            columns.add("ratio3");
                            Variables.panel3_has_information = true;
                        }
                        if (string.compareToIgnoreCase("ratio4") == 0) {
                            Variables.ratio_values_exist = true;
                            Variables.check_sample_ref_ratio.setLabel("ratio4");
                            columns.add("ratio4");
                            Variables.panel4_has_information = true;
                        }
                    }
                    for (int i = 0; i < columns.size(); i++) {
                        System.out.println("column " + (i + 1) + ":" + columns.get(i));
                    }
                   
                }



                if ((line_number != 0)) {

                    String[] str = strLine.split("\t");
                    Pixel pixel = new Pixel();
                    pixel.setZoom_level(Variables.zoom);
                    if (str[0].contains("-")) {
                        String[] ss = str[0].split("-");
                        pixel.setPosition_range_start(Integer.parseInt(ss[0]));
                        pixel.setPosition_range_end(Integer.parseInt(ss[1]));
                    }

                    int pos = pixel.getPosition_range_start();
                    if (Variables.min_max_position_is_set == false) {
                        Variables.min_chromosome_position_of_the_zoomed_area = Math.min(pos, Variables.min_chromosome_position_of_the_zoomed_area);
                        Variables.max_chromosome_position_of_the_zoomed_area = Math.max(pos, Variables.max_chromosome_position_of_the_zoomed_area);
                    }



                    for (int i = 0; i < columns.size(); i++) {

                        if (columns.get(i).compareToIgnoreCase("sample1") == 0) {
                            int index = columns.indexOf("sample1") + 1;
                            double value = 1 + Double.parseDouble(str[index]);
//                            if(Double.parseDouble(str[index])!=0)
//                                value+=30;
                            pixel.setCoverage_sample1(value);
                            Variables.average_read_sample1 += pixel.getCoverage_sample1();
                            Variables.min_read_sample1 = Math.min(Variables.min_read_sample1, value);
                            Variables.max_read_sample1 = Math.max(Variables.max_read_sample1, value);
                        }

                        if (columns.get(i).compareToIgnoreCase("sample") == 0) {
                            int index = columns.indexOf("sample") + 1;
                            double value = 1 + Double.parseDouble(str[index]);
//                            if(Double.parseDouble(str[index])!=0)
//                                value+=30;
                            pixel.setCoverage_sample1(value);
                            Variables.average_read_sample1 += pixel.getCoverage_sample1();
                            Variables.min_read_sample1 = Math.min(Variables.min_read_sample1, value);
                            Variables.max_read_sample1 = Math.max(Variables.max_read_sample1, value);
                        }

                        if (columns.get(i).compareToIgnoreCase("sample2") == 0) {
                            int index = columns.indexOf("sample2") + 1;
                            double value = 1 + Double.parseDouble(str[index]);
//                            if(Double.parseDouble(str[index])!=0)
//                                value+=30;
                            pixel.setCoverage_sample2(value);
                            Variables.average_read_sample2 += pixel.getCoverage_sample2();
                            Variables.min_read_sample2 = Math.min(Variables.min_read_sample2, value);
                            Variables.max_read_sample2 = Math.max(Variables.max_read_sample2, value);
                        }

                        if (columns.get(i).compareToIgnoreCase("sample3") == 0) {
                            int index = columns.indexOf("sample3") + 1;
                            double value = 1 + Double.parseDouble(str[index]);
//                            if(Double.parseDouble(str[index])!=0)
//                                value+=30;
                            pixel.setCoverage_sample3(value);
                            Variables.average_read_sample3 += pixel.getCoverage_sample3();
                            Variables.min_read_sample3 = Math.min(Variables.min_read_sample3, value);
                            Variables.max_read_sample3 = Math.max(Variables.max_read_sample3, value);
                        }

                        if (columns.get(i).compareToIgnoreCase("sample4") == 0) {
                            int index = columns.indexOf("sample4") + 1;
                            double value = 1 + Double.parseDouble(str[index]);
//                            if(Double.parseDouble(str[index])!=0)
//                                value+=30;
                            pixel.setCoverage_sample4(value);
                            Variables.average_read_sample4 += pixel.getCoverage_sample4();
                            Variables.min_read_sample4 = Math.min(Variables.min_read_sample4, value);
                            Variables.max_read_sample4 = Math.max(Variables.max_read_sample4, value);
                        }


                        if (columns.get(i).compareToIgnoreCase("reference") == 0) {
                            int index = columns.indexOf("reference") + 1;
                            double value = 1 + Double.parseDouble(str[index]);
                            pixel.setCoverage_reference(value);
                            Variables.average_read_reference += pixel.getCoverage_reference();
                            Variables.min_read_reference = Math.min(Variables.min_read_reference, value);
                            Variables.max_read_reference = Math.max(Variables.max_read_reference, value);
                        }
                        if (Variables.ratio_values_exist == true) {
                            if (columns.get(i).compareToIgnoreCase("ratio") == 0) {
                                int index = columns.indexOf("ratio") + 1;
                                double value = Double.parseDouble(str[index]);
                                pixel.setRatio1(value);
                                Variables.min_read_ratio1 = Math.min(Variables.min_read_ratio1, pixel.getRatio1());
                                Variables.max_read_ratio1 = Math.max(Variables.max_read_ratio1, pixel.getRatio1());
                            }
                        } else {
                            double value = (double) Math.log((double) ((double) 1 + (double) pixel.getCoverage_sample1()) / (double) ((double) 1 + (double) pixel.getCoverage_reference()));
                            pixel.setRatio1(value);
                            Variables.min_read_ratio1 = Math.min(Variables.min_read_ratio1, pixel.getRatio1());
                            Variables.max_read_ratio1 = Math.max(Variables.max_read_ratio1, pixel.getRatio1());
                        }




                        if (Variables.ratio_values_exist == true) {
                            if (columns.get(i).compareToIgnoreCase("ratio1") == 0) {
                                int index = columns.indexOf("ratio1") + 1;
                                double value = Double.parseDouble(str[index]);
                                pixel.setRatio1(value);
                                Variables.min_read_ratio1 = Math.min(Variables.min_read_ratio1, pixel.getRatio1());
                                Variables.max_read_ratio1 = Math.max(Variables.max_read_ratio1, pixel.getRatio1());
                            }
                        } else {
                            double value = (double) Math.log((double) ((double) 1 + (double) pixel.getCoverage_sample1()) / (double) ((double) 1 + (double) pixel.getCoverage_reference()));
                            pixel.setRatio1(value);
                            Variables.min_read_ratio1 = Math.min(Variables.min_read_ratio1, pixel.getRatio1());
                            Variables.max_read_ratio1 = Math.max(Variables.max_read_ratio1, pixel.getRatio1());
                        }


                        if (Variables.ratio_values_exist == true) {
                            if (columns.get(i).compareToIgnoreCase("ratio2") == 0) {
                                int index = columns.indexOf("ratio2") + 1;
                                double value = Double.parseDouble(str[index]);
                                pixel.setRatio2(value);
                                Variables.min_read_ratio2 = Math.min(Variables.min_read_ratio2, pixel.getRatio2());
                                Variables.max_read_ratio2 = Math.max(Variables.max_read_ratio2, pixel.getRatio2());
                            }
                        } else {
                            double value = (double) Math.log((double) ((double) 1 + (double) pixel.getCoverage_sample2()) / (double) ((double) 1 + (double) pixel.getCoverage_reference()));
                            pixel.setRatio2(value);
                            Variables.min_read_ratio2 = Math.min(Variables.min_read_ratio2, pixel.getRatio2());
                            Variables.max_read_ratio2 = Math.max(Variables.max_read_ratio2, pixel.getRatio2());
                        }


                        if (Variables.ratio_values_exist == true) {
                            if (columns.get(i).compareToIgnoreCase("ratio3") == 0) {
                                int index = columns.indexOf("ratio3") + 1;
                                double value = Double.parseDouble(str[index]);
                                pixel.setRatio3(value);
                                Variables.min_read_ratio3 = Math.min(Variables.min_read_ratio3, pixel.getRatio3());
                                Variables.max_read_ratio3 = Math.max(Variables.max_read_ratio3, pixel.getRatio3());
                            }
                        } else {
                            double value = (double) Math.log((double) ((double) 1 + (double) pixel.getCoverage_sample3()) / (double) ((double) 1 + (double) pixel.getCoverage_reference()));
                            pixel.setRatio3(value);
                            Variables.min_read_ratio3 = Math.min(Variables.min_read_ratio3, pixel.getRatio3());
                            Variables.max_read_ratio3 = Math.max(Variables.max_read_ratio3, pixel.getRatio3());
                        }




                        if (Variables.ratio_values_exist == true) {
                            if (columns.get(i).compareToIgnoreCase("ratio4") == 0) {
                                int index = columns.indexOf("ratio4") + 1;
                                double value = Double.parseDouble(str[index]);
                                pixel.setRatio4(value);
                                Variables.min_read_ratio4 = Math.min(Variables.min_read_ratio4, pixel.getRatio4());
                                Variables.max_read_ratio4 = Math.max(Variables.max_read_ratio4, pixel.getRatio4());
                            }
                        } else {
                            double value = (double) Math.log((double) ((double) 1 + (double) pixel.getCoverage_sample4()) / (double) ((double) 1 + (double) pixel.getCoverage_reference()));
                            pixel.setRatio4(value);
                            Variables.min_read_ratio4 = Math.min(Variables.min_read_ratio4, pixel.getRatio4());
                            Variables.max_read_ratio4 = Math.max(Variables.max_read_ratio4, pixel.getRatio4());
                        }


                    }




                    if (Variables.min_max_position_is_set == false) {
                        Variables.min_chromosome_position = Math.min(Variables.min_chromosome_position, pos);
                        Variables.max_chromosome_position = Math.max(Variables.max_chromosome_position, pos);
                    }


                    Variables.pixels.add(pixel);
                    if (Meander.jProgressBar != null) {
                        if (Variables.pixels.size() % 2600 == 0) {

                            Meander.jProgressBar.setValue(Variables.pixels.size());
                            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                            Meander.jProgressBar.repaint();
                        }
                    }
                    if (Variables.pixels_initial.size() <= (512 * 512)) {
                        Variables.pixels_initial.add(pixel);
                    }
                }
                line_number++;


            }

            //normalization
            calculate_average_ratio1();
            calculate_average_ratio2();
            calculate_average_ratio3();
            calculate_average_ratio4();

            for (int i = 0; i < Variables.pixels.size(); i++) {
                Pixel pixel = Variables.pixels.get(i);


                if (pixel.getRatio1() != 0) {
                    pixel.setRatio1(pixel.getRatio1() - Variables.average_ratio1);
                }

                if (pixel.getRatio2() != 0) {
                    pixel.setRatio2(pixel.getRatio2() - Variables.average_ratio2);
                }

                if (pixel.getRatio3() != 0) {
                    pixel.setRatio3(pixel.getRatio3() - Variables.average_ratio3);
                }

                if (pixel.getRatio4() != 0) {
                    pixel.setRatio4(pixel.getRatio4() - Variables.average_ratio4);
                }




            }

            if (Variables.reference_values_exist == true && Variables.sample_values_exist == true) {
                Variables.ratio_values_exist = true;
                Variables.check_sample_ref_ratio.setLabel("ratio");
            }

            double tmp11 = Variables.average_read_sample1;
            double tmp12 = Variables.average_read_sample2;
            double tmp13 = Variables.average_read_sample3;
            double tmp14 = Variables.average_read_sample4;
            double tmp2 = Variables.average_read_reference;
            Variables.average_read_sample1 = tmp11 / Variables.pixels.size();
            Variables.average_read_sample2 = tmp12 / Variables.pixels.size();
            Variables.average_read_sample3 = tmp13 / Variables.pixels.size();
            Variables.average_read_sample4 = tmp14 / Variables.pixels.size();
            Variables.average_read_reference = tmp2 / Variables.pixels.size();

            Variables.min_chromosome_position_of_the_zoomed_area = Variables.pixels.get(0).getPosition_range_start();
            Variables.max_chromosome_position_of_the_zoomed_area = Variables.pixels.get(Variables.pixels.size() - 1).getPosition_range_end();


            System.out.println("Loading file is now completed ");
            Meander.jLabel_status.setText("");
            Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
            Meander.jLabel_status.repaint();



            //histogram
            for (int i = 0; i < 260; i++) {
                Variables.sample_histogram1.add(0);
                Variables.reference_histogram1.add(0);
                Variables.ratio_histogram1.add(0);


                Variables.sample_histogram2.add(0);
                Variables.reference_histogram2.add(0);
                Variables.ratio_histogram2.add(0);


                Variables.sample_histogram3.add(0);
                Variables.reference_histogram3.add(0);
                Variables.ratio_histogram3.add(0);


                Variables.sample_histogram4.add(0);
                Variables.reference_histogram4.add(0);
                Variables.ratio_histogram4.add(0);
            }

            for (int i = 0; i < Variables.pixels.size(); i++) {

                float index_reference1 = map((float) Math.min(Variables.pixels.get(i).getCoverage_reference(), 500), (float) Variables.min_read_sample1, 500, (float) 0.0, (float) 259.0);
                float index_reference2 = map((float) Math.min(Variables.pixels.get(i).getCoverage_reference(), 500), (float) Variables.min_read_sample2, 500, (float) 0.0, (float) 259.0);
                float index_reference3 = map((float) Math.min(Variables.pixels.get(i).getCoverage_reference(), 500), (float) Variables.min_read_sample3, 500, (float) 0.0, (float) 259.0);
                float index_reference4 = map((float) Math.min(Variables.pixels.get(i).getCoverage_reference(), 500), (float) Variables.min_read_sample4, 500, (float) 0.0, (float) 259.0);



                float index_sample1 = map((float) Math.min(Variables.pixels.get(i).getCoverage_sample1(), 500), (float) Variables.min_read_sample1, 500, (float) 0.0, (float) 259.0);
                float index_ratio1 = map((float) Variables.pixels.get(i).getRatio1(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);

                float index_sample2 = map((float) Math.min(Variables.pixels.get(i).getCoverage_sample2(), 500), (float) Variables.min_read_sample2, 500, (float) 0.0, (float) 259.0);
                float index_ratio2 = map((float) Variables.pixels.get(i).getRatio2(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);

                float index_sample3 = map((float) Math.min(Variables.pixels.get(i).getCoverage_sample3(), 500), (float) Variables.min_read_sample3, 500, (float) 0.0, (float) 259.0);
                float index_ratio3 = map((float) Variables.pixels.get(i).getRatio3(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);

                float index_sample4 = map((float) Math.min(Variables.pixels.get(i).getCoverage_sample4(), 500), (float) Variables.min_read_sample4, 500, (float) 0.0, (float) 259.0);
                float index_ratio4 = map((float) Variables.pixels.get(i).getRatio4(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);

                try {
                    if (Variables.panel1_has_information) {
                        Variables.sample_histogram1.set((int) Math.min(259, index_sample1), Variables.sample_histogram1.get((int) Math.min(259, index_sample1)) + 1);
                        Variables.reference_histogram1.set((int) Math.min(259, index_reference1), Variables.reference_histogram1.get((int) Math.min(259, index_reference1)) + 1);
                        Variables.ratio_histogram1.set((int) Math.min(259, index_ratio1), Variables.ratio_histogram1.get((int) Math.min(259, index_ratio1)) + 1);
                    }

                    if (Variables.panel2_has_information) {
                        Variables.sample_histogram2.set((int) Math.min(259, index_sample2), Variables.sample_histogram2.get((int) Math.min(259, index_sample2)) + 1);
                        Variables.reference_histogram2.set((int) Math.min(259, index_reference2), Variables.reference_histogram2.get((int) Math.min(259, index_reference2)) + 1);
                        Variables.ratio_histogram2.set((int) Math.min(259, index_ratio2), Variables.ratio_histogram2.get((int) Math.min(259, index_ratio2)) + 1);
                    }

                    if (Variables.panel3_has_information) {
                        Variables.sample_histogram3.set((int) Math.min(259, index_sample3), Variables.sample_histogram3.get((int) Math.min(259, index_sample3)) + 1);
                        Variables.reference_histogram3.set((int) Math.min(259, index_reference3), Variables.reference_histogram3.get((int) Math.min(259, index_reference3)) + 1);
                        Variables.ratio_histogram3.set((int) Math.min(259, index_ratio3), Variables.ratio_histogram3.get((int) Math.min(259, index_ratio3)) + 1);
                    }

                    if (Variables.panel4_has_information) {
                        Variables.sample_histogram4.set((int) Math.min(259, index_sample4), Variables.sample_histogram4.get((int) Math.min(259, index_sample4)) + 1);
                        Variables.reference_histogram4.set((int) Math.min(259, index_reference4), Variables.reference_histogram4.get((int) Math.min(259, index_reference4)) + 1);
                        Variables.ratio_histogram4.set((int) Math.min(259, index_ratio4), Variables.ratio_histogram4.get((int) Math.min(259, index_ratio4)) + 1);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            for (int i = 0; i < Variables.sample_histogram1.size(); i++) {
                Variables.sample_histogram_max_value1 = Math.max(Variables.sample_histogram_max_value1, (Variables.sample_histogram1.get(i) + 1));
            }
            for (int i = 0; i < Variables.reference_histogram1.size(); i++) {
                Variables.reference_histogram_max_value1 = Math.max(Variables.reference_histogram_max_value1, (Variables.reference_histogram1.get(i) + 1));
            }
            for (int i = 0; i < Variables.ratio_histogram1.size(); i++) {
                Variables.ratio_histogram_max_value1 = Math.max(Variables.ratio_histogram_max_value1, (Variables.ratio_histogram1.get(i) + 1));
            }


            for (int i = 0; i < Variables.sample_histogram2.size(); i++) {
                Variables.sample_histogram_max_value2 = Math.max(Variables.sample_histogram_max_value2, (Variables.sample_histogram2.get(i) + 1));
            }
            for (int i = 0; i < Variables.reference_histogram2.size(); i++) {
                Variables.reference_histogram_max_value2 = Math.max(Variables.reference_histogram_max_value2, (Variables.reference_histogram2.get(i) + 1));
            }
            for (int i = 0; i < Variables.ratio_histogram2.size(); i++) {
                Variables.ratio_histogram_max_value2 = Math.max(Variables.ratio_histogram_max_value2, (Variables.ratio_histogram2.get(i) + 1));
            }


            for (int i = 0; i < Variables.sample_histogram3.size(); i++) {
                Variables.sample_histogram_max_value3 = Math.max(Variables.sample_histogram_max_value3, (Variables.sample_histogram3.get(i) + 1));
            }
            for (int i = 0; i < Variables.reference_histogram3.size(); i++) {
                Variables.reference_histogram_max_value3 = Math.max(Variables.reference_histogram_max_value3, (Variables.reference_histogram3.get(i) + 1));
            }
            for (int i = 0; i < Variables.ratio_histogram3.size(); i++) {
                Variables.ratio_histogram_max_value3 = Math.max(Variables.ratio_histogram_max_value3, (Variables.ratio_histogram3.get(i) + 1));
            }

            for (int i = 0; i < Variables.sample_histogram4.size(); i++) {
                Variables.sample_histogram_max_value4 = Math.max(Variables.sample_histogram_max_value4, (Variables.sample_histogram4.get(i) + 1));
            }
            for (int i = 0; i < Variables.reference_histogram4.size(); i++) {
                Variables.reference_histogram_max_value4 = Math.max(Variables.reference_histogram_max_value4, (Variables.reference_histogram4.get(i) + 1));
            }
            for (int i = 0; i < Variables.ratio_histogram4.size(); i++) {
                Variables.ratio_histogram_max_value4 = Math.max(Variables.ratio_histogram_max_value4, (Variables.ratio_histogram4.get(i) + 1));
            }


//             for (int i = 0; i < Variables.sample_histogram.size(); i++)
//                 System.out.println(Variables.sample_histogram.get(i));
//                 System.out.println("max:"+Variables.reference_histogram_max_value );

            Meander.jMenuItem6.setEnabled(false);
            Meander.file_Open.setEnabled(false);

            Meander.jMenuItem4.setVisible(true);
            Meander.jMenuItem10.setVisible(true);



//            for (int i = 0; i < Variables.pixels.size(); i++) 
//                System.out.println(Variables.pixels.get(i).toString());


        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void create_zooming_files2(String filename, String chromosome, String organism) {


        boolean exists = true;


        Variables.chromosome = chromosome;
        Variables.organism = organism;

        System.out.println("\ncreating project folder...");
        codebase_zooming = filename.replace(".txt", "");
        String name_of_the_file = "";
        GenericMethods.create_folder(codebase_zooming);


        System.out.println("\ncreating backup of source file...");
        File f = new File(filename);
        name_of_the_file = f.getName();
        String full_name = codebase_zooming + System.getProperty("file.separator") + name_of_the_file;
        if (!GenericMethods.file_exists(full_name)) {
            GenericMethods.copyfile(filename, full_name);
        }


        System.out.println("\ncreating log file...");
        // log_file = codebase_zooming + System.getProperty("file.separator") + ".." + System.getProperty("file.separator") + "chromosome_" + Variables.chromosome + ".meander";
        //log_file = codebase_zooming + System.getProperty("file.separator") + ".." + System.getProperty("file.separator") + "chromosome" + ".meander";
        log_file = filename.replace(".txt", ".meander");

        System.out.println("\n" + log_file);
        GenericMethods.write_file("", log_file);
        GenericMethods.append_file("source:\t" + full_name + "\n", log_file);


        System.out.println("\ncreating file with zeros...");
        String zeros = full_name.replace(".txt", "_zeros.txt");
        if (!GenericMethods.file_exists(zeros)) {
            extend_File_with_zeros(full_name, true);
        }

        GenericMethods.append_file("zeros:\t" + zeros + "\n", log_file);
        System.out.println(full_name);


        GenericMethods.append_file("chromosome:" + Variables.chromosome + "\n", log_file);
        GenericMethods.append_file("organism:" + Variables.organism + "\n", log_file);
        GenericMethods.append_file("minimum_position:" + min_position + "\n", log_file);
        GenericMethods.append_file("maximum_position:" + max_position + "\n", log_file);
        GenericMethods.append_file("chromosome_length:" + (max_position - min_position) + "\n", log_file);
        GenericMethods.append_file("maximum_hilbert_position:" + max_position_hilbert + "\n", log_file);

        Variables.organisms_load_allowance = true;

        for (int zoom = 1; zoom <= zoom_levels; zoom++) {//to -1 native fygei
            System.out.println("Creating files for zoom level..." + zoom);
            Zoom_Level z = new Zoom_Level(zoom, lines_including_missing_zeros, min_position, max_position_hilbert);
            average_File(zeros, z);
        }

    }
//

    public static void average_File(String filename, Zoom_Level z) {

        int file_counter = 1;
        int entity_counter = 1;
        boolean file_bigger_than_given_length = false;

        StringBuffer str_buf = new StringBuffer();
        ArrayList<String> headers = get_headers(filename);
        double average_sample1 = 0;
        double average_reference = 0;
        double average_ratio1 = 0;

        double average_sample2 = 0;
        double average_ratio2 = 0;

        double average_sample3 = 0;
        double average_ratio3 = 0;

        double average_sample4 = 0;
        double average_ratio4 = 0;

        double total_cntr = 0;
        double local_cntr = 0;
        String first_position_of_bucket = "";



        try {

            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int starting_point = -1;
            boolean first_line_of_group = true;
            boolean new_file = false;
            while ((strLine = br.readLine()) != null) {
                if (!strLine.startsWith("position")) {
                    String[] str = strLine.split("\t");
                    total_cntr++;
                    local_cntr++;


                    if (first_line_of_group == true) {
                        if (new_file == false) {
                            starting_point = Integer.parseInt(str[0].trim());
                            new_file = true;
                        }
                        first_position_of_bucket = str[0];
                        first_line_of_group = false;
                    }





                    for (int i = 0; i < columns; i++) {

                        if (headers.get(i).compareToIgnoreCase("reference") == 0) {
                            average_reference += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("sample1") == 0 || headers.get(i).compareToIgnoreCase("sample") == 0) {
                            average_sample1 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("ratio1") == 0 || headers.get(i).compareToIgnoreCase("ratio") == 0) {
                            average_ratio1 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("sample2") == 0) {
                            average_sample2 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("ratio2") == 0) {
                            average_ratio2 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("sample3") == 0) {
                            average_sample3 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("ratio3") == 0) {
                            average_ratio3 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("sample4") == 0) {
                            average_sample4 += (Double.parseDouble(str[i]));
                        }
                        if (headers.get(i).compareToIgnoreCase("ratio4") == 0) {
                            average_ratio4 += (Double.parseDouble(str[i]));
                        }

                    }


                    if (local_cntr == z.bucket || total_cntr == Math.abs(max_position_hilbert - min_position) + 1) {
                        // System.out.println(total_cntr+"/"+(max_position-min_position));



                        ArrayList<Double> tmp = new ArrayList();
                        for (int i = 0; i < columns; i++) {
                            tmp.add(-9999999.0);
                        }

                        for (int i = 0; i < columns; i++) {
                            if (headers.get(i).compareToIgnoreCase("reference") == 0) {
                                tmp.set(i, (average_reference / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("sample1") == 0 || headers.get(i).compareToIgnoreCase("sample") == 0) {
                                tmp.set(i, (average_sample1 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("sample2") == 0) {
                                tmp.set(i, (average_sample2 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("sample3") == 0) {
                                tmp.set(i, (average_sample3 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("sample4") == 0) {
                                tmp.set(i, (average_sample4 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("ratio1") == 0 || headers.get(i).compareToIgnoreCase("ratio") == 0) {
                                tmp.set(i, (average_ratio1 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("ratio2") == 0) {
                                tmp.set(i, (average_ratio2 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("ratio3") == 0) {
                                tmp.set(i, (average_ratio3 / local_cntr));
                            }
                            if (headers.get(i).compareToIgnoreCase("ratio4") == 0) {
                                tmp.set(i, (average_ratio4 / local_cntr));
                            }


                        }

                        str_buf.append(first_position_of_bucket + "-" + str[0]);
                        for (int i = 1; i < columns; i++) {
                            str_buf.append("\t" + tmp.get(i));

                        }
                        str_buf.append("\n");


                        // System.out.println("---------"+first_position_of_bucket);
                        local_cntr = 0;
                        average_sample1 = 0;
                        average_ratio1 = 0;
                        average_sample2 = 0;
                        average_ratio2 = 0;
                        average_sample3 = 0;
                        average_ratio3 = 0;
                        average_sample4 = 0;
                        average_ratio4 = 0;
                        average_reference = 0;


                        first_line_of_group = true;
                    }




                    for (int i = 0; i < z.zoom_end_points.size(); i++) {
                        if (total_cntr == z.zoom_end_points.get(i)) {
                            // System.out.println(total_cntr);
                            // System.out.println(z.zoom_start_points.get(i) + "-" + z.zoom_end_points.get(i));
                            String filename_2 = filename.replace(".txt", "_zoom_" + z.zoomLevel + "_part_" + (i + 1) + ".txt");
                            file_resolution = filename_2;
                            GenericMethods.write_file("", filename_2);

                            System.out.println("\n" + "created: " + filename_2);

                            System.out.println("created: " + filename_2);




                            if (columns == 2) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 3) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 4) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 5) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\t" + headers.get(4) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 6) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\t" + headers.get(4) + "\t" + headers.get(5) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 7) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\t" + headers.get(4) + "\t" + headers.get(5) + "\t" + headers.get(6) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 8) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\t" + headers.get(4) + "\t" + headers.get(5) + "\t" + headers.get(6) + "\t" + headers.get(7) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 9) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\t" + headers.get(4) + "\t" + headers.get(5) + "\t" + headers.get(6) + "\t" + headers.get(7) + "\t" + headers.get(8) + "\n" + str_buf.toString()), filename_2);
                            }
                            if (columns == 10) {
                                GenericMethods.append_file((headers.get(0) + "\t" + headers.get(1) + "\t" + headers.get(2) + "\t" + headers.get(3) + "\t" + headers.get(4) + "\t" + headers.get(5) + "\t" + headers.get(6) + "\t" + headers.get(7) + "\t" + headers.get(8) + "\t" + headers.get(9) + "\n" + str_buf.toString()), filename_2);
                            }




                            int start = starting_point;
                            int end = Math.min(max_position_hilbert, Integer.parseInt(first_position_of_bucket) + z.bucket) - 1;

                            if (i == z.zoom_end_points.size() - 1) {
                                end = max_position_hilbert;
                            }

                            GenericMethods.append_file("\nzoom:" + z.zoomLevel + "\tpart:" + (i + 1) + "\tbucket_size:" + z.bucket + "\t" + "start:" + start + "\t" + "end:" + end + "\t" + file_resolution, log_file);

                            local_cntr = 0;
                            average_sample1 = 0;
                            average_ratio1 = 0;
                            average_sample2 = 0;
                            average_ratio2 = 0;
                            average_sample3 = 0;
                            average_ratio3 = 0;
                            average_sample4 = 0;
                            average_ratio4 = 0;
                            average_reference = 0;

                            str_buf.setLength(0);
                            new_file = false;
                            break;
                        }

                    }//for zoom...

                }//if startswith("position")...


            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }



    }//method
}//class

