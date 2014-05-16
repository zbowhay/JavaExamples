/**
 * @author Zac R Bowhay
 * Sierpinski class will create a JFrame that will create an object of SierpinskiDraw and place it within this JFrame
 */
import javax.swing.*;
import java.awt.*;

public class Sierpinski{
	private static final int EXIT_ON_CLOSE = 3;
	protected static JButton test;
	protected static JFrame frame;
	public static void main(String[] args){
		frame = new JFrame("Sierpinski's Triangle");
		SierpinskiDraw panel = new SierpinskiDraw();
		Container contentPane = frame.getContentPane();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(450, 450);
		contentPane.add(panel);
	}
}
