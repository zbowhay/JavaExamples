/* Project Euler Problem 2, By considering the terms in the Fibonacci sequence whose
 *  values do not exceed four million, find the sum of the even-valued terms.
 */
public class Euler2 {
	public static void main(String[] args){
		int sum = 0;
		int Fnum = 1;
		int Snum = 2;
		int Temp = 0;
		for(int a = 1; a <= 4000000; a++){
			a = Fnum + Snum;// this line keeps the count of the for loop accurate.
			Temp = Fnum;// next 3 lines update Fnum and Snum to be the two most recent Fibonnacci numbers
			Fnum = Snum;
			Snum += Temp;
			if(Snum % 2 == 0){// checks for all of the even Fibonnacci numbers
				sum += Snum;
			}
			sum += 2;// required because at the beginning the first even number is skipped
		}
		System.out.println(sum);
	}
}
