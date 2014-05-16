//Euler 3, Find the largest prime factor of 600851475143.

import java.util.ArrayList;

public class Euler3 {
	public static void main(String[] args){
		ArrayList<Long> factors = new ArrayList<Long>();
		Long num = new Long("600851475143");
		getFactors(factors,num);
		System.out.println(factors);
		if(isPrime(factors.get(3))){
			System.out.println("Largest Prime Factor Is: " + factors.get(3));
		}
		
	}
	
	public static void getFactors(ArrayList<Long> factors, Long num){
		long n = num.longValue();
		for(long a = 2; a*a <= n; a++){
			if(num%a == 0){
				factors.add(a);
				num = (num/a);
			}
		}
	}
	
	public static boolean isPrime(long num){
		if(num == 1){
			return false;
		}
		if(num == 2){
			return true;
		}
		for(long a = 2; a <= (num/2); a++){
			if(num%a == 0){
				return false;
			}
		}
		return true;
	}
}
