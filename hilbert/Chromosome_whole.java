/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import controlP5.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import processing.core.PApplet;

/**
 *
 * @author gpavlopo
 */
public class Chromosome_whole extends PApplet {

    int width = 260;
    DecimalFormat df = new DecimalFormat("#.##");
    int height = 350;
    int chromosome_thickness = 16;
    int chromosome_position = 100;
    int chromosome_position_bucket_end = 100;
    int chromosome_position_scaled = 0;
    int chromosome_area_start_scaled = 30;
    int chromosome_area_end_scaled = 70;
    int chromosome_minimum = Variables.min_chromosome_position;
    int chromosome_maximum = Variables.max_chromosome_position;
    boolean mouse_released = false;
    boolean pairs_touched = false;
    ControlP5 controlP5;
    Slider s1;
    Range range;
    Slider range_pe;
    Textlabel myTextlabelA;
    Textlabel myTextlabelB;
    Textlabel myTextlabelC;
    Textlabel myTextlabelD;
    Textlabel myTextlabelE;
    Textlabel myTextlabelF;
    Textlabel myTextlabelG;
    Textlabel myTextlabelH;
    Textlabel myTextlabelI;
    Textlabel myTextlabelJ;
    Textlabel myTextlabelK;
    Textlabel myTextlabelL;
    Textlabel myTextlabelM;
    Textlabel myTextlabelN;
    Textlabel myTextlabelO;
    Textlabel myTextlabelP;

    public void setup() {

        smooth();

        size(width, height, P2D);
        background(255, 255, 255, 255);
        this.addKeyListener(new MyKeyListener());
        frameRate(4);

        controlP5 = new ControlP5(this);





        myTextlabelA = controlP5.addTextlabel("labelA", "", 0, 0);
        myTextlabelB = controlP5.addTextlabel("labelB", "", 0, 0);
        myTextlabelC = controlP5.addTextlabel("labelC", "", 0, 0);
        myTextlabelD = controlP5.addTextlabel("labelD", "", 0, 0);
        myTextlabelE = controlP5.addTextlabel("labelE", "", 0, 0);
        myTextlabelF = controlP5.addTextlabel("labelF", "", 0, 0);
        myTextlabelG = controlP5.addTextlabel("labelG", "", 0, 0);
        myTextlabelH = controlP5.addTextlabel("labelH", "", 0, 0);
        myTextlabelI = controlP5.addTextlabel("labelI", "", 0, 0);
        myTextlabelJ = controlP5.addTextlabel("labelJ", "", 0, 0);
        myTextlabelK = controlP5.addTextlabel("labelK", "", 0, 0);
        myTextlabelL = controlP5.addTextlabel("labelL", "", 0, 0);
        myTextlabelM = controlP5.addTextlabel("labelM", "", 0, 0);
        myTextlabelN = controlP5.addTextlabel("labelN", "", 0, 0);
        myTextlabelO = controlP5.addTextlabel("labelO", "", 0, 0);
        myTextlabelP = controlP5.addTextlabel("labelP", "", 0, 0);



        controlP5.addSlider("sliderValue", 0, 500, 0, 0, height / 2 - 30 - 50, width, 50).setId(1);
        s1 = (Slider) controlP5.controller("sliderValue");
        s1.setColorBackground(color(255, 255, 255, 0));
        s1.setColorValueLabel(color(0, 0, 255));
        s1.setColorForeground(color(100, 0, 0, 42));
        s1.setColorActive(color(100, 0, 0, 42));
        s1.setDecimalPrecision(0);

        controlP5.addSlider("rangeController_pe", 1, 100, Variables.pair_end_count_of_cluster, 0, height - 10, width, 10).setId(20);
        range_pe = (Slider) controlP5.controller("rangeController_pe");
        range_pe.setColorBackground(color(255, 255, 255, 0));
        range_pe.setColorValueLabel(color(0, 0, 255));
        range_pe.setValueLabel("#pair-ends/cluster: >" + range_pe.value());
        range_pe.setColorCaptionLabel(color(0, 0, 255));
        range_pe.setColorForeground(color(100, 0, 0, 42));
        range_pe.setColorActive(color(100, 0, 0, 42));
        range_pe.setDecimalPrecision(0);


        controlP5.addRange("rangeController", -5, 5, -5, 5, 0, height - 170, width, 50);
        range = (Range) controlP5.controller("rangeController");
        range.setId(6);
        range.setColorBackground(color(255, 255, 255, 0));
        range.setColorValueLabel(color(255, 255, 255));
        range.setColorCaptionLabel(color(255, 255, 255));
        range.setColorForeground(color(100, 0, 0, 42));
        range.setColorActive(color(100, 0, 0, 42));





        controlP5.draw();
        smooth();


        Variables.position_textfield = controlP5.addTextfield("search by position", 1, height - 87, 100, 20);
        Variables.position_textfield.setId(2);
        Variables.position_textfield.setColorCaptionLabel(color(0, 0, 178));
        Variables.position_textfield.setFocus(true);


        Variables.check_sample_ref_ratio = controlP5.addDropdownList("myList-p1", 112, height - 70, 70, 120);
        Variables.check_sample_ref_ratio.setId(3);
        customize1(Variables.check_sample_ref_ratio);

        Variables.check_variations = controlP5.addDropdownList("myList-p2", 190, height - 70, 70, 120);
        Variables.check_variations.setId(4);
        customize2(Variables.check_variations);



    }//setup()

