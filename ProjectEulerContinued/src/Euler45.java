import java.util.ArrayList;

// Euler 45, It can be verified that T285 = P165 = H143 = 40755.
// Find the next triangle number that is also pentagonal and hexagonal.
public class Euler45 {
	private static ArrayList<Long> tri, pent, hex;
	public static void main(String[] args){
		// create and initialize everything
		tri = new ArrayList<Long>();
		pent = new ArrayList<Long>();
		hex = new ArrayList<Long>();
		initializeTriangleNums(tri);
		initializePentagonalNums(pent);
		initializeHexagonalNums(hex);
		long answer = 0;
		//set to 45000 to speed up the process.
		// begin searching through tri to find terms that are also in pent and hex
		for(int a = 45000; a < tri.size(); a++){
			// if in pent
			if(pent.contains(tri.get(a))){
				System.out.println("Triangle term: " + a);
				// if in hex
				if(hex.contains(tri.get(a))){
					// set the answer
					answer = tri.get(a);
					break;
				}
			}
		}
		System.out.println("The next triangle number after 40,755 that is also pentagonal and hexagonal");
		System.out.println("is " + answer);
	}
	// will return the value of the term, n, for the Triangle number function
	public static long triangleNumber(long n){
		long trinum = 0;
		trinum = (((n+1)*n)/2);
		return trinum;
	}
	// stores the triangle terms between 6000 & 56000 within an ArrayList<Integer> object
	public static void initializeTriangleNums(ArrayList<Long> list){
		for(int a = 6000; a < 56000; a++){
			list.add(triangleNumber(a));
		}
	}
	// will return the value of the term, n, for the Pentagonal number function
	public static long pentagonalNumber(long n){
		long pentnum = 0;
		pentnum = (((3*n)-1)*n)/2;
		return pentnum;
	}
	// stores the first 50000 pentagonal terms within an ArrayList<Integer> object
	public static void initializePentagonalNums(ArrayList<Long> list){
		for(int a = 0; a < 50000; a++){
			list.add(pentagonalNumber(a));
		}
	}
	// will return the value of the term, n, for the Hexagonal number function
	public static long hexagonalNumber(long n){
		long hexnum = 0;
		hexnum = ((2*n)-1)*n;
		return hexnum;
	}
	// stores the first 50000 hexagonal terms within an ArrayList<Integer> object
	public static void initializeHexagonalNums(ArrayList<Long> list){
		for(int a = 0; a < 50000; a++){
			list.add(hexagonalNumber(a));
		}
	}
}
