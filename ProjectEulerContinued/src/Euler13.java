//Euler 13, Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
// For this to work you need to have the Euler13Numbers.txt file placed at C:/Euler13Numbers.txt
public class Euler13 {
	private static String fileLocation;
	private static ArrayList<String> fileContents;
	public static void main(String[] args){
		fileLocation = "C:/Euler13Numbers.txt";
		File E13N = new File(fileLocation);
		try{
			FileInputStream fis = new FileInputStream(E13N);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			fileContents = new ArrayList<String>();
			while(dis.available() != 0 ){
				fileContents.add(dis.readLine());
			}
			fis.close();
		    bis.close();
		    dis.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		BigInteger sum = BigInteger.ZERO;
		for(int a = 0; a < fileContents.size(); a++){
			BigInteger num = new BigInteger(fileContents.get(a));
			sum = sum.add(num);
		}
		String answer = sum.toString();
		answer = answer.substring(0,10);
		System.out.println("The sum is " + sum);
		System.out.println("The first ten digits are " + answer);		
	}
}