    void customize1(DropdownList ddl) {
        ddl.setBackgroundColor(color(190));
        ddl.setItemHeight(10);
        ddl.setBarHeight(15);
        ddl.captionLabel().set("coverage");
        ddl.captionLabel().style().marginTop = 3;
        ddl.captionLabel().style().marginLeft = 3;
        ddl.valueLabel().style().marginTop = 3;
        ddl.addItem("sample", 1);
        ddl.addItem("reference", 2);
        ddl.addItem("ratio", 3);
        ddl.setColorBackground(color(60));
        ddl.setColorActive(color(255, 128));
        ddl.actAsPulldownMenu(true);
    }

    void customize2(DropdownList ddl) {
        ddl.setBackgroundColor(color(190));
        ddl.setItemHeight(10);
        ddl.setBarHeight(15);
        ddl.captionLabel().set("variations");
        ddl.captionLabel().style().marginTop = 3;
        ddl.captionLabel().style().marginLeft = 3;
        ddl.valueLabel().style().marginTop = 3;

        ddl.addItem("deletions", 4);
        ddl.addItem("insertions", 5);
        ddl.addItem("inversion", 6);
        ddl.addItem("duplications", 7);
        ddl.addItem("translocations", 8);
        ddl.addItem("all", 9);


        ddl.setColorBackground(color(60));
        ddl.setColorActive(color(255, 128));
        ddl.actAsPulldownMenu(true);
    }

