// Problem 4, Investigations into Pi
import java.util.*;

public class Gregory {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a number, k, for which you want to calculate Pi by using the Gregory series.");
		int kCount = userInput.nextInt();
		double gregPi = 0;
		for(int a = 0; a < kCount; a++){
			gregPi += ((Math.pow(-1,(a + 1)))/((2*a)+1));//Gregory Series
		}
		gregPi *= -1;
		gregPi *= 4;
		double percentDifference = 0;
		percentDifference = ((Math.PI - gregPi)/Math.PI) * 100;
		System.out.println("Pi according to Gregory series: " + gregPi);
		System.out.println("This differs from Java's value by " + percentDifference + " percent.");
	}
}
