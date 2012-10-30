/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import color_factory.ColorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.SwingUtilities;
import javax.vecmath.Color3f;
import processing.core.*;

public class Hilbert extends PApplet {

    public int x = 0;
    public int y = 0;
    public int start_x = 0;
    public int start_y = 0;
    public int dist = 0;
    public int edges = 0;
    int tre = 0;
    ArrayList<Integer> tmp = null;
    ArrayList<Coordinate> tmp_coor = null;
    int start_selection_x = -1;
    int start_selection_y = -1;
    int end_selection_x = -1;
    int end_selection_y = -1;
    boolean selected_pairs = false;
    static int translation = Variables.translation;
    boolean p1 = false;
    boolean p2 = false;
    boolean p3 = false;
    boolean p4 = false;

    @Override
    public void setup() {
        smooth();
        // Hilbert_pixel_length.calculate_hilbert_characterisics(X, dist);
        edges = (int) Math.pow(4, Variables.fold_level);
        //System.out.println("edges=" + edges + "\t" + "pixels:" + (Variables.dimension * Variables.dimension));

        size(560, 560, P2D);
        Variables.pg1 = createGraphics(512, 512, P2D);
        Variables.pi1 = createImage(512, 512, RGB);
        Variables.pg1_copy1 = createGraphics(512, 512, P2D);
        Variables.pi1_copy1 = createImage(512, 512, RGB);
        Variables.pg1_copy2 = createGraphics(512, 512, P2D);
        Variables.pi1_copy2 = createImage(512, 512, RGB);
        Variables.pg1.background(255);


        Variables.pg2 = createGraphics(512, 512, P2D);
        Variables.pi2 = createImage(512, 512, RGB);
        Variables.pg2_copy1 = createGraphics(512, 512, P2D);
        Variables.pi2_copy1 = createImage(512, 512, RGB);
        Variables.pg2_copy2 = createGraphics(512, 512, P2D);
        Variables.pi2_copy2 = createImage(512, 512, RGB);
        Variables.pg2.background(255);


        Variables.pg3 = createGraphics(512, 512, P2D);
        Variables.pi3 = createImage(512, 512, RGB);
        Variables.pg3_copy1 = createGraphics(512, 512, P2D);
        Variables.pi3_copy1 = createImage(512, 512, RGB);
        Variables.pg3_copy2 = createGraphics(512, 512, P2D);
        Variables.pi3_copy2 = createImage(512, 512, RGB);
        Variables.pg3.background(255);


        Variables.pg4 = createGraphics(512, 512, P2D);
        Variables.pi4 = createImage(512, 512, RGB);
        Variables.pg4_copy1 = createGraphics(512, 512, P2D);
        Variables.pi4_copy1 = createImage(512, 512, RGB);
        Variables.pg4_copy2 = createGraphics(512, 512, P2D);
        Variables.pi4_copy2 = createImage(512, 512, RGB);
        Variables.pg4.background(255);


        dist = Variables.dimension;
        for (int i = Variables.fold_level; i > 0; i--) {
            dist /= 2;
        }
        x = dist / 2;
        y = dist / 2;
        start_x = x;
        start_y = y;
        MyKeyListener.overlay_hibert(3);

        Variables.pi1_enhanced = new PImage(512, 512);
        Variables.pi2_enhanced = new PImage(512, 512);
        Variables.pi3_enhanced = new PImage(512, 512);
        Variables.pi4_enhanced = new PImage(512, 512);

        background(255, 255, 255);
        this.addKeyListener(new MyKeyListener());

    }

    //@Override
    void mouse_over() {
        setLabels(mouseX, mouseY);

    }

    public void inter_chromosomal_variations() {




        if (Variables.organisms_load_allowance == true) {



            PFont myFont;
            myFont = createFont("Arial", 12);
            textFont(myFont);


            long virtual_chromosome = (540 - 10) * 4;
            Variables.give_position_get_Coordinate_for_Chromosomes.clear();

            //if (Variables.organisms_loaded_once == false)
            {



                int cnt = 0;
                for (int i = 10; i < 540; i++) {
                    Coordinate coor = new Coordinate(i, 10);
                    Variables.give_position_get_Coordinate_for_Chromosomes.put(cnt, coor);
                    cnt++;
                }
                for (int i = 10; i < 540; i++) {
                    Coordinate coor = new Coordinate(540, i);
                    Variables.give_position_get_Coordinate_for_Chromosomes.put(cnt, coor);
                    cnt++;
                }
                for (int i = 540; i > 10; i--) {
                    Coordinate coor = new Coordinate(i, 540);
                    Variables.give_position_get_Coordinate_for_Chromosomes.put(cnt, coor);
                    cnt++;
                }
                for (int i = 540; i > 10; i--) {
                    Coordinate coor = new Coordinate(10, i);
                    Variables.give_position_get_Coordinate_for_Chromosomes.put(cnt, coor);
                    cnt++;
                }



                Variables.lengths.clear();
                Variables.names.clear();
                if (Variables.organism.compareToIgnoreCase("human") == 0) {
                    for (int i = 0; i < Variables.get_human_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_human_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_human_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_human_Chr_names.get(i));
                    }
                }

                if (Variables.organism.compareToIgnoreCase("rat") == 0) {
                    for (int i = 0; i < Variables.get_rat_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_rat_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_rat_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_rat_Chr_names.get(i));
                    }
                }

                if (Variables.organism.compareToIgnoreCase("arabidopsis") == 0) {
                    for (int i = 0; i < Variables.get_arabidopsis_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_arabidopsis_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_arabidopsis_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_arabidopsis_Chr_names.get(i));
                    }
                }

                if (Variables.organism.compareToIgnoreCase("mouse") == 0) {
                    for (int i = 0; i < Variables.get_mouse_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_mouse_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_mouse_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_mouse_Chr_names.get(i));
                    }
                }

                if (Variables.organism.compareToIgnoreCase("zebra") == 0 || Variables.organism.compareToIgnoreCase("zebrafish") == 0) {
                    for (int i = 0; i < Variables.get_zebrafish_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_zebrafish_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_zebrafish_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_zebrafish_Chr_names.get(i));
                    }
                }

                if (Variables.organism.compareToIgnoreCase("drosophila") == 0) {
                    for (int i = 0; i < Variables.get_drosophila_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_drosophila_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_drosophila_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_drosophila_Chr_names.get(i));
                    }
                }

                if (Variables.organism.compareToIgnoreCase("chimp") == 0) {
                    for (int i = 0; i < Variables.get_chimp_Chr_lengths.size(); i++) {
                        Variables.lengths.add(Variables.get_chimp_Chr_lengths.get(i));
                    }
                    for (int i = 0; i < Variables.get_chimp_Chr_names.size(); i++) {
                        Variables.names.add(Variables.get_chimp_Chr_names.get(i));
                    }
                }

                Variables.organisms_loaded_once = true;
            }