    public void controlEvent(ControlEvent theEvent) {

        pairs_touched = false;
        if (theEvent.isGroup()) {
            Meander.jProgressBar.setValue(0);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();
            Meander.jProgressBar.setVisible(true);
            if (theEvent.group().value() == 1) {
                Variables.sample_enabled = true;
                Variables.ratio_enabled = false;
                Variables.reference_enabled = false;

                Variables.deletions_enabled = false;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = false;
                Hilbert.changeHilbert();

            }
            if (theEvent.group().value() == 2) {
                Variables.sample_enabled = false;
                Variables.ratio_enabled = false;
                Variables.reference_enabled = true;
                Variables.deletions_enabled = false;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = false;
                Hilbert.changeHilbert();
            }
            if (theEvent.group().value() == 3) {
                Variables.sample_enabled = false;
                Variables.ratio_enabled = true;
                Variables.reference_enabled = false;
                Variables.deletions_enabled = false;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = false;
                Hilbert.changeHilbert();
            }
            if (theEvent.group().value() == 4) {

                //System.out.println("deletions");

                Variables.deletions_enabled = true;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = false;
                Variables.variation_enabled = true;
                Meander.load_variations(Variables.file_with_variations);
                if (Variables.variation_enabled == true) {
                    Hilbert.overlay_variations();
                    Hilbert.changeHilbert();
                }
                Variables.variation_enabled = false;


            }
            if (theEvent.group().value() == 5) {
                Variables.deletions_enabled = false;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = true;
                Variables.variation_enabled = true;
                Meander.load_variations(Variables.file_with_variations);
                if (Variables.variation_enabled == true) {
                    Hilbert.overlay_variations();
                    Hilbert.changeHilbert();
                }
                Variables.variation_enabled = false;
            }

            if (theEvent.group().value() == 6) {
                Variables.deletions_enabled = false;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = true;
                Variables.insertions_enabled = false;
                Variables.variation_enabled = true;
                Meander.load_variations(Variables.file_with_variations);
                if (Variables.variation_enabled == true) {
                    Hilbert.overlay_variations();
                    Hilbert.changeHilbert();
                }
                Variables.variation_enabled = false;
            }

            if (theEvent.group().value() == 7) {
                Variables.deletions_enabled = false;
                Variables.duplications_enabled = true;
                Variables.translocations_enabled = false;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = false;
                Variables.variation_enabled = true;
                Meander.load_variations(Variables.file_with_variations);
                if (Variables.variation_enabled == true) {
                    Hilbert.overlay_variations();
                    Hilbert.changeHilbert();
                }
                Variables.variation_enabled = false;
            }

            if (theEvent.group().value() == 8) {
                Variables.deletions_enabled = false;
                Variables.duplications_enabled = false;
                Variables.translocations_enabled = true;
                Variables.inversions_enabled = false;
                Variables.insertions_enabled = false;
                Variables.variation_enabled = true;
                Meander.load_variations(Variables.file_with_variations);
                if (Variables.variation_enabled == true) {
                    Hilbert.overlay_variations();
                    Hilbert.changeHilbert();
                }
                Variables.variation_enabled = false;
            }

            if (theEvent.group().value() == 9) {
                Variables.deletions_enabled = true;
                Variables.duplications_enabled = true;
                Variables.translocations_enabled = true;
                Variables.inversions_enabled = true;
                Variables.insertions_enabled = true;
                Variables.variation_enabled = true;
                Meander.load_variations(Variables.file_with_variations);
                if (Variables.variation_enabled == true) {
                    Hilbert.overlay_variations();
                    Hilbert.changeHilbert();
                }
                Variables.variation_enabled = false;
            }

            if (Variables.reference_enabled == true) {
                Meander.jMenuItemReferenceColor.setVisible(true);
                Meander.jMenuItemSampleColor.setVisible(false);
                Meander.jMenuItemRatioColor.setVisible(false);
            }
            if (Variables.sample_enabled == true) {
                Meander.jMenuItemReferenceColor.setVisible(false);
                Meander.jMenuItemSampleColor.setVisible(true);
                Meander.jMenuItemRatioColor.setVisible(false);
            }
            if (Variables.ratio_enabled == true) {
                Meander.jMenuItemReferenceColor.setVisible(false);
                Meander.jMenuItemSampleColor.setVisible(false);
                Meander.jMenuItemRatioColor.setVisible(true);
            }
        } else if (theEvent.isController()) {






            if (theEvent.controller().id() == 1) { //filter threshold for coverage
                mouse_released = true;

            } else if (theEvent.controller().id() == 2) {//search by position

                boolean go = true;
                if (GenericMethods.isNumber(Variables.position_textfield.valueLabel().toString()) == false) {
                    JOptionPane.showMessageDialog(this, "The text field takes only numerical values");
                    go = false;
                }
                if (GenericMethods.isNumber(Variables.position_textfield.valueLabel().toString()) == true) {
                    int position = (int) Integer.parseInt(Variables.position_textfield.valueLabel().toString());
                    position = Math.abs(position);
                    if (go == true) {
                        Hilbert.search_by_position(position);
                    }
                }
            } else if (theEvent.controller().id() == 6) {//range ratio
                mouse_released = true;
            } else if (theEvent.controller().id() == 20) {//range pair ends
                mouse_released = true;
                pairs_touched = true;
            }



        }


    }//control event function

    public void mouseReleased() {
        if (mouse_released == true) {
            Variables.upper_threshold = (int) s1.value();

            Variables.upper_ratio_threshold = (float) range.highValue();
            Variables.lower_ratio_threshold = (float) range.lowValue();

            Variables.pair_end_count_of_cluster = (int) range_pe.value();
            System.out.println("filter of pair-ends that belong to a clusters is set to: "+ Variables.pair_end_count_of_cluster);

            if (Variables.pair_ends_enabled == true) {
                    Meander.load_pair_ends(Variables.file_with_pair_ends);
                }
            
            
            Variables.finished_pair_end_drawing_for_first_time = false;


            if (pairs_touched == false) {
                Hilbert.changeHilbert();
            }
            mouse_released = false;
        }
    }

