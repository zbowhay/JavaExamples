/**
 * @author Zac Bowhay
 * MinesweeperPanel.java controls every aspect of the panel
 * and game control and is to be used in the Minesweeper.java file
 * Created on September 26, 2012 
 */
import java.applet.AudioClip;
import java.awt.*;
import javax.swing.*;
import javax.xml.transform.Source;

import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MinesweeperPanel extends JPanel{
	//for game
	public static ArrayList<JLabel> labels; 
	public static ArrayList<Boolean> mines;
	public static ImageIcon mine = new ImageIcon("C:/Users/Owner/Desktop/Assignment3/Images/Minesweeper Mine.png");
	public static String surndMineCountString;
	public static int MinesLeft;
	public static final int defaultDifficulty = 10;
	//for saving
	public static ArrayList<String> labelsSave;
/**
 * MinesweeperPanel() is the constructor for MinesweeperPanel class
 */
	public MinesweeperPanel(){
		System.out.println("Mine image will only work if its placed here:");
		System.out.println("C:/Users/Owner/Desktop/Assignment3/Images/Minesweeper Mine.png");
		System.out.println("Difficulty set at default: " + defaultDifficulty);
		setBackground(Color.YELLOW);
		labels = new ArrayList<JLabel>();
		labelsSave = new ArrayList<String>();
		setLayout(new GridLayout(11,10));
		initializeLabels(labels);
		initializeLabelsSave(labelsSave);
		updateSaveLabels(labelsSave, labels);
		mines = new ArrayList<Boolean>();
		generateMines(mines, defaultDifficulty);
		
	}
	/**
	 * MinesweeperPanel's overloaded constructor that allows for difficulty setting by changing
	 * the number of mines that will be generated
	 * @param difficulty represents the number of mines to be generated
	 */
	public MinesweeperPanel(int difficulty){
		int Difficulty = difficulty;
		System.out.println("Mine image will only work if its placed here:");
		System.out.println("C:/Users/Owner/Desktop/Assignment3/Images/Minesweeper Mine.png");
		if(Difficulty < 10){
			System.out.println("difficulty has to be greater than 10. Reseting to default.");
			Difficulty = defaultDifficulty;
		}
		System.out.println("Difficulty set at " + Difficulty);
		setBackground(Color.YELLOW);
		labels = new ArrayList<JLabel>();
		labelsSave = new ArrayList<String>();
		initializeLabels(labels);
		initializeLabelsSave(labelsSave);
		setLayout(new GridLayout(11,10));
		updateSaveLabels(labelsSave, labels);
		mines = new ArrayList<Boolean>();
		generateMines(mines, Difficulty);

	}
	/**
	 * initalizeLabelsSave will initialize the variable LabelsSave
	 * @param save ArrayList<String> param that will be used to initialize LabelsSave
	 */
	public static void initializeLabelsSave(ArrayList<String> save){
		for(int a = 0; a < MinesweeperPanel.labels.size(); a++){
			save.add("?");
		}
	}
	/**
	 * initializeLabels will initialize the labels variable
	 * @param label The ArrayList<JLabel> that will be entered
	 */
	public void initializeLabels(ArrayList<JLabel> label){
		for(int a = 0; a < 100; a++){
			String s = "?";
			label.add(a,new JLabel(s));
			label.get(a).addMouseListener(new MouseHandler());
			this.add(label.get(a));
		}
	}
	/**
	 * updateSaveLabels will take label and get the text and store it in save
	 * @param save ArrayList<String> object that will hold label's text for saving purposes
	 * @param label ArrayList<JLabel> object that represents the minesweeper board, that text will be taken from and stored in save.
	 */
	/*This probably could be made faster if it just replaced the 
	corresponding index in save with the one from label per click.
	as opposed to running through the entire ArrayList and resetting all elements.*/
	public static void updateSaveLabels(ArrayList<String> save, ArrayList<JLabel> label){
		for(int a = 0; a < label.size(); a++){
			save.set(a, label.get(a).getText());
		}
	}
	/**
	 * generateMines(ArrayList<Boolean> b) will generate mines randomly by assigning true or false
	 * to the ArrayList<Boolean> b that was entered
	 * @param b b is the ArrayList<Boolean> that will have mines stored within it at random locations
	 * @return returns new ArrayList<Boolean> with randomly placed mines 
	 */
	public static ArrayList<Boolean> generateMines(ArrayList<Boolean> b, int numMines){
		Random rand = new Random();
		int mineCount = 0;
		int seperate = 0;//spreads the mines out
		int seperateCheck = 0;
		if(numMines <= 10){
			seperateCheck = 4;
		}
		if(numMines > 10 && numMines <= 20){
			seperateCheck = 3;
		}
		if(numMines > 20 && numMines <= 30){
			seperateCheck = 2;
		}
		if(numMines > 30 && numMines <= 40){
			seperateCheck = 1;
		}
		if(numMines > 40 && numMines <= 50){
			seperateCheck = 0;
		}
		for(int a = 0; a < 100; a++){
			int temp = rand.nextInt(50);
			if(temp <= 10){
				b.add(false);
			}
			if(temp > 10 && mineCount <= numMines){
				if(seperate > seperateCheck){
					b.add(true);
					mineCount++;
					seperate = 0;
				}else{
					b.add(false);
				}
			}
			if(mineCount > 10){
				b.add(false);
			}
			seperate++;
		}
		b.remove(100);
		for(int a = 0; a < 100; a++){
			if(b.get(a)){
				MinesLeft++;
			}
		}
		return b;
	}	
	/**
	 * getNearMines(int index) will return an int that lets you know how many mines are surrounding index
	 * @param index index is the location that you want to have searched for surrounding mines
	 * @return returns number of surrounding mines
	 */
	public static int getNearMines(int index){
		int numMines = 0;
		ArrayList<Boolean> Mines = new ArrayList<Boolean>();
		if(index > 0 && index < 9){//checks around any index on top row except for 0 and 9
			Mines.add(checkForMines(index - 1));
			Mines.add(checkForMines(index + 1));
			Mines.add(checkForMines(index + 10));
			Mines.add(checkForMines(index + 9));
			Mines.add(checkForMines(index + 11));
			for(int a = 0; a < 5; a++){
				if(Mines.get(a) == true)
					numMines++;
			}
		}
		if(index == 0){//checks around 0
			Mines.add(checkForMines(index + 1));
			Mines.add(checkForMines(index + 10));
			Mines.add(checkForMines(index + 11));
			for(int a = 0; a < 3; a++){
				if(Mines.get(a) == true)
					numMines++;
			}
		}
		if(index == 9){//checks around 9
			Mines.add(checkForMines(index - 1));
			Mines.add(checkForMines(index + 10));
			Mines.add(checkForMines(index + 9));
			for(int a = 0; a < 3; a++){
				if(Mines.get(a) == true)
					numMines++;
			}
		}
		if(index == 90){//checks around 90
			Mines.add(checkForMines(index + 1));
			Mines.add(checkForMines(index - 10));
			Mines.add(checkForMines(index - 9));
			for(int a = 0; a < 3; a++){
				if(Mines.get(a) == true)
					numMines++;
			}
		}
		if(index == 99){// checks around 99
			Mines.add(checkForMines(index - 1));
			Mines.add(checkForMines(index - 10));
			Mines.add(checkForMines(index - 11));
			for(int a = 0; a < 3; a++){
				if(Mines.get(a) == true)
					numMines++;
			}
		}
		for(int a = 10; a <= 80; a += 10){//checks around any index on left column except 0 and 90
			if(index == a){
				Mines.add(checkForMines(index - 10));
				Mines.add(checkForMines(index + 10));
				Mines.add(checkForMines(index + 1));
				Mines.add(checkForMines(index - 9));
				Mines.add(checkForMines(index + 11));
				for(int b = 0; b < 5; b++){
					if(Mines.get(b) == true)
						numMines++;
				}
			}
		}
		for(int a = 19; a <= 89; a += 10){//checks around any index on left column except 9 and 99
			if(index == a){
				Mines.add(checkForMines(index - 10));
				Mines.add(checkForMines(index + 10));
				Mines.add(checkForMines(index - 1));
				Mines.add(checkForMines(index + 9));
				Mines.add(checkForMines(index - 11));
				for(int b = 0; b < 5; b++){
					if(Mines.get(b) == true)
						numMines++;
				}
			}
		}
		for(int a = 91; a <= 98; a++){//checks around any index between 91 and 98
			if(index == a){
				Mines.add(checkForMines(index - 1));
				Mines.add(checkForMines(index + 1));
				Mines.add(checkForMines(index - 9));
				Mines.add(checkForMines(index - 10));
				Mines.add(checkForMines(index - 11));
				for(int b = 0; b < 5; b++){
					if(Mines.get(b) == true)
						numMines++;
				}
			}
		}
		/*
		 * next for loop will check near all indexes between 11 and 88. Excluding indexes that end in 0 or 9.
		 * which are the two side columns.
		 */
		for(int a = 11; a <= 81; a += 10){
			for(int b = a; b <= a+7; b++){
				if(index == b){
					Mines.add(checkForMines(index - 11));
					Mines.add(checkForMines(index - 10));
					Mines.add(checkForMines(index - 9));
					Mines.add(checkForMines(index - 1));
					Mines.add(checkForMines(index + 1));
					Mines.add(checkForMines(index + 9));
					Mines.add(checkForMines(index + 10));
					Mines.add(checkForMines(index + 11));
					for(int c = 0; c < 8; c++){
						if(Mines.get(c) == true)
							numMines++;
					}
				}
			}
		}
		return numMines;
	}
	/**
	 * checkForMines(int n) will check a location to see if a mine is there
	 * @param n n is the location that will be checked for mines
	 * @return returns true if there is a mine, false if there is not a mine
	 */
	public static boolean checkForMines(int n){
		if(mines.get(n) == true)
			return true;
		return false;
	}
	/**
	 * getJLabelIndex(int x, int y) will return the index based on the two coordinates entered as params.
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @return returns an integer that represents the index
	 */
	public static int getJLabelIndex(int x, int y){
		int xColumn, yColumn, index;
		index = 0;
		xColumn = x/45;
		yColumn = y/42;// has to be 42 because of weird screen resolution and gridLayout formatting issue.
		if(y <= 80){// needed to accommodate the resolution and gridLayout glitch
			yColumn = 0;
		}
		// New resolution and GridLayout glitch when the JMenuBar was added...
		// Therefore, these were needed to help click detection more accurate.
		if(y >= 90 && y <= 116){
			yColumn = 1;
		}
		if(y >= 125 && y <= 150){
			yColumn = 2;
		}
		if(y >= 160 && y <= 190){
			yColumn = 3;
		}
		if(y >= 200 && y <= 225){
			yColumn = 4;
		}
		if(xColumn != 0 && yColumn != 0){// first possible condition and equation required
			index = ((yColumn*10) + xColumn);
		}
		if(xColumn != 0 && yColumn == 0){// second possible condition and equation required
			index = xColumn;
		}
		if(yColumn != 0 && xColumn == 0){// third possible condition and equation required
			index = yColumn*10;
		}
		return index;
	}
	/**
	 * MouseHandler will control all of the interaction from the user that is required to make 
	 * this game operational
	 * @author Zac Bowhay
	 * Created September 26, 2012
	 *
	 */
	private class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getButton() == 1){//left click
				// if there is a mine where you clicked
				if(mines.get(MinesweeperPanel.getJLabelIndex(e.getXOnScreen(), e.getYOnScreen()))){
					// then reveal all mines on screen
 					for(int a = 0; a < 100; a++){
						if(mines.get(a) == true){
							labels.get(a).setIcon(mine);
						}
					}
 					// and tell user that they lost
					JLabel You = new JLabel("YOU");
					You.setVisible(true);
					JLabel Lose = new JLabel("LOSE!");
					Lose.setVisible(true);
					add(You);
					add(Lose);
				}else{
					// if they did not click on a mine then reveal number of surrounding mines
					// where they clicked
					int index = MinesweeperPanel.getJLabelIndex(e.getXOnScreen(),e.getYOnScreen());
					surndMineCountString = "" + getNearMines(index);
					MinesweeperPanel.labels.get(index).setText(surndMineCountString);
					updateSaveLabels(labelsSave, labels);
				}
				JLabel temp = new JLabel();
				temp = (JLabel)e.getSource();
				//this handles clicks on places that have been "Flagged"
				if(temp.getText().equalsIgnoreCase("F")){// handles switching "F"'s back to there original index
					int index = MinesweeperPanel.getJLabelIndex(e.getXOnScreen(),e.getYOnScreen());
					surndMineCountString = "" + getNearMines(index);
					MinesweeperPanel.labels.get(index).setText(surndMineCountString);
					updateSaveLabels(labelsSave, labels);
				}else{
					// needed this in case there is not an F present so it doesn't throw an error
				}
				/* this is called after every click so that it will keep saving accurate
				 HOWEVER
				 in this case it is not put here so that we can avoid an error caused when a mine is clicked
				 and then the user saves and the mine is an image not a String therefore it causes
				 an error in the save system.
				 updateSaveLabels(labelsSave, labels);*/
				 
			}
			if(e.getButton() == 3){//right click
				JLabel temp = new JLabel();
				temp = (JLabel)e.getSource();
				// Handles "un-flagging" of areas that have been previously flagged 
				if(temp.getText().equalsIgnoreCase("F")){// handles switching "F"'s back to there original index
					int index = MinesweeperPanel.getJLabelIndex(e.getXOnScreen(),e.getYOnScreen());
					MinesweeperPanel.labels.get(index).setText("?");
				}else{
					// if there isn't a flag there yet.. then set a flag there
					int index = MinesweeperPanel.getJLabelIndex(e.getXOnScreen(),e.getYOnScreen());
					MinesweeperPanel.labels.get(index).setText("F");
					// if a flag was placed on an area where a mines is then it needs to 
					// recognize that and reduce the MinesLeft quantity by 1
					if(MinesweeperPanel.mines.get(index) == true){
						MinesLeft--;
						System.out.println("Mines remaining: " + MinesLeft);
					}
					// when all of the mines have been flagged then the user Wins!
					if(MinesLeft == 0){
						JLabel You = new JLabel("YOU");
						You.setVisible(true);
						JLabel Win = new JLabel("WIN!");
						Win.setVisible(true);
						add(You);
						add(Win);
					}
				}
				// this is called after every click so that it will keep saving accurate
				updateSaveLabels(labelsSave, labels);
			}
		}
	}
}