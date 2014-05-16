/**
 * @author Zac Bowhay
 * Minesweeper.java will create an extremely rudimentary version of minesweeper. 
 * Its recommended that you just play the one that came with your OS.
 * Created on September 26, 2012  
 */
import java.awt.*;
import javax.swing.*;

public class Minesweeper extends JFrame{
	protected static JFrame frame;
	protected static final int EXIT_ON_CLOSE = 3;
	public static void main(String[] args){
		frame = new JFrame("Minesweeper");
		MinesweeperPanel panel = new MinesweeperPanel();
		frame.setVisible(true);
		frame.setSize(450,450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.add(panel);
	}
}
