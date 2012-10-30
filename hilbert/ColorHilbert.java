/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

/**
 *
 * @author Georgios
 */
public class ColorHilbert {

    public int R;
    public int G;
    public int B;
    public int alpha;

    public ColorHilbert() {
        //white
        this.R = 255;
        this.G = 255;
        this.B = 255;
        this.alpha = 255;
    }

    public ColorHilbert(ColorHilbert c) {
        this.R = c.R;
        this.G = c.G;
        this.B = c.B;
        this.alpha = c.alpha;
    }


    public ColorHilbert(String color) {
        this.R = 255;
        this.G = 255;
        this.B = 255;
        this.alpha = 255;

        if (color.compareToIgnoreCase("black") == 0) {
            this.R = 0;
            this.G = 0;
            this.B = 0;
        }
        if (color.compareToIgnoreCase("white") == 0) {
            this.R = 255;
            this.G = 255;
            this.B = 255;
        }
        if (color.compareToIgnoreCase("grey") == 0) {
            this.R = 135;
            this.G = 135;
            this.B = 135;
        }
        if (color.compareToIgnoreCase("red") == 0) {
            this.R = 255;
            this.G = 0;
            this.B = 0;
        }
        if (color.compareToIgnoreCase("green") == 0) {
            this.R = 0;
            this.G = 255;
            this.B = 0;
        }
        if (color.compareToIgnoreCase("blue") == 0) {
            this.R = 0;
            this.G = 0;
            this.B = 255;
        }
        if (color.compareToIgnoreCase("yellow") == 0) {
            this.R = 255;
            this.G = 165;
            this.B = 0;
        }

    }

    public ColorHilbert(int r, int g, int b) {
        this.R = r;
        this.G = g;
        this.B = b;
        this.alpha = 255;
    }

    public ColorHilbert(int r, int g, int b, int alpha) {
        this.R = r;
        this.G = g;
        this.B = b;
        this.alpha = alpha;
    }

    public void setColor(ColorHilbert c) {
        this.R = c.R;
        this.G = c.G;
        this.B = c.B;
        this.alpha = c.alpha;
    }

    public void setColor(String color) {
        this.R = 255;
        this.G = 255;
        this.B = 255;
        this.alpha = 255;

        if (color.compareToIgnoreCase("black") == 0) {
            this.R = 0;
            this.G = 0;
            this.B = 0;
        }
        if (color.compareToIgnoreCase("white") == 0) {
            this.R = 255;
            this.G = 255;
            this.B = 255;
        }
        if (color.compareToIgnoreCase("grey") == 0) {
            this.R = 135;
            this.G = 135;
            this.B = 135;
        }
        if (color.compareToIgnoreCase("red") == 0) {
            this.R = 255;
            this.G = 0;
            this.B = 0;
        }
        if (color.compareToIgnoreCase("green") == 0) {
            this.R = 0;
            this.G = 100;
            this.B = 0;
        }
        if (color.compareToIgnoreCase("blue") == 0) {
            this.R = 25;
            this.G = 25;
            this.B = 112;
        }
        if (color.compareToIgnoreCase("yellow") == 0) {
            this.R = 255;
            this.G = 165;
            this.B = 0;
        }
    }

    public int compareToIgnoreAlpha(ColorHilbert c) {
        int equal = 0;
        if (this.R == c.R && this.G == c.G && this.B == c.B) {
            equal = 1;
        }
        return equal;
    }

    public int compareTo(ColorHilbert c) {
        int equal = 0;
        if (this.R == c.R && this.G == c.G && this.B == c.B && this.alpha == c.alpha) {
            equal = 1;
        }
        return equal;
    }

    public int compareToIgnoreAlpha(int r, int g, int b) {
        int equal = 0;
        if (this.R == r && this.G == g && this.B == b) {
            equal = 1;
        }
        return equal;
    }

    public int compareTo(int r, int g, int b, int alpha) {
        int equal = 0;
        if (this.R == r && this.G == g && this.B == b && this.alpha == alpha) {
            equal = 1;
        }
        return equal;
    }

    public int compareToOneValue(int val) {
        int equal = 0;
        if (this.R == val && this.G == val && this.B == val) {
            equal = 1;
        }
        return equal;
    }

    public void scaleTo255(double x, double y, double z) {
        this.R = (int) (255 * x);
        this.G = (int) (255 * y);
        this.B = (int) (255 * z);
    }

    public void removeTransparency() {
        this.alpha = 255;
    }

    public void setTransparency(int val) {
        this.alpha = val;
    }

    public void makeTransparent() {
        this.alpha = 80;
    }

    public String toString() {
        return "(" + this.R + "," + this.G + "," + this.B + "," + this.alpha + ")";
    }
}
