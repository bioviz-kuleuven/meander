/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 *
 * @author gpavlopo
 */
public class SamplePanel extends PApplet {

    static int height = 560;
    static int width = 518;
    PGraphics pg = createGraphics(512, 512, P2D);
    PImage pi = createImage(512, 512, RGB);
    PFont myFont;
    
    static boolean state_changed = false;

    public void setup() {


        myFont = createFont("Arial", 12);
        textFont(myFont);

        size(width, height, P2D);
        smooth();
        this.addKeyListener(new MyKeyListener());

        background(255);
        pg.background(255);

    }

    public void draw() {

        smooth();
        background(255);


        try {
            if (Variables.finished_hilbert_drawing_for_first_time == true) {

                if (Variables.panel1_has_information == true) {
                    image(Variables.pi1_copy2, 0, 0);
                }

                if (Variables.panel2_has_information == true) {
                    image(Variables.pi2_copy2, 258, 0);
                }

                if (Variables.panel3_has_information == true) {
                    image(Variables.pi3_copy2, 0, 280);
                }

                if (Variables.panel4_has_information == true) {
                    image(Variables.pi4_copy2, 258, 280);
                }

            }
        } catch (Exception e) {
        }




        //crosses
        int xxx = Variables.highlight_hilbert_point_zoomed.X;
        int yyy = Variables.highlight_hilbert_point_zoomed.Y;
        stroke(Variables.cross.R, Variables.cross.G, Variables.cross.B, 120);
        line(0, yyy, 256, yyy);
        line(xxx, 0, xxx, 256);

        line(0, yyy, 256, yyy);
        line(xxx, 0, xxx, 256);

        line(258, yyy, 256 + 258, yyy);
        line(xxx + 258, 0, xxx + 258, 256);

        line(0, yyy + 280, 256, yyy + 280);
        line(xxx, 280, xxx, 280 + 256);

        line(258, yyy + 280, 256 + 258, yyy + 280);
        line(xxx + 258, 280, xxx + 258, 280 + 256);



//frames          
        if (Variables.panel == 1) {
            noFill();
            stroke(255, 0, 0);
            rect(0, 0, 256, 256);
            fill(255, 0, 0);
            text(Variables.panel1_label, 0, 270);

        } else {
            noFill();
            stroke(100, 100, 100, 160);
            rect(0, 0, 256, 256);
            fill(100, 100, 100, 160);
            text(Variables.panel1_label, 0, 270);
        }
        if (Variables.panel == 2) {
            noFill();
            stroke(255, 0, 0);
            rect(258, 0, 256, 256);
            fill(255, 0, 0);
            text(Variables.panel2_label, 258, 270);
        } else {
            noFill();
            stroke(100, 100, 100, 160);
            rect(258, 0, 256, 256);
            fill(100, 100, 100, 160);
            text(Variables.panel2_label, 258, 270);
        }

        if (Variables.panel == 3) {
            noFill();
            stroke(255, 0, 0);
            rect(0, 280, 256, 256);
            fill(255, 0, 0);
            text(Variables.panel3_label, 0, 550);
        } else {
            noFill();
            stroke(100, 100, 100, 160);
            rect(0, 280, 256, 256);
            fill(100, 100, 100, 160);
            text(Variables.panel3_label, 0, 550);
        }

        if (Variables.panel == 4) {
            noFill();
            stroke(255, 0, 0);
            rect(258, 280, 256, 256);
            fill(255, 0, 0);
            text(Variables.panel4_label, 258, 550);
        } else {
            noFill();
            stroke(100, 100, 100, 160);
            rect(258, 280, 256, 256);
            fill(100, 100, 100, 160);
            text(Variables.panel4_label, 258, 550);
        }



        //sample1 
        if (Variables.panel1_has_information == true) {
            if (Variables.panel == 1) {
                if (Variables.visualization_mode_PE_RD == 2 || Variables.visualization_mode_PE_RD == 3) {
                    for (int i = 0; i < Variables.pe_marking_for_first_zoom_level.size(); i++) {
                        Coordinate cc = Variables.pe_marking_for_first_zoom_level.get(i);
                        stroke(0, 0, 0, 150);
                        noFill();
                        if (cc != null) {
                            point(cc.X / 2, cc.Y / 2);
                        }
                    }
                }
            }
        }
        //sample2
        int translation2_x = 258;
        int translation2_y = 0;
        if (Variables.panel2_has_information == true) {
            if (Variables.panel == 2) {
                if (Variables.visualization_mode_PE_RD == 2 || Variables.visualization_mode_PE_RD == 3) {
                    for (int i = 0; i < Variables.pe_marking_for_first_zoom_level.size(); i++) {
                        Coordinate cc = Variables.pe_marking_for_first_zoom_level.get(i);
                        stroke(0, 0, 0, 150);
                        noFill();
                        if (cc != null) {
                            point(cc.X / 2 + translation2_x, cc.Y / 2 + translation2_y);
                        }
                    }
                }
            }
        }


        //sample3
        int translation3_x = 0;
        int translation3_y = 280;
        if (Variables.panel3_has_information == true) {
            if (Variables.panel == 3) {
                if (Variables.visualization_mode_PE_RD == 2 || Variables.visualization_mode_PE_RD == 3) {
                    for (int i = 0; i < Variables.pe_marking_for_first_zoom_level.size(); i++) {
                        Coordinate cc = Variables.pe_marking_for_first_zoom_level.get(i);
                        stroke(0, 0, 0, 150);
                        noFill();
                        if (cc != null) {
                            point(cc.X / 2 + translation3_x, cc.Y / 2 + translation3_y);
                        }
                    }
                }
            }
        }



        //sample4
        int translation4_x = 258;
        int translation4_y = 280;
        if (Variables.panel4_has_information == true) {
            if (Variables.panel == 4) {
                if (Variables.visualization_mode_PE_RD == 2 || Variables.visualization_mode_PE_RD == 3) {
                    for (int i = 0; i < Variables.pe_marking_for_first_zoom_level.size(); i++) {
                        Coordinate cc = Variables.pe_marking_for_first_zoom_level.get(i);
                        stroke(0, 0, 0, 150);
                        noFill();
                        if (cc != null) {
                            point(cc.X / 2 + translation4_x, cc.Y / 2 + translation4_y);
                        }
                    }
                }
            }

        }




    }