    public void draw() {
        smooth();

        if (Variables.finished_hilbert_drawing_for_first_time == true) {
            background(255);
            chromosome_minimum = Variables.min_chromosome_position;
            chromosome_maximum = Variables.max_chromosome_position;
            int chromosome_area_start = Variables.min_chromosome_position_of_the_zoomed_area;
            int chromosome_area_end = Variables.max_chromosome_position_of_the_zoomed_area;


            chromosome_position_scaled = (int) map((int) chromosome_position, chromosome_minimum, chromosome_maximum, 0, width);
            chromosome_area_end_scaled = (int) map((int) chromosome_area_end, chromosome_minimum, chromosome_maximum, 0, width);
            chromosome_area_start_scaled = (int) map((int) chromosome_area_start, chromosome_minimum, chromosome_maximum, 0, width);



//find the linear position
            Coordinate c = new Coordinate(Variables.mouse_x, Variables.mouse_y);
            Pixel pixel = Variables.give_coordinate_get_pixel.get(c.toString());
            if (pixel != null) {
                chromosome_position = pixel.getPosition_range_start();
                chromosome_position_bucket_end = pixel.getPosition_range_end();
            }

//chromosome
            noStroke();
            fill(192, 192, 192);
            rect(0, height / 6 - chromosome_thickness / 2, width, chromosome_thickness);

//line indicating the position
            stroke(255, 0, 0);
            line(chromosome_position_scaled, height / 6 - chromosome_thickness / 2 - 2, chromosome_position_scaled, height / 6 + chromosome_thickness / 2 + 2);


//area indicating the dispayed area

            noStroke();
            fill(0, 0, 180, 80);
            rect(chromosome_area_start_scaled, height / 6 - chromosome_thickness / 2 - 2, chromosome_area_end_scaled - chromosome_area_start_scaled, chromosome_thickness + 4);


//position
            fill(255, 0, 0);
            String ss = GenericMethods.giveNumber_getHumanformat(chromosome_position) + " - " + GenericMethods.giveNumber_getHumanformat(chromosome_position_bucket_end);
            myTextlabelA.setValue(ss);
            myTextlabelA.setColorCaptionLabel(color(255, 0, 0));
            myTextlabelA.setColorValueLabel(color(255, 0, 0));
            myTextlabelA.setPosition(width / 2 - 50, 6);
            stroke(255, 0, 0, 80);
            line(width / 2, 15, chromosome_position_scaled, height / 6 - chromosome_thickness / 2 - 2);


//area of chromosome displayed
//position

            String start = "" + GenericMethods.giveNumber_getHumanformat(chromosome_area_start);
            myTextlabelB.setValue(start);
            myTextlabelB.setColorCaptionLabel(color(0, 0, 180));
            myTextlabelB.setColorValueLabel(color(0, 0, 180));
            myTextlabelB.setPosition(width / 2 - 60, height / 6 + 30);

            String end = "" + GenericMethods.giveNumber_getHumanformat(chromosome_area_end);
            myTextlabelC.setValue(end);
            myTextlabelC.setColorCaptionLabel(color(0, 0, 180));
            myTextlabelC.setColorValueLabel(color(0, 0, 180));
            myTextlabelC.setPosition(width / 2 + 20, height / 6 + 30);

            stroke(0, 0, 180, 80);
            line(chromosome_area_start_scaled, height / 6 + chromosome_thickness / 2 + 2, width / 2 - 60, height / 6 + 30);
            line(chromosome_area_end_scaled, height / 6 + chromosome_thickness / 2 + 2, width / 2 + 28, height / 6 + 28);


//corners - start end
            fill(52, 52, 52);
            String sstart = "" + GenericMethods.giveNumber_getHumanformat(chromosome_minimum);
            String send = "" + GenericMethods.giveNumber_getHumanformat(chromosome_maximum);

            myTextlabelD.setValue(sstart);
            myTextlabelD.setColorCaptionLabel(color(52, 52, 52));
            myTextlabelD.setColorValueLabel(color(52, 52, 52));
            myTextlabelD.setPosition(1, height / 6 - chromosome_thickness / 2 - 12);

            myTextlabelE.setValue(send);
            myTextlabelE.setColorCaptionLabel(color(52, 52, 52));
            myTextlabelE.setColorValueLabel(color(52, 52, 52));
            myTextlabelE.setPosition(width - 70, height / 6 - chromosome_thickness / 2 - 12);




//--------------------------------------------histogram -----------------------------------
            stroke(0, 0, 255, 100);
            line(0, height / 2 - 30, width, height / 2 - 30);
            fill(78, 78, 78);
            String min_cov = "0";
            String max_cov = "500";

            myTextlabelF.setValue(min_cov);
            myTextlabelF.setColorCaptionLabel(color(78, 78, 78));
            myTextlabelF.setColorValueLabel(color(78, 78, 78));
            myTextlabelF.setPosition(1, height / 2 - 35 + 15);


            myTextlabelG.setValue(max_cov);
            myTextlabelG.setColorCaptionLabel(color(78, 78, 78));
            myTextlabelG.setColorValueLabel(color(78, 78, 78));
            myTextlabelG.setPosition(240, height / 2 - 35 + 15);




            if (Variables.pair_ends_enabled == true) {

                //draw PE histogram              
                stroke(0, 127, 32);
                line(0, height - 10, 260, height - 10);
                noFill();
                beginShape();
                for (int i = 0; i < Variables.PE_histogram.size(); i++) {

                    int pick = Variables.PE_histogram.get(i);
                    int y = (int) map((int) pick, 0, Variables.PE_histogram_max_value, 0, 30);//0-50 to show the picks
                    vertex(i, height - 10 - y);
                }
                endShape();
            }
            float index_distance = map((float) Variables.pair_end_count_of_cluster, (float) 0.0, (float) Variables.PE_max_value, (float) 0.0, (float) 259.0);

            int pickk = Variables.pair_end_count_of_cluster;
            stroke(255, 0, 0, 150);
            line(index_distance, height - 10, index_distance, height - 50);



            //---------------------histogram  sample           

            if (Variables.sample_values_exist == true) {

//draw coverage sample                
                stroke(0, 127, 32);
                noFill();
                beginShape();

                if (Variables.panel == 1) {
                    for (int i = 0; i < Variables.sample_histogram1.size(); i++) {
                        int pick = Variables.sample_histogram1.get(i);
                        int y = (int) map((int) pick, 0, Variables.sample_histogram_max_value1, 0, 50);//0-50 to show the picks
                        vertex(i, height / 2 - 30 - y);
                    }
                }


                if (Variables.panel == 2) {
                    for (int i = 0; i < Variables.sample_histogram2.size(); i++) {
                        int pick = Variables.sample_histogram2.get(i);
                        int y = (int) map((int) pick, 0, Variables.sample_histogram_max_value2, 0, 50);//0-50 to show the picks
                        vertex(i, height / 2 - 30 - y);
                    }
                }


                if (Variables.panel == 3) {
                    for (int i = 0; i < Variables.sample_histogram3.size(); i++) {
                        int pick = Variables.sample_histogram3.get(i);
                        int y = (int) map((int) pick, 0, Variables.sample_histogram_max_value3, 0, 50);//0-50 to show the picks
                        vertex(i, height / 2 - 30 - y);
                    }
                }


                if (Variables.panel == 4) {
                    for (int i = 0; i < Variables.sample_histogram4.size(); i++) {
                        int pick = Variables.sample_histogram4.get(i);
                        int y = (int) map((int) pick, 0, Variables.sample_histogram_max_value4, 0, 50);//0-50 to show the picks
                        vertex(i, height / 2 - 30 - y);
                    }
                }
                endShape();



//dynamic lines
                stroke(0, 127, 32, 120);
                Coordinate ccc = new Coordinate(Variables.mouse_x, Variables.mouse_y);
                Pixel p = Variables.give_coordinate_get_pixel.get(c.toString());
                if (pixel != null) {
                    float index_sample = 0;
                    if(Variables.panel==1)
                    index_sample=map((float) Math.min(pixel.getCoverage_sample1(), 500), (float) Variables.min_read_sample1, 500, (float) 0.0, (float) 259.0);
                    if(Variables.panel==2)
                    index_sample=map((float) Math.min(pixel.getCoverage_sample2(), 500), (float) Variables.min_read_sample2, 500, (float) 0.0, (float) 259.0);
                    if(Variables.panel==3)
                    index_sample=map((float) Math.min(pixel.getCoverage_sample3(), 500), (float) Variables.min_read_sample3, 500, (float) 0.0, (float) 259.0);
                    if(Variables.panel==4)
                    index_sample=map((float) Math.min(pixel.getCoverage_sample4(), 500), (float) Variables.min_read_sample4, 500, (float) 0.0, (float) 259.0);
                    
                    int ind_s = (int) index_sample;
                    strokeWeight(1.5f);
                    line(ind_s, height / 2 - 30 - 50, ind_s, height / 2 - 30);
                    String cov = "S:"; 
                    if(Variables.panel==1)
                    cov = "S:" + GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_sample1());
                     if(Variables.panel==2)
                    cov = "S:" + GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_sample2());
                     if(Variables.panel==3)
                    cov = "S:" + GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_sample3());
                     if(Variables.panel==4)
                    cov = "S:" + GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_sample4());
                    
