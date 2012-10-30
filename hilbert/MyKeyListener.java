/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author gpavlopo
 */
public class MyKeyListener extends KeyAdapter {

    private static int x = 0;
    private static int y = 0;
    private static int start_x = 0;
    private static int start_y = 0;
    private static int dist = 0;
    private static int edges = 0;
    public static boolean switcher = false;

    public MyKeyListener() {
    }

    public static void overlay_hibert(int fold_level) {
        x = 0;
        y = 0;
        start_x = 0;
        start_y = 0;
        dist = 0;
        edges = 0;
        Variables.overlaid_hilbert.clear();
        edges = (int) Math.pow(4, Variables.fold_level);
        //System.out.println("edges=" + edges + "\t" + "pixels:" + (Variables.dimension * Variables.dimension));


        dist = Variables.dimension;
        for (int i = fold_level; i > 0; i--) {
            dist /= 2;
        }
        x = dist / 2;
        y = dist / 2;
        start_x = x;
        start_y = y;
        Coordinate coor = new Coordinate(start_x, start_y);
        Variables.overlaid_hilbert.add(coor);
        HilbertB(fold_level);
    }

    private static void deplacement(int vx, int vy) {

        int ax = x;
        int ay = y;
        x = x + vx;
        y = y + vy;
        Coordinate coor = new Coordinate(x, y);
        Variables.overlaid_hilbert.add(coor);


    }

