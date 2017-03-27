import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public abstract class CenteredTrochoid {
  
  final int fixedRingR; // The radius of the fixed ring
  final int cx, cy;     // The coordinates of the fixed ring's center
  Color color;          // The color of the curve's drawing pen
  Boolean clear;
  
  protected CenteredTrochoid(int x, int y, int R, int colorChoice) {
    // The "protected" modifier means that only subclasses can use this
    // constructor (which is true anyway, since the class is abstract).
    this.fixedRingR = R;
    this.cx = x;
    this.cy = y;
    if (colorChoice == 0) {
      this.color = Color.RED;
    } else if (colorChoice == 1) {
      this.color = Color.BLUE;
    } else if (colorChoice == 2) {
      this.color = Color.GREEN;
    } else if (colorChoice == 3) {
      this.color = Color.ORANGE;
      //this will never happen, is just a placeholder for rainbow
    
    } else {
      this.color = Color.WHITE;
    }
  }
  
  abstract public void draw(Graphics g);
 
  
  
  protected static double period(double R, double r) {
    /*
     Determine the period of a trigonmetric function of the form
     
     f(t) =  (R-r) *g(t) +/- p * g(((R-r)/r) * t)
     
     The period is always 2*pi*n, where n is the least integer that is a
     multiple of 2*pi and 2*pi*(r/(R-r)),  i.e.  (10^k)r/gcd((10^k)(R-r),(10^k)r),
     where k is the least integer s.t. both (10^k)(R-r) and (10^k)r are integers
     */
    
    double a = R - r, b = r;
    
    /*
     * There is a very subtle hazard here, which comes from the fact that the
     * finite representation scheme of floating point numbers means that some  
     * values cannot be represented accurately.  In such cases, either a or b 
     * will be off in only the 16th decimal place, but this means we compute  
     * an enormous return value, simply in order to handle this small roundoff
     * error.  For example, 0.28 - 0.2 is 0.08, but roundoff error gives us
     * 0.08000000000000002 instead.  That means our return value is roughly
     * 1.7 * 10^17, since 8000000000000001 and 20000000000000000 are relatively
     * prime.  The real answer, of course, should be 2*pi*5.
     */
    
    while (((int) a) != a || ((int) b) != b) {
      // We'll handle roundoff error by keeping a and b to only 5 decimal places
      a = round(a * 10,5);
      b = round(b * 10,5);
    }
    //a,b = int(a),int(b)
    
    return  2*Math.PI*(b/gcd((int) a, (int) b));
  } // period
  
  static double round(double x, int p) {
    // returns the value of x, rounded to the nearest p decimal places
    
    return ((long) ((x + (5 * Math.pow(10,-(p+1)))) 
                      * Math.pow(10,p))) 
      / Math.pow(10,p);
  }
  
  static int gcd(int a, int b){
    // Returns the greatest common integer divisor of a and b
    // This is based on an algorithm diescovered by the ancient Greek
    // mathemetician Euclid
    
    if (b == 0) {
      return a;
    } else {
      return gcd(b,a%b);
    }
  }
  
  
}