import java.util.*;

class Test{
	public static void main(String[] args){
		System.out.println("Hello");
		for(int a = 0; a <= 10; a++){
			if(a == 10){
				System.out.println(a + ".");
			}else{
				System.out.print(a + ", ");
			}
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Please type something, then press enter.");
		String Input = in.nextLine();
		System.out.println("User entered: " + Input);
	}
}
	