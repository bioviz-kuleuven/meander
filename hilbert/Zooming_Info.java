/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hilbert;

/**
 *
 * @author gpavlopo
 */
public class Zooming_Info {

    public int zoom;
    public int part;
    public String filename=null;
    public int range_start=0;
    public int range_end=0;
    public int bucket;
    public int counts_tmp=0;

    public String toString()
    {
        return ("zoom:"+zoom+"\t"+"part:"+part+"\t"+"bucket:"+bucket+"\t"+"start:"+range_start+"\t"+"end:"+range_end+"\t"+"filename:"+filename);
    }

    public Zooming_Info() {
        
    }

}
