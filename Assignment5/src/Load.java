// Load.java creates the JFrame for the loading system
import java.awt.Container;
import javax.swing.JFrame;

public class Load extends JFrame{
	protected static final int EXIT_ON_CLOSE = 3;
	public static JFrame window;
	// Main method only here for testing purposes....
	public static void main(String[] args){
		window = new JFrame("Load");
		window.setVisible(true);
		window.setSize(350, 150);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLocation(300, 150);
		LoadPanel panel = new LoadPanel();
		Container contentPane = window.getContentPane();
		contentPane.add(panel.loadPanel);
	}
	// constructor is what is called by Minesweeper.java
	public Load(){
		window = new JFrame("Load");
		window.setVisible(true);
		window.setSize(350, 150);
		window.setResizable(false);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLocation(300, 150);
		LoadPanel panel = new LoadPanel();
		Container contentPane = window.getContentPane();
		contentPane.add(panel.loadPanel);
	}
}
