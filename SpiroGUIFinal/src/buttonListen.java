import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class buttonListen implements ActionListener {
	private GUI win;
	static int color;
	
	public buttonListen(GUI w){
		this.win = w;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("red")) {
			this.color = 0;
			System.out.println("red");
		} else if (e.getActionCommand().equals("blue")) {
			this.color = 1;
			System.out.println("blue");
		} else if (e.getActionCommand().equals("green")) {
			this.color = 2;
			System.out.println("green");
		} else if (e.getActionCommand().equals("rainbow")) {
			this.color = 3;
			System.out.println("rainbow");
		} else if (e.getActionCommand().equals("clear")) {
			this.win.drawPane.clear = true;
			this.win.drawPane.repaint();
			System.out.println("clear");
		} else if (e.getActionCommand().equals("new")) {
			this.win.drawPane.clickDetect.newShape();
			System.out.println("new");
		} else if (e.getActionCommand().equals("draw")) {
			this.win.drawPane.clickDetect.addShape();
			this.win.drawPane.repaint();
			System.out.println("draw");
		} else if (e.getActionCommand().equals("save")) {
			this.win.drawPane.savePicture();
		}
		this.win.drawPane.repaint();
	}
	public int colorReturn () {
		return this.color;
	}
	
}
