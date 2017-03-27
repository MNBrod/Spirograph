import java.awt.event.*;

public class mouseListen implements MouseListener{
	private GUI win;
	public  boolean center, radius, sradius, penD;
	public  int cx, cy, Radius, smallRadius, penDistance, penx, peny = 0;
	
	public mouseListen (GUI w) {
		this.win = w;
	}
	public void mouseClicked(MouseEvent e) {
	
	if (!center) {
		this.win.controlPane.current.setText("Set the Radius");
		cx = e.getX();
		cy = e.getY();
		System.out.println("cx is" + cx + " cy is" + cy);
		center = true;
	} else if (!radius) {
		this.win.controlPane.current.setText("Set the small Radius");
		Radius = distanceBetween(cx, cy, e.getX(), e.getY());
		radius = true;
		System.out.println("Radius is " + Radius);
	} else if (!sradius) {
		this.win.controlPane.current.setText("Set the Pen");
		smallRadius = Math.abs(distanceBetween(cx, cy, e.getX(), e.getY()) - Radius);
		penx = e.getX();
		peny = e.getY();
		System.out.println("small radius is " + smallRadius);
		sradius = true;
	} else if (!penD) {
		this.win.controlPane.current.setText("Hit Draw!");
		penDistance = distanceBetween(penx, peny, e.getX(), e.getY());
		System.out.println("pen distance is " + penDistance);
	}
	}
	
	public int distanceBetween (int x1,int y1,int x2,int y2) {
		return (int) Math.abs(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
	}
	public void newShape() {
		center = radius = sradius = penD = false;
		cx = cy = Radius = smallRadius = penx = peny = penDistance = 0;
		this.win.controlPane.current.setText("Set the Center");
	}
	public void addShape (){
		if (distanceBetween(cx, cy, penx, peny) < Radius) {
			this.win.drawPane.addShapeToArray(new Hypotrochoid(this.cx, this.cy, this.Radius, this.smallRadius, this.penDistance, this.win.drawPane.buttonDetect.color, false));
			this.win.drawPane.numberShapes++;
		} else {
			this.win.drawPane.addShapeToArray(new Epitrochoid(this.cx, this.cy, this.Radius, this.smallRadius, this.penDistance, this.win.drawPane.buttonDetect.color, false));
			this.win.drawPane.numberShapes++;
		}
	}
	public void clear() {
		
	}
	
	public void mouseEntered(MouseEvent e) {	}

	
	public void mouseExited(MouseEvent e) { 	}

	
	public void mousePressed(MouseEvent e) {	}

	
	public void mouseReleased(MouseEvent e) {	}
}
