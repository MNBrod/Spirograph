import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	private JPanel contentPane;
	protected final SpiroControl controlPane;
	protected final SpiroDraw drawPane;
	public GUI () {
		super("Spriograph");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(10, 10, 800, 1000);
		this.setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		this.controlPane = new SpiroControl(this);
		this.contentPane.add(controlPane, BorderLayout.NORTH);
		this.drawPane = new SpiroDraw(this);
		this.contentPane.add(drawPane, BorderLayout.CENTER);
		this.pack();
		
}
}
