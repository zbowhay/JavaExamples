/**
 * PolyFunc class extends Function, This class is used for generating and evaluating polynomials as well as finding their roots.
 * @author Zac R Bowhay
 * Created on September 16, 2012
 */
public class PolyFunc extends Function{
	public int[] coNums;// will hold all of the coefficients
	public static void main(String[] args){
		int[] check = {4,0,-8,0,3,2};
		int[] doubleCheck = {0,-2,4,1};
		PolyFunc who = new PolyFunc(doubleCheck);
		PolyFunc what = new PolyFunc(check);
		String testWhat = "2x^5 +3x^4 -8x^2 +4";
		String testWho = "1x^3 +4x^2 -2x^1";
		String testAdd = "2x^5 +3x^4 +1x^3 -4x^2 -2x^1 +4";
		double testEvaluate = 84.0;
		//Check to make sure methods are working correctly
		if(what.degree() == 5){
			System.out.println("Degree passed.");
		}else{
			System.out.println("Degree failed.");
		}
		if(what.evaluate(2) == testEvaluate){
			System.out.println("Evaluate passed.");
		}else{
			System.out.println("Evaluate failed.");
		}
		if(testAdd.compareTo(what.add(who).toString()) == 0){
			System.out.println("Add passed.");
		}else{
			System.out.println("Add failed.");
		}
		if(testWhat.compareTo(what.toString()) == 0 && testWho.compareTo(who.toString()) == 0){
			System.out.println("toString passed.");
		}else{
			System.out.println("toString failed.");
		}
	}
	
	/**
	 * PolyFunc(int[] coefficients) is the constructor method for PolyFunc class
	 * @param coefficients the array of coefficents that will be entered to generate a polynomial
	 */
	public PolyFunc(int[] coefficients){// will store an array within the array test[]
		coNums = new int[coefficients.length];
		for(int a = 0; a < coefficients.length; a++){
			coNums[a] = coefficients[a];
		}
	}
	
	/**
	 * add method is used to add to polynomials together
	 * @param a a is the PolyFunc object that will be added to this PolyFunc object
	 * @return returns the new PolyFunc object that is the result of adding the two other polynomials
	 */
	public PolyFunc add(PolyFunc a){
		PolyFunc addedPoly = new PolyFunc(coNums);
		
		if(a.coNums.length > this.coNums.length){// when the param's coefficient array is larger, then do this..
			PolyFunc tempPoly = new PolyFunc(a.coNums);
			addedPoly = tempPoly;
			int[] temp = new int[a.coNums.length];// is going to replace this.test and increase its size to be equal to a.test.length for adding
			for(int c = 0; c < a.coNums.length; c++){// creates the new coNums[] array
				if(c < this.coNums.length){// when this's coefficient array's length is reached this if statement will cease to prevent indexoutofbounds error
					temp[c] = this.coNums[c];
				}else{
					temp[c] = 0;
				}
			}
			for(int b = (a.coNums.length - 1); b > 0; b--){// adds the Polys
				addedPoly.coNums[b] = (a.coNums[b] + temp[b]);
			}
			
		}else if(a.coNums.length < this.coNums.length){// when the param's coefficient array is smaller, then do this..
			PolyFunc otherTempPoly = new PolyFunc(this.coNums);
			addedPoly = otherTempPoly;
			int[] otherTemp = new int[this.coNums.length];
			for(int d = 0; d < this.coNums.length; d++){// creates the new otherTemp[] array
				if(d < a.coNums.length){// when the length of param's coefficient array is reached this if statement will cease so their isn't an indexoutofbounds error
					otherTemp[d] = a.coNums[d];
				}else{
					otherTemp[d] = 0;
				}
			}
			for(int e = (this.coNums.length - 1); e > 0; e--){// adds the Polys
				addedPoly.coNums[e] = (this.coNums[e] + otherTemp[e]);
			}
		}
		return addedPoly;
	}
	
	/**
	 * evaluate method is used to evaluate polynomials at x
	 * @param x is the number that the polynomial will be evaluated with
	 * @return returns the answer
	 */
	public double evaluate(double x){
		double answer = 0;
		for(int a = this.coNums.length - 1; a >= 0; a--){// begins evaluating equation from left to right.
			answer += ((Math.pow(x, a))*this.coNums[a]);
		}
		return answer;
	}
	
	/**
	 * findRoot method is used to find the root of a polynomial between two limits.
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
		}else if((evaluate(a) >=0 && evaluate(x) >= 0)||(evaluate(a) < 0 && evaluate(x) < 0) /*isNegative(evaluate(x))*/){//checks if f(x) is the same sign as f(a).
			return findRoot(x,b,epsilon);
		}else{// means f(x) is not the same sign as f(a).
			return findRoot(a,x,epsilon);
		}
	}
	
	/**
	 * degree method returns the highest degree of the polynomial
	 * @return the degree of the polynomial
	 */
	public int degree(){
		int power = 0;
		power = coNums.length - 1;// sets power to highest possible according to test array length
		if(coNums[coNums.length - 1] == 0){//if the coefficient for the highest element is 0 then..
			for(int a = coNums.length - 1; a > 0; a--){// runs through test[]
				if(coNums[a] != 0){//until if finds the first coefficient that isn't 0
					power = a;// and sets the power to that elements position-1
					break;
				}
			}
		}
		return power;
	}
	
	/**
	 * toString method returns the string of the polynomial
	 * @return returns the String of the polynomial.
	 */
	public String toString(){
		String polyString = "";
		String xPower = "x^";
		int loop = 0;// counts the number of times the loop has ran
		for(int a = (coNums.length - 1); a >= 0; a--){
			loop++;
			if(coNums[a] != 0 && loop == 1){// if first loop and coefficient isn't 0
				polyString += coNums[a] + xPower + a;// creates string for that element
			}
			if(coNums[a] != 0 && loop > 1 && loop < coNums.length){// if coefficient isn't 0 and loop is less than length of coefficent array(test[])
				if(coNums[a] >= 0){// checks if coefficient is positive
					polyString += " +" + coNums[a] + xPower + a;
				}
				if(coNums[a] < 0){//checks if coefficient is negative
					polyString += " " +coNums[a] + xPower + a;
				}
			}
			if(coNums[a] != 0 && loop == coNums.length){// if coefficient isn't 0 and its the last element in the array
				if(coNums[a] >= 0){//if positive
					polyString += " +" + coNums[a];
				}
				if(coNums[a] < 0){//if negative
					polyString += " " + coNums[a];
				}
			}
		}
		return polyString;
	}
	
}
