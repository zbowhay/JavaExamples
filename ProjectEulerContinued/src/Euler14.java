// Euler 14, Which starting number, under one million, produces the longest chain?

import java.util.LinkedList;

public class Euler14 {
	//couldn't use ArrayList, kept getting a heap space error.... wonder why?
	private static LinkedList<Long> chain = new LinkedList<Long>();;
	public static void main(String[] args){
		long largestChain = 0;
		int chainStart = 0;
		for(int a = 500000; a < 1000000; a++){
			long n = a;
			makeChain(n);
			// if the size of the chain is longer than previous set largestChain to new largest chain
			if(chain.size() > largestChain){
				largestChain = chain.size();
				// set chainStart to a so that we know which number produces the largest chain under 1000000.
				chainStart = a;
			}
			// clear chain so that we can restart with the next number
			chain.clear();
		}
		System.out.println(chainStart + " produces the longest chain: " + largestChain);
	}
	// creates sequence/chain using the equations provided in problem 14.
	public static void makeChain(long n){
		while(n != 1){
			if(n%2 == 0){
				n /= 2;
				chain.add(n);
			}else{
				n = ((n*3) + 1);
				chain.add(n);
			}
		}
	}
}
