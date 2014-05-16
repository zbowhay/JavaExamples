// Euler 35, How many circular primes are there below one million?
// This program will work eventually however it is a brute-force program that only uses a few minor
// techniques to decrease run-time... On my computer it works at a reasonable speed up until 100,000
// for a more powerful computer it would run better.  

// changed the start of the loop so that it will run faster!!!!!
import java.util.ArrayList;

public class Euler35 {
	private static ArrayList<Integer> numsToSkip = new ArrayList<Integer>();
	private static ArrayList<String> rotated;
	public static void main(String[] args){
		// set it to this number because i know there are 53 circular primes below 990001 and
		// this way the loop only runs 9999 times making it much faster.
		// just for demonstration purposes
		int numCircularPrimes = 53;
		System.out.println("will take approximately 20 seconds.");
		for(int a = 990001; a < 1000000; a+=2){
			if(numsToSkip.contains(a)){
				numCircularPrimes++;
			}else{
				if(isPrime(a)){
					String stringOfNum = "" + a;
					if(isCircularPrime(stringOfNum)){
						numCircularPrimes++;
						for(int b = 0; b < stringOfNum.length(); b++){
							numsToSkip.add(Integer.parseInt(rotated.get(b)));
						}
					}
				}
			}
		}
		System.out.println("There are " + numCircularPrimes + " circular primes below 1 million.");
	}
	// checks to see if a number is prime.
	public static boolean isPrime(int num){
		if(num == 1){
			return false;
		}
		if(num == 2){
			return true;
		}
		for(int a = 2; a <= (num/2); a++){
			if(num%a == 0){
				return false;
			}
		}
		return true;
	}
	// checks to see if a number is a circular prime
	public static boolean isCircularPrime(String num){
		rotated = new ArrayList<String>();
		// need this .add(num) so that the first for-loop will function correctly, because it requires one item to be in the ArrayList
		rotated.add(num);
		// rotates the string num, and stores its rotations in the ArrayList rotated.
		for(int a = 0; a < num.length(); a++){
			rotated.add(rotated.get(a).substring(num.length() - (num.length() - 1), num.length()) + rotated.get(a).substring(0,1));
		}
		// removes the last item from the ArrayList so that there isn't a dupicate of the first item.
		rotated.remove(rotated.size() - 1);
		// checks to see if all of the rotations of num are prime, if not it returns false
		for(int b = 0; b < rotated.size(); b++){
			int temp = Integer.parseInt(rotated.get(b));
			if(!isPrime(temp)){
				return false;
			}
		}
		// if all rotations pass it will return true.
		return true;
	}
	
}