    private static void HilbertA(int level) {
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

    private static void HilbertB(int level) {


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

    private static void HilbertC(int level) {
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

    private static void HilbertD(int level) {
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

    public void keyPressed(KeyEvent e) {

        if ((e.getKeyCode() == KeyEvent.VK_1) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(1);
        }
        if ((e.getKeyCode() == KeyEvent.VK_2) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(2);
        }
        if ((e.getKeyCode() == KeyEvent.VK_3) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(3);
        }
        if ((e.getKeyCode() == KeyEvent.VK_4) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(4);
        }
        if ((e.getKeyCode() == KeyEvent.VK_5) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(5);
        }
        if ((e.getKeyCode() == KeyEvent.VK_6) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(6);
        }
        if ((e.getKeyCode() == KeyEvent.VK_7) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            overlay_hibert(7);
        }
        if ((e.getKeyCode() == KeyEvent.VK_0)) {
            Variables.overlaid_hilbert.clear();
        }



        //-------------------------------------
        if ((e.getKeyCode() == KeyEvent.VK_U) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            Coordinate coor = new Coordinate(Variables.mouse_x, Variables.mouse_y);
            Pixel pix = Variables.give_coordinate_get_pixel.get(coor.toString());
            if (pix != null) {
                String URL = "";
                if (Variables.organism.compareToIgnoreCase("human") == 0) {
                    URL = "http://genome.ucsc.edu/cgi-bin/hgTracks?hgHubConnect.destUrl=..%2Fcgi-bin%2FhgTracks&clade=CLADE&org=ORGANISM&db=hg19&position=chrCHROMOSOME%3ASTART-END&hgt.suggest=&hgt.suggestTrack=knownGene&Submit=submit&hgsid=282183561";
                    URL = URL.replace("ORGANISM", "Humman");
                    URL = URL.replace("CLADE", "mammal");
                }

                if (Variables.organism.compareToIgnoreCase("rat") == 0) {
                    URL = "http://genome.ucsc.edu/cgi-bin/hgTracks?hgHubConnect.destUrl=..%2Fcgi-bin%2FhgTracks&clade=CLADE&org=ORGANISM&db=rn5&position=chrCHROMOSOME%3ASTART-END&hgt.suggest=&hgt.suggestTrack=refGene&Submit=submit&hgsid=282867033";
                    URL = URL.replace("ORGANISM", "Rat");
                    URL = URL.replace("CLADE", "mammal");
                }


                if (Variables.organism.compareToIgnoreCase("Mouse") == 0) {
                    URL = "http://genome.ucsc.edu/cgi-bin/hgTracks?hgHubConnect.destUrl=..%2Fcgi-bin%2FhgTracks&clade=CLADE&org=ORGANISM&db=mm10&position=chrCHROMOSOME%3ASTART-END&hgt.suggest=&hgt.suggestTrack=refGene&Submit=submit&hgsid=282867033";
                    URL = URL.replace("ORGANISM", "Mouse");
                    URL = URL.replace("CLADE", "mammal");
                }

                if (Variables.organism.compareToIgnoreCase("chimp") == 0) {
                    URL = "http://genome.ucsc.edu/cgi-bin/hgTracks?hgHubConnect.destUrl=..%2Fcgi-bin%2FhgTracks&clade=CLADE&org=ORGANISM&db=panTro3&position=chrCHROMOSOME%3ASTART-END&hgt.suggest=&hgt.suggestTrack=refGene&Submit=submit&hgsid=282867033";
                    URL = URL.replace("ORGANISM", "Chimp");
                    URL = URL.replace("CLADE", "mammal");
                }

                if (Variables.organism.compareToIgnoreCase("arabidopsis") == 0) {
                    URL = "http://epigenomics.mcdb.ucla.edu/cgi-bin/hgTracks?clade=plant&org=A.+thaliana&db=araTha1&position=chrCHROMOSOME%3ASTART-END&pix=1000&hgsid=25975&Submit=submit";

                }

                if (Variables.organism.compareToIgnoreCase("zebra") == 0 || Variables.organism.compareToIgnoreCase("zebrafish") == 0) {
                    URL = "http://genome.ucsc.edu/cgi-bin/hgTracks?hgHubConnect.destUrl=..%2Fcgi-bin%2FhgTracks&clade=vertebrate&org=Zebrafish&db=danRer7&position=chrCHROMOSOME%3ASTART-END&hgt.suggest=&hgt.suggestTrack=refGene&Submit=submit&hgsid=282867033";

                }

                if (Variables.organism.compareToIgnoreCase("drosophila") == 0) {
                    URL = "http://genome.ucsc.edu/cgi-bin/hgTracks?hgHubConnect.destUrl=..%2Fcgi-bin%2FhgTracks&clade=insect&org=D.+melanogaster&db=dm3&position=chrCHROMOSOME%3ASTART-END&hgt.suggest=&hgt.suggestTrack=refGene&Submit=submit&hgsid=282867033";

                }


                URL = URL.replace("CHROMOSOME", "" + Variables.chromosome);
                URL = URL.replace("START", "" + pix.getPosition_range_start());
                URL = URL.replace("END", "" + pix.getPosition_range_end());
                Browser.openURL(URL);
            }
        }

        //-------------------------------------

        if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if (Variables.zoom == 1) {
                Grid_Zoom.replace_image();
            } else {
                JOptionPane.showMessageDialog(null, "Zoom x1 should be selected");
            }
        }
        //-------------------------------------
        if ((e.getKeyCode() == KeyEvent.VK_W) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            String aboutText = "<html><center><h2>Web site:</h2><br>"
                    + "<a href=\"https://sites.google.com/site/meanderviz/\">https://sites.google.com/site/meanderviz/</a>"
                    + " </center></html>";

            JOptionPane.showMessageDialog(null, aboutText);
        }
        //-------------------------------------

        if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            String aboutText = "<html><center><h2>Meander 1.0</h2><br>"
                    + "<center><br>Georgios Pavlopoulos<br>georgios.pavlopoulos@esat.kuleuven.be"
                    + "<p></center>"
                    + "<p><center>Jan Aerts<br>jan.aerts@esat.kuleuven.be<br>"
                    + "<p><p><center><b>Katholieke Universiteit Leuven<BR> KU.Leuven Belgium<br></b>"
                    + " </center></html>";

            JOptionPane.showMessageDialog(null, aboutText);
        }

        //-------------------------------------

        if ((e.getKeyCode() == KeyEvent.VK_P) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            FileFilter filter = new FileNameExtensionFilter("Meander file", "meander", "MEANDER", "Meander");

            JFileChooser jFileChooser1 = new JFileChooser(new File("."));
            jFileChooser1.addChoosableFileFilter(filter);
            int returnVal = jFileChooser1.showOpenDialog((Component) e.getSource());
            if (returnVal == jFileChooser1.APPROVE_OPTION) {

                Variables.file_with_pair_ends = jFileChooser1.getSelectedFile().getAbsolutePath();

                if (!Variables.file_with_pair_ends.endsWith(".meander")) {
                    JOptionPane.showMessageDialog(null, "file with .meander extension could not be found");
                } else {
                    Meander.load_pair_ends(Variables.file_with_pair_ends);
                    JOptionPane.showMessageDialog(null, Variables.file_with_pair_ends + " loaded");

                    Variables.pair_ends_enabled = true;


                }

                System.out.println("Loaded:" + Variables.file_with_pair_ends);
            }
        }
        //-------------------------------------
        if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            JFileChooser jFileChooser1 = new JFileChooser(new File("."));
            int returnVal = jFileChooser1.showOpenDialog((Component) e.getSource());
            if (returnVal == jFileChooser1.APPROVE_OPTION) {

                Variables.file_with_variations = jFileChooser1.getSelectedFile().getAbsolutePath();

                if (!Variables.file_with_variations.endsWith(".meander")) {
                    JOptionPane.showMessageDialog(null, "file with .meander extension could not be found");
                } else {
                    Meander.load_variations(Variables.file_with_variations);
                    JOptionPane.showMessageDialog(null, Variables.file_with_variations + " loaded");

                    Variables.variation_enabled = true;


                }
            }
        }
        //-------------------------------------



        if ((e.getKeyCode() == KeyEvent.VK_R) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            Meander.jProgressBar.setVisible(true);
            Meander.jProgressBar.setValue(0);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();


            Variables.check_sample_ref_ratio.setLabel("ratio");


            Meander.jMenuItemRatioColor.setVisible(true);
            Meander.jMenuItemSampleColor.setVisible(false);
            Meander.jMenuItemReferenceColor.setVisible(false);
            Meander.jMenuItemRatioColor.setVisible(true);

            Variables.ratio_enabled = true;
            Variables.sample_enabled = false;
            Variables.reference_enabled = false;


            Variables.deletions_enabled = false;
            Variables.duplications_enabled = false;

            Hilbert.changeHilbert();
            Chromosome_zoomed.update_diagram();
            Variables.finished_hilbert_drawing_for_first_time = true;

        }
        //-------------------------------------



        if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            Meander.jProgressBar.setVisible(true);
            Meander.jProgressBar.setValue(0);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();


            Variables.check_sample_ref_ratio.setLabel("sample");

            Meander.jMenuItemRatioColor.setVisible(false);
            Meander.jMenuItemSampleColor.setVisible(true);
            Meander.jMenuItemReferenceColor.setVisible(false);

            Variables.ratio_enabled = false;
            Variables.sample_enabled = true;
            Variables.reference_enabled = false;

            Meander.jMenuItemSampleColor.setVisible(true);


            Variables.deletions_enabled = false;
            Variables.duplications_enabled = false;

            Hilbert.changeHilbert();
            Chromosome_zoomed.update_diagram();
            Variables.finished_hilbert_drawing_for_first_time = true;

        }
        //-------------------------------------

        if ((e.getKeyCode() == KeyEvent.VK_L) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            Variables.enable_pair_end_lines = !Variables.enable_pair_end_lines;
        }

//-------------------------------------
        if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            switcher = !switcher;

            circles(switcher);

        }

