import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class Hypotrochoid extends CenteredTrochoid {
  
  int r;
  int penSize;
  
  
  public Hypotrochoid (int cx, int cy, int R, int r, int penSize,
                       int colorChoice, Boolean clear) {
    super(cx, cy, R, colorChoice);
    this.r = r;
    this.penSize = penSize;
    this.clear = clear;
  }


  public void draw(Graphics g) {
    double period = super.period(fixedRingR, r);
    double t = 0;
    if (this.clear) {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, 800, 800);
    }
    if (this.color == Color.ORANGE) {
      float q = .01f; 
      while (t < period) {
        
        int x = (int) ((fixedRingR - r) * Math.cos(t) + 
                       (penSize * Math.cos(((fixedRingR-r)*(1.0/r))*t)));
        int y = (int) ((fixedRingR - r) * Math.sin(t) - 
                       (penSize * Math.sin(((fixedRingR-r)*(1.0/r))*t)));
        g.setColor(Color.getHSBColor((.01f*q), 1f, 1f));
        g.fillOval(cx+x, cy+y, 2, 2);
        t = t + .001;
        q = q + (float)(1/period);
      }
    } else {
      while (t < period) {
        int x = (int) ((fixedRingR - r) * Math.cos(t) + 
                       (penSize * Math.cos(((fixedRingR-r)*(1.0/r))*t)));
        int y = (int) ((fixedRingR - r) * Math.sin(t) - 
                       (penSize * Math.sin(((fixedRingR-r)*(1.0/r))*t)));
        g.setColor(color);
        g.fillOval(cx+x, cy+y, 2, 2);
        t = t + .001;
      }
    }
    
  }
  
  
}