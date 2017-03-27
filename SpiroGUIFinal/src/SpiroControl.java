import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SpiroControl extends JPanel{
	protected JButton rdbtnRed;
	protected JButton rdbtnBlue;
	protected JButton rdbtnGreen;
	protected JButton rdbtnRainbow;
	protected JButton btnDraw;
	protected JButton btnClear;
	protected JButton btnNew;
	protected JButton btnSave;
	protected JTextField field;
	protected JLabel current;
	
	public SpiroControl (GUI win) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		field = new JTextField("File path name here, no \"png\"");
		btnSave = new JButton("Save");
		rdbtnRed = new JButton("Red");
		rdbtnBlue = new JButton("Blue");
		rdbtnGreen = new JButton("Green");
		rdbtnRainbow = new JButton("Rainbow");
		btnDraw = new JButton("Draw!");
		btnClear = new JButton("Clear");
		btnNew = new JButton ("New");
		current = new JLabel("Set the Center");
		this.add(current);
		this.add(rdbtnRed);
		this.add(rdbtnBlue);
		this.add(rdbtnGreen);
		this.add(rdbtnRainbow);
		this.add(btnDraw);
		this.add(btnNew);
		this.add(btnClear);
		this.add(btnSave);
		this.add(field);
		field.setColumns(20);
		rdbtnRed.addActionListener(new buttonListen(win));
		rdbtnRed.setActionCommand("red");
		rdbtnBlue.addActionListener(new buttonListen(win));
		rdbtnBlue.setActionCommand("blue");
		rdbtnGreen.addActionListener(new buttonListen(win));
		rdbtnGreen.setActionCommand("green");
		rdbtnRainbow.addActionListener(new buttonListen(win));
		rdbtnRainbow.setActionCommand("rainbow");
		btnDraw.addActionListener(new buttonListen(win));
		btnDraw.setActionCommand("draw");
		btnClear.addActionListener(new buttonListen(win));
		btnClear.setActionCommand("clear");
		btnNew.addActionListener(new buttonListen(win));
		btnNew.setActionCommand("new");
		btnSave.addActionListener(new buttonListen(win));
		btnSave.setActionCommand("save");
	}
	public void setLabel(String h) {
		this.current.setText(h);
	}
}
