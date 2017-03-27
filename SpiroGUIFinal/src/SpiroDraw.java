import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class SpiroDraw extends JPanel {
	static final int MAX_SHAPES = 20;
	CenteredTrochoid[] shapes = new CenteredTrochoid[MAX_SHAPES];
	static int numberShapes = 0;
	mouseListen clickDetect;
	buttonListen buttonDetect;
	boolean clear;
	
	GUI win;
	public SpiroDraw(GUI win){
		this.clear = false;
		this.buttonDetect = new buttonListen(win);
		this.clickDetect = new mouseListen(win);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setPreferredSize(new Dimension(1000,1500));
		setBackground(Color.WHITE);
		this.addMouseListener(clickDetect);
		this.win = win; 
	}
	public void addShapeToArray(CenteredTrochoid ct){
		shapes[numberShapes] = ct;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("V1.2, Max Brodheim and Dan Choe", 13,15);
		if (clear) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			clear = false;
			for (int c = 0; c < numberShapes; c++) {
				   shapes[c] = new Hypotrochoid (0,0,0,0,0,5,false);
			}
		} else {
			for (int c = 0; c < numberShapes; c++) {
			   shapes[c].draw(g);
			}
		}
	}
	protected void savePicture () {
		String name = this.win.controlPane.field.getText();
		BufferedImage im = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		this.paint(im.getGraphics());
		try {
		ImageIO.write(im, "PNG", new File(name + ".png"));
		} catch (Exception e){
			System.out.println("error in saving");
		}

		
		
	}
	

}
