/**
 * @author Zac Bowhay
 * Permutations.java will print out all of the permutations of an arbitrary list entered into the parameters
 * as list.
 */
import java.util.*;

public class Permutations<E> {
	public List<E> List1, List2;
	public int counter = 0;
	/**
	 * Permutations(List<E> list, List<E> list2) will take an arbitrary list (list) and then print
	 * out all of its permutations by moving elements between list and list2
	 * @param list the list of elements that you want the permutations for
	 * @param list2 the empty list you enter that will be used un the process
	 */
	public Permutations(List<E> list, List<E> list2){
		next(list2, list);
		System.out.println("Permutations: " + counter);
	}
	/**
	 * hasNext(List<E> list) will return true if the list size is greater than 1 else its false
	 * @param list arbitrary list that is being checked for its size
	 * @return boolean return true (if list.size() > 1) else return false
	 */
	public boolean hasNext(List<E> list){
		if(list.size() > 1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * next(List<E> l1, List<E> l2) will return all of the permutations of l2.
	 * @param l1 list1 (on first call of next() l1 should be empty)
	 * @param l2 list2 (on first call of next() l2 should be the list of elements that you want permutations for)
	 */
	public void next(List<E> l1, List<E> l2){
		if(hasNext(l2) == false){
			// temp is created to combine l1 and l2 so that the output is clean.
			List<E> temp = new ArrayList<E>();
			// populate temp with l1
			for(int d = 0; d < l1.size(); d++){
				temp.add(l1.get(d));
			}
			// populate temp with l2
			for(int e = 0; e < l2.size(); e++){
				temp.add(l2.get(e));
			}
			// display permutation
			System.out.println(temp);
			// counts number permutations
			counter++;
		}else{
			for(int a = 0; a < l2.size(); a++){
				List<E> joe = new ArrayList<E>();
				// populate joe with l2
				for(int b = 0; b < l2.size(); b++){
					joe.add(l2.get(b));
				}
				List<E> bob = new ArrayList<E>();
				// populate bob with l1
				for(int c = 0; c < l1.size(); c++){
					bob.add(l1.get(c));
				}
				// get element a from joe and put in bob
				bob.add(joe.get(a));
				// remove same element from joe
				joe.remove(a);
				// recurse
				next(bob, joe);
			}
		}
	}
}