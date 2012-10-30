/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

/**
 *
 * @author gpavlopo
 */
public class DoubleEvidence {
private  int x;
private  int y;
private  double radius;

  public DoubleEvidence()
  {
      
  }
  
  public DoubleEvidence(int x , int y, double radius)
  {
      this.x=x;
      this.y=y;
      this.radius=radius;
  }
  
  public String toString()
  {
      return "("+getX()+","+getY()+" radius:"+getRadius();
  }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
   
}
