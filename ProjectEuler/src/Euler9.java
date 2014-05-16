/* Project Euler Problem 9, Find the only Pythagorean triplet, {a, b, c}, 
 * for which a + b + c = 1000. Then Multiply a, b, and c and give the resulting number.
 */
public class Euler9 {
	public static void main(String[] args){
		int A = 0;
		int B = 0;
		int C = 0;
		for(int a = 1; a <= 1000; a++){
			for(int b = 1; b <= 1000; b++){
				for(int c = 1; c <= 1000; c++){
					if(Squared(a) + Squared(b) == Squared(c)){// checks for Pythagorean triplets
						if(a + b + c == 1000){// checks for the triplet that adds to 1000
							A=a;
							B=b;
							C=c;
							a = 1001;//terminates loop
							b = 1001;
							c = 1001;
						}
					}
					
				}
			}
		}
		System.out.println(A*B*C);
	}
	public static int Squared(int a){// Method for squaring.
		return a *= a;
	}
}
