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
	public static ArrayList<JLabel> labels; 
	public static ArrayList<Boolean> mines;
	public static ImageIcon mine = new ImageIcon("C:/Users/Owner/Desktop/Assignment3/Images/Minesweeper Mine.png");
	public static String surndMineCountString;
	public static int MinesLeft;
/**
 * MinesweeperPanel() is the constructor for MinesweeperPanel class
 */
public MinesweeperPanel(){
		System.out.println("Mine image will only work if its placed here:");
		System.out.println("C:/Users/Owner/Desktop/Assignment3/Images/Minesweeper Mine.png");
		setBackground(Color.YELLOW);
		labels = new ArrayList<JLabel>();
		setLayout(new GridLayout(11,10));
		for(int a = 0; a < 100; a++){
			String s = "?";
			labels.add(a,new JLabel(s));
			labels.get(a).addMouseListener(new MouseHandler());
			add(labels.get(a));
		}
		mines = new ArrayList<Boolean>();
		generateMines(mines);

	}
	/**
	 * generateMines(ArrayList<Boolean> b) will generate mines randomly by assigning true or false
	 * to the ArrayList<Boolean> b that was entered
	 * @param b b is the ArrayList<Boolean> that will have mines stored within it at random locations
	 * @return returns new ArrayList<Boolean> with randomly placed mines 
	 */
	public static ArrayList<Boolean> generateMines(ArrayList<Boolean> b){
		Random rand = new Random();
		int mineCount = 0;
		int seperate = 0;//spreads the mines out
		for(int a = 0; a < 100; a++){
			int temp = rand.nextInt(50);
			if(temp <= 25){
				b.add(false);
			}
			if(temp > 25 && mineCount <=10){
				if(seperate > 4){
					b.add(true);
					mineCount++;
					seperate = 0;
				}else{
					b.add(false);
				}
			}
			if(temp > 25 && mineCount > 10){
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
		if(y <= 52){// needed to accommodate the resolution and gridLayout glitch
			yColumn = 0;
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
				}
				JLabel temp = new JLabel();
				temp = (JLabel)e.getSource();
				//this handles clicks on places that have been "Flagged"
				if(temp.getText().equalsIgnoreCase("F")){// handles switching "F"'s back to there original index
					int index = MinesweeperPanel.getJLabelIndex(e.getXOnScreen(),e.getYOnScreen());
					surndMineCountString = "" + getNearMines(index);
					MinesweeperPanel.labels.get(index).setText(surndMineCountString);
				}else{
					// needed this in case there is not an F present so it doesnt throw an error
				}
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
			}
		}
	}
}