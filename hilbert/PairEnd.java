/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

/**
 *
 * @author gpavlopo
 */
public class PairEnd {

    public int from_PE1 = -1;
    public int to_PE1 = -1;
    public int from_PE2 = -1;
    public int to_PE2 = -1;
    public int count = 1;
    public String chromosome_from = "";
    public String chromosome_to = "";
    public String direction_PE1 = "";
    public String direction_PE2 = "";
    public String variation_type = "";
    public ColorHilbert color = new ColorHilbert(255, 51, 204, 200);
    public int sample = 1;
    public Pixel source = null;
    public Pixel dest = null;

    public PairEnd() {
        this.chromosome_from = Variables.chromosome;
        this.chromosome_to = Variables.chromosome;
    }

    public void assign_variation_type() {
        if (this.from_PE1 == -1 || this.to_PE1 == -1) {
            int max = Math.max(this.from_PE1, this.to_PE1);
            this.from_PE1 = max;
            this.to_PE1 = max;
        }

        if (this.from_PE2 == -1 || this.to_PE2 == -1) {
            int max = Math.max(this.from_PE2, this.to_PE2);
            this.from_PE2 = max;
            this.to_PE2 = max;
        }
       

            if (this.variation_type.compareToIgnoreCase("inversion") == 0 ) {
                this.color.R = 44;
                this.color.G = 77;
                this.color.B = 143;
                this.color.alpha = 200;
            }
            if (this.variation_type.compareToIgnoreCase("duplication") == 0 ) {
                this.color.R = 88;
                this.color.G = 171;
                this.color.B = 45;
                this.color.alpha = 200;
            }
            
            if (this.variation_type.compareToIgnoreCase("insertion") == 0 ) {
                this.color.R = 88;
                this.color.G = 171;
                this.color.B = 45;
                this.color.alpha = 200;
            }
            if (this.variation_type.compareToIgnoreCase("deletion") == 0 ) {
                this.color.R = 255;
                this.color.G = 51;
                this.color.B = 208;
                this.color.alpha = 200;
            }
             if (this.variation_type.compareToIgnoreCase("translocation") == 0 ) {
                this.color.R = 201;
                this.color.G = 51;
                this.color.B = 255;
                this.color.alpha = 200;
            }
            
            //--------
            
            //if(this.variation_type.length()>=2)
            {
            if (this.direction_PE1.compareToIgnoreCase(this.direction_PE2) == 0 && this.direction_PE1.compareTo("-") == 0) {
                this.variation_type = "inversion";
                this.color.R = 44;
                this.color.G = 77;
                this.color.B = 143;
                this.color.alpha = 200;

            }
            if (this.direction_PE1.compareToIgnoreCase(this.direction_PE2) == 0 && this.direction_PE1.compareTo("+") == 0) {
                this.variation_type = "inversion";
                this.color.R = 44;
                this.color.G = 77;
                this.color.B = 143;
                this.color.alpha = 200;
            }
            if (this.direction_PE1.compareToIgnoreCase("+") == 0 && this.direction_PE2.compareTo("-") == 0) {
                this.variation_type = "deletion";
                this.color.R = 255;
                this.color.G = 51;
                this.color.B = 208;
                this.color.alpha = 200;
                
                
            }
            if (this.direction_PE1.compareToIgnoreCase("-") == 0 && this.direction_PE2.compareTo("+") == 0) {
                this.variation_type = "insertion";
                this.color.R = 88;
                this.color.G = 171;
                this.color.B = 45;
                this.color.alpha = 200;
                
            }
            }
      
    }

    public PairEnd(int a, int b) {
        this.from_PE1 = a;
        this.to_PE1 = a;
        this.from_PE2 = b;
        this.to_PE2 = b;
        this.chromosome_from = Variables.chromosome;
        this.chromosome_to = Variables.chromosome;
        assign_variation_type();


    }

    public PairEnd(int a, int b, String cromosome) {
        this.from_PE1 = a;
        this.to_PE1 = a;
        this.from_PE2 = b;
        this.to_PE2 = b;
        this.chromosome_from = cromosome;
        this.chromosome_to = cromosome;
        assign_variation_type();

    }

    public PairEnd(int a, int b, String cromosome_from, String cromosome_to) {
        this.from_PE1 = a;
        this.to_PE1 = a;
        this.from_PE2 = b;
        this.to_PE2 = b;
        this.chromosome_from = cromosome_from;
        this.chromosome_to = cromosome_to;
        assign_variation_type();

    }

    public PairEnd(int from_PE1, int to_PE1, int from_PE2, int to_PE2) {
        this.from_PE1 = from_PE1;
        this.to_PE1 = to_PE1;
        this.from_PE2 = from_PE2;
        this.to_PE2 = to_PE2;
        this.count = 1;
         this.chromosome_from = Variables.chromosome;
        this.chromosome_to = Variables.chromosome;
        assign_variation_type();
    }

    public PairEnd(int from_PE1, int to_PE1, int from_PE2, int to_PE2, String cromosome_from, String cromosome_to) {
        this.from_PE1 = from_PE1;
        this.to_PE1 = to_PE1;
        this.from_PE2 = from_PE2;
        this.to_PE2 = to_PE2;
        this.chromosome_from = cromosome_from;
        this.chromosome_to = cromosome_to;
        assign_variation_type();
    }

    public String toString() {
        return (" chr" + this.chromosome_from + " (" + this.from_PE1 + "-" + this.to_PE1 + ")" 
                + " direction " + this.direction_PE1
                +" <-> "
                + " chr" + this.chromosome_to + " (" + this.from_PE2 + "-" + this.to_PE2 + ")"
                + " direction " + this.direction_PE2
                + " color" + this.color.toString()
                + "   " + this.variation_type);
    }
}
