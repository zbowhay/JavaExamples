/* Project Euler Problem 20, Find the sum of digits in 100!
 */

import java.util.*;
import java.math.BigInteger;

public class Euler20 {
	public static void main(String[] args){
		BigInteger factorial = BigInteger.valueOf(100);
		for(int a = 99; a > 0; a--){// calculates 100!
			factorial = factorial.multiply(BigInteger.valueOf(a));
		}
		String digits = factorial.toString();
		ArrayList<Integer> addDigits = new ArrayList<Integer>();
		for(int b = 0; b<digits.length(); b++){
			addDigits.add(Integer.parseInt(digits.substring(b,b+1)));//digits seperated
		}
		int sumDigits = 0;
		for(int c = 0; c < addDigits.size(); c++){// digits added up
			sumDigits += addDigits.get(c);
		}
		System.out.println(sumDigits);
	}
}
