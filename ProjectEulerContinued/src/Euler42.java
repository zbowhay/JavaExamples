//Euler 42, How many triangle words does the list of common English words contain?

import java.io.*;
import java.util.*;

public class Euler42 {
	private static String fileContents;
	private static ArrayList<String> temp;
	private static String[] alphabet;
	private static int[] posTriWords;
	
	public static void main(String[] args){
		ArrayList<Integer> triangleNums = new ArrayList<Integer>();
		initializeTriangleNums(triangleNums);
		ArrayList<String> words = new ArrayList<String>();
		File wordFile = new File("C:/Euler42Words.txt");
		// reads the wordFile and adds its contents to fileContents
		try{
			FileInputStream fis = new FileInputStream(wordFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			fileContents = "";
			while(dis.available() != 0 ){
				fileContents += dis.readLine();
			}
			fis.close();
		    bis.close();
		    dis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		// creates temporary ArrayList<String> to store the file contents
		temp = new ArrayList<String>();
		for(int a = 0; a < fileContents.length()-1; a++){
			temp.add(fileContents.substring(a,a+1));
		}
		System.out.println(temp);
		// removes all quotations
		for(int b = 0; b < temp.size(); b++){
			if(temp.get(b).equals("\"")){
				temp.remove(b);
			}
		}
		// adds all of the words from the list to the ArrayList<String> words
		int count = 0;
		for(int d = 0; d < temp.size(); d++){
			count++;
			if(temp.get(d).equals(",")){
				words.add(getWord(count - 1,d));
				count = 0;
			}
		}
		// array of the alphabet
		alphabet = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		// creates array full of the values of every word in the text file
		posTriWords = new int[words.size()];
		for(int f = 0; f < words.size(); f++){
			int sum = 0;
			for(int g = 0; g < words.get(f).length(); g++){
				sum += getLetterValue(words.get(f).substring(g, g+1), alphabet);
			}
			posTriWords[f] = sum;
		}
		//adds up the sum of triangle words
		int numTriWords = 0;
		for(int g = 0; g < posTriWords.length; g++){
			if(isTriangleWord(posTriWords[g], triangleNums)){
				numTriWords++;
			}
		}
		System.out.println(numTriWords);
	}
	// will return the value of the term, n, for the Triangle number function
	public static int triangleNumber(int n){
		int trinum = 0;
		trinum = (((n+1)*n)/2);
		return trinum;
	}
	// stores the first 1000 triangle terms within an ArrayList<Integer> object
	public static void initializeTriangleNums(ArrayList<Integer> list){
		for(int a = 0; a < 1000; a++){
			list.add(triangleNumber(a));
		}
	}
	// returns word from ArrayList<String> temp.
	public static String getWord(int num, int currentIndex){
		String word = "";
		for(int a = num; a > 0; a--){
			word += temp.get(currentIndex - a);
		}
		return word;
	}
	// obtains the int value of a letter according to its alphabetic position
	public static int getLetterValue(String s, String[] a){
		for(int i = 0; i < 26; i++){
			if(s.equalsIgnoreCase(a[i])){
				return (i+1);
			}
		}
		return 0;
	}
	// returns true if the worldValue is equal to a trianle Number else it returns false
	public static boolean isTriangleWord(int wordValue, ArrayList<Integer> triNums){
		for(int j = 0; j < triNums.size(); j++){
			if(triNums.get(j) == wordValue){
				return true;
			}
		}
		return false;
	}
}