//  System.out.println(Variables.give_position_get_Coordinate.size()+"-----"+cnt+"------"+virtual_chromosome);
//   System.out.println(Variables.names.size()+"-----"+cnt+"------"+Variables.lengths.size());
//   System.out.println(Variables.chromosome_ends.size());       

            //if(Variables.organism.compareToIgnoreCase("human")==0)

            Variables.chromosome_ends.clear();




            long length = 0;

            long value = 0;
            long max_value = 0;





            for (int i = 0; i < Variables.lengths.size(); i++) {
                value = Variables.lengths.get(i);
                max_value += value;
            }


            length = 0;
            for (int i = 0; i < Variables.lengths.size(); i++) {
                value = Variables.lengths.get(i);
                length += value;

                int mapped_length = (int) map((long) length, (long) 1, (long) max_value, (long) 1, (long) virtual_chromosome);

                Variables.chromosome_ends.add(Math.abs(mapped_length) - 1);
            }


            if (Variables.organism.compareToIgnoreCase("arabidopsis") == 0) {
                Variables.chromosome_ends.clear();
                Variables.chromosome_ends.add(520);
                Variables.chromosome_ends.add(880);
                Variables.chromosome_ends.add(1380);
                Variables.chromosome_ends.add(1670);
                Variables.chromosome_ends.add(2119);


            }



            for (int i = 0; i < Variables.chromosome_ends.size(); i++) {

                noFill();
                stroke(150, 150, 150);

                Coordinate coor = Variables.give_position_get_Coordinate_for_Chromosomes.get(Variables.chromosome_ends.get(i));
                Coordinate coor_prev = null;
                if (i != 0) {
                    coor_prev = Variables.give_position_get_Coordinate_for_Chromosomes.get(Variables.chromosome_ends.get(i - 1));
                }



                if (coor != null) {

                    if (Variables.chromosome_ends.get(i) >= 0 && Variables.chromosome_ends.get(i) < (540 - 10) * 1) {

                        line(coor.X, coor.Y, coor.X, coor.Y - 10);
                        if (i == 0) {
                            line(coor.X, coor.Y, coor.X, coor.Y - 10);
                            pushMatrix();

                            translate((coor.X) / 2, coor.Y);
                            fill(150, 150, 150);
                            stroke(150, 150, 150);
                            if (Variables.names.get(i).compareToIgnoreCase(Variables.chromosome) == 0) {
                                stroke(255, 0, 0);
                                fill(255, 0, 0);
                            }
                            text(Variables.names.get(i), 0, 0);
                            popMatrix();
                        } else if (i > 0) {

                            pushMatrix();

                            translate((coor.X + coor_prev.X) / 2, coor.Y);
                            fill(150, 150, 150);
                            stroke(150, 150, 150);



                            if (Variables.names.get(i).compareToIgnoreCase(Variables.chromosome) == 0) {
                                stroke(255, 0, 0);
                                fill(255, 0, 0);
                            }

                            text(Variables.names.get(i), 0, 0);
                            popMatrix();


                        }


                    }

                    if (Variables.chromosome_ends.get(i) >= (540 - 10) * 1 && Variables.chromosome_ends.get(i) < (540 - 10) * 2) {
                        line(coor.X, coor.Y, coor.X + 10, coor.Y);

                        pushMatrix();
                        translate(coor.X, (coor.Y + coor_prev.Y) / 2);
                        rotate(PI / 2);
                        fill(150, 150, 150);
                        stroke(150, 150, 150);
                        if (Variables.names.get(i).compareToIgnoreCase(Variables.chromosome) == 0) {
                            stroke(255, 0, 0);
                            fill(255, 0, 0);
                        }
                        text(Variables.names.get(i), 0, 0);
                        popMatrix();


                    }

                    if (Variables.chromosome_ends.get(i) >= (540 - 10) * 2 && Variables.chromosome_ends.get(i) < (540 - 10) * 3) {
                        line(coor.X, coor.Y, coor.X, coor.Y + 10);

                        pushMatrix();
                        translate((coor.X + coor_prev.X) / 2, coor.Y + 10);
                        fill(150, 150, 150);
                        stroke(150, 150, 150);

                        if (Variables.names.get(i).compareToIgnoreCase(Variables.chromosome) == 0) {
                            stroke(255, 0, 0);
                            fill(255, 0, 0);
                        }
                        text(Variables.names.get(i), 0, 0);
                        popMatrix();


                    }

                    if (Variables.chromosome_ends.get(i) >= (540 - 10) * 3 && Variables.chromosome_ends.get(i) < (540 - 10) * 4) {
                        line(coor.X, coor.Y - 1, coor.X - 10, coor.Y - 1);

                        pushMatrix();
                        translate(coor.X, (coor.Y + coor_prev.Y) / 2);
                        fill(150, 150, 150);
                        stroke(150, 150, 150);
                        rotate(-HALF_PI);
                        if (Variables.names.get(i).compareToIgnoreCase(Variables.chromosome) == 0) {
                            stroke(255, 0, 0);
                            fill(255, 0, 0);
                        }
                        text(Variables.names.get(i), 0, 0);
                        popMatrix();


                    }
                }
            }

            noFill();
            stroke(150, 150, 150);
            rect(10, 10, 530, 530);


