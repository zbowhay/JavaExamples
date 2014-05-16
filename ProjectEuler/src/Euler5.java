/* Project Euler Problem 5, What is the smallest number divisible
 *  by each of the numbers 1 to 20?
 */
public class Euler5 {
	public static void main(String[] args){
		boolean done = false;
		boolean temp = false;
		int count = 232000000;// set to this high number just to make the process quicker
		while(done == false){
			count++;
			for(int a = 1; a <= 20; a++){
				if(count % a == 0){// checks that count is divisble by every number between 1 and 20
					temp = true;
				}else{
					temp = false;
					a = 21;// when count is not divisible the for loop terminates
				}
			}
			if(temp){// everything checked out
				System.out.println(count);
				done = true;
				
			}
		}
	}
}
