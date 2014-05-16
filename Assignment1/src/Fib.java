// Problem 3, Fibonacci Numbers
import java.util.*;

public class Fib {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a number for which Fibonnaci Number you are looking for.");
		int choice = userInput.nextInt();
		int Fnum = 1;
		int Snum = 2;
		int Temp = 0;
		int count = 2;
		for(int a = 1; a < Integer.MAX_VALUE; a++){
			count++;
			a = Fnum + Snum;// this line keeps the count of the for loop accurate.
			Temp = Fnum;// next 3 lines update Fnum and Snum to be the two most recent Fibonnacci numbers
			Fnum = Snum;
			Snum += Temp;
			if(count == choice){
				break;
			}
		}
		System.out.println("Fibonnaci number " + choice + " is " + Snum);
	}
}
