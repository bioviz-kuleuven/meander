/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

/**
 *
 * @author Georgios
 */
public class Coordinate {

    public int X;
    public int Y;

    public Coordinate() {
    }
     public Coordinate(int x, int y) {
         this.X=x;
         this.Y=y;
    }
     public Coordinate(Coordinate cc) {
         this.X=cc.X;
         this.Y=cc.Y;
    }

     public String toString() {
        return "("+ GenericMethods.giveNumber_getHumanformat(this.X)+","+ GenericMethods.giveNumber_getHumanformat(this.Y)+")";
    }
}