                    line(ind_s, height / 2 - 30, 200, height / 2 - 30 + 20);

                    myTextlabelH.setValue(cov);
                    myTextlabelH.setColorCaptionLabel(color(0, 127, 32));
                    myTextlabelH.setColorValueLabel(color(0, 127, 32));
                    myTextlabelH.setPosition(200, height / 2 - 30 + 21);
                }
            }

            //---------------------histogram  reference  

            if (Variables.reference_values_exist == true) {
//coverage reference
                stroke(0, 0, 178);
                noFill();
                beginShape();
                if(Variables.panel==1){
                for (int i = 0; i < Variables.reference_histogram1.size(); i++) {
                    int pick = Variables.reference_histogram1.get(i);
                    int y = (int) map((int) pick, 0, Variables.reference_histogram_max_value1, 0, 50);//0-50 to show the picks
                    vertex(i, height / 2 - 30 - y);
                }
                }
                
                
                if(Variables.panel==2){
                for (int i = 0; i < Variables.reference_histogram2.size(); i++) {
                    int pick = Variables.reference_histogram2.get(i);
                    int y = (int) map((int) pick, 0, Variables.reference_histogram_max_value2, 0, 50);//0-50 to show the picks
                    vertex(i, height / 2 - 30 - y);
                }
                }
                
                
                if(Variables.panel==3){
                for (int i = 0; i < Variables.reference_histogram3.size(); i++) {
                    int pick = Variables.reference_histogram3.get(i);
                    int y = (int) map((int) pick, 0, Variables.reference_histogram_max_value3, 0, 50);//0-50 to show the picks
                    vertex(i, height / 2 - 30 - y);
                }
                }
                
                if(Variables.panel==4){
                for (int i = 0; i < Variables.reference_histogram4.size(); i++) {
                    int pick = Variables.reference_histogram4.get(i);
                    int y = (int) map((int) pick, 0, Variables.reference_histogram_max_value4, 0, 50);//0-50 to show the picks
                    vertex(i, height / 2 - 30 - y);
                }
                }
                endShape();



//dynamic lines
                stroke(0, 0, 178, 120);
                Coordinate ccc = new Coordinate(Variables.mouse_x, Variables.mouse_y);
                Pixel p = Variables.give_coordinate_get_pixel.get(c.toString());
                if (pixel != null) {
                    float index_reference = 0;
                    if(Variables.panel==1)
                    index_reference = map((float) Math.min(pixel.getCoverage_reference(), 500), (float) Variables.min_read_sample1, 500, (float) 0.0, (float) 259.0);
                    if(Variables.panel==2)
                    index_reference = map((float) Math.min(pixel.getCoverage_reference(), 500), (float) Variables.min_read_sample2, 500, (float) 0.0, (float) 259.0);
                    if(Variables.panel==3)
                    index_reference = map((float) Math.min(pixel.getCoverage_reference(), 500), (float) Variables.min_read_sample3, 500, (float) 0.0, (float) 259.0);
                    if(Variables.panel==4)
                    index_reference = map((float) Math.min(pixel.getCoverage_reference(), 500), (float) Variables.min_read_sample4, 500, (float) 0.0, (float) 259.0);
                    
                    int ind_s = (int) index_reference;
                    strokeWeight(1.5f);
                    line(ind_s, height / 2 - 30 - 50, ind_s, height / 2 - 30);
                    String cov = "R:" + GenericMethods.giveNumber_getHumanformat(pixel.getCoverage_reference());
                    line(ind_s, height / 2 - 30, 20, height / 2 - 30 + 20);

                    myTextlabelI.setValue(cov);
                    myTextlabelI.setColorCaptionLabel(color(0, 0, 178));
                    myTextlabelI.setColorValueLabel(color(0, 0, 178));
                    myTextlabelI.setPosition(20, height / 2 - 30 + 21);
                }
            }


