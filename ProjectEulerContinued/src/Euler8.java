//Euler 8, Find the greatest product of five consecutive digits in the 1000-digit number.
import java.io.*;
import java.util.ArrayList;
public class Euler8 {
	private static String fileLocation, fileContents;
	public static void main(String[] args){
		fileLocation = "C:/Euler8Number.txt";
		// retrieves the contents of Euler8Number.txt
		try{
			FileInputStream fis = new FileInputStream(fileLocation);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			fileContents = "";
			while(dis.available() != 0 ){
				fileContents += dis.readLine();
			}
			fis.close();
		    bis.close();
		    dis.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		int finalProduct = 0;
		// runs through fileContents and pulls out a substring of 5 characters then sees which substring
		// has the largest product.
		for(int a = 0; a < (fileContents.length() - 5); a++){
			String temp = fileContents.substring(a, a+5);
			int temporary = findProduct(temp);
			if(temporary > finalProduct){
				finalProduct = temporary;
			}
		}
		System.out.println("Largest final product is " + finalProduct);
	}
	// multiplies the 5 characters of a string to get the resulting product
	public static int findProduct(String num){
		int product = 1;
		ArrayList<String> chars = new ArrayList<String>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for(int a = 0; a < 5; a++){
			chars.add(num.substring(a,a+1));
			ints.add(Integer.parseInt(chars.get(a)));
		}
		for(int b = 0; b < ints.size(); b++){
			product *= ints.get(b); 
		}
		return product;
	}
}
