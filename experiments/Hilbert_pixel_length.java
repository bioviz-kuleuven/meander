/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import processing.core.PApplet;

/**
 * <p align=center>Algo Avancé : Les Fractals <br>Courbe de Hilbert</p>
 * @author Nicolas SARRA
 * @version 1.0
 */
public class Hilbert_pixel_length {

    private static  int fold_level = 0;
    private static  int x = 0;
    private static  int y = 0;
    private static  int start_x = 0;
    private static  int start_y = 0;
    private static  int height = 0;
    private static  int width = height;
    private static  int dist = 0;
    private static  int pixel_size = 1;
    public static  int length=0;
    public static  int corners=1;
    public static  int grid_size=0;





    public static void main(String[] args) {

              calculate_hilbert_characterisics(1, 500);
              System.out.println(corners+"\t"+grid_size);
    }


    public static void calculate_hilbert_characterisics(int fold, int resol) {
      fold_level=fold;
      height=width=resol;


        dist = height;
        for (int i = fold_level; i > 0; i--) {
            dist /= 2;
        }
        x = dist / 2;
        y = dist / 2;
        start_x = x;
        start_y = y;

         HilbertA(fold);

        }





    public static void deplacement(int vx, int vy) {
        int ax = x;
        int ay = y;
        x = x + vx;
        y = y + vy;



//        System.out.println("\n" + ax + " " + ay + " | " + x + " " + y + " | " + width);


        if (ax < x && y == ay) {
            corners++;
            for (int k = ax; k < x; k++) {
                length++;
            }
        }
        if (x < ax && y == ay) {
            corners++;
            for (int k = ax; k > x; k--) {
                length++;
            }
        }
        if (x == ax && y == ay) {
            corners++;
            length++;
        }



        if (y > ay && x == ax) {
            corners++;
            for (int k = ay; k < y; k++) {
                length++;
            }
        }
        if (y < ay && x == ax) {
            corners++;
            for (int k = ay; k > y; k--) {
                length++;
            }
        }
        if (y == ay && x == ax) {
            corners++;
            length++;
        }
       grid_size=(int)Math.sqrt(corners);
    }
//

    private static void HilbertA(int level) {
        if (level > 0 && x <= width && x >= 0 && y <= width && y >= 0) {
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
        if (level > 0 && x <= width && x >= 0 && y <= width && y >= 0) {
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
        if (level > 0 && x <= width && x >= 0 && y <= width && y >= 0) {
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
        if (level > 0 && x <= width && x >= 0 && y <= width && y >= 0) {
            HilbertC(level - 1);
            deplacement(0, -dist);
            HilbertD(level - 1);
            deplacement(-dist, 0);
            HilbertD(level - 1);
            deplacement(0, dist);
            HilbertB(level - 1);
        }
    }


}
