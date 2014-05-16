// Euler problem 6, Find the difference between the sum of the squares of
// the first one hundred natural numbers and the square of the sum.

public class Euler6 {
	public static void main(String[] args){
		int sumOfSquares = 0;
		for(int a = 1; a <= 100; a++){
			sumOfSquares += Math.pow(a, 2);
		}
		System.out.println("Sum of the squares: " + sumOfSquares);
		int squareOfSums = 0;
		for(int b = 1; b <= 100; b++){
			squareOfSums += b;
		}
		squareOfSums = (int)Math.pow((double)squareOfSums, 2);
		System.out.println("Square of the sum: " + squareOfSums);
		System.out.println("Difference between the two: " +(squareOfSums - sumOfSquares));
	}
}
