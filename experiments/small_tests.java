/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package experiments;

import java.util.ArrayList;
import java.util.HashSet;
import processing.core.PApplet;

/**
 *
 * @author gpavlopo
 */
public class small_tests extends PApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        double tr=33;
//        System.out.println(get_shorter_double(tr));
        
    //    System.out.println((double)Math.log10((double)185/(double)207));
        
       // System.out.println(map(150, 10, 100, 0,250));
        
//        System.out.println(map(150, 10, 100, 0,250));
//        
//        String file = "/Users/gpavlopo/Desktop/Thierry/B8FF4C_A6GD7A_Chr1.txt";
//        System.out.println(hilbert.GenericMethods.get_last_reported_position_in_file(file));
         

        ArrayList<String> oldlist = new ArrayList();
        oldlist.add("A");
        oldlist.add("A");
        oldlist.add("C");
        oldlist.add("B");
        oldlist.add("A");
        oldlist.add("B");
        oldlist.add("C");
        ArrayList<String> newList = new ArrayList<String>(new HashSet<String>(oldlist));
        for (int i = 0; i <newList.size(); i++) {
            System.out.println(newList.get(i));
            
        }

        
        
    }

    static String get_shorter_double(double val)
    {
        String s=""+val;

        if(s.contains("."))
            s=s.substring(0, s.indexOf(".")+2);

        return s;
    }

}