    public void mousePressed() {


        if (mouseX > 0 && mouseX < 256 && mouseY > 0 && mouseY < 256) {
            if (Variables.panel1_has_information == true) {
                Variables.panel = 1;
                Grid_Zoom.update();
                if (Variables.pair_ends_enabled == true) {
                    Meander.load_pair_ends(Variables.file_with_pair_ends);
                }
            }
        }

        if (mouseX > 257 && mouseX < (257 + 256) && mouseY > 0 && mouseY < 256) {
            if (Variables.panel2_has_information == true) {
                Variables.panel = 2;
                Grid_Zoom.update();
                if (Variables.pair_ends_enabled == true) {
                    Meander.load_pair_ends(Variables.file_with_pair_ends);
                }
            }
        }

        if (mouseX > 0 && mouseX < 256 && mouseY > 280 && mouseY < (280 + 256)) {
            if (Variables.panel3_has_information == true) {
                Variables.panel = 3;
                Grid_Zoom.update();
                if (Variables.pair_ends_enabled == true) {
                    Meander.load_pair_ends(Variables.file_with_pair_ends);
                }
            }
        }
        if (mouseX > 257 && mouseX < (257 + 256) && mouseY > 280 && mouseY < (280 + 256)) {
            if (Variables.panel4_has_information == true) {
                Variables.panel = 4;
                Grid_Zoom.update();
                if (Variables.pair_ends_enabled == true) {
                    Meander.load_pair_ends(Variables.file_with_pair_ends);

                }
            }
        }


    }
}
