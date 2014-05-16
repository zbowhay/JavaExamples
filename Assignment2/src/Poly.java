// Problem 5, Polynomials

public class Poly {
	public int[] test;// will hold all of the coefficients
	
	public static void main(String[] args){
		int[] check = {4,0,-8,0,3,2};
		int[] doubleCheck = {0,-2,4,1};
		Poly who = new Poly(doubleCheck);
		Poly what = new Poly(check);
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
	
	public Poly(int[] coefficients){// will store an array within the array test[]
		test = new int[coefficients.length];
		for(int a = 0; a < coefficients.length; a++){
			test[a] = coefficients[a];
		}
	}
	
	public Poly add(Poly a){
		Poly addedPoly = new Poly(test);
		
		if(a.test.length > this.test.length){// when the param's coefficient array is larger, then do this..
			Poly tempPoly = new Poly(a.test);
			addedPoly = tempPoly;
			int[] temp = new int[a.test.length];// is going to replace this.test and increase its size to be equal to a.test.length for adding
			for(int c = 0; c < a.test.length; c++){// creates the new temp[] array
				if(c < this.test.length){// when this's coefficient array's length is reached this if statement will cease to prevent indexoutofbounds error
					temp[c] = this.test[c];
				}else{
					temp[c] = 0;
				}
			}
			for(int b = (a.test.length - 1); b > 0; b--){// adds the Polys
				addedPoly.test[b] = (a.test[b] + temp[b]);
			}
			
		}else if(a.test.length < this.test.length){// when the param's coefficient array is smaller, then do this..
			Poly otherTempPoly = new Poly(this.test);
			addedPoly = otherTempPoly;
			int[] otherTemp = new int[this.test.length];
			for(int d = 0; d < this.test.length; d++){// creates the new otherTemp[] array
				if(d < a.test.length){// when the length of param's coefficient array is reached this if statement will cease so their isn't an indexoutofbounds error
					otherTemp[d] = a.test[d];
				}else{
					otherTemp[d] = 0;
				}
			}
			for(int e = (this.test.length - 1); e > 0; e--){// adds the Polys
				addedPoly.test[e] = (this.test[e] + otherTemp[e]);
			}
		}
		return addedPoly;
	}
	
	public double evaluate(double x){
		double answer = 0;
		for(int a = this.test.length - 1; a >= 0; a--){// begins evaluating equation from left to right.
			answer += ((Math.pow(x, a))*this.test[a]);
		}
		return answer;
	}
	
	public int degree(){
		int power = 0;
		power = test.length - 1;// sets power to highest possible according to test array length
		if(test[test.length - 1] == 0){//if the coefficient for the highest element is 0 then..
			for(int a = test.length - 1; a > 0; a--){// runs through test[]
				if(test[a] != 0){//until if finds the first coefficient that isn't 0
					power = a;// and sets the power to that elements position-1
					break;
				}
			}
		}
		return power;
	}
	
	public String toString(){
		String polyString = "";
		String xPower = "x^";
		int loop = 0;// counts the number of times the loop has ran
		for(int a = (test.length - 1); a >= 0; a--){
			loop++;
			if(test[a] != 0 && loop == 1){// if first loop and coefficient isn't 0
				polyString += test[a] + xPower + a;// creates string for that element
			}
			if(test[a] != 0 && loop > 1 && loop < test.length){// if coefficient isn't 0 and loop is less than length of coefficent array(test[])
				if(test[a] >= 0){// checks if coefficient is positive
					polyString += " +" + test[a] + xPower + a;
				}
				if(test[a] < 0){//checks if coefficient is negative
					polyString += " " +test[a] + xPower + a;
				}
			}
			if(test[a] != 0 && loop == test.length){// if coefficient isn't 0 and its the last element in the array
				if(test[a] >= 0){//if positive
					polyString += " +" + test[a];
				}
				if(test[a] < 0){//if negative
					polyString += " " + test[a];
				}
			}
		}
		return polyString;
	}
}
