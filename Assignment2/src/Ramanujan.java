/* Problem 3, Pi revisited.
 * cannot enter any number over 1 because i did not use BigInteger or BigDouble.
 */
import java.util.Scanner;

public class Ramanujan {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a number, k, for which you want to calculate Pi by using the Ramanujan series.");
		System.out.println("Have to enter 1 for decimal answer, else it will be infinity.");
		int kCount = userInput.nextInt();
		double ramPi = 0;
		for(int a = 0; a < kCount; a++){
			ramPi += (Factorial.calculate(4*a)*(1103 + (26390*a)))/(Math.pow(Factorial.calculate(a), 4)*Math.pow(396,(4*a)));
		}
		ramPi *= ((2*Math.sqrt(2))/9801);
		ramPi *= Math.pow(Math.PI, 2);
		double percentDifference = 0;
		percentDifference = ((Math.PI - ramPi)/Math.PI) * 100;
		System.out.println("Pi according to Ramanujan series: " + ramPi);
		System.out.println("This differs from Java's value by " + percentDifference + " percent.");
	}
}
