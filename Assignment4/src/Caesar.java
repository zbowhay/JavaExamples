// A simple encrypting program.
import java.io.*;
import java.util.*;

public class Caesar {
	private static Scanner read;
	private static String fileContents;
	private static String encryptedMessage;
	private static String unencryptedMessage;
	private static Boolean textCharacters = true;
	private static int Key;
	public static void main(String[] args){
		// needs to be run from the command line!
		// try-catch setup is made to insure that at least two arguments have been entered and then
		// if a third has been entered to use the correct constructor
		try{
			if(args[0] == null){
				throw new Exception("No key entered.");
			}
			if(args[1] == null){
				throw new Exception("No input file entered.");
			}
			Key = Integer.parseInt(args[0]);
			File infile = new File(args[1]);
			if(args.length == 3){
				File outfile = new File(args[2]);
				Caesar test = new Caesar(Key, infile, outfile);
			}else{
				Caesar test = new Caesar(Key, infile);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Argument should be: java Caesar Key infile outfile");
			System.out.println("OR");
			System.out.println("Argument should be: java Caesar Key infile");
		}
	}
	
	public Caesar(){
		System.out.println("Default Constructor.");
		Key = 0;
	}
	
	public Caesar(int key, File inFile, File outFile){
		Key = key;
		try{
			read = new Scanner(inFile);
			readFile();
			encryptedMessage = encrypt(fileContents, key);
			unencryptedMessage = unencrypt(encryptedMessage, key);
			if(textCharacters == false){
				throw new Exception(inFile + " contains non-text characters.");
			}
			if(inFile.canRead() == false){
				throw new Exception("cannot read " + inFile);
			}
			if(outFile.canWrite() == false){
				outFile.setWritable(true);
				throw new Exception("cannot write to " + outFile + ", trying to fix... run program again.");
			}
			//writes to outFile
			FileWriter fStream = new FileWriter(outFile);
			BufferedWriter out = new BufferedWriter(fStream);
			out.write(encryptedMessage);
			out.close();
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public Caesar(int key, File inFile){
		Key = key;
		try{
			read = new Scanner(inFile);
			readFile();
			// encrypts message and stores in String
			encryptedMessage = encrypt(fileContents, key);
			unencryptedMessage = unencrypt(encryptedMessage, key);
			System.out.println(encryptedMessage);
			if(inFile.canRead() == false){
				throw new Exception("cannot read " + inFile);
			}
			if(textCharacters == false){
				throw new Exception(inFile + " contains non-text characters.");
			}			
		}catch(Exception e){
			System.out.println("Error");
		}
		
	}
		
	public void displayFileContents(){
		System.out.println(fileContents);
	}
	
	public void readFile(){
		fileContents = "";
		while(read.hasNext()){
			fileContents = fileContents + read.next() + " ";
			//creates a string that contains all of the text in the file
		}
		for(int a = 0; a < fileContents.length(); a++){
			//checks to make sure that all characters are text
			if((int)fileContents.charAt(a) > 126 || (int)fileContents.charAt(a) < 32){
				textCharacters = false;
			}
		}
	}
	
	public static String encrypt(String s, int key){
		encryptedMessage = "";
		for(int a = 0; a < s.length(); a++){
			if((int)s.charAt(a) >= 32 && (int)s.charAt(a) <= 126){
				// deals with the problem of having to loop back around to 32 when encrypting
				if(((int)s.charAt(a) + key > 126)){
					int leftOver = (126 - ((int)s.charAt(a) + key))*(-1) - 1;
					leftOver += 32;
					encryptedMessage += (char)leftOver;
				}else{
					char c = s.charAt(a);
					int charValue = (int)c;
					charValue += key;
					c = (char)charValue;
					encryptedMessage += c;
				}
			}
		}
		return encryptedMessage;
	}
	
	public static String unencrypt(String s, int key){
		unencryptedMessage = "";
		for(int a = 0; a < s.length(); a++){
			if((int)s.charAt(a) >= 32 && (int)s.charAt(a) <= 126){
				// deals with the problem of having to loop back to 126 when unencrypting
				if(((int)s.charAt(a) - key < 32)){
					int leftOver = (32 - ((int)s.charAt(a) - key)) - 1;
					leftOver = 126 - leftOver;
					unencryptedMessage += (char)leftOver;
				}else{
					char c = s.charAt(a);
					int charValue = (int)c;
					charValue -= key;
					c = (char)charValue;
					unencryptedMessage += c;
				}
			}
		}
		return unencryptedMessage;
	}
}
