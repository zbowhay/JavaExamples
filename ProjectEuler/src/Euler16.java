/* Project Euler Problem 16, What is the sum of the digits of the number 21000?
 */

import java.math.BigInteger;
import java.util.*;

public class Euler16 {
	public static void main(String[] args){		
		BigInteger sum = BigInteger.valueOf(2);
		for(int a = 0; a < 999; a++){
			sum = sum.multiply(BigInteger.valueOf(2));// this calculates 2^1000
		}
		String numString = sum.toString();// 2^1000 converted to string
		ArrayList<Integer> addDigits = new ArrayList<Integer>();
		for(int b = 0; b<numString.length(); b++){
			addDigits.add(Integer.parseInt(numString.substring(b,b+1)));//digits seperated
		}
		int addedDigits = 0;
		for(int c = 0; c < addDigits.size(); c++){
			addedDigits += addDigits.get(c);//digits added
		}
		System.out.println(addedDigits);
	}	
}
