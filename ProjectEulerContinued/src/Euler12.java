// Euler 12, What is the value of the first triangle number to have over five hundred divisors?

import java.util.ArrayList;

public class Euler12 {
	private static ArrayList<Long> tri = new ArrayList<Long>();
	public static void main(String[] args){
		initializeTriangleNums(tri);
		System.out.println("May take up to 30 seconds to calculate.");
		// a is set to 370 so that it doesn't take to long to calculate the answer
		for(int a = 370; a < tri.size(); a++){
			if(findNumDivisors(tri.get(a)) >= 500){
				System.out.println("First triangle number with over 500 divisors is " + tri.get(a));
				break;			
			}
		}
	}
	// will return the value of the term, n, for the Triangle number function
	public static long triangleNumber(long n){
		long trinum = 0;
		trinum = (((n+1)*n)/2);
		return trinum;
	}
	// stores the first 10000 triangle terms within an ArrayList<Integer> object
	public static void initializeTriangleNums(ArrayList<Long> list){
		for(int a = 12000; a < 13000; a++){
			list.add(triangleNumber(a));
		}
	}
	// find number of divisors that n has.
	public static int findNumDivisors(long n){
		//divisors is initialized at 1 because n is divisible by itself but the loop wont account for it
		int divisors = 1;
		for(long a = 1; a <= n/2; a++){
			if(n%a == 0){
				divisors++;
			}
		}
		return divisors;
	}
}