        //-------------------------------------
        if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
            Variables.visualization_mode_PE_RD++;
            if (Variables.visualization_mode_PE_RD == 4) {
                Variables.visualization_mode_PE_RD = 1;
            }
        }



        if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            Meander.jProgressBar.setVisible(true);
            Meander.jProgressBar.setValue(0);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();


            Variables.check_sample_ref_ratio.setLabel("reference");

            SliderColorRatio.scaleSlider_Ratio.setEnabled(false);
            SliderColorSample.scaleSlider_Sample.setEnabled(false);
            SliderColorReference.scaleSlider_Reference.setEnabled(true);

            Meander.jMenuItemRatioColor.setVisible(false);
            Meander.jMenuItemSampleColor.setVisible(false);
            Meander.jMenuItemReferenceColor.setVisible(true);

            Variables.ratio_enabled = false;
            Variables.sample_enabled = false;
            Variables.reference_enabled = true;
            Meander.jMenuItemReferenceColor.setVisible(true);


            Variables.deletions_enabled = false;
            Variables.duplications_enabled = false;

            Hilbert.changeHilbert();
            Chromosome_zoomed.update_diagram();
            Variables.finished_hilbert_drawing_for_first_time = true;

        }
        //-------------------------------------


        if ((e.getKeyCode() == KeyEvent.VK_F) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            boolean go = true;
            if (GenericMethods.isNumber(Variables.position_textfield.valueLabel().toString()) == false) {
                JOptionPane.showMessageDialog(null, "The text field takes only numerical values");

                go = false;
            }
            if (GenericMethods.isNumber(Variables.position_textfield.valueLabel().toString()) == true) {
                int position = (int) Integer.parseInt(Variables.position_textfield.valueLabel().toString());
                position = Math.abs(position);
                if (go == true) {
                    Hilbert.search_by_position(position);
                }
            }
        }





        //-------------------------------------

        if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {

            Variables.interchromosomal = !Variables.interchromosomal;
            if (Variables.interchromosomal) {
                JOptionPane.showMessageDialog(null, "Interchromosomal Variations Enabled", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Interchromosomal Variations Disabled", "", JOptionPane.INFORMATION_MESSAGE);
            }



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

    }

    public static void circles(boolean switcher) {

        int counter_positive = 1;
        int counter_negative = 1;
        double positive_ratio = 0;
        double negative_ratio = 0;
        ArrayList<DoubleEvidence> circles = new ArrayList();
        Variables.circles.clear();
        if (switcher == true) {

            for (int i = 0; i < Variables.pixels.size(); i++) {
                double ratio = 0;
                if (Variables.panel == 1) {
                    ratio = Variables.pixels.get(i).getRatio1();
                }
                if (Variables.panel == 2) {
                    ratio = Variables.pixels.get(i).getRatio2();
                }
                if (Variables.panel == 3) {
                    ratio = Variables.pixels.get(i).getRatio3();
                }
                if (Variables.panel == 4) {
                    ratio = Variables.pixels.get(i).getRatio4();
                }
                if (ratio > 0) {
                    positive_ratio += ratio;
                    counter_positive++;
                }
                if (ratio < 0) {
                    negative_ratio += Math.abs(ratio);
                    counter_negative++;
                }
            }
            positive_ratio = positive_ratio / counter_positive;
            negative_ratio = negative_ratio / counter_negative;

//                System.out.println("positive_ratio:" + positive_ratio);
//                System.out.println("negative_ratio:" + negative_ratio);



            for (int i = 0; i < Variables.pair_end_list.size(); i++) {
                PairEnd pe = Variables.pair_end_list.get(i);
                if (pe.chromosome_from.compareToIgnoreCase(Variables.chromosome) == 0 && pe.chromosome_to.compareToIgnoreCase(Variables.chromosome) == 0) {


                    Interval interval_x = new Interval(pe.from_PE1, pe.to_PE1, null);
                    Interval interval_y = new Interval(pe.from_PE2, pe.to_PE2, null);

                    for (Interval x : Variables.searchTree_pair_ends.searchAll_intersections(interval_x)) {
                        if (x != null) {
                            for (Interval y : Variables.searchTree_pair_ends.searchAll_intersections(interval_y)) {
                                if (y != null) {
                                    pe.source = x.pix;
                                    pe.dest = y.pix;

                                    if (pe.source != null && pe.dest != null && pe.source.getZoom_level() == Variables.zoom && pe.dest.getZoom_level() == Variables.zoom) {

                                        int distance = Math.abs(pe.from_PE1 - pe.from_PE2);
                                        if (distance >= Variables.pair_end_minimum_distance_threshold && distance <= Variables.pair_end_maximum_distance_threshold) {


                                            double positive_average_signal_of_region = 0;
                                            double negative_average_signal_of_region = 0;
                                            counter_positive = 1;
                                            counter_negative = 1;
                                            ArrayList<Coordinate> intermediate_pixels = give_itermediate_pixels_between_points(pe.source.getCoordinate_hilbert(), pe.dest.getCoordinate_hilbert());

                                            for (int k = 0; k < intermediate_pixels.size(); k++) {
                                                Coordinate coor = intermediate_pixels.get(k);
                                                Pixel pix = Variables.give_coordinate_get_pixel.get(coor.toString());
                                                if (pix != null) {

                                                    if (Variables.panel == 1) {
                                                        if (pix.getRatio1() > 0) {
                                                            positive_average_signal_of_region += pix.getRatio1();
                                                            counter_positive++;
                                                        }
                                                        if (pix.getRatio1() < 0) {
                                                            negative_average_signal_of_region += Math.abs(pix.getRatio1());
                                                            counter_negative++;
                                                        }
                                                    }


                                                    if (Variables.panel == 2) {
                                                        if (pix.getRatio2() > 0) {
                                                            positive_average_signal_of_region += pix.getRatio2();
                                                            counter_positive++;
                                                        }
                                                        if (pix.getRatio2() < 0) {
                                                            negative_average_signal_of_region += Math.abs(pix.getRatio2());
                                                            counter_negative++;
                                                        }
                                                    }



                                                    if (Variables.panel == 3) {
                                                        if (pix.getRatio3() > 0) {
                                                            positive_average_signal_of_region += pix.getRatio3();
                                                            counter_positive++;
                                                        }
                                                        if (pix.getRatio3() < 0) {
                                                            negative_average_signal_of_region += Math.abs(pix.getRatio3());
                                                            counter_negative++;
                                                        }
                                                    }


                                                    if (Variables.panel == 4) {
                                                        if (pix.getRatio4() > 0) {
                                                            positive_average_signal_of_region += pix.getRatio4();
                                                            counter_positive++;
                                                        }
                                                        if (pix.getRatio4() < 0) {
                                                            negative_average_signal_of_region += Math.abs(pix.getRatio4());
                                                            counter_negative++;
                                                        }
                                                    }

                                                }

                                            }


                                            positive_average_signal_of_region = positive_average_signal_of_region / counter_positive;
                                            negative_average_signal_of_region = negative_average_signal_of_region / counter_negative;
//                                            System.out.println("positive_average_signal_of_region:" + positive_average_signal_of_region);
//                                            System.out.println("negative_average_signal_of_region:" + negative_average_signal_of_region);
                                            if (positive_average_signal_of_region > positive_ratio + 0.05f || negative_average_signal_of_region > positive_ratio + 0.05f) {
                                                DoubleEvidence de = new DoubleEvidence();
                                                de.setX((pe.source.getCoordinate_hilbert().X + pe.dest.getCoordinate_hilbert().X) / 2);
                                                de.setY((pe.source.getCoordinate_hilbert().Y + pe.dest.getCoordinate_hilbert().Y) / 2);
                                                de.setRadius(Math.sqrt(Math.pow((pe.source.getCoordinate_hilbert().X - pe.dest.getCoordinate_hilbert().X), 2) + Math.pow((pe.source.getCoordinate_hilbert().Y - pe.dest.getCoordinate_hilbert().Y), 2)));
                                                circles.add(de);
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }

            }
        }


        for (int i = 0; i < circles.size(); i++) {
            boolean place = true;
            for (int j = i + 1; j < circles.size(); j++) {

                DoubleEvidence de1 = circles.get(i);
                DoubleEvidence de2 = circles.get(j);
                double distance = Math.sqrt(Math.pow((de1.getX() - de2.getX()), 2) + Math.pow((de1.getY() - de2.getY()), 2));
                if (distance < 5) {
                    place = false;
                    break;
                }

            }
            if (place == true) {
                Variables.circles.add(circles.get(i));
            }

        }
    }

    public static ArrayList<Coordinate> give_itermediate_pixels_between_points(Coordinate c1, Coordinate c2) {

        ArrayList<Coordinate> coor = new ArrayList();


        int x0 = c1.X;
        int y0 = c1.Y;
        int x1 = c2.X;
        int y1 = c2.Y;

        boolean steep = (Math.abs(y1 - y0) > Math.abs(x1 - x0));

        if (x0 != y0 && x0 != x1 && x0 != y1 && y0 != x0 && y0 != x1 && x0 != y1 && x1 != x0 && x1 != y0 && x1 != y1 && y1 != x0 && y1 != y0 && y1 != x1) {
            if (steep) {
                int tmp = x1;
                x1 = y1;
                y1 = tmp;
                tmp = x0;
                x0 = y0;
                y0 = tmp;
            }

            if (x0 > x1) {
                int tmp = x0;
                x0 = x1;
                x1 = tmp;
                tmp = y0;
                y0 = y1;
                y1 = tmp;
            }
            int deltax = (x1 - x0);
            int deltay = Math.abs(y1 - y0);

            double error = 0;
            double deltaerr = (deltay / deltax);    // Assume deltax != 0 (line is not vertical),
            // note that this division needs to be done in a way that preserves the fractional part
            int y = y0;
            int ystep;

            if (y0 > y1) {
                ystep = 1;
            } else {
                ystep = -1;
            }

            int x;
            for (x = x0; x < x1; x++) {
                if (steep) {
                    Coordinate c = new Coordinate(y, x);
                    coor.add(c);
                } else {
                    Coordinate c = new Coordinate(x, y);
                    coor.add(c);
                }
                error += deltaerr;
                if (error >= 0.5) {
                    y++;
                    error--;
                }
            }
        } else {
            Coordinate c = new Coordinate(x0, y0);
            coor.add(c);
        }


        return coor;
    }
}