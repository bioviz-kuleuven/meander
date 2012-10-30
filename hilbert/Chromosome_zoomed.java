/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.SwingUtilities;
import processing.core.PApplet;

/**
 *
 * @author gpavlopo
 */
public class Chromosome_zoomed extends PApplet {

    static int height = 160;
    static int width = 1024;
    static double upper_limit = 15;
    static double lower_limit = 80;
    static double upper_threshold_Y = height / 2;
    static double lower_threshold_Y = height / 2;
    static boolean upper_bover = false;
    static boolean upper_locked = false;
    static boolean lower_bover = false;
    static boolean lower_locked = false;
    static boolean run_once = false;
    static double maximum_average_coverage = -999999999;
    static double minimum_average_coverage = 999999999;
    static double maximum_average_coverage_negative = -999999999;
    static double minimum_average_coverage_negative = 999999999;
    static double maximum_coverage = -999999999;
    static double minimum_coverage = 999999999;
    static double averages_in_bucket = 0;
    static ArrayList<Double> values = new ArrayList();
    static Hashtable<Pixel, Integer> give_coordinate_highlight_position = new Hashtable();
    static Hashtable<Integer, Pixel> give_position_get_Pixel = new Hashtable();

    public void setup() {
        size(width, height, P2D);
        this.addKeyListener(new MyKeyListener());
        frameRate(4);
        smooth();
    }

