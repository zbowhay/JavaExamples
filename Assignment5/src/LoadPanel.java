//LoadPanel.java creates the GUI and runs the entire loading system
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class LoadPanel {
	protected static JPanel loadPanel;
	protected static JTextField textArea;
	protected static JLabel prompt, guide;
	protected static String loadLocation, labelsToBeLoaded, minesToBeLoaded;
	public LoadPanel(){
		loadPanel = new JPanel();
		loadPanel.setVisible(true);
		loadPanel.setBackground(Color.GREEN);
		JButton load = new JButton("Load");
		load.addActionListener(new LoadButtonHandler());
		textArea = new JTextField(25);
		prompt = new JLabel("Enter desired load location:");
		guide = new JLabel("Example: C:/SomethingLikeThis.txt");
		loadPanel.add(prompt);
		loadPanel.add(guide);
		loadPanel.add(textArea);
		loadPanel.add(load);
	}
	/**
	 * Returns a String that represents the user specified load location of a file.
	 * @return returns a String that represents the user specified load location of a file.
	 */
	public static String getLoadLocation(){
		if(loadLocation == null){
			System.out.println("Save location has not been entered yet.");
			return null;
		}else{
			return loadLocation;
		}
	}
}
/**
 * @author Zac Bowhay
 * Handles the loading system when the "Load" button is clicked by user.
 */
class LoadButtonHandler implements ActionListener{
	private static ArrayList<String> forLoading, temp;
	public void actionPerformed(ActionEvent e) {
		LoadPanel.loadLocation = LoadPanel.textArea.getText();
		forLoading = new ArrayList<String>();
		System.out.println("Got the String!");
		System.out.println(LoadPanel.loadLocation);
		File toLoad = new File(LoadPanel.loadLocation);
		FileReader fileRead = null;
		BufferedReader read = null;
		try {
			fileRead = new FileReader(toLoad);
			read = new BufferedReader(fileRead);
			for(int a = 0; a < 4; a++){
				if(a == 1){
					LoadPanel.labelsToBeLoaded = read.readLine();
				}else if( a == 3){
					LoadPanel.minesToBeLoaded = read.readLine();
				}else{
					read.readLine();
				}
			}
			//Load game
			loadLabels(LoadPanel.labelsToBeLoaded);
			loadMines(LoadPanel.minesToBeLoaded);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Load strings of Jlabels and String of true/false for Mines
		Load.window.setVisible(false);
	}
	/**
	 * loadLabels(String s) will load the labels from the load location to the Minesweeper game.
	 * @param s Represents the String from the load file that pertains to the JLabels.
	 */
	public static void loadLabels(String s){
		forLoading = new ArrayList<String>();
		forLoading.add(s.substring(1,2));
		for(int a = 4; a < s.length(); a+=3){
			forLoading.add(s.substring(a, a+1));
		}
		//load Labels
		for(int b = 0; b < MinesweeperPanel.labels.size(); b++){
			MinesweeperPanel.labels.get(b).setText(forLoading.get(b));
		}
	}
	/**
	 * loadMines(String s) will load the mines from the load location to the Minesweeper game.
	 * @param s Represents the String from the load file that pertains to the mines.
	 */
	public static void loadMines(String s){
		forLoading = new ArrayList<String>();
		temp = new ArrayList<String>();
		for(int a = 0; a < s.length()-1; a++){
			temp.add(s.substring(a,a+1));
		}
		// removes all quotations and commas
		for(int b = 0; b < temp.size(); b++){
			if(temp.get(b).equals("\"")){
				temp.remove(b);
			}
			if(temp.get(b).equals(",")){
				temp.remove(b);
			}
		}
		temp.remove(0);
		// adds all of the words from the list to the ArrayList<String> words
		int count = 0;
		for(int c = 0; c < temp.size(); c++){
			count++;
			if(temp.get(c).equals(" ")){
				forLoading.add(getWord(count - 1,c));
				count = 0;
			}
		}
		//Load mines
		for(int d = 0; d < forLoading.size(); d++){
			if(forLoading.get(d).equals("false")){
				MinesweeperPanel.mines.set(d, false);
			}else{
				MinesweeperPanel.mines.set(d, true);
			}
		}
	}
	/**
	 *	getWord(int num, int currentIndex) will return a word by counting back num 
	 *	from the currentIndex and making a substring
	 * @param num represents the number of characters to go back
	 * @param currentIndex current index
	 * @return returns word in String variable word.
	 */
	public static String getWord(int num, int currentIndex){
		String word = "";
		for(int a = num; a > 0; a--){
			word += temp.get(currentIndex - a);
		}
		return word;
	}
}