//        Coordinate coooor = give_chromosome_get_coordinate("human", "Y", 211);
//        if (coooor != null) {
//            line(256, 256, coooor.X, coooor.Y);
//        }

        }

    }

    public static Coordinate give_chromosome_get_coordinate(String organism, String chromosome, int position) {
        long virtual_chromosome = (540 - 10) * 4;
        int index = Variables.get_human_Chr_names.indexOf(chromosome);
        int chromosome_end = Variables.chromosome_ends.get(index);



        long max_value = 0;
        for (int i = 0; i < Variables.get_human_Chr_lengths.size(); i++) {
            max_value += Variables.get_human_Chr_lengths.get(i);
        }

        long value = 0;
        for (int i = 0; i < index; i++) {
            value += Variables.get_human_Chr_lengths.get(i);
        }
        value += position;

        int mapped_length = (int) map((long) value, (long) 1, (long) max_value, (long) 1, (long) virtual_chromosome);

        Coordinate coor = Variables.give_position_get_Coordinate_for_Chromosomes.get(Math.abs(mapped_length));
        return coor;

    }

    public static void PE_histogram_initilization() {
        for (int i = 0; i < 260; i++) {
            Variables.PE_histogram.add(0);
        }

        for (int i = 0; i < Variables.pair_end_list.size(); i++) {
            PairEnd pe = Variables.pair_end_list.get(i);
            int distance = Math.abs(pe.from_PE1 - pe.from_PE2);

            Variables.PE_max_value = Math.max(Variables.PE_max_value, distance);
        }
        for (int i = 0; i < Variables.pair_end_list.size(); i++) {
            PairEnd pe = Variables.pair_end_list.get(i);
            int distance = Math.abs(pe.from_PE1 - pe.from_PE2);
            float index_distance = map((float) distance, (float) 0.0, (float) Variables.PE_max_value, (float) 0.0, (float) 259.0);
            Variables.PE_histogram.set((int) Math.min(259, index_distance), Variables.PE_histogram.get((int) Math.min(259, index_distance)) + 1);

        }
        for (int i = 0; i < Variables.PE_histogram.size(); i++) {
            Variables.PE_histogram_max_value = Math.max(Variables.PE_histogram_max_value, (Variables.PE_histogram.get(i) + 1));
        }
    }

    public void draw() {

        // System.out.println(Variables.highlight_hilbert_point.X +"-"+Variables.highlight_hilbert_point.Y);
        //selection for read-pairs

        smooth();
        background(255, 255, 255);






        if (Variables.finished_hilbert_drawing_for_first_time == false) {




            Meander.jProgressBar.setStringPainted(true);
            Meander.jProgressBar.setVisible(false);
            Variables.pg1.beginDraw();
            Variables.pg2.beginDraw();
            Variables.pg3.beginDraw();
            Variables.pg4.beginDraw();

            if (Variables.file_with_reads != null) {
                LoadReads.load_expressions(Variables.file_with_reads);

                if (Variables.reference_values_exist == true) {
                    Variables.reference_enabled = true;
                    Meander.jMenuItemReferenceColor.setVisible(true);
                    Meander.jMenuItemSampleColor.setVisible(false);
                    Meander.jMenuItemRatioColor.setVisible(false);
                    Variables.ratio_enabled = false;
                    Variables.sample_enabled = false;
                    Variables.reference_enabled = true;
                }


                if (Variables.sample_values_exist == true) {
                    Variables.sample_enabled = true;
                    Meander.jMenuItemSampleColor.setVisible(true);
                    Meander.jMenuItemReferenceColor.setVisible(false);
                    Meander.jMenuItemRatioColor.setVisible(false);
                    Variables.ratio_enabled = false;
                    Variables.sample_enabled = true;
                    Variables.reference_enabled = false;
                }
                if (Variables.ratio_values_exist == true || (Variables.reference_values_exist == true && Variables.sample_values_exist == true)) {
                    Variables.ratio_enabled = true;
                    Meander.jMenuItemRatioColor.setVisible(true);
                    Meander.jMenuItemSampleColor.setVisible(false);
                    Meander.jMenuItemReferenceColor.setVisible(false);
                    Variables.ratio_enabled = true;
                    Variables.sample_enabled = false;
                    Variables.reference_enabled = false;
                }



                Meander.activate_interface();
                for (int i = 0; i < Variables.pixels.size(); i++) {
                    Pixel pixel = Variables.pixels.get(i);
                    color_scale_ref(pixel);
                    color_scale_sample(pixel);
                    color_scale_ratio(pixel);
                }

                Variables.finished_hilbert_drawing_for_first_time = true;
            }


            Variables.pg1.background(255);
            Variables.pg2.background(255);
            Variables.pg3.background(255);
            Variables.pg4.background(255);

            x = start_x;
            y = start_y;

            if (Variables.file_with_reads != null) {

                Meander.jLabel_status.setText("Calculating Hilbert...");
                Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
                Meander.jLabel_status.repaint();

                HilbertB(Variables.fold_level);//<<<<<<----------------------

                Meander.jLabel_status.setText("");
                Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
                Meander.jLabel_status.repaint();

                try {
                    SwingUtilities.invokeAndWait(new Runnable() {

                        public void run() {
                            Meander.jProgressBar.setVisible(true);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


            if (Variables.initial_calculations_made == false) {


                Variables.searchTree_Coordinates = new IntervalST();
                for (int i = 0; i < Variables.pixels_initial.size(); i++) {
                    Pixel pix = Variables.pixels_initial.get(i);
                    int low = pix.getPosition_range_start();
                    int high = pix.getPosition_range_end();
                    Interval interval = new Interval(low, high, pix);
                    Variables.searchTree_Coordinates.put(interval, pix);
                }

            }

        }

        if (Variables.finished_hilbert_drawing_for_first_time == true) {
            if (p1 == false) {
                Variables.pi1 = Variables.pg1.get(0, 0, Variables.pg1.width, Variables.pg1.height);
                image(Variables.pg1, 0, 0);
                Variables.pg1_copy1.copy(Variables.pg1, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pg1_copy2.copy(Variables.pg1, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pi1_copy2 = Variables.pg1_copy2.get(0, 0, Variables.pg1.width, Variables.pg1.height);
                Variables.pi1_copy2.resize(256, 256);
                Variables.pg1.endDraw();
                //System.out.println("*** - 1");
                Grid_Zoom.update();
                p1 = true;
            }

            if (p2 == false) {
                Variables.pi2 = Variables.pg2.get(0, 0, Variables.pg2.width, Variables.pg2.height);
                image(Variables.pg2, 0, 0);
                Variables.pg2_copy1.copy(Variables.pg2, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pg2_copy2.copy(Variables.pg2, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pi2_copy2 = Variables.pg2_copy2.get(0, 0, Variables.pg2.width, Variables.pg2.height);
                Variables.pi2_copy2.resize(256, 256);
                Variables.pg2.endDraw();
                //System.out.println("*** - 2");
                p2 = true;
            }

            if (p3 == false) {

                Variables.pi3 = Variables.pg3.get(0, 0, Variables.pg3.width, Variables.pg3.height);
                image(Variables.pg3, 0, 0);
                Variables.pg3_copy1.copy(Variables.pg3, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pg3_copy2.copy(Variables.pg3, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pi3_copy2 = Variables.pg3_copy2.get(0, 0, Variables.pg3.width, Variables.pg3.height);
                Variables.pi3_copy2.resize(256, 256);
                Variables.pg3.endDraw();
                //System.out.println("*** - 3");
                p3 = true;
            }

            if (p4 == false) {
                Variables.pi4 = Variables.pg4.get(0, 0, Variables.pg4.width, Variables.pg4.height);
                image(Variables.pg4, 0, 0);
                Variables.pg4_copy1.copy(Variables.pg4, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pg4_copy2.copy(Variables.pg4, 0, 0, 512, 512, 0, 0, 512, 512);
                Variables.pi4_copy2 = Variables.pg4_copy2.get(0, 0, Variables.pg4.width, Variables.pg4.height);
                Variables.pi4_copy2.resize(256, 256);
                Variables.pg4.endDraw();
                //System.out.println("*** - 4");
                p4 = true;
            }



            if (Variables.panel == 1) {
                Variables.contrast_memory+=1;
                pushMatrix();
                translate(translation, translation);
                Variables.pi1 = Variables.pg1.get(0, 0, Variables.pg1.width, Variables.pg1.height);
                if (Variables.pi1 != null && Variables.pi1_enhanced != null) {
                    if ((Variables.contrast_memory != Variables.contrast)) {
                        ContrastAndBrightness(Variables.pi1, Variables.pi1_enhanced, Variables.contrast, 1);
                        Variables.contrast_memory = Variables.contrast;
                        //System.out.println("* - 1");
                    }
                }
                if (Variables.visualization_mode_PE_RD == 1 || Variables.visualization_mode_PE_RD == 3) {
                    image(Variables.pi1_enhanced, 0, 0);
                }
                popMatrix();


            }

            if (Variables.panel == 2) {
                Variables.contrast_memory+=1;
                pushMatrix();
                translate(translation, translation);
                Variables.pi2 = Variables.pg2.get(0, 0, Variables.pg2.width, Variables.pg2.height);
                if (Variables.pi2 != null && Variables.pi2_enhanced != null) {
                    if ((Variables.contrast_memory != Variables.contrast)) {
                        ContrastAndBrightness(Variables.pi2, Variables.pi2_enhanced, Variables.contrast, 1);
                        Variables.contrast_memory = Variables.contrast;
                    }
                }
                if (Variables.visualization_mode_PE_RD == 1 || Variables.visualization_mode_PE_RD == 3) {
                    image(Variables.pi2_enhanced, 0, 0);
                }
                popMatrix();

               // System.out.println("* - 2");
            }


            if (Variables.panel == 3) {
                Variables.contrast_memory+=1;
                pushMatrix();
                translate(translation, translation);
                Variables.pi3 = Variables.pg3.get(0, 0, Variables.pg3.width, Variables.pg3.height);
                if (Variables.pi4 != null && Variables.pi4_enhanced != null) {
                    if ((Variables.contrast_memory != Variables.contrast)) {
                        ContrastAndBrightness(Variables.pi3, Variables.pi3_enhanced, Variables.contrast, 1);
                        Variables.contrast_memory = Variables.contrast;
                    }
                }
                if (Variables.visualization_mode_PE_RD == 1 || Variables.visualization_mode_PE_RD == 3) {
                    image(Variables.pi3_enhanced, 0, 0);
                }
                popMatrix();

               // System.out.println("* - 3");
            }


            if (Variables.panel == 4) {
                Variables.contrast_memory+=1;
                pushMatrix();
                translate(translation, translation);
                Variables.pi4 = Variables.pg4.get(0, 0, Variables.pg4.width, Variables.pg4.height);
                if (Variables.pi4 != null && Variables.pi4_enhanced != null) {
                    if ((Variables.contrast_memory != Variables.contrast)) {
                        ContrastAndBrightness(Variables.pi4, Variables.pi4_enhanced, Variables.contrast, 1);
                        Variables.contrast_memory = Variables.contrast;
                    }

                }
                if (Variables.visualization_mode_PE_RD == 1 || Variables.visualization_mode_PE_RD == 3) {
                    image(Variables.pi4_enhanced, 0, 0);
                }
                popMatrix();

               // System.out.println("* - 4");
            }

        }
        //circles
        stroke(255, 20, 147, 160);
        noFill();
        for (int i = 0; i < Variables.circles.size(); i++) {
            DoubleEvidence de = Variables.circles.get(i);
            int x = de.getX() + Variables.translation;
            int y = de.getY() + Variables.translation;
            int radius = (int) de.getRadius();
            ellipse(x, y, radius, radius);
        }


        for (int i = 1; i < Variables.overlaid_hilbert.size(); i++) {
            Coordinate x = Variables.overlaid_hilbert.get(i - 1);
            Coordinate y = Variables.overlaid_hilbert.get(i);
            stroke(0, 0, 255, 50);
            line(x.X, x.Y, y.X, y.Y);
        }




        if (Variables.finished_pair_end_drawing_for_first_time == false) {

            stroke(0);
            fill(0);
            // Variables.pair_ends_for_zoom_level.clear();

            Variables.pair_end_list_to_highlight_initial_zooming_panel.clear();


            for (int i = 0; i < Variables.pixels.size(); i++) {
                Pixel pix_source = Variables.pixels.get(i);
                for (int j = 0; j < pix_source.pair_ends.size(); j++) {
                    Pixel pix_dest = pix_source.pair_ends.get(j);
                    int distance = Math.abs(pix_source.getPosition_range_start() - pix_dest.getPosition_range_start());
                    if (distance >= Variables.pair_end_minimum_distance_threshold && distance <= Variables.pair_end_maximum_distance_threshold) {
                        if (pix_source.getZoom_level() == Variables.zoom) {
                            if (!Variables.pair_ends_for_zoom_level.contains(pix_source)) {
                                Variables.pair_ends_for_zoom_level.add(pix_source);
                            }
                        }
                        if (pix_dest.getZoom_level() == Variables.zoom) {
                            if (!Variables.pair_ends_for_zoom_level.contains(pix_dest)) {
                                Variables.pair_ends_for_zoom_level.add(pix_dest);
                            }
                        }
                    }
                }
            }





            Variables.finished_pair_end_drawing_for_first_time = true;

        }



        //cross to show points
        if (focused) {


            mouse_over();


            Variables.highlight_hilbert_point.X = mouseX + translation;
            Variables.highlight_hilbert_point.Y = mouseY + translation;

            stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
            line(translation, mouseY, translation + 512, mouseY);
            line(mouseX, translation, mouseX, translation + 512);

            //when an area is selected highlight the pair-end pixels


            if (Math.abs(start_selection_x - end_selection_x) != 0 && Math.abs(start_selection_y - end_selection_y) != 0) {
                stroke(0, 0, 255, 180);
                fill(0, 0, 255, 10);
                if (Variables.pair_end_list != null) {
                    rect(start_selection_x, start_selection_y, end_selection_x - start_selection_x, end_selection_y - start_selection_y);
                }
                //will get changed

                show_pair_ends();
            }
        }


        if (!focused) {
            stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
            line(translation, translation + Variables.highlight_hilbert_point.Y, translation + 512, translation + Variables.highlight_hilbert_point.Y);
            line(translation + Variables.highlight_hilbert_point.X, translation, translation + Variables.highlight_hilbert_point.X, translation + 512);

            show_pair_ends();

        }


        //will get changed
        Coordinate c = new Coordinate(Variables.mouse_x, Variables.mouse_y);
        if (Variables.give_coordinate_get_pixel.get(c.toString()) != null) {
            try {

                Pixel pix = Variables.give_coordinate_get_pixel.get(c.toString());
                int start = pix.getPosition_range_start();
                int end = pix.getPosition_range_end();
                Interval interval = new Interval(start, end, null);
                Pixel p = Variables.searchTree_Coordinates.search(interval).pix;
                if (p != null) {
                    Variables.highlight_hilbert_point_zoomed.X = p.getCoordinate_hilbert().X / 2;
                    Variables.highlight_hilbert_point_zoomed.Y = p.getCoordinate_hilbert().Y / 2;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        try {
            inter_chromosomal_variations();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (Variables.visualization_mode_PE_RD == 2 || Variables.visualization_mode_PE_RD == 3) {
            for (int i = 0; i < Variables.pair_ends_for_zoom_level.size(); i++) {
                Pixel pix = Variables.pair_ends_for_zoom_level.get(i);
                stroke(0, 0, 0, 150);
                noFill();
                point(pix.getCoordinate_hilbert().X + Variables.translation, pix.getCoordinate_hilbert().Y + Variables.translation);
            }
        }

    }

    public void show_pair_ends() {
        try {

            int max_variations = 0;
            if (Variables.pair_ends_enabled == true) {

                if (Variables.pair_ends_initial_loaded == true) {


                    if (Variables.tmp_coor_pair_end.size() > 0) {
                        for (int i = 0; i < Variables.tmp_coor_pair_end.size(); i++) {

                            Coordinate c = Variables.tmp_coor_pair_end.get(i);


                            Pixel pix_source = Variables.give_coordinate_get_pixel.get(c.toString());


                            if (pix_source != null) {
                                max_variations += pix_source.pair_ends.size();
                                if (pix_source.pair_ends.size() > 0) {
                                    stroke(255, 51, 204);
                                    // point(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y);
                                }
                            }


                            if (pix_source != null && pix_source.pair_ends.size() > 0) {
                                for (int k = 0; k < pix_source.pair_ends.size(); k++) {

                                    Pixel pix_dest = pix_source.pair_ends.get(k);


                                    if (pix_source.pair_end_destination_chromosome.get(k).compareToIgnoreCase(Variables.chromosome) != 0) {
                                        //System.out.println(pix_source.pair_end_destination_chromosome"dfvdfavsfa");
                                        PairEnd ppp = new PairEnd(pix_source.getPosition_range_middle(), pix_dest.getPosition_range_middle());
                                        ppp.source = pix_source;
                                        ppp.dest = pix_dest;

                                        ppp.chromosome_from = pix_source.pair_end_source_chromosome.get(k);
                                        ppp.chromosome_to = pix_source.pair_end_destination_chromosome.get(k);


                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("insertion") == 0) {
                                            ppp.variation_type = "insertion";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("inversion") == 0) {
                                            ppp.variation_type = "inversion";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("duplication") == 0) {
                                            ppp.variation_type = "duplication";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("translocation") == 0) {
                                            ppp.variation_type = "translocation";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("deletion") == 0) {
                                            ppp.variation_type = "deletion";
                                        }

                                        ppp.assign_variation_type();



                                        //System.out.println("----" + pix_source.getZoom_level() + "-" + pix_dest.getZoom_level());
                                        if (Variables.pair_end_list_to_highlight.size() <= max_variations) {
                                            Variables.pair_end_list_to_highlight.add(ppp);
                                        }

                                        if (Variables.pair_end_list_to_highlight_initial.size() <= max_variations) {
                                            Variables.pair_end_list_to_highlight_initial.add(ppp);
                                        }


                                    }

                                    int distance = Math.abs(pix_source.getPosition_range_start() - pix_dest.getPosition_range_start());
                                    if (distance >= Variables.pair_end_minimum_distance_threshold && distance <= Variables.pair_end_maximum_distance_threshold) {

                                        PairEnd ppp = new PairEnd(pix_source.getPosition_range_middle(), pix_dest.getPosition_range_middle());
                                        ppp.source = pix_source;
                                        ppp.dest = pix_dest;


                                        ppp.chromosome_to = pix_source.pair_end_destination_chromosome.get(k);


                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("insertion") == 0) {
                                            ppp.variation_type = "insertion";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("inversion") == 0) {
                                            ppp.variation_type = "inversion";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("duplication") == 0) {
                                            ppp.variation_type = "duplication";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("translocation") == 0) {
                                            ppp.variation_type = "translocation";
                                        }
                                        if (ppp.source.pair_end_variation_type.get(k).compareTo("deletion") == 0) {
                                            ppp.variation_type = "deletion";
                                        }

                                        ppp.assign_variation_type();



                                        //System.out.println("----" + pix_source.getZoom_level() + "-" + pix_dest.getZoom_level());

                                        if (Variables.zoom == 1) {
                                            if (pix_dest.getZoom_level() == 1 || pix_source.getZoom_level() == 1) {
                                                if (Variables.pair_end_list_to_highlight.size() <= max_variations) {
                                                    Variables.pair_end_list_to_highlight.add(ppp);
                                                }
                                            }
                                            if (pix_dest.getZoom_level() == 1 || pix_source.getZoom_level() == 1) {
                                                if (Variables.pair_end_list_to_highlight_initial.size() <= max_variations) {
                                                    Variables.pair_end_list_to_highlight_initial.add(ppp);
                                                }
                                            }
                                        } else {
                                            if (pix_source.getZoom_level() == Variables.zoom && pix_dest.getZoom_level() != 1) {
                                                if (Variables.pair_end_list_to_highlight.size() <= max_variations) {
                                                    Variables.pair_end_list_to_highlight.add(ppp);
                                                }
                                            }
                                            if (pix_source.getZoom_level() == Variables.zoom || pix_dest.getZoom_level() == 1) {
                                                if (Variables.pair_end_list_to_highlight_initial.size() <= max_variations) {
                                                    Variables.pair_end_list_to_highlight_initial.add(ppp);
                                                }
                                            }
                                        }


                                    }//distance


                                }//for pair-ends


                            }//source!=null

                        }//for

                    }
                }


                if (Variables.pair_end_list_to_highlight != null) {
                    if (Variables.pair_end_list_to_highlight.size() > 0) {
                        for (int i = 0; i < Variables.pair_end_list_to_highlight.size(); i++) {

                            Pixel pix_source = Variables.pair_end_list_to_highlight.get(i).source;
                            Pixel pix_dest = Variables.pair_end_list_to_highlight.get(i).dest;

                            stroke(255, 51, 204);
                            noFill();
                            point(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation);

                            stroke(255, 51, 204);
                            noFill();
                            point(pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation);

                            if (Variables.enable_pair_end_lines == true) {
                                int R = 255;
                                int G = 51;
                                int B = 204;
                                int alpha = 200;

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
                                fill(R, G, B, alpha);

                                if (Variables.pair_end_list_to_highlight.get(i).chromosome_from.compareTo(Variables.chromosome) == 0 && Variables.pair_end_list_to_highlight.get(i).chromosome_to.compareTo(Variables.chromosome) == 0) {

                                    if (Variables.deletions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("deletion") == 0) {
                                        line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation);
                                    }

                                    if (Variables.insertions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("insertion") == 0) {
                                        line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation);
                                    }

                                    if (Variables.inversions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("inversion") == 0) {
                                        line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation);
                                    }

                                    if (Variables.translocations_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("translocation") == 0) {
                                        line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation);
                                    }

                                    if (Variables.duplications_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("duplication") == 0) {
                                        line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation);
                                    }



                                }

                                if (Variables.interchromosomal == true) {
                                    if (Variables.pair_end_list_to_highlight.get(i).chromosome_from.compareTo(Variables.chromosome) == 0 && Variables.pair_end_list_to_highlight.get(i).chromosome_to.compareTo(Variables.chromosome) != 0) {
                                        PairEnd pe = Variables.pair_end_list_to_highlight.get(i);
                                        String chrom = pe.chromosome_to;
                                        int position = pe.from_PE2;

                                        Coordinate coor = Hilbert.give_chromosome_get_coordinate(Variables.organism, chrom, position);
                                        if (coor != null) {
                                            // System.out.println("*******"+chrom+"-"+pe.from_PE1+"-"+pe.to_PE1+"-"+pe.from_PE2+"-"+pe.to_PE2);

                                            if (Variables.deletions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("deletion") == 0) {
                                                line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.insertions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("insertion") == 0) {
                                                line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.inversions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("inversion") == 0) {
                                                line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.translocations_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("translocation") == 0) {
                                                line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.duplications_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("duplication") == 0) {
                                                line(pix_source.getCoordinate_hilbert().X + translation, pix_source.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                        }

                                    }
                                }

                                if (Variables.interchromosomal == true) {
                                    if (Variables.pair_end_list_to_highlight.get(i).chromosome_from.compareTo(Variables.chromosome) != 0 && Variables.pair_end_list_to_highlight.get(i).chromosome_to.compareTo(Variables.chromosome) == 0) {


                                        PairEnd pe = Variables.pair_end_list_to_highlight.get(i);
                                        String chrom = pe.chromosome_from;
                                        int position = pe.from_PE1;

                                        Coordinate coor = Hilbert.give_chromosome_get_coordinate(Variables.organism, chrom, position);
                                        if (coor != null) {

                                            if (Variables.deletions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("deletion") == 0) {
                                                line(pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.insertions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("insertion") == 0) {
                                                line(pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.inversions_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("inversion") == 0) {
                                                line(pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.translocations_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("translocation") == 0) {
                                                line(pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }

                                            if (Variables.duplications_enabled == true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("duplication") == 0) {
                                                line(pix_dest.getCoordinate_hilbert().X + translation, pix_dest.getCoordinate_hilbert().Y + translation, coor.X, coor.Y);
                                            }


                                        }

                                    }
                                }
                            }
                        }
                    }
                }

            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pixel get_Coordinate(Pixel pix) {
        Coordinate coor = null;

        if (pix != null) {
            int start = pix.getPosition_range_start();
            int end = pix.getPosition_range_end();
            Interval interval = new Interval(start, end, null);
            Pixel p = Variables.searchTree_Coordinates.search(interval).pix;
            if (p != null) {
                return p;
            }
            return p;
        }
        return null;

    }

    public static void search_by_position(int number) {
        boolean found = false;
        for (int i = 0; i < Variables.pixels.size(); i++) {
            Pixel pixel = Variables.pixels.get(i);
            Variables.highlight_hilbert_point.X = pixel.getCoordinate_hilbert().X;
            Variables.highlight_hilbert_point.Y = pixel.getCoordinate_hilbert().Y;
            int start = pixel.getPosition_range_start();
            int end = pixel.getPosition_range_end();
            if (number >= start && number <= end) {
                found = true;
                Variables.mouse_x = Variables.highlight_hilbert_point.X;
                Variables.mouse_y = Variables.highlight_hilbert_point.Y;

                Variables.highlight_hilbert_point.X = pixel.getCoordinate_hilbert().X;
                Variables.highlight_hilbert_point.Y = pixel.getCoordinate_hilbert().Y;


                //to corraclty find the cross points on the grid zooming panel when zooming in
                Coordinate c = new Coordinate(Variables.mouse_x, Variables.mouse_y);
                if (Variables.give_coordinate_get_pixel.get(c.toString()) != null) {
                    Pixel pix = Variables.give_coordinate_get_pixel.get(c.toString());

                    for (int ii = 0; ii < Variables.pixels_initial.size(); ii++) {
                        int start2 = Variables.pixels_initial.get(ii).getPosition_range_start();
                        int end2 = Variables.pixels_initial.get(ii).getPosition_range_end();
                        if (pix.getPosition_range_start() >= start2 && pix.getPosition_range_start() <= end2
                                && pix.getPosition_range_end() >= start2 && pix.getPosition_range_end() <= end2) {

                            // if (pix.getPosition_range_start() >= start && pix.getPosition_range_start() <= end && pix.getPosition_range_end() >= start && pix.getPosition_range_end() <= end) {
                            Variables.highlight_hilbert_point_zoomed.X = Variables.pixels_initial.get(ii).getCoordinate_hilbert().X / 2;
                            Variables.highlight_hilbert_point_zoomed.Y = Variables.pixels_initial.get(ii).getCoordinate_hilbert().Y / 2;
                            break;
                        }
                    }


                }
                break;

            }
        }

        if (found == false) {
            System.out.println("Position could not be found");

        }

    }

    // check all particles if mouse pos is less than snap distance
    public void mousePressed() {

        selected_pairs = false;
        start_selection_x = mouseX;
        start_selection_y = mouseY;
        Variables.select_whole_area = false;
        if (Variables.pair_ends_enabled == true) {
            Variables.pair_end_list_to_highlight.clear();
            Variables.pair_end_list_to_highlight_initial.clear();

            Variables.tmp_coor_pair_end.clear();
        }


        if (mouseEvent.getClickCount() == 1) {

            start_selection_x = mouseX;
            start_selection_y = mouseY;
            end_selection_x = mouseX;
            end_selection_y = mouseY;
            selected_pairs = false;
        }

        if (mouseEvent.getClickCount() == 2) {//select all

            start_selection_x = translation;
            start_selection_y = translation;
            end_selection_x = translation + 512 - 1;
            end_selection_y = translation + 512 - 1;
            selected_pairs = false;
            Variables.select_whole_area = true;

            for (int i = 0; i < Variables.pixels.size(); i++) {
                Coordinate c = new Coordinate(Variables.pixels.get(i).getCoordinate_hilbert());
                Variables.tmp_coor_pair_end.add(c);
            }
        }

    }

// only react to mouse dragging events if we have a selected particle
    public void mouseDragged() {
        end_selection_x = mouseX;
        end_selection_y = mouseY;
        selected_pairs = true;

    }

// if we had a selected particle unlock it again and kill reference
    public void mouseReleased() {
        if (selected_pairs == true) {
            end_selection_x = mouseX;
            end_selection_y = mouseY;
            selected_pairs = false;


            for (int i = Math.min(start_selection_x - translation, end_selection_x - translation); i < Math.max(start_selection_x - translation, end_selection_x - translation); i++) {
                for (int j = Math.min(start_selection_y - translation, end_selection_y - translation); j < Math.max(start_selection_y - translation, end_selection_y - translation); j++) {
                    Coordinate c = new Coordinate(i, j);
                    Variables.tmp_coor_pair_end.add(c);
                }
            }

            //  System.out.println("-----------" + Variables.pair_end_list_to_highlight.size());

        }
    }

    //image processing function to enhance contrast
//this doesn't make sense without also adjusting the brightness at the same time
    public void ContrastAndBrightness(PImage input, PImage output, double cont, double bright) {
        int w = input.width;
        int h = input.height;

        //our assumption is the image sizes are the same
        //so test this here and if it's not true just return with a warning
        if (w != output.width || h != output.height) {
            println("error: image dimensions must agree");
            return;
        }

        //this is required before manipulating the image pixels directly
        input.loadPixels();
        output.loadPixels();

        //loop through all pixels in the image
        for (int i = 0; i < w * h; i++) {
            //get color values from the current pixel (which are stored as a list of type 'color')
            int inColor = (input.pixels[i]);



            //slow version for illustration purposes - calling a function inside this loop
            //is a big no no, it will be very slow, plust we need an extra cast
            //as this loop is being called w * h times, that can be a million times or more!
            //so comment this version and use the one below
            int r = (int) red(input.pixels[i]);
            int g = (int) green(input.pixels[i]);
            int b = (int) blue(input.pixels[i]);

            //here the much faster version (uses bit-shifting) - uncomment to try
            //int r = (inColor >> 16) & 0xFF; //like calling the function red(), but faster
            //int g = (inColor >> 8) & 0xFF;
            //int b = inColor & 0xFF;      

            //apply contrast (multiplcation) and brightness (addition)
            r = (int) (r * cont + bright); //floating point aritmetic so convert back to int with a cast (i.e. '(int)');
            g = (int) (g * cont + bright);
            b = (int) (b * cont + bright);

            //slow but absolutely essential - check that we don't overflow (i.e. r,g and b must be in the range of 0 to 255)
            //to explain: this nest two statements, sperately it would be r = r < 0 ? 0 : r; and r = r > 255 ? 255 : 0;
            //you can also do this with if statements and it would do the same just take up more space
            r = r < 0 ? 0 : r > 255 ? 255 : r;
            g = g < 0 ? 0 : g > 255 ? 255 : g;
            b = b < 0 ? 0 : b > 255 ? 255 : b;

            //and again in reverse for illustration - calling the color function is slow so use the bit-shifting version below
            output.pixels[i] = color(r, g, b);
            //output.pixels[i]= 0xff000000 | (r << 16) | (g << 8) | b; //this does the same but faster

        }

        //so that we can display the new image we must call this for each image
        input.updatePixels();
        output.updatePixels();
    }

    public static void changeHilbert() {


        Meander.jLabel_status.setText("Drawing Hilbert...");
        Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
        Meander.jLabel_status.repaint();
        int counter = 0;


        for (int i = 0; i < Variables.pixels.size(); i++) {


            if (i % 1000 == 0) {
                Meander.jProgressBar.setValue(i);
                Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                Meander.jProgressBar.repaint();
            }
            Pixel pixel = Variables.pixels.get(i);
            int xx = pixel.getCoordinate_hilbert().X;
            int yy = pixel.getCoordinate_hilbert().Y;

            Variables.pg1.stroke(255, 255, 255);
            Variables.pg1.point(xx, yy);

            Variables.pg2.stroke(255, 255, 255);
            Variables.pg2.point(xx, yy);

            Variables.pg3.stroke(255, 255, 255);
            Variables.pg3.point(xx, yy);

            Variables.pg4.stroke(255, 255, 255);
            Variables.pg4.point(xx, yy);


            if (Variables.ratio_enabled == true) {



                if (pixel.getRatio1() >= Variables.lower_ratio_threshold && pixel.getRatio1() <= Variables.upper_ratio_threshold) {
                    color_scale_ratio(pixel);
                    Variables.pg1.stroke(pixel.getColor_hilbert_ratio1().R, pixel.getColor_hilbert_ratio1().G, pixel.getColor_hilbert_ratio1().B, pixel.getColor_hilbert_ratio1().alpha);
                    Variables.pg1.point(xx, yy);
                }




                if (pixel.getRatio2() >= Variables.lower_ratio_threshold && pixel.getRatio2() <= Variables.upper_ratio_threshold) {
                    color_scale_ratio(pixel);
                    Variables.pg2.stroke(pixel.getColor_hilbert_ratio2().R, pixel.getColor_hilbert_ratio2().G, pixel.getColor_hilbert_ratio2().B, pixel.getColor_hilbert_ratio2().alpha);
                    Variables.pg2.point(xx, yy);
                }



                if (pixel.getRatio3() >= Variables.lower_ratio_threshold && pixel.getRatio3() <= Variables.upper_ratio_threshold) {
                    color_scale_ratio(pixel);
                    Variables.pg3.stroke(pixel.getColor_hilbert_ratio3().R, pixel.getColor_hilbert_ratio3().G, pixel.getColor_hilbert_ratio3().B, pixel.getColor_hilbert_ratio3().alpha);
                    Variables.pg3.point(xx, yy);
                }



                if (pixel.getRatio4() >= Variables.lower_ratio_threshold && pixel.getRatio4() <= Variables.upper_ratio_threshold) {
                    color_scale_ratio(pixel);
                    Variables.pg4.stroke(pixel.getColor_hilbert_ratio4().R, pixel.getColor_hilbert_ratio4().G, pixel.getColor_hilbert_ratio4().B, pixel.getColor_hilbert_ratio4().alpha);
                    Variables.pg4.point(xx, yy);
                }




                if (Variables.variation_enabled == true) {
                    if (Variables.duplications_enabled == true) {
                        if (pixel.isDuplication()) {
                            ColorHilbert variation_col = pixel.getColor_duplication();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg2.point(xx, yy);


                            Variables.pg3.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg4.point(xx, yy);

                        }
                    }
                    if (Variables.deletions_enabled == true) {
                        if (pixel.isDeletion() == true) {
                            ColorHilbert variation_col = pixel.getColor_deletion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.insertions_enabled == true) {
                        if (pixel.isInsertion() == true) {
                            ColorHilbert variation_col = pixel.getColor_insertion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.translocations_enabled == true) {
                        if (pixel.isTranslocation() == true) {
                            ColorHilbert variation_col = pixel.getColor_translocation();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.inversions_enabled == true) {
                        if (pixel.isInversion() == true) {
                            ColorHilbert variation_col = pixel.getColor_inversion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }



                }
            }

            if (Variables.reference_enabled == true) {
                if (pixel.getCoverage_reference() >= Variables.upper_threshold) {
                    color_scale_ref(pixel);
                    Variables.pg1.stroke(pixel.getColor_hilbert_ref().R, pixel.getColor_hilbert_ref().G, pixel.getColor_hilbert_ref().B, pixel.getColor_hilbert_ref().alpha);
                    Variables.pg1.point(xx, yy);

                    Variables.pg2.stroke(pixel.getColor_hilbert_ref().R, pixel.getColor_hilbert_ref().G, pixel.getColor_hilbert_ref().B, pixel.getColor_hilbert_ref().alpha);
                    Variables.pg2.point(xx, yy);

                    Variables.pg3.stroke(pixel.getColor_hilbert_ref().R, pixel.getColor_hilbert_ref().G, pixel.getColor_hilbert_ref().B, pixel.getColor_hilbert_ref().alpha);
                    Variables.pg3.point(xx, yy);

                    Variables.pg4.stroke(pixel.getColor_hilbert_ref().R, pixel.getColor_hilbert_ref().G, pixel.getColor_hilbert_ref().B, pixel.getColor_hilbert_ref().alpha);
                    Variables.pg4.point(xx, yy);
                }


                if (Variables.variation_enabled == true) {
                    if (Variables.duplications_enabled == true) {
                        if (pixel.isDuplication() == true) {
                            ColorHilbert variation_col = pixel.getColor_duplication();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.deletions_enabled == true) {
                        if (pixel.isDeletion() == true) {
                            ColorHilbert variation_col = pixel.getColor_deletion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.insertions_enabled == true) {
                        if (pixel.isInsertion() == true) {
                            ColorHilbert variation_col = pixel.getColor_insertion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.translocations_enabled == true) {
                        if (pixel.isTranslocation() == true) {
                            ColorHilbert variation_col = pixel.getColor_translocation();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg1.point(xx, yy);
                            Variables.pg2.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg2.point(xx, yy);
                            Variables.pg3.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg3.point(xx, yy);
                            Variables.pg4.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.inversions_enabled == true) {
                        if (pixel.isInversion() == true) {
                            ColorHilbert variation_col = pixel.getColor_inversion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }



                }
            }

            if (Variables.sample_enabled == true) {


                if (pixel.getCoverage_sample1() >= Variables.upper_threshold) {
                    color_scale_sample(pixel);
                    Variables.pg1.stroke(pixel.getColor_hilbert_sample1().R, pixel.getColor_hilbert_sample1().G, pixel.getColor_hilbert_sample1().B, pixel.getColor_hilbert_sample1().alpha);
                    Variables.pg1.point(xx, yy);
                }



                if (pixel.getCoverage_sample2() >= Variables.upper_threshold) {
                    color_scale_sample(pixel);
                    Variables.pg2.stroke(pixel.getColor_hilbert_sample2().R, pixel.getColor_hilbert_sample2().G, pixel.getColor_hilbert_sample2().B, pixel.getColor_hilbert_sample2().alpha);
                    Variables.pg2.point(xx, yy);
                }



                if (pixel.getCoverage_sample3() >= Variables.upper_threshold) {
                    color_scale_sample(pixel);
                    Variables.pg3.stroke(pixel.getColor_hilbert_sample3().R, pixel.getColor_hilbert_sample3().G, pixel.getColor_hilbert_sample3().B, pixel.getColor_hilbert_sample3().alpha);
                    Variables.pg3.point(xx, yy);
                }



                if (pixel.getCoverage_sample4() >= Variables.upper_threshold) {
                    color_scale_sample(pixel);
                    Variables.pg4.stroke(pixel.getColor_hilbert_sample4().R, pixel.getColor_hilbert_sample4().G, pixel.getColor_hilbert_sample4().B, pixel.getColor_hilbert_sample4().alpha);
                    Variables.pg4.point(xx, yy);
                }



                if (Variables.variation_enabled == true) {
                    if (Variables.duplications_enabled == true) {
                        if (pixel.isDuplication() == true) {
                            ColorHilbert variation_col = pixel.getColor_duplication();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_duplication().R, pixel.getColor_duplication().G, pixel.getColor_duplication().B, pixel.getColor_duplication().alpha);
                            Variables.pg4.point(xx, yy);

                        }
                    }
                    if (Variables.deletions_enabled == true) {
                        if (pixel.isDeletion() == true) {
                            ColorHilbert variation_col = pixel.getColor_deletion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_deletion().R, pixel.getColor_deletion().G, pixel.getColor_deletion().B, pixel.getColor_deletion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.insertions_enabled == true) {
                        if (pixel.isInsertion() == true) {
                            ColorHilbert variation_col = pixel.getColor_insertion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_insertion().R, pixel.getColor_insertion().G, pixel.getColor_insertion().B, pixel.getColor_insertion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.translocations_enabled == true) {
                        if (pixel.isTranslocation() == true) {
                            ColorHilbert variation_col = pixel.getColor_translocation();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_translocation().R, pixel.getColor_translocation().G, pixel.getColor_translocation().B, pixel.getColor_translocation().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                    if (Variables.inversions_enabled == true) {
                        if (pixel.isInversion() == true) {
                            ColorHilbert variation_col = pixel.getColor_inversion();
                            variation_col.alpha = 100;
                            Variables.pg1.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg1.point(xx, yy);

                            Variables.pg2.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg2.point(xx, yy);

                            Variables.pg3.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg3.point(xx, yy);

                            Variables.pg4.stroke(pixel.getColor_inversion().R, pixel.getColor_inversion().G, pixel.getColor_inversion().B, pixel.getColor_inversion().alpha);
                            Variables.pg4.point(xx, yy);
                        }
                    }
                }

            }

        }



        //   System.out.println("counter:"+counter);

        Meander.jLabel_status.setText("");
        Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
        Meander.jLabel_status.repaint();
        Meander.jProgressBar.setVisible(true);

    }

    public static void overlay_variations() {

//        if (Variables.chromosome_selected != null) {
//
//            if (Variables.chromosome_selected.compareTo(Variables.chromosome) != 0) {
//                JOptionPane.showMessageDialog(null, "Caution! \nThe variations you are about to load refer to a \nDIFFERENT chromosome than the one you have loaded");
//            }


        int start = 0, end = 0;
        ColorFactory colorFactory = new ColorFactory();


        Meander.jProgressBar.setMinimum(1);
        Meander.jProgressBar.setMaximum(150);
        Meander.jProgressBar.setStringPainted(true);
        Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
        Meander.jProgressBar.repaint();

        Meander.jLabel_status.setText("Loading Variations...");
        Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
        Meander.jLabel_status.repaint();

        // System.out.println("-----"+Variables.deletions_start.size());
        for (int i = 0; i < Variables.pixels.size(); i++) {
            ColorHilbert c = null;

            Variables.pixels.get(i).setDeletion(false);
            Variables.pixels.get(i).setInversion(false);
            Variables.pixels.get(i).setDuplication(false);
            Variables.pixels.get(i).setTranslocation(false);
            Variables.pixels.get(i).setInsertion(false);

            if (Variables.ratio_enabled == true) {
                c = new ColorHilbert();
                if (Variables.panel == 1) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_ratio1().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_ratio1().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_ratio1().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_ratio1().alpha;
                }
                if (Variables.panel == 2) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_ratio2().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_ratio2().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_ratio2().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_ratio2().alpha;
                }
                if (Variables.panel == 3) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_ratio3().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_ratio3().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_ratio3().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_ratio3().alpha;
                }
                if (Variables.panel == 4) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_ratio4().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_ratio4().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_ratio4().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_ratio4().alpha;
                }
            }
            if (Variables.reference_enabled == true) {
                c = new ColorHilbert();
                c.R = Variables.pixels.get(i).getColor_hilbert_ref().R;
                c.G = Variables.pixels.get(i).getColor_hilbert_ref().G;
                c.B = Variables.pixels.get(i).getColor_hilbert_ref().B;
                c.alpha = Variables.pixels.get(i).getColor_hilbert_ref().alpha;
            }
            if (Variables.sample_enabled == true) {
                c = new ColorHilbert();

                if (Variables.panel == 1) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_sample1().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_sample1().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_sample1().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_sample1().alpha;
                }
                if (Variables.panel == 2) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_sample2().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_sample2().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_sample2().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_sample2().alpha;
                }
                if (Variables.panel == 3) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_sample3().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_sample3().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_sample3().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_sample3().alpha;
                }
                if (Variables.panel == 4) {
                    c.R = Variables.pixels.get(i).getColor_hilbert_sample4().R;
                    c.G = Variables.pixels.get(i).getColor_hilbert_sample4().G;
                    c.B = Variables.pixels.get(i).getColor_hilbert_sample4().B;
                    c.alpha = Variables.pixels.get(i).getColor_hilbert_sample4().alpha;
                }
            }


            Variables.pixels.get(i).setColor_deletion(c);
            Variables.pixels.get(i).setColor_duplication(c);
            Variables.pixels.get(i).setColor_inversion(c);
            Variables.pixels.get(i).setColor_insertion(c);
            Variables.pixels.get(i).setColor_translocation(c);

            //  System.out.println(Variables.pixels.get(i).getColor_deletion().toString()+"-"+Variables.pixels.get(i).getColor_hilbert_sample().toString());
        }



        for (int k = 0; k < Variables.variation_list.size(); k++) {



            Meander.jProgressBar.setValue(k);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();



            Color3f col = colorFactory.computeColor(new Integer(k), 1.0f);

            int x = (int) (col.x * 255);
            int y = (int) (col.y * 255);
            int z = (int) (col.z * 255);

            int alpha = 0;

            ColorHilbert cc = new ColorHilbert(x, y, z, alpha);

            // ColorHilbert cc = new ColorHilbert(255, 0, 0, 255);

            for (int i = 0; i < Variables.pixels.size(); i++) {

                if (Variables.pixels.get(i).getPosition_range_start() >= Variables.variation_list.get(k).from && Variables.pixels.get(i).getPosition_range_start() <= Variables.variation_list.get(k).to
                        && Variables.pixels.get(i).getPosition_range_end() >= Variables.variation_list.get(k).from && Variables.pixels.get(i).getPosition_range_end() <= Variables.variation_list.get(k).to) {


                    if (Variables.variation_list.get(k).variation_type.compareToIgnoreCase("deletion") == 0) {
                        Variables.pixels.get(i).setDeletion(true);
                        Variables.pixels.get(i).setColor_deletion(cc);
                    }
                    if (Variables.variation_list.get(k).variation_type.compareToIgnoreCase("insertion") == 0 || Variables.variation_list.get(k).variation_type.compareToIgnoreCase("duplication") == 0) {
                        Variables.pixels.get(i).setInsertion(true);
                        Variables.pixels.get(i).setColor_insertion(cc);

                    }
                    if (Variables.variation_list.get(k).variation_type.compareToIgnoreCase("inversion") == 0) {
                        Variables.pixels.get(i).setInversion(true);
                        Variables.pixels.get(i).setColor_inversion(cc);
                    }
                    if (Variables.variation_list.get(k).variation_type.compareToIgnoreCase("duplication") == 0) {
                        Variables.pixels.get(i).setDuplication(true);
                        Variables.pixels.get(i).setColor_duplication(cc);
                    }
                    if (Variables.variation_list.get(k).variation_type.compareToIgnoreCase("translocation") == 0) {
                        Variables.pixels.get(i).setTranslocation(true);
                        Variables.pixels.get(i).setColor_translocation(cc);
                    }


                }//if there is a variation

            }//for all pixels


        }//for all variations









        Meander.jProgressBar.setValue(0);
        Meander.jProgressBar.setVisible(false);
        Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
        Meander.jProgressBar.repaint();



//        } else {
//            JOptionPane.showMessageDialog(null, "Please select a chromsosome");
//        }
    }

    //----------------------------------------------------------------------------
    public static void setLabels(int x, int y) {
        Variables.mouse_x = x - translation;
        Variables.mouse_y = y - translation;
        Meander.jProgressBar.setVisible(false);
//        Coordinate c = new Coordinate(x, y);
//        Pixel pixel = Variables.give_coordinate_get_pixel.get(c.toString());
//        if (pixel != null) {
//            //System.out.println(pixel.toString());
////            Meander.label_hilbert_position.setText("X,Y Coordinates: " + pixel.getCoordinate_hilbert().toString());
////            Meander.label_coverage_sample.setText("Sample Coverage: " + (GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_sample())));
////            Meander.label_coverage_reference.setText("Reference Coverage: " + (GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_reference())));
////
////            Meander.label_ratio.setText("Sample/Reference Ratio: " + (pixel.getRatio()));
////
////            Meander.label_linear_position.setText("Bucket: " + GenericMethods.giveNumber_getHumanformat(pixel.getPosition_range_start()) + "-" + GenericMethods.giveNumber_getHumanformat(pixel.getPosition_range_end()));
////            Meander.label_maximum.setText("Maximum Coverage: " + GenericMethods.giveNumber_getHumanformat((double) Variables.max_read_sample));
////            Meander.label_minimum.setText("Minimum Coverage: " + GenericMethods.giveNumber_getHumanformat((double) Variables.min_read_sample));
////            Meander.label_average.setText("Average Coverage: " + GenericMethods.giveNumber_getHumanformat((double) Variables.average_read_sample));
//        }
    }

    public static void color_scale_ref(Pixel pixel) {


        double real_depth = -9999;
        double abs_depth = -9999;
        int transparency = 0;

        real_depth = pixel.getCoverage_reference();
        if (real_depth != 1) {
            abs_depth = Math.abs(pixel.getCoverage_reference());

            transparency = (int) map((float) abs_depth, (float) 0, (float) Variables.max_value_color_for_reference, (float) 1, (float) 255);

            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }


            ColorHilbert c = new ColorHilbert("black");
            c.alpha = transparency;
            pixel.setColor_hilbert_ref(c);
        }

    }

    public static void color_scale_sample(Pixel pixel) {


        double real_depth1 = -9999999;
        double abs_depth1 = -9999999;

        double real_depth2 = -9999999;
        double abs_depth2 = -9999999;


        double real_depth3 = -9999999;
        double abs_depth3 = -9999999;

        double real_depth4 = -9999999;
        double abs_depth4 = -9999999;

        int transparency;


        real_depth1 = pixel.getCoverage_sample1();
        if (real_depth1 != 1) {
            abs_depth1 = Math.abs(pixel.getCoverage_sample1());
            transparency = (int) map((float) abs_depth1, (float) 0, (float) Variables.max_value_color_for_sample, (float) 1, (float) 255);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }


            ColorHilbert c = new ColorHilbert("black");
            c.alpha = transparency;
            pixel.setColor_hilbert_sample1(c);
        }



        real_depth2 = pixel.getCoverage_sample2();
        if (real_depth2 != 1) {
            abs_depth2 = Math.abs(pixel.getCoverage_sample2());
            transparency = (int) map((float) abs_depth2, (float) 0, (float) Variables.max_value_color_for_sample, (float) 1, (float) 255);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }


            ColorHilbert c = new ColorHilbert("black");
            c.alpha = transparency;
            pixel.setColor_hilbert_sample2(c);
        }


        real_depth3 = pixel.getCoverage_sample3();
        if (real_depth3 != 1) {
            abs_depth3 = Math.abs(pixel.getCoverage_sample3());
            transparency = (int) map((float) abs_depth3, (float) 0, (float) Variables.max_value_color_for_sample, (float) 1, (float) 255);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }


            ColorHilbert c = new ColorHilbert("black");
            c.alpha = transparency;
            pixel.setColor_hilbert_sample3(c);
        }



        real_depth4 = pixel.getCoverage_sample4();
        if (real_depth4 != 1) {
            abs_depth4 = Math.abs(pixel.getCoverage_sample4());
            transparency = (int) map((float) abs_depth4, (float) 0, (float) Variables.max_value_color_for_sample, (float) 1, (float) 255);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }


            ColorHilbert c = new ColorHilbert("black");
            c.alpha = transparency;
            pixel.setColor_hilbert_sample4(c);
        }

    }

    public static void color_scale_ratio(Pixel pixel) {


        double real_depth1 = -9999999;
        double abs_depth1 = -9999999;

        double real_depth2 = -9999999;
        double abs_depth2 = -9999999;


        double real_depth3 = -9999999;
        double abs_depth3 = -9999999;

        double real_depth4 = -9999999;
        double abs_depth4 = -9999999;

        int transparency;


        real_depth1 = pixel.getRatio1();
        if (real_depth1 != 0) {
            abs_depth1 = Math.abs(pixel.getRatio1()) * 100;
            transparency = (int) map((int) abs_depth1, (float) 0, (float) Variables.max_value_color_for_ratio * 100f, (float) 1, 255);
            // System.out.println(transparency);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }
            if (pixel.getRatio1() > 0) {
                pixel.setColor_hilbert_ratio1(Variables.up_regulated);
                pixel.getColor_hilbert_ratio1().alpha = transparency;
            }
            if (pixel.getRatio1() < 0) {
                pixel.setColor_hilbert_ratio1(Variables.down_regulated);
                pixel.getColor_hilbert_ratio1().alpha = transparency;
            }
            if (pixel.getRatio1() == 0) {
                ColorHilbert c = new ColorHilbert("white");
                pixel.setColor_hilbert_ratio1(c);
            }
        }






        real_depth2 = pixel.getRatio2();
        if (real_depth2 != 0) {
            abs_depth2 = Math.abs(pixel.getRatio2()) * 100;
            transparency = (int) map((int) abs_depth2, (float) 0, (float) Variables.max_value_color_for_ratio * 100f, (float) 1, 255);
            // System.out.println(transparency);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }
            if (pixel.getRatio2() > 0) {
                pixel.setColor_hilbert_ratio2(Variables.up_regulated);
                pixel.getColor_hilbert_ratio2().alpha = transparency;
            }
            if (pixel.getRatio2() < 0) {
                pixel.setColor_hilbert_ratio2(Variables.down_regulated);
                pixel.getColor_hilbert_ratio2().alpha = transparency;
            }
            if (pixel.getRatio2() == 0) {
                ColorHilbert c = new ColorHilbert("white");
                pixel.setColor_hilbert_ratio2(c);
            }
        }





        real_depth3 = pixel.getRatio3();
        if (real_depth3 != 0) {
            abs_depth3 = Math.abs(pixel.getRatio3()) * 100;
            transparency = (int) map((int) abs_depth3, (float) 0, (float) Variables.max_value_color_for_ratio * 100f, (float) 1, 255);
            // System.out.println(transparency);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }
            if (pixel.getRatio3() > 0) {
                pixel.setColor_hilbert_ratio3(Variables.up_regulated);
                pixel.getColor_hilbert_ratio3().alpha = transparency;
            }
            if (pixel.getRatio3() < 0) {
                pixel.setColor_hilbert_ratio3(Variables.down_regulated);
                pixel.getColor_hilbert_ratio3().alpha = transparency;
            }
            if (pixel.getRatio3() == 0) {
                ColorHilbert c = new ColorHilbert("white");
                pixel.setColor_hilbert_ratio3(c);
            }
        }




        real_depth4 = pixel.getRatio4();
        if (real_depth4 != 0) {
            abs_depth4 = Math.abs(pixel.getRatio4()) * 100;
            transparency = (int) map((int) abs_depth4, (float) 0, (float) Variables.max_value_color_for_ratio * 100f, (float) 1, 255);
            // System.out.println(transparency);
            if (transparency <= 1) {
                transparency = 1;
            }
            if (transparency >= 255) {
                transparency = 255;
            }
            if (pixel.getRatio4() > 0) {
                pixel.setColor_hilbert_ratio4(Variables.up_regulated);
                pixel.getColor_hilbert_ratio4().alpha = transparency;
            }
            if (pixel.getRatio4() < 0) {
                pixel.setColor_hilbert_ratio4(Variables.down_regulated);
                pixel.getColor_hilbert_ratio4().alpha = transparency;
            }
            if (pixel.getRatio4() == 0) {
                ColorHilbert c = new ColorHilbert("white");
                pixel.setColor_hilbert_ratio4(c);
            }
        }

    }
    int cnt = 0;

    public void deplacement(int vx, int vy) {
        if (cnt < Variables.pixels.size()) {
            int ax = x;



            int ay = y;
            x = x + vx;
            y = y + vy;
            Pixel pixel = Variables.pixels.get(cnt);
            Coordinate coor = new Coordinate(x, y);
            pixel.setCoordinate_hilbert(coor);

            if (Variables.initial_calculations_made == false) {
                Variables.give_coordinate_get_pixel_initial.put(coor.toString(), Variables.pixels_initial.get(cnt));
            }
            Variables.give_coordinate_get_pixel.put(coor.toString(), Variables.pixels.get(cnt));

            display(pixel);
            cnt++;

        }


    }

    private void HilbertA(int level) {
        if (level > 0 && x <= Variables.dimension && x >= 0 && y <= Variables.dimension && y >= 0) {
            HilbertB(level - 1);
            deplacement(0, dist);
            HilbertA(level - 1);
            deplacement(dist, 0);
            HilbertA(level - 1);
            deplacement(0, -dist);
            HilbertC(level - 1);


        }
    }

    private void HilbertB(int level) {
        if (cnt % 4096 == 0) {

            Meander.jProgressBar.setValue(cnt);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();

        }

        if (level > 0 && x <= Variables.dimension && x >= 0 && y <= Variables.dimension && y >= 0) {
            HilbertA(level - 1);
            deplacement(dist, 0);
            HilbertB(level - 1);
            deplacement(0, dist);
            HilbertB(level - 1);
            deplacement(-dist, 0);
            HilbertD(level - 1);


        }
    }

    private void HilbertC(int level) {
        if (level > 0 && x <= Variables.dimension && x >= 0 && y <= Variables.dimension && y >= 0) {
            HilbertD(level - 1);
            deplacement(-dist, 0);
            HilbertC(level - 1);
            deplacement(0, -dist);
            HilbertC(level - 1);
            deplacement(dist, 0);
            HilbertA(level - 1);


        }
    }

    private void HilbertD(int level) {
        if (level > 0 && x <= Variables.dimension && x >= 0 && y <= Variables.dimension && y >= 0) {
            HilbertC(level - 1);
            deplacement(0, -dist);
            HilbertD(level - 1);
            deplacement(-dist, 0);
            HilbertD(level - 1);
            deplacement(0, dist);
            HilbertB(level - 1);


        }
    }

    void display(Pixel pixel) {



        ColorHilbert c1 = null;
        ColorHilbert c2 = null;
        ColorHilbert c3 = null;
        ColorHilbert c4 = null;

        if (Variables.reference_enabled == true) {
            c1 = pixel.getColor_hilbert_ref();
            c2 = pixel.getColor_hilbert_ref();
            c3 = pixel.getColor_hilbert_ref();
            c4 = pixel.getColor_hilbert_ref();
        }
        if (Variables.sample_enabled == true) {

            c1 = pixel.getColor_hilbert_sample1();


            c2 = pixel.getColor_hilbert_sample2();


            c3 = pixel.getColor_hilbert_sample3();


            c4 = pixel.getColor_hilbert_sample4();

        }
        if (Variables.ratio_enabled == true) {

            c1 = pixel.getColor_hilbert_ratio1();

            c2 = pixel.getColor_hilbert_ratio2();

            c3 = pixel.getColor_hilbert_ratio3();

            c4 = pixel.getColor_hilbert_ratio4();

        }


        Variables.pg1.stroke(c1.R, c1.G, c1.B, c1.alpha);
        Variables.pg1.point(x, y);

        Variables.pg2.stroke(c2.R, c2.G, c2.B, c2.alpha);
        Variables.pg2.point(x, y);

        Variables.pg3.stroke(c3.R, c3.G, c3.B, c3.alpha);
        Variables.pg3.point(x, y);

        Variables.pg4.stroke(c4.R, c4.G, c4.B, c4.alpha);
        Variables.pg4.point(x, y);


    }
}
