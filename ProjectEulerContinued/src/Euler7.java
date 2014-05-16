// Euler 7, What is the 10,001st prime number?

public class Euler7 {
	public static void main(String[] args){
		int numPrimes = 0;
		for(int a = 3; a < Integer.MAX_VALUE; a++){
			if(isPrime(a)){
				numPrimes++;
			}
			if(numPrimes == 10001){
				System.out.println("The 10,001st prime is: " + a);
				break;
			}
		}
	}
	
	public static boolean isPrime(int num){
		if(num <= 2 && num >= 1){
			return true;
		}
		for(int a = 2; a < (num/2); a++){
			if(num%a == 0){
				return false;
			}
		}
		return true;
	}
}
