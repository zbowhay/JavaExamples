//SavePanel.java creates the GUI for and runs the loading system

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*Wierd bug in save system... if a label has been clicked on and had the number returned, then
 * after clicking save, everything will revert to "?" and you cannot click on labels that have been
 * previously clicked on unless you set them to a "F" and then click on them again.
 */

public class SavePanel extends JPanel{
	protected static JPanel savePanel;
	protected static JTextField textArea;
	protected static JLabel prompt, guide;
	protected static String saveLocation;
	public SavePanel(){
		savePanel = new JPanel();
		savePanel.setVisible(true);
		savePanel.setBackground(Color.GREEN);
		JButton save = new JButton("Save");
		save.addActionListener(new SaveButtonHandler());
		textArea = new JTextField(25);
		prompt = new JLabel("Enter desired save location:");
		guide = new JLabel("Example: C:/SomethingLikeThis.txt");
		savePanel.add(prompt);
		savePanel.add(guide);
		savePanel.add(textArea);
		savePanel.add(save);
	}
	// returns a string that represents the save Location entered by user.
	public static String getSaveLocation(){
		if(saveLocation == null){
			System.out.println("Save location has not been entered yet.");
			return null;
		}else{
			return saveLocation;
		}
	}
}
// does the handling and processing when the "Save" button is clicked
class SaveButtonHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		SavePanel.saveLocation = SavePanel.textArea.getText();
		//System.out.println("Got the String!");
		//System.out.println(SavePanel.saveLocation);
		File toSave = new File(SavePanel.saveLocation);
		PrintWriter out = null;
		try {
			// create file if not there and replaces if it is (Updates file).
			toSave.createNewFile();
			out = new PrintWriter(SavePanel.saveLocation);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		toSave.setWritable(true);
		//Save string of Jlabels and String of true/false for Mines into user specified location
		out.println("Labels:");
		out.println(getLabelsSaveToString());
		out.println("Mines:");
		out.println(getMinesSaveToString());
		out.close();
		Save.window.setVisible(false);
	}
	//gets the string necessary for saving current games label state.
	public static String getLabelsSaveToString(){
		String saveString = "";
		saveString = MinesweeperPanel.labelsSave.toString();
		return saveString;
	}
	//gets the string necessary for saving current games mine setup.
	public static String getMinesSaveToString(){
		String saveString = "";
		saveString = MinesweeperPanel.mines.toString();
		return saveString;
	}
}