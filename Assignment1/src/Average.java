// Problem 2, Statistics.
import java.util.*;

public class Average {
	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a series of numbers.  Enter an negative number to quit.");
		boolean finished = false;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(!finished){
			nums.add(userInput.nextInt());
			if(nums.get(nums.size() - 1) < 0){//ends the while loop when user enters negative number
				finished = true;
			}
		}
		int sum = 0;
		double average = 0;
		for(int a = 0; a < nums.size() - 1; a++){
			sum += nums.get(a);
			average = (double)sum;
			average /= (nums.size() - 1);// computes average
			
		}
		System.out.println("You entered " + (nums.size() - 1) + " numbers averaging " + average);
	}
}
