//Problem 6, Inheritance
/**
 * Function Abstract Class
 * Created on September 16, 2012
 * @author Zac R Bowhay 
 */
public abstract class Function {
	public static void main(String[] args){
		//Function testFuncTest = new FunctionTest();
		Function testSin = new SinFunc();
		Function testCos = new CosFunc();
		int[] check = {-3,0,1};
		int[] doubleCheck = {-2,1,1};
		Function testPoly = new PolyFunc(check);
		Function testPolyAgain = new PolyFunc(doubleCheck);
		/*if(testFuncTest.findRoot(3,4,.00000001) == 3.1415926590561867){
			System.out.println("TestFunc findRoot passed.");
		}else{
			System.out.println("TestFunc findRoot failed.");
		}*/
		if(testSin.findRoot(3,4,.00000001) == 3.1415926590561867){
			System.out.println("SinFunc findRoot passed.");
		}else{
			System.out.println("SinFunc findRoot failed.");
		}
		if(testCos.findRoot(1,3,.00000001) == 1.5707963332533836){
			System.out.println("CosFunc findRoot passed.");
		}else{
			System.out.println("CosFunc findRoot failed.");
		}
		if((testPoly.findRoot(0,4,.00000001) == 1.7320508137345314) && (testPolyAgain.findRoot(0,4,.00000001) == 0.9999999925494194)){
			System.out.println("PolyFunc findRoot passed twice.");
		}else{
			System.out.println("PolyFunc findRoot failed.");
		}
	}
	
	/**
	 * Abstract Method Evaluate
	 * @param x a double that will be evaluated according to which evaluate is called
	 * @return returns evaluated x
	 */
	public abstract double evaluate(double x);
	
	/**
	 * findRoot is used to find the roots of different functions between two limits.
	 * @param a the first limit ex: (A,b)
	 * @param b the second limit ex: (a,B)
	 * @param epsilon the smaller epsilon is, the more accurate the answer will be
	 * @return returns the root.
	 */
	public double findRoot(double a, double b, double epsilon){
		double x = 0;
		x = ((a+b)/2);
		if(Math.abs(a-x) < epsilon){
			return x;
		}else if(evaluate(a) >=0 && evaluate(x) >= 0 /*isNegative(evaluate(x))*/){//checks if f(x) is the same sign as f(a).
			return findRoot(x,b,epsilon);
		}else{// means f(x) is not the same sign as f(a).
			return findRoot(a,x,epsilon);
		}
	}
}