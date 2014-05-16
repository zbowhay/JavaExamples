
import java.math.BigInteger;

public class Euler10 {
	public static void main(String[] args){
		BigInteger sum = BigInteger.valueOf(3709507115);
		for(int a = 300000; a <= 2000000; a++){
			//System.out.println(a);
			if(isPrime(a))
				sum = sum.add(BigInteger.valueOf(a));
		}
		System.out.println(sum);
	}
	
	public static boolean isPrime(int num){
		boolean prime = true;
		double dubNum = num;
		int halfNum = num/2;
		if(num < 3 && num > 0){
			return true;
		}
		for(double a = halfNum; a > 1; a--){
			//System.out.println(dubNum%a + " remainder");
			//System.out.println(a + " A");
			if(dubNum%a == 0){
				prime = false;
				break;
			}
		}
		return prime;
	}
}
