/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hilbert;

/**
 *
 * @author gpavlopo
 */


public class Variation {

    /**
     * @param args the command line arguments
     */
    public String variation_type=null; //"deletion", "insertion";
    public String chromosome=null;
    public int from=-1;
    public int to=-1;



    public Variation () {
        // TODO code application logic here
    }

    public String toString()
    {
        return "chromsosome:"+chromosome+"\t"+"variation:"+variation_type+"\t"+"start:"+from+"\t"+"end:"+to;
    }

}
