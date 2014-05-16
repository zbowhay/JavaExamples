
import java.util.*;

public class TestPermutations {
	public static ArrayList<Integer> list, other;
	public static void main(String[] args){
		list = new ArrayList<Integer>();
		other = new ArrayList<Integer>();
		for(int a = 0; a <= 4; a++){
			list.add(a);
		}
		Permutations<Integer> test = new Permutations<Integer>(list, other);
	}
}
