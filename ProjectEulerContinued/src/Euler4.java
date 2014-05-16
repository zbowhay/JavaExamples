// Euler 4, Find the largest palindrome made from the product of two 3-digit numbers.

import java.util.ArrayList;

public class Euler4 {
	public static void main(String[] args){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int firstNum = 900;
		int secondNum = 900;
		for(int a = 1; a <= 99; a++){
			firstNum++;
			for(int b = 1; b <= 99; b++){
				secondNum++;
				int temp = firstNum*secondNum;
				nums.add(temp);
			}
			secondNum = 900;
		}
		ArrayList<Integer> palindromeNums = new ArrayList<Integer>();
		for(int c = 0; c < nums.size(); c++){
			if(isPalindrome(nums.get(c))){
				palindromeNums.add(nums.get(c));
			}
		}
		System.out.println(largestValue(palindromeNums));
	}
	
	public static boolean isPalindrome(int num){
		String s = "" + num;
		int n = s.length();
		for(int a = 0; a <= (n/2); a++){
			if(s.charAt(a) != s.charAt(n-a-1)){
				return false;
		    }
		}
		return true;
	}
	
	public static int largestValue(ArrayList<Integer> ints){
		int largest = ints.get(0);
		int temp = 0;
		for(int a = 0; a < ints.size(); a++){
			temp = ints.get(a);
			if(temp > largest){
				largest = ints.get(a);
			}
		}
		return largest;
	}
}
