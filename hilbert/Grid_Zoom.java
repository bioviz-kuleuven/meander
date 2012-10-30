/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import processing.core.PApplet;

/**
 *
 * @author gpavlopo
 */
public class Grid_Zoom extends PApplet {

    float bx;
    float by;
    int bs = 8;
    boolean bover = false;
    boolean locked = false;
    float bdifx = 0.0f;
    float bdify = 0.0f;
    public static boolean printed_once = false;
    static boolean replace = false;
    int index = 0;
    boolean file_found = false;
    
   

    public void setup() {
        //dimensions of the small panel interface pixels
        Variables.give_zoom_get_size.put(1, 128);
        Variables.give_zoom_get_size.put(2, 64);
        Variables.give_zoom_get_size.put(3, 32);
        Variables.give_zoom_get_size.put(4, 16);
        Variables.give_zoom_get_size.put(5, 8);
        smooth();
        size(256, 256, P2D);
        background(255);
        bx = bs;
        by = bs;
        rectMode(RADIUS);
        this.addKeyListener(new MyKeyListener());

    }//setup()

    public static void replace_image() {
        replace = false;
    }

    public static void update()
    {
        if (Variables.panel == 1) {
                    Variables.pi1_copy1 = Variables.pg1_copy1.get(0, 0, Variables.pg1.width, Variables.pg1.height);
                    Variables.pi1_copy1.resize(256, 256);
               
                    
                }

                if (Variables.panel == 2) {
                    Variables.pi2_copy1 = Variables.pg2_copy1.get(0, 0, Variables.pg2.width, Variables.pg2.height);
                    Variables.pi2_copy1.resize(256, 256);
                   
                }

                if (Variables.panel == 3) {
                    Variables.pi3_copy1 = Variables.pg3_copy1.get(0, 0, Variables.pg3.width, Variables.pg3.height);
                    Variables.pi3_copy1.resize(256, 256);
                }

                if (Variables.panel == 4) {
                    Variables.pi4_copy1 = Variables.pg4_copy1.get(0, 0, Variables.pg4.width, Variables.pg4.height);
                    Variables.pi4_copy1.resize(256, 256);
                }
    }
    
    
    
