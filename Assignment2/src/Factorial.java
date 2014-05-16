//Problem 1, Recursion.
public class Factorial {
	public static void main(String[] args){
		int test =  calculate(5);
		System.out.println(test);
	}
	public static int calculate(int n){
		if(n == 0){
			return 1;
		}
		if(n > 12){
			System.out.println("arguments over 12 will not be processed.");
			return 0;
		}
		int answer = n;
		int temp = n-1;
		int num = n;
		for(int a = n; a > 0; a--){
			if(a == n){
				answer = num * temp;
				a = temp-1;
			}
			if(a != n){
				answer *= a;
			}
		}
		return answer;
	}
}