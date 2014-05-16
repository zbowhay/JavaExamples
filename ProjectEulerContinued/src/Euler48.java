//Euler 48, Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

import java.math.BigInteger;

public class Euler48 {
	public static void main(String[] args){
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger temp = BigInteger.valueOf(0);
		for(long a = 1; a <= 1000; a++){
			temp = BigInteger.valueOf(a);
			sum = sum.add(temp.pow((int)a));
		}
		System.out.println(sum);
		String lastTen = sum.toString();
		System.out.println("Last Ten Digits: " + lastTen.substring(2991, 3001));
	}
}