    public void draw() {
        smooth();
        background(255);


        if (Variables.finished_hilbert_drawing_for_first_time == true) {
            {
                bs = Variables.give_zoom_get_size.get(Variables.zoom_tmp);

                ColorHilbert c = new ColorHilbert(210, 210, 210);
                gridMNC(0, 0, 16, 16, 16, c);

                //copy image of the hipbert panel
                if (Variables.panel == 1) {
                    image(Variables.pi1_copy1, 0, 0);
                }

                if (Variables.panel == 2) {
                    image(Variables.pi2_copy1, 0, 0);
                }

                if (Variables.panel == 3) {
                    image(Variables.pi3_copy1, 0, 0);
                }

                if (Variables.panel == 4) {
                    image(Variables.pi4_copy1, 0, 0);
                }

                printed_once = true;
            }
        }



        //   testing - highlight the zoomed areas yellow
        if (Variables.zoom != 1) {

            stroke(255, 255, 0, 30);
            for (int i = 0; i < Variables.highlight_zoom_point_list.size(); i++) {
                if (Variables.highlight_zoom_point_list.get(i) != null) {
                    point(Variables.highlight_zoom_point_list.get(i).X, Variables.highlight_zoom_point_list.get(i).Y);
                }
            }
        }



        //cross hilbert zoomed
        int xxx = Variables.highlight_hilbert_point_zoomed.X;
        int yyy = Variables.highlight_hilbert_point_zoomed.Y;

        stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
        line(0, yyy, 256, yyy);
        line(xxx, 0, xxx, 256);


        if (Variables.pair_ends_enabled == true) {
//            for (int i = 0; i < Variables.pair_end_list_to_highlight_initial_zooming_panel.size(); i++) {
//                Pixel pix = Variables.pair_end_list_to_highlight_initial_zooming_panel.get(i);
//                stroke(0, 0, 0, 150);
//                noFill();
//                point(pix.getCoordinate_hilbert().X / 2, pix.getCoordinate_hilbert().Y / 2);
//            }

            if (Variables.enable_pair_end_lines == true) {
                try {
                    noFill();


                    if (Variables.pair_end_list_to_highlight_initial.size() > 0) {
                        for (int i = 0; i < Variables.pair_end_list_to_highlight_initial.size(); i++) {
                            Pixel pix_source = Variables.pair_end_list_to_highlight_initial.get(i).source;
                            Pixel pix_dest = Variables.pair_end_list_to_highlight_initial.get(i).dest;


                            int R = Variables.pair_end_list_to_highlight_initial.get(i).color.R;
                            int G = Variables.pair_end_list_to_highlight_initial.get(i).color.G;
                            int B = Variables.pair_end_list_to_highlight_initial.get(i).color.B;
                            int alpha = Variables.pair_end_list_to_highlight_initial.get(i).color.alpha;

                            if (Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareTo("inversion") == 0) {
                                R = 44;
                                G = 77;
                                B = 143;
                                alpha = 200;
                            }
                            if (Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareTo("duplication") == 0) {
                                R = 88;
                                G = 171;
                                B = 45;
                                alpha = 200;
                            }
                            if (Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareTo("insertion") == 0) {
                                R = 88;
                                G = 171;
                                B = 45;
                                alpha = 200;
                            }
                            if (Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareTo("deletion") == 0) {
                                R = 255;
                                G = 51;
                                B = 208;
                                alpha = 200;
                            }
                            if (Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareTo("translocation") == 0) {
                                R = 201;
                                G = 51;
                                B = 255;
                                alpha = 200;
                            }

                            stroke(R, G, B, alpha);
                            noFill();

                            Coordinate src_coor = get_Coordinate(pix_source);
                            Coordinate dest_coor = get_Coordinate(pix_dest);
                            if (src_coor != null && dest_coor != null) {
                                if (Variables.deletions_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("deletion") == 0) {
                                    line(src_coor.X, src_coor.Y, dest_coor.X, dest_coor.Y);
                                }

                                if (Variables.insertions_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("insertion") == 0) {
                                    line(src_coor.X, src_coor.Y, dest_coor.X, dest_coor.Y);
                                }

                                if (Variables.inversions_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("inversion") == 0) {
                                    line(src_coor.X, src_coor.Y, dest_coor.X, dest_coor.Y);
                                }

                                if (Variables.translocations_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("translocation") == 0) {
                                    line(src_coor.X, src_coor.Y, dest_coor.X, dest_coor.Y);
                                }
                                if (Variables.duplications_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("duplication") == 0) {
                                    line(src_coor.X, src_coor.Y, dest_coor.X, dest_coor.Y);
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }
        }

        stroke(255);
        fill(180, 238, 180, 120);


        try {
            if (replace == false) {

                if (Variables.panel == 1) {
                    Variables.pg1_copy1.beginDraw();
                    Variables.pg1_copy1.set(0, 0, Variables.pg1);
                    Variables.pi1_copy1.resize(256, 256);
                    Variables.pg1_copy1.endDraw();
                    image(Variables.pg1_copy1, 0, 0);
                }

                if (Variables.panel == 2) {
                    Variables.pg2_copy1.beginDraw();
                    Variables.pg2_copy1.set(0, 0, Variables.pg2);
                    Variables.pi2_copy1.resize(256, 256);
                    Variables.pg2_copy1.endDraw();
                    image(Variables.pg2_copy1, 0, 0);
                }

                if (Variables.panel == 3) {
                    Variables.pg3_copy1.beginDraw();
                    Variables.pg3_copy1.set(0, 0, Variables.pg3);
                    Variables.pi3_copy1.resize(256, 256);
                    Variables.pg3_copy1.endDraw();
                    image(Variables.pg3_copy1, 0, 0);
                }

                if (Variables.panel == 4) {
                    Variables.pg4_copy1.beginDraw();
                    Variables.pg4_copy1.set(0, 0, Variables.pg4);
                    Variables.pi4_copy1.resize(256, 256);
                    Variables.pg4_copy1.endDraw();
                    image(Variables.pg4_copy1, 0, 0);
                }


                replace = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }




        // Test if the cursor is over the box
        if (mouseX > bx - bs && mouseX < bx + bs
                && mouseY > by - bs && mouseY < by + bs) {
            bover = true;
            if (!locked) {
                stroke(255);
                fill(180, 238, 180, 120);
            }
        } else {
            stroke(153);
            fill(180, 238, 180, 120);
            bover = false;
        }

//snap zoom box to grid
        for (int i = (int) bx; i >= 0; i--) {
            if ((i) % (2 * bs) == 0) {
                bx = i + bs;
                Variables.zooming_grid_index_x = i / (2 * bs) + 1;
                break;
            }
        }

        for (int i = (int) by; i >= 0; i--) {
            if ((i) % (2 * bs) == 0) {
                by = i + bs;
                Variables.zooming_grid_index_y = i / (2 * bs) + 1;
                break;
            }
        }






//System.out.println("("+Variables.zooming_grid_index_y+","+Variables.zooming_grid_index_x+")");



//dont let the zoom box outside the borders
        if (bx <= bs) {
            bx = bs;
        }
        if (by <= bs) {
            by = bs;
        }
        if (bx >= (width - bs)) {
            bx = width - bs - 1;
        }
        if (by >= (height - bs)) {
            by = height - bs - 1;
        }


        // Draw the box
        if (Variables.zooming_window_enabled == true) {
            //  if (Variables.finished_hilbert_drawing_for_first_time == true)
            {
                rect(bx, by, bs, bs);


                if (Variables.zooming_file_list.size() > 0) {

                    int counter = 0;

                    //find the index in a row
                    for (int i = 1; i <= 512; i++) {
                        for (int j = 1; j <= 512; j++) {

                            if (i == Variables.zooming_grid_index_x && j == Variables.zooming_grid_index_y) {
                                index = counter;
                                break;
                            }
                            counter++;
                        }

                    }
                }





            }
        }


        //------------
        //finds the pixels withing the green window for zooming
        //detects which file corresponds to which gene and counts them
        //finally selects the file with the maximum counts
        //if(focused)
        {
            //  if (!locked)   
            {
                file_found = false;
                for (int i = 0; i < Variables.zooming_file_list.size(); i++) {
                    Variables.zooming_file_list.get(i).counts_tmp = 0;
                }
                for (int x = (int) bx; x < (int) (bx + bs); x++) {
                    for (int y = (int) by; y < (int) (by + bs); y++) {

                        //find the linear position
                        Coordinate c = new Coordinate(2 * x, 2 * y);
                        Pixel pix = Variables.give_coordinate_get_pixel_initial.get(c.toString());
                        if (pix != null) {
                            for (int i = 0; i < Variables.zooming_file_list.size(); i++) {
                                Zooming_Info zzz = Variables.zooming_file_list.get(i);
                                if (Variables.zoom_tmp == zzz.zoom) {
                                    if (pix.getPosition_range_start() >= zzz.range_start && pix.getPosition_range_start() <= zzz.range_end
                                            && pix.getPosition_range_end() >= zzz.range_start && pix.getPosition_range_end() <= zzz.range_end) {

                                        Variables.zooming_file_list.get(i).counts_tmp++;
                                    }
                                }
                            }

                        }

                    }

                }
                int max = -1;
                int index = -1;
                Zooming_Info zzz = null;
                for (int i = 0; i < Variables.zooming_file_list.size(); i++) {
                    if (Variables.zooming_file_list.get(i).counts_tmp >= max) {
                        max = Variables.zooming_file_list.get(i).counts_tmp;
                        index = i;
                        zzz = Variables.zooming_file_list.get(i);
                    }

                }
                Variables.zooming_file_to_be_loaded = zzz;
                // if(Variables.zooming_file_to_be_loaded!=null)
                // System.out.println("file loaded:"+Variables.zooming_file_to_be_loaded.filename);

            }
        }


        if (Variables.pair_ends_enabled == true) {
          
                for (int i = 0; i < Variables.pe_marking_for_first_zoom_level.size(); i++) {
                    Coordinate cc = Variables.pe_marking_for_first_zoom_level.get(i);
                    stroke(0, 0, 0, 150);
                    noFill();
                    if(cc!=null)
                    point(cc.X / 2, cc.Y / 2);
                }
            
           
        }



    }//draw()

//========================================================
// grid of given #row/#column
    public void gridMNC(int x0, int y0, int mrow, int ncol, int cellw, ColorHilbert c) {
        stroke(c.R, c.G, c.B, c.alpha);
        int x1 = x0 + ncol * cellw;
        int y1 = y0 + mrow * cellw;
        for (int i = 0, iy = y0; i <= mrow; i++, iy += cellw) {
            line(x0, iy, x1, iy);
        }
        for (int i = 0, ix = x0; i <= ncol; i++, ix += cellw) {
            line(ix, y0, ix, y1);
        }
    }//gridMNC()

    public void mousePressed() {
        if (bover) {
            locked = true;
            stroke(105, 139, 105);
            fill(180, 238, 180, 120);
        } else {
            locked = false;
        }
        bdifx = mouseX - bx;
        bdify = mouseY - by;
    }

    public void mouseDragged() {
        if (locked) {
            bx = (int) (mouseX - bdifx);
            by = (int) (mouseY - bdify);

            for (int i = (int) bx; i >= 0; i--) {
                if ((i) % (2 * bs) == 0) {
                    bx = i + bs;
                    break;
                }
            }
            for (int i = (int) by; i >= 0; i--) {
                if ((i) % (2 * bs) == 0) {
                    by = i + bs;
                    break;
                }
            }
            if (bx <= bs) {
                bx = bs;
            }
            if (by <= bs) {
                by = bs;
            }
            if (bx >= (width - bs)) {
                bx = width - bs;
            }
            if (by >= (height - bs)) {
                by = height - bs;
            }


            stroke(105, 139, 105);
            fill(180, 238, 180, 120);
        }
    }

    public void mouseReleased() {
        locked = false;
    }
    // TODO overwrite start(), stop() and destroy() methods

    public Coordinate get_Coordinate(Pixel pix) {
        Coordinate coor = null;

        try {

            int start = pix.getPosition_range_start();
            int end = pix.getPosition_range_end();
            Interval interval = new Interval(start, end, null);
            if (pix != null) {
                Pixel p = Variables.searchTree_Coordinates.search(interval).pix;
                if (p != null) {
                    coor = new Coordinate(p.getCoordinate_hilbert().X / 2, p.getCoordinate_hilbert().Y / 2);
                    return coor;
                }
            }

        } catch (Exception e) {
        }

        return coor;
    }
}
