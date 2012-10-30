/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.util.ArrayList;

public class Interval implements Comparable<Interval> {

    public int low;   // left endpoint
    public int high;  // right endpoint
    public Pixel pix = null;

    // precondition: left <= right
    public Interval(int left, int right, Pixel pix) {

        if (left <= right) {
            this.low = left;
            this.high = right;
            this.pix = pix;
        } else {
            throw new RuntimeException("Illegal interval");
        }
    }

    // does this interval intersect that one?
    public boolean intersects(Interval that) {
        if (that.high < this.low) return false;
        if (this.high < that.low) return false;
        return true;
    }
    
    // does this interval a intersect b?
    public boolean includes(Interval that) {
        if (this.high < that.low || this.high > that.high) {
            return false;
        }
        if (this.low < that.low || this.low > that.high) {
            return false;
        }
        return true;
    }

    public int compareTo(Interval that) {
        if (this.low < that.low) {
            return -1;
        } else if (this.low > that.low) {
            return +1;
        } else if (this.high < that.high) {
            return -1;
        } else if (this.high < that.high) {
            return +1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "[" + low + ", " + high + "]";
    }

    // test client
    public static void main(String[] args) {
//        Interval1D a = new Interval1D(15, 20);
//        Interval1D b = new Interval1D(25, 30);
//        Interval1D c = new Interval1D(10, 40);
//        Interval1D d = new Interval1D(40, 50);
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("c = " + c);
//        System.out.println("d = " + d);
//
//        System.out.println("b intersects a = " + b.intersects(a));
//        System.out.println("a intersects b = " + a.intersects(b));
//        System.out.println("a intersects c = " + a.intersects(c));
//        System.out.println("a intersects d = " + a.intersects(d));
//        System.out.println("b intersects c = " + b.intersects(c));
//        System.out.println("b intersects d = " + b.intersects(d));
//        System.out.println("c intersects d = " + c.intersects(d));
    }
}