//-----------------------histogram ratio----------------            


            stroke(0, 0, 255, 100);
            myTextlabelK.setValue("-5.0");
            myTextlabelK.setColorCaptionLabel(color(78, 78, 78));
            myTextlabelK.setColorValueLabel(color(78, 78, 78));
            myTextlabelK.setPosition(1, height - 115);

            myTextlabelM.setValue("0.0");
            myTextlabelM.setColorCaptionLabel(color(78, 78, 78));
            myTextlabelM.setColorValueLabel(color(78, 78, 78));
            myTextlabelM.setPosition(width / 2 - 8, height - 115);


            myTextlabelL.setValue("5.0");
            myTextlabelL.setColorCaptionLabel(color(78, 78, 78));
            myTextlabelL.setColorValueLabel(color(78, 78, 78));
            myTextlabelL.setPosition(240, height - 115);


            stroke(0, 0, 255);
            line(0, height - 120, width, height - 120);

            if (Variables.ratio_values_exist == true) {
//coverage reference

                noFill();
                beginShape();
                if(Variables.panel==1){
                for (int i = 0; i < Variables.ratio_histogram1.size(); i++) {
                    int pick = Variables.ratio_histogram1.get(i);
                    int y = (int) map((int) pick, 0, Variables.ratio_histogram_max_value1, 0, 50);//0-50 to show the picks
                    vertex(i, height - y - 120);
                }
                }
                if(Variables.panel==2){
                for (int i = 0; i < Variables.ratio_histogram2.size(); i++) {
                    int pick = Variables.ratio_histogram2.get(i);
                    int y = (int) map((int) pick, 0, Variables.ratio_histogram_max_value2, 0, 50);//0-50 to show the picks
                    vertex(i, height - y - 120);
                }
                }
                if(Variables.panel==3){
                for (int i = 0; i < Variables.ratio_histogram3.size(); i++) {
                    int pick = Variables.ratio_histogram3.get(i);
                    int y = (int) map((int) pick, 0, Variables.ratio_histogram_max_value3, 0, 50);//0-50 to show the picks
                    vertex(i, height - y - 120);
                }
                }
                if(Variables.panel==4){
                for (int i = 0; i < Variables.ratio_histogram4.size(); i++) {
                    int pick = Variables.ratio_histogram4.get(i);
                    int y = (int) map((int) pick, 0, Variables.ratio_histogram_max_value4, 0, 50);//0-50 to show the picks
                    vertex(i, height - y - 120);
                }
                }
                endShape();



//dynamic lines
                stroke(0, 0, 255, 120);
                Coordinate ccc = new Coordinate(Variables.mouse_x, Variables.mouse_y);
                Pixel p = Variables.give_coordinate_get_pixel.get(c.toString());
                if (pixel != null) {
                    float index_ratio = 0;
                    if(Variables.panel==1)
                    index_ratio=map((float) pixel.getRatio1(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);
                    if(Variables.panel==2)
                    index_ratio=map((float) pixel.getRatio2(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);
                    if(Variables.panel==3)
                    index_ratio=map((float) pixel.getRatio3(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);
                    if(Variables.panel==4)
                    index_ratio=map((float) pixel.getRatio4(), (float) -5.0, (float) 5.0, (float) 0.0, (float) 259.0);
                    
                    int ind_r = (int) index_ratio;
                    strokeWeight(1.5f);
                    line(ind_r, height - 120 - 50, ind_r, height - 120 + 10);
                    line(ind_r, height - 120 + 10, 105, height - 102);

                }
            }


            String high = df.format(range.highValue());
            String low = df.format(range.lowValue());
            if (range.highValue() == 0) {
                high = "0.0";
            }
            if (range.highValue() == 1) {
                high = "1.0";
            }
            if (range.highValue() == 2) {
                high = "2.0";
            }
            if (range.highValue() == 3) {
                high = "3.0";
            }
            if (range.highValue() == 4) {
                high = "4.0";
            }
            if (range.highValue() == 5) {
                high = "5.0";
            }
            if (range.lowValue() == 0) {
                low = "0.0";
            }
            if (range.lowValue() == 1) {
                low = "1.0";
            }
            if (range.lowValue() == 2) {
                low = "2.0";
            }
            if (range.lowValue() == 3) {
                high = "3.0";
            }
            if (range.lowValue() == 4) {
                high = "4.0";
            }
            if (range.lowValue() == 5) {
                high = "5.0";
            }
            myTextlabelN.setValue(high);
            myTextlabelN.setColorCaptionLabel(color(0, 0, 255));
            myTextlabelN.setColorValueLabel(color(0, 0, 255));
            myTextlabelN.setPosition(240, height - 138);

            myTextlabelO.setValue(low);
            myTextlabelO.setColorCaptionLabel(color(0, 0, 255));
            myTextlabelO.setColorValueLabel(color(0, 0, 255));
            myTextlabelO.setPosition(0, height - 138);

//           
            myTextlabelP.setValue("#pair-ends/cluster: >" + (int) range_pe.value());
            myTextlabelP.setColorCaptionLabel(color(0, 0, 255));
            myTextlabelP.setColorValueLabel(color(0, 0, 255));
            myTextlabelP.setPosition(80, height - 8);



            // arcs for pair-ends

//
            strokeWeight(1);
            if (Variables.pair_ends_enabled == true && Variables.pair_end_list_to_highlight_initial != null) {
                if (Variables.pair_end_list_to_highlight_initial.size() > 0) {
                    try {

                        float pair_source_scaled;
                        float pair_dest_scaled;
                        noFill();
                        for (int i = 0; i < Variables.pair_end_list_to_highlight_initial.size(); i++) {
                            if (Variables.pair_end_list_to_highlight_initial.get(i).chromosome_from.compareTo(Variables.chromosome) == 0 && Variables.pair_end_list_to_highlight_initial.get(i).chromosome_to.compareTo(Variables.chromosome) == 0) {

                                //System.out.println(Variables.pair_end_list_to_highlight_initial.get(i).toString());
                                pair_source_scaled = (int) map((float) Variables.pair_end_list_to_highlight_initial.get(i).from_PE1, (float) Variables.min_chromosome_position, (float) Variables.max_chromosome_position, (float) 0, (float) width);
                                pair_dest_scaled = (int) map((float) Variables.pair_end_list_to_highlight_initial.get(i).from_PE2, (float) Variables.min_chromosome_position, (float) Variables.max_chromosome_position, (float) 0, (float) width);

                                int height_point = 2;
                                int y = height / 6 - chromosome_thickness / 2;
                                //

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


                                if (Variables.deletions_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("deletion") == 0) {
                                    bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                }
//                            
                                if (Variables.insertions_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("insertion") == 0) {
                                    bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                }
//                            
                                if (Variables.inversions_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("inversion") == 0) {
                                    bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                }
//                            
                                if (Variables.translocations_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("translocation") == 0) {
                                    bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                }
//                            
                                if (Variables.duplications_enabled == true && Variables.pair_end_list_to_highlight_initial.get(i).variation_type.compareToIgnoreCase("duplication") == 0) {
                                    bezier(pair_source_scaled, y, pair_source_scaled, height_point, pair_dest_scaled, height_point, pair_dest_scaled, y);
                                }
//                            


//                              line(pair_source_scaled, y, pair_source_scaled, 2);
//                              line(pair_dest_scaled, y, pair_dest_scaled, 2);

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }


//ratio label
            stroke(52, 52, 52);
            if (Variables.sample_values_exist == true && Variables.reference_values_exist == true) {
                Coordinate ccc = new Coordinate(Variables.mouse_x, Variables.mouse_y);
                Pixel p = Variables.give_coordinate_get_pixel.get(c.toString());
                if (pixel != null) {

                    String cov = "";
                    if (Variables.panel == 1) {
                        cov = "Ratio:" + (pixel.getRatio_String1());
                    }
                    if (Variables.panel == 2) {
                        cov = "Ratio:" + (pixel.getRatio_String2());
                    }
                    if (Variables.panel == 3) {
                        cov = "Ratio:" + (pixel.getRatio_String3());
                    }
                    if (Variables.panel == 4) {
                        cov = "Ratio:" + (pixel.getRatio_String4());
                    }

                    myTextlabelJ.setValue(cov);
                    myTextlabelJ.setColorCaptionLabel(color(52, 52, 52));
                    myTextlabelJ.setColorValueLabel(color(52, 52, 52));
                    myTextlabelJ.setPosition(100, height - 100);
                }
            }



            s1.setColorBackground(color(255, 255, 255, 0));



            controlP5.draw();


        }//finished drawing




    }
}
