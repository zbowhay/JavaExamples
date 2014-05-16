/* Problem 4, Root finding.
 */
public class FunctionTest{
	public static void main(String[] args){
		System.out.println(findRoot(3,4,.00000001));
	}
	
	//public double evaluate(double x){
		//return Math.sin(x);
	//}
	// for this part i wasnt sure if i should leave all of this commented so that you know it was
	// used to help create the evaluate method and be able to extend Function
	
	public static double findRoot(double a, double b, double epsilon){
		double x = 0;
		x = ((a+b)/2);
		if(Math.abs(a-x) < epsilon){
			return x;
		}else if(isNegative(Math.sin(a)) == isNegative(Math.sin(x))){//checks if f(x) is the same sign as f(a).
			return findRoot(x,b,epsilon);
		}else{// means f(x) is not the same sign as f(a).
			return findRoot(a,x,epsilon);
		}
	}
	public static boolean isNegative(double a){//checks whether or not a double is negative.
		boolean neg = true;
		if(a >= 0){
			neg = false;
		}
		return neg;
	}
}
