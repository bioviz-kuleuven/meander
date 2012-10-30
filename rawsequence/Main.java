/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rawsequence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;


/**
 *
 * @author Georgios
 */
public class Main extends PApplet {

    static Long maximum_position;
    static Long minimum_position;
    static Long maximum_read;
    static Long minimum_read;
    int start_dimensionX = 0;
    int start_dimensionY = 0;
    int end_dimensionX = 800;
    int end_dimensionY = 600;
    float bx;
    float by = 20;
    int bsx = 1;
    int bsy = 35;
    boolean bover = false;
    boolean zinover = false;
    boolean zoutover = false;
    boolean locked = false;
    float bdifx = 0.0f;
    float bdify = 0.0f;
    float maximum = -1;
    static ArrayList<Long> position = new ArrayList();
    static ArrayList<Long> expression = new ArrayList();

 

    public static void load_expressions(String filename) {
        String line = null;
        long currentLineNo = 1;

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String strLine = null;
            while ((strLine = in.readLine()) != null) {
                String[] str = strLine.split("\t");
                long pos = Long.parseLong(str[0]);
                long val = Long.parseLong(str[1]);

                position.add(pos);
                expression.add(val);
                if (currentLineNo % 1000000 == 0) {
                    System.gc();
                }
                currentLineNo++;
                maximum_position = Collections.max(position);
                minimum_position = Collections.min(position);
                maximum_read = Collections.max(expression);
                minimum_read = Collections.min(expression);
                if (currentLineNo == 3000) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.out.println("Problem reading file.\n" + ex.getMessage());
        }
    }

    @Override
    public void setup() {
        size(end_dimensionX, end_dimensionY);
        load_expressions("test_raw.txt");
    }

    @Override
    public void draw() {
        background(255);





        //chromosome bar
        stroke(192, 192, 192);
        fill(192, 192, 192);
        rect(0, 25, end_dimensionX, 25);

        //axis
        stroke(255, 0, 0);
        line(0, 300, end_dimensionX, 300);


        //slide bar
        // Test if the cursor is over the box
        noFill();
        if (mouseX > bx - bsx && mouseX < bx + bsx && mouseY > by - bsy && mouseY < by + bsy) {
            bover = true;
            stroke(255, 0, 0);
            if (!locked) {
            }
        } else {
            stroke(153);
            bover = false;
        }

        // Draw the box
        if (position.size() <= end_dimensionX) {
            bsx = end_dimensionX - 1;
        } else {
            bsx = (end_dimensionX * end_dimensionX / position.size());
        }
        quad(bx, by, bx + bsx, by, bx + bsx, by + bsy, bx, by + bsy);

        // Draw zoom lines
        line(bx, by + bsy, 0, 300);
        line(bx + bsx, by + bsy, end_dimensionX, 300);

        //picks
        stroke(126);
        noFill();
        long start_posit = 0;
        long end_posit = 0;
        int posit = (int) ((position.size()) * bx / (bx + bsx));
        start_posit = position.get(posit);
        end_posit = position.get(posit + (int) Math.min(position.size(), end_dimensionX));
        for (int i = 0; i < Math.min(position.size(), end_dimensionX); i++) {
            posit = i + (int) ((position.size()) * bx / (bx + bsx));

            if (i == 0) {
                // System.out.println("position:" + start_posit);
            }
            line(i, start_dimensionY + 300, i, start_dimensionY + 300 - expression.get(posit));
            // System.out.println(expression.get(i));
        }

    }//draw

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void mousePressed() {
        //slidebar
        if (bover) {
            locked = true;
        } else {
            locked = false;
        }
        bdifx = mouseX - bx;

        //zoom-in-out
        if (zinover && (bsx + bx) < (end_dimensionX)) {
            bsx += 20;
            if ((bsx + bx) > (end_dimensionX)) {
                bsx = (int) (end_dimensionX - 1 - bx);
            }
        }
        if (zoutover && bsx >= 35) {
            bsx -= 20;
            if (bsx <= 35) {
                bsx = 35;
            }
        }

    }

    @Override
    public void mouseDragged() {
        if (locked) {
            //slidebar cannot extend the limits
            bx = mouseX - bdifx;
            if (bx <= 0) {
                bx = 0;
            }
            if ((bx + bsx) > end_dimensionX) {
                bx = end_dimensionX - bsx - 1;
            }
        }
    }

    @Override
    public void mouseReleased() {
        locked = false;
    }
}