    public static void update_diagram() {


        try {



            maximum_average_coverage = -999999999;
            minimum_average_coverage = 999999999;
            maximum_average_coverage_negative = -999999999;
            minimum_average_coverage_negative = 999999999;

            maximum_coverage = -999999999;
            minimum_coverage = 999999999;
            give_coordinate_highlight_position.clear();
            give_position_get_Pixel.clear();
            averages_in_bucket = 0;



            //coverage
            averages_in_bucket = (int) Math.ceil((double) Variables.pixels.size() / (double) width);


            //every averages_in_bucket values get the average
            double counter = 1;
            double sum = 0;
            double average = 0;
            int bucket = 0;
            int bucket2 = 0;
            values.clear();

            //initialize

            for (int i = 0; i < width; i++) {
                values.add(0.0);
            }


            for (int i = 0; i < Variables.pixels.size(); i++) {
                if (Variables.pixels.get(i) != null) {
                    double value = 0;
                    if (Variables.sample_enabled == true) {

                        if (Variables.panel == 1) {
                            value = Variables.pixels.get(i).getCoverage_sample1();
                            maximum_coverage = Variables.max_read_sample1;
                            minimum_coverage = Variables.min_read_sample1;
                        }
                        if (Variables.panel == 2) {
                            value = Variables.pixels.get(i).getCoverage_sample2();
                            maximum_coverage = Variables.max_read_sample2;
                            minimum_coverage = Variables.min_read_sample2;
                        }
                        if (Variables.panel == 3) {
                            value = Variables.pixels.get(i).getCoverage_sample3();
                            maximum_coverage = Variables.max_read_sample3;
                            minimum_coverage = Variables.min_read_sample3;
                        }
                        if (Variables.panel == 4) {
                            value = Variables.pixels.get(i).getCoverage_sample4();
                            maximum_coverage = Variables.max_read_sample4;
                            minimum_coverage = Variables.min_read_sample4;
                        }

                    }
                    if (Variables.reference_enabled == true) {
                        value = Variables.pixels.get(i).getCoverage_reference();
                        maximum_coverage = Variables.max_read_reference;
                        minimum_coverage = Variables.min_read_reference;

                    }
                    if (Variables.ratio_enabled == true) {

                        if (Variables.panel == 1) {
                            value = Variables.pixels.get(i).getRatio1();
                            maximum_coverage = Math.max((double) Math.abs(Variables.max_read_ratio1), (double) Math.abs(Variables.min_read_ratio1));
                            minimum_coverage = 0;
                        }

                        if (Variables.panel == 2) {
                            value = Variables.pixels.get(i).getRatio2();
                            maximum_coverage = Math.max((double) Math.abs(Variables.max_read_ratio2), (double) Math.abs(Variables.min_read_ratio2));
                            minimum_coverage = 0;
                        }


                        if (Variables.panel == 3) {
                            value = Variables.pixels.get(i).getRatio3();
                            maximum_coverage = Math.max((double) Math.abs(Variables.max_read_ratio3), (double) Math.abs(Variables.min_read_ratio3));
                            minimum_coverage = 0;
                        }

                        if (Variables.panel == 4) {
                            value = Variables.pixels.get(i).getRatio4();
                            maximum_coverage = Math.max((double) Math.abs(Variables.max_read_ratio4), (double) Math.abs(Variables.min_read_ratio4));
                            minimum_coverage = 0;
                        }

                    }

                    sum += value;
                    counter++;
                    if (counter != 0 && counter == averages_in_bucket) {
                        bucket++;
                        average = sum / averages_in_bucket;

                        if ((bucket - 1) >= 0 && (bucket - 1) <= (width - 1)) {
                            values.set(bucket - 1, average);
                        }
                        sum = 0;
                        counter = 0;

                        if (Variables.pixels.get(i) != null) {
                            give_position_get_Pixel.put(bucket, Variables.pixels.get(i));
                        }

                    }

                    if (i <= (Variables.pixels.size() - 1)) {
                        if (Variables.pixels.get(i) != null) {
                            give_coordinate_highlight_position.put(Variables.pixels.get(i), bucket);
                        }
                    }
                }
            }


            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) >= 0) {
                    maximum_average_coverage = Math.max(maximum_average_coverage, Math.abs(values.get(i)));
                    minimum_average_coverage = Math.min(minimum_average_coverage, Math.abs(values.get(i)));
                } else {
                    maximum_average_coverage_negative = Math.max(maximum_average_coverage, Math.abs(values.get(i)));
                }
                minimum_average_coverage_negative = Math.min(minimum_average_coverage, Math.abs(values.get(i)));
            }

            //follow the thresholds

            for (int i = 0; i < values.size(); i++) {
                if (Variables.sample_enabled == true) {
                    double value = values.get(i);
                    if (value <= Variables.upper_threshold) {
                        value = 0;
                    }
                    values.set(i, value);
                }
            }
            for (int i = 0; i < values.size(); i++) {
                if (Variables.reference_enabled == true) {
                    double value = values.get(i);
                    if (value <= Variables.upper_threshold) {
                        value = 0;
                    }
                    values.set(i, value);
                }
            }
            for (int i = 0; i < values.size(); i++) {
                if (Variables.ratio_enabled == true) {
                    double value = values.get(i);
                    if (!((value) >= (Variables.lower_ratio_threshold) && (value) <= (Variables.upper_ratio_threshold))) {
                        value = 0;
                    }
                    values.set(i, value);
                }
            }


            Meander.jProgressBar.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void draw() {


        smooth();
        if (Variables.pause_everything == false) {
            background(255);

            if (Variables.finished_hilbert_drawing_for_first_time == true) {


                if (run_once == false) {
                    update_diagram();
                }

                // arcs for pair-ends


                if (Variables.pair_ends_enabled == true && Variables.pair_end_list_to_highlight != null) {
                    if (Variables.pair_end_list_to_highlight.size() > 0) {
                        try {


                            noFill();
                            for (int i = 0; i < Variables.pair_end_list_to_highlight.size(); i++) {
                                if (Variables.pair_end_list_to_highlight.get(i).chromosome_from.compareTo(Variables.chromosome) == 0 && Variables.pair_end_list_to_highlight.get(i).chromosome_to.compareTo(Variables.chromosome) == 0) {

                                    int pair_source_scaled = (int) map((int) Variables.pair_end_list_to_highlight.get(i).from_PE1, Variables.min_chromosome_position_of_the_zoomed_area, Variables.max_chromosome_position_of_the_zoomed_area, 0, width);
                                    int pair_dest_scaled = (int) map((int) Variables.pair_end_list_to_highlight.get(i).from_PE2, Variables.min_chromosome_position_of_the_zoomed_area, Variables.max_chromosome_position_of_the_zoomed_area, 0, width);


                                    int height_point = 2;
                                    int y = height / 2;

                                    int R = Variables.pair_end_list_to_highlight.get(i).color.R;
                                    int G = Variables.pair_end_list_to_highlight.get(i).color.G;
                                    int B = Variables.pair_end_list_to_highlight.get(i).color.B;
                                    int alpha = Variables.pair_end_list_to_highlight.get(i).color.alpha;

                                    if (Variables.pair_end_list_to_highlight.get(i).variation_type.compareTo("inversion") == 0) {
                                        R = 44;
                                        G = 77;
                                        B = 143;
                                        alpha = 200;
                                    }
                                    if (Variables.pair_end_list_to_highlight.get(i).variation_type.compareTo("duplication") == 0) {
                                        R = 88;
                                        G = 171;
                                        B = 45;
                                        alpha = 200;
                                    }

                                    if (Variables.pair_end_list_to_highlight.get(i).variation_type.compareTo("insertion") == 0) {
                                        R = 88;
                                        G = 171;
                                        B = 45;
                                        alpha = 200;
                                    }
                                    if (Variables.pair_end_list_to_highlight.get(i).variation_type.compareTo("deletion") == 0) {
                                        R = 255;
                                        G = 51;
                                        B = 208;
                                        alpha = 200;
                                    }
                                    if (Variables.pair_end_list_to_highlight.get(i).variation_type.compareTo("translocation") == 0) {
                                        R = 201;
                                        G = 51;
                                        B = 255;
                                        alpha = 200;
                                    }

                                    stroke(R, G, B, alpha);
                                    noFill();
//                           
                                    try {



                                        if (Variables.deletions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("deletion") == 0) {
                                            bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                        }
//                            
                                        if (Variables.insertions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("insertion") == 0) {
                                            bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                        }
//                            
                                        if (Variables.inversions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("inversion") == 0) {
                                            bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                        }
//                            
                                        if (Variables.translocations_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("translocation") == 0) {
                                            bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                        }
//                            
                                        if (Variables.duplications_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("duplication") == 0) {
                                            bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                        }
//                            
                                    } catch (Exception e) {
                                    }

                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }




                stroke(0, 0, 255, 100);



                //draw picks
                for (int i = 0; i < width; i++) {
                    double value = (double) values.get(i);


//         System.out.println(i+"\t"+value+"\t["+minimum_average_coverage+"-"+maximum_average_coverage+"]");




                    int maximum = width;
                    if (Variables.ratio_enabled == false) {
                        int value_scaled = (int) map((float) value, (float) minimum_average_coverage, (float) maximum_average_coverage, (float) (height / 2), (float) upper_limit);
                        if (value != 1) {
                            line(i, height / 2, i, value_scaled);
                        }
                    }
                    if (Variables.ratio_enabled == true) {
                        int value_scaled = 0;
                        if (value > 0) {
                            value_scaled = (int) map((float) (value), (float) minimum_average_coverage, (float) maximum_average_coverage, 0, (float) (height / 2));
                        }
                        if (value < 0) {
                            value_scaled = (int) map((float) Math.abs(value), (float) minimum_average_coverage_negative, (float) maximum_average_coverage_negative, 0, (float) (height / 2));
                        }


                        if (value == 0) {
                            stroke(255, 255, 255, 120);
                            line(i, height / 2, i, height / 2);
                        }
                        if (value > 0) {
                            stroke(Variables.up_regulated.R, Variables.up_regulated.G, Variables.up_regulated.B, 120);
                            line(i, height / 2, i, height / 2 - value_scaled);
                        }
                        if (value < 0) {
                            stroke(Variables.down_regulated.R, Variables.down_regulated.G, Variables.down_regulated.B, 120);
                            line(i, height / 2, i, height / 2 + value_scaled);
                        }

                    }

                }





                //highlight position cross
                stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);


                if (!focused) {
                    Coordinate c = new Coordinate(Variables.mouse_x, Variables.mouse_y);

                    if (Variables.give_coordinate_get_pixel.get(c.toString()) != null) {
                        Pixel pixel = Variables.give_coordinate_get_pixel.get(c.toString());
                        if (give_coordinate_highlight_position.get(pixel) != null) {
                            Variables.highlight_hilbert_chromosome_point_zoomed = give_coordinate_highlight_position.get(pixel);
                            if (Variables.highlight_hilbert_chromosome_point_zoomed == width) {
                                Variables.highlight_hilbert_chromosome_point_zoomed--;
                            }
                            line(Variables.highlight_hilbert_chromosome_point_zoomed, 0, Variables.highlight_hilbert_chromosome_point_zoomed, height);
                        }
                    }
                }

                if (focused) {

                    Variables.highlight_hilbert_chromosome_point_zoomed = mouseX;
                    line(Variables.highlight_hilbert_chromosome_point_zoomed, 0, Variables.highlight_hilbert_chromosome_point_zoomed, height);

                    int buck = Variables.highlight_hilbert_chromosome_point_zoomed;


                    if (give_position_get_Pixel.get(buck) != null) {
                        Coordinate cc = give_position_get_Pixel.get(buck).getCoordinate_hilbert();
                        Variables.highlight_hilbert_point.X = cc.X;
                        Variables.highlight_hilbert_point.Y = cc.Y;
                        Hilbert.setLabels(cc.X, cc.Y);
                        try {
                            SwingUtilities.invokeAndWait(new Runnable() {

                                public void run() {
                                    Meander.jProgressBar.setVisible(false);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }

                run_once = false;

            }
        }

        stroke(0, 0, 255);
        line(0, height / 2, width, height / 2);
    }
}
