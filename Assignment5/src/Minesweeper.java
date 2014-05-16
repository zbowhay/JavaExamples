/**
 * @author Zac Bowhay
 * Minesweeper.java will create an extremely rudimentary version of minesweeper. 
 * Its recommended that you just play the one that came with your OS :)
 * Created on September 26, 2012  
 */
// IMPORTANT must be run as administrator for saving and loading system to work 100%
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class Minesweeper extends JFrame{
	protected static JFrame frame;
	protected static Container contentPane;
	protected static final int EXIT_ON_CLOSE = 3;
	public static void main(String[] args){
		frame = new JFrame("Minesweeper");
		MinesweeperPanel panel = new MinesweeperPanel();
		frame.setSize(450,450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setVisible(true);
		JMenu file = new JMenu("File");
		file.setVisible(true);
		JMenuItem New = new JMenuItem("New");
		JMenuItem Save = new JMenuItem("Save");
		JMenuItem Load = new JMenuItem("Load");
		JMenuItem Quit = new JMenuItem("Quit");
		New.addActionListener(new NewActionListener());
		Save.addActionListener(new SaveActionListener());
		Load.addActionListener(new LoadActionListener());
		Quit.addActionListener(new QuitActionListener());
		file.add(New);
		file.add(Save);
		file.add(Load);
		file.add(Quit);
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		contentPane = frame.getContentPane();
		contentPane.add(panel);
	}
	/**
	 * reset(int difficultyLevel) will reset the game and allow user to specify the level of difficulty
	 * @param difficultyLevel int that represents the level of difficulty
	 */
	public static void reset(int difficultyLevel){
		MinesweeperPanel panel = new MinesweeperPanel(difficultyLevel);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setVisible(true);
		JMenu file = new JMenu("File");
		file.setVisible(true);
		JMenuItem New = new JMenuItem("New");
		JMenuItem Save = new JMenuItem("Save");
		JMenuItem Load = new JMenuItem("Load");
		JMenuItem Quit = new JMenuItem("Quit");
		New.addActionListener(new NewActionListener());
		Save.addActionListener(new SaveActionListener());
		Load.addActionListener(new LoadActionListener());
		Quit.addActionListener(new QuitActionListener());
		file.add(New);
		file.add(Save);
		//for Save function Make it so that it will save the ArrayList<Boolean> mines in the 
		//MinesweeperPanel.java program
		file.add(Load);
		//then use that saved ArrayList to Load.
		file.add(Quit);
		menuBar.add(file);
		Minesweeper.frame.setJMenuBar(menuBar);
		Minesweeper.contentPane.add(panel);
	}
}
/**
 * @author Zac Bowhay
 * Does all of the handling for the New option in the drop down menu of Minesweeper.
 */
class NewActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		Scanner in = new Scanner(System.in);
		System.out.println("Difficulty level (10-50): ");
		int difficulty = in.nextInt();
		Minesweeper.reset(difficulty);
		System.out.println("Your next click will reset the game.");
	}
}
/**
 * @author Zac Bowhay
 * Does all of the handling for the Save option in the drop down menu of Minesweeper.
 */
class SaveActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("Running");
		Save save = new Save();
	}
}
/**
 * @author Zac Bowhay
 * Does all of the handling for the Load option in the drop down menu of Minesweeper.
 */
class LoadActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("Running");
		Load load = new Load();
	}
}
/**
 * @author Zac Bowhay
 * Does all of the handling for the Quit option in the drop down menu of Minesweeper.
 */
class QuitActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Minesweeper.frame.dispose();
		System.exit(1);
	}
}