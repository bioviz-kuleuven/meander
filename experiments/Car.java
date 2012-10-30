/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

/**
 *
 * @author gpavlopo
 */
public class Car {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num=35161430;
        System.out.println("Chr22_Human:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        num=247199999;
        System.out.println("Chr1_Human:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        num=30427664;
        System.out.println("Chr1_Arabidopsis:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        num=19698288;
        System.out.println("Chr2_Arabidopsis:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        num=23459808;
        System.out.println("Chr3_Arabidopsis:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        num=18585055;
        System.out.println("Chr4_Arabidopsis:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        num=26975501;
        System.out.println("Chr5_Arabidopsis:"+num+"->"+hilbert.LoadReads.max_hilbert_lines(num));
        
        
        for (int i = 0; i < (262144); i++) {
            for (int j = i; j < 262144; j++) {
                
            }
            System.out.println(i);
            
        }
        
            }
}
