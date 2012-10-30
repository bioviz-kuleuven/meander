/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author gpavlopo
 */
public class Zoom_Level {

    public int zoomLevel = 0;
    private int genomeLength = 0;
    public int bucket = 0;
    public ArrayList<Integer> zoom_start_points = new ArrayList();
    public ArrayList<Integer> zoom_end_points = new ArrayList();
     public ArrayList<Integer> zoom_actual_start_points = new ArrayList();
    public ArrayList<Integer> zoom_actual_end_points = new ArrayList();
    BufferedImage clipBoardImage = null;

    public static void main(String[] args) {

        Zoom_Level z = new Zoom_Level(2, 35161431, 14430002, 49591432);


//        System.out.println("");
        for (int i = 0; i < z.zoom_start_points.size(); i++) {
            System.out.println((i+1)+"\tbucket:" + z.bucket + "\trange:" + z.zoom_start_points.get(i) + "\t" + z.zoom_end_points.get(i));
            System.out.println((i+1)+"\tbucket:" + z.bucket + "\trange:" + z.zoom_actual_start_points.get(i) + "\t" + z.zoom_actual_end_points.get(i));
            System.out.println("");
        }

//        System.out.println("max level depth:"+z.getZoomlevel_to_reach_resolution1());

    }



     public  int getZoomlevel_to_reach_resolution1()
    {
         int zoom_depth=1;
         for (int zoom = 1; zoom <=15; zoom++) {
            bucket = this.get_pixel_size(zoom);
            // System.out.println(this.get_pixel_size(zoom));
            if(bucket==1)
            {
                zoom_depth=zoom;
                break;
            }

        }
         return zoom_depth;

    }


    public Zoom_Level(int zoom, int length, int start, int end) {
        this.zoomLevel = zoom;
        this.genomeLength = length;

        int p = get_number_of_pieces1D(this.zoomLevel);


        bucket = this.get_pixel_size(this.zoomLevel);

        for (int i = 0; i < p; i++) {
            zoom_start_points.add(i * bucket * (512*512)+ 1);
            zoom_actual_start_points.add(start+i * bucket * (512*512));
            zoom_end_points.add(   Math.min(  length, (i + 1)* (512*512) * bucket) );
            if(i!=p-1)
            zoom_actual_end_points.add(   start+Math.min(  length, (i +1)* (512*512) * bucket-1));
           if(i==p-1)
               zoom_actual_end_points.add( Math.min(end,  start+Math.min(  length, (i +1)* (512*512) * bucket)));
        }


//        for (int i = 0; i < zoom_end_points.size(); i++) {
//            System.out.println((i + 1) + "\tbucket:" + bucket + "\trange:" + zoom_start_points.get(i) + "\t" + zoom_end_points.get(i));
//
//        }
    }

    private int get_pixel_size(int zoom_level) {
        int initial_res = (int) Math.ceil((float) this.genomeLength / (float) (512 * 512));
        int resolution = (int) Math.ceil((float) initial_res / (float) get_number_of_pieces1D(zoom_level));
        if (resolution == 0) {
            resolution = 1;
        }
        return resolution;
    }

    private int get_number_of_pieces1D(int zoom_level) {
        int parts = 0;

        if (zoom_level == 1) {
            parts = 1;
        }
        if (zoom_level == 2) {
            parts = 4;
        }
        if (zoom_level == 3) {
            parts = 16;
        }
        if (zoom_level == 4) {
            parts = 64;
        }
        if (zoom_level == 5) {
            parts = 256;
        }
        if (zoom_level == 6) {
            parts = 1024;
        }
        if (zoom_level == 7) {
            parts = 4096;
        }
        if (zoom_level == 8) {
            parts = 16384;
        }
        if (zoom_level == 9) {
            parts = 65536;
        }
        if (zoom_level == 10) {
            parts = 262144;
        }
        if (zoom_level == 11) {
            parts = 1048576;
        }
        if (zoom_level == 12) {
            parts = 4194304;
        }
        if (zoom_level == 13) {
            parts = 16777216;
        }
        if (zoom_level == 14) {
            parts = 67108864;
        }
        if (zoom_level == 15) {
            parts = 268435456;
        }

        return (int) parts;
    }
}
