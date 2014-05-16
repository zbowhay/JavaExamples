/* Project Euler Problem 25, What is the first term in the Fibonacci 
 * sequence to contain 1000 digits?
 */

import java.math.BigInteger;
import java.util.*;

public class Euler25 {
	public static void main(String[] args){
		System.out.println("This is going to take a moment!");
		BigInteger limit = BigInteger.valueOf(2);
		BigInteger start = BigInteger.valueOf(1836311903);
		for(int b = 0; b < 3999; b++){
			limit = limit.multiply(BigInteger.valueOf(2));
		}
		BigInteger fNum = BigInteger.valueOf(1);
		BigInteger sNum = BigInteger.valueOf(2);
		BigInteger temp = BigInteger.valueOf(0);
		int countFib = 2;// count must start at 2 for the Fibonacci term to be accurate
		while(checkLimit(start, limit) == false){// check if start is larger than limit
			start = fNum.add(sNum);
			temp = fNum;
			fNum = sNum;
			sNum = sNum.add(temp);
			countFib++;// count fib term currently at
			if(numDigits(fNum) == 1000){// checks for when number of digits is 1000
				System.out.println("Finished!");
				break;
			}
		}
		System.out.println(countFib);
	}
	public static boolean checkLimit(BigInteger start, BigInteger limit){// checks to see if start is larger than limit
		if(start.compareTo(limit) >= 0){
			return true;
		}
		return false;
	}
	public static int numDigits(BigInteger num){// obtains number of digits in param entered (num)
		int digits = 0;
		String numString = num.toString();
		ArrayList<Integer> numInDigits = new ArrayList<Integer>();
		for(int b = 0; b<numString.length(); b++){
			numInDigits.add(Integer.parseInt(numString.substring(b,b+1)));//digits separated
		}
		digits = numInDigits.size();
		return digits;
	}
}
