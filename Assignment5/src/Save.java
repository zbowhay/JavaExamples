//Save.java creates the JFrame for the Saving system
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Save extends JFrame{
	protected static final int EXIT_ON_CLOSE = 3;
	public static JFrame window;
	// Main method only here for testing purposes....
	public static void main(String[] args){
		window = new JFrame("Save");
		window.setVisible(true);
		window.setSize(350, 150);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLocation(300, 150);
		SavePanel panel = new SavePanel();
		Container contentPane = window.getContentPane();
		contentPane.add(panel.savePanel);
	}
	// constructor is what is called by Minesweeper.java
	public Save(){
		window = new JFrame("Save");
		window.setVisible(true);
		window.setSize(350, 150);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLocation(300, 150);
		SavePanel panel = new SavePanel();
		Container contentPane = window.getContentPane();
		contentPane.add(panel.savePanel);
	}
}