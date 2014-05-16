//Problem 2, Fibonacci Revisited
public class FibTest {
	public static void main(String[] args){
		if(fibRecur(5) != 8){
			System.out.println("fibRecur(5) didn't return 8.");
			System.exit(0);
		}
		if(fibIter(5) != 8){
			System.out.println("fibIter(5) didn't return 8.");
			System.exit(0);
		}
		long startR = System.currentTimeMillis();
		long startI = System.currentTimeMillis();
		fibRecur(10);
		long finishR = System.currentTimeMillis() - startR;
		fibIter(10);
		long finishI = System.currentTimeMillis() - startI;
		System.out.println("Time to finish fibRecur(10): " + finishR + " milliseconds.");
		System.out.println("Time to finish fibIter(10): " + finishI + " milliseconds.");
	}

	public static int fibIter(int n){
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
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
			if(count == n){
				break;
			}
		}
		return Snum;
	}
	
	public static int fibRecur(int n){
		if(n <= 2){//base case
			return n;
		}
		return fibRecur(n-1) + fibRecur(n-2);
	}
}
