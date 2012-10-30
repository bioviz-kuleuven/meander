/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.util.ArrayList;
import java.util.HashSet;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 *
 * @author gpavlopo
 */
public class PairEndPanel_old extends PApplet {

    static int height = 512;
    static int width = 512;
    boolean selected_pairs = false;
    int start_selection_x = -1;
    int start_selection_y = -1;
    int end_selection_x = -1;
    int end_selection_y = -1;
    PGraphics pg = createGraphics(512, 512, P2D);
    PImage pi = createImage(512, 512, RGB);

    public void setup() {
        size(width, height, P2D);
        smooth();
        this.addKeyListener(new MyKeyListener());

        background(255);
        pg.background(255);
    }

    public void draw() {

        smooth();
        background(255);
        pi = pg.get(0, 0, pg.width, pg.height);
        image(pi, 0, 0);

        if (Variables.pair_ends_enabled == true) {
            
            
      
         stroke(255,20,147,160);
        noFill();
        if(Variables.circles.size()>0) 
        for (int i = 0; i < Variables.circles.size(); i++) {
            DoubleEvidence de = Variables.circles.get(i);
            //System.out.println(i+" - "+de.toString());
            int x=de.getX();
            int y=de.getY();
            int radius=(int)Math.ceil(de.getRadius());
            ellipse(x,y,radius,radius);
        }


            if (Math.abs(start_selection_x - end_selection_x) != 0 && Math.abs(start_selection_y - end_selection_y) != 0) {
                stroke(0, 0, 255, 180);
                fill(0, 0, 255, 30);
                if (Variables.pair_end_list != null) {
                    rect(start_selection_x, start_selection_y, end_selection_x - start_selection_x, end_selection_y - start_selection_y);
                }
                //will get changed
                show_pair_ends();

            }


            if (Variables.finished_pair_end_drawing_for_first_time == false) {

                stroke(0);
                fill(0);
                pg.beginDraw();
                pg.background(255);
                Variables.pair_ends_for_zoom_level.clear();




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

                for (int i = 0; i < Variables.pair_ends_for_zoom_level.size(); i++) {
                    Pixel pix = Variables.pair_ends_for_zoom_level.get(i);

                    if (Variables.zoom == 1) {
                        Variables.pair_end_list_to_highlight_initial_zooming_panel.add(pix);
                    }

                    if (pix.getZoom_level() == Variables.zoom) {
                        pg.point(pix.getCoordinate_hilbert().X, pix.getCoordinate_hilbert().Y);
                    }
                }

                pi = pg.get(0, 0, pg.width, pg.height);
                image(pg, 0, 0);
                pg.endDraw();
                Variables.finished_pair_end_drawing_for_first_time = true;
            }



        }

        if (!focused) {
            if (Variables.panel != 1) {
                stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
                line(0, Variables.highlight_hilbert_point.Y, 512, Variables.highlight_hilbert_point.Y);
                line(Variables.highlight_hilbert_point.X, 0, Variables.highlight_hilbert_point.X, 512);
            } else {

                stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
                line(0, Variables.highlight_hilbert_point.Y - 2 * Variables.translation, 512, Variables.highlight_hilbert_point.Y - 2 * Variables.translation);
                line(Variables.highlight_hilbert_point.X - 2 * Variables.translation, 0, Variables.highlight_hilbert_point.X - 2 * Variables.translation, 512);
            }

        }
        if (focused) {

            mouse_over();
           

            Variables.highlight_hilbert_point.X = mouseX;
            Variables.highlight_hilbert_point.Y = mouseY;

            stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
            line(0, Variables.highlight_hilbert_point.Y, 512, Variables.highlight_hilbert_point.Y);
            line(Variables.highlight_hilbert_point.X, 0, Variables.highlight_hilbert_point.X, 512);
        }



    }//draw

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
                            point(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y);

                            stroke(255, 51, 204);
                            noFill();
                            point(pix_dest.getCoordinate_hilbert().X, pix_dest.getCoordinate_hilbert().Y);

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
                                    
                                    if(Variables.deletions_enabled==true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("deletion")==0)
                                    line(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y, pix_dest.getCoordinate_hilbert().X, pix_dest.getCoordinate_hilbert().Y);

                                    if(Variables.insertions_enabled==true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("insertion")==0)
                                    line(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y, pix_dest.getCoordinate_hilbert().X, pix_dest.getCoordinate_hilbert().Y);

                                    if(Variables.inversions_enabled==true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("inversion")==0)
                                    line(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y, pix_dest.getCoordinate_hilbert().X, pix_dest.getCoordinate_hilbert().Y);

                                    if(Variables.translocations_enabled==true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("translocation")==0)
                                    line(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y, pix_dest.getCoordinate_hilbert().X, pix_dest.getCoordinate_hilbert().Y);

                                    if(Variables.duplications_enabled==true && Variables.pair_end_list_to_highlight.get(i).variation_type.compareToIgnoreCase("duplication")==0)
                                    line(pix_source.getCoordinate_hilbert().X, pix_source.getCoordinate_hilbert().Y, pix_dest.getCoordinate_hilbert().X, pix_dest.getCoordinate_hilbert().Y);

                              
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

    void mouse_over() {
        setLabels(mouseX, mouseY);

    }

    public static void setLabels(int x, int y) {
        Variables.mouse_x = x;
        Variables.mouse_y = y;
    }

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

            start_selection_x = 0;
            start_selection_y = 0;
            end_selection_x = width - 1;
            end_selection_y = height - 1;
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


            for (int i = Math.min(start_selection_x, end_selection_x); i < Math.max(start_selection_x, end_selection_x); i++) {
                for (int j = Math.min(start_selection_y, end_selection_y); j < Math.max(start_selection_y, end_selection_y); j++) {
                    Coordinate c = new Coordinate(i, j);
                    Variables.tmp_coor_pair_end.add(c);
                }
            }

            //  System.out.println("-----------" + Variables.pair_end_list_to_highlight.size());

        }
    }
}
