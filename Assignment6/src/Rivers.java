/**
 * @author Zac Bowhay
 * Rivers.java extends Countries.java and handles all of the rivers that are within a country
 */
import java.util.ArrayList;

public class Rivers extends Countries{
	// rivers contains all of the rivers
	public ArrayList<String> rivers = new ArrayList<String>();
	// lengths contains the lengths of the rivers, in miles.
	public ArrayList<Integer> lengths = new ArrayList<Integer>();
	/**
	 * Rivers() is the base constructor for Rivers.java
	 */
	public Rivers(){
		super();
		country = super.getCountry();
	}
	/**
	 * Rivers(String cntry) is the overloaded constructor of Rivers.java that allows you to determine
	 * which country these rivers are in
	 * @param cntry name of country that rivers will be in
	 */
	public Rivers(String cntry){
		country = cntry;
	}
	/**
	 * addRiver(String n, int length) will add a river and its repsective length to the appropriate
	 * ArrayList's
	 * @param n name of river
	 * @param length length of river
	 */
	public void addRiver(String n, int length){
		rivers.add(n);
		lengths.add(length);
	}
	/**
	 * removeRiver(String n) will remove the river, n, from rivers if it is there
	 * @param n name of the river to be removed
	 */
	public void removeRiver(String n){
		if(rivers.contains(n)){
			for(int a = 0; a < rivers.size(); a++){
				if(rivers.get(a).equalsIgnoreCase(n)){
					rivers.remove(a);
				}
			}
		}else{
			System.out.println("Could not find river called: " + n);
		}
	}
	/**
	 * getRiverLength(String n) will return the length of the river entered
	 * @param n the name of the river you are looking for
	 * @return the length of the river
	 */
	public int getRiverLength(String n){
		if(rivers.contains(n)){
			for(int a = 0; a < rivers.size(); a++){
				if(rivers.get(a).equalsIgnoreCase(n)){
					return lengths.get(a);
				}
			}
		}else{
			System.out.println("there isn't a river called " + n);
			return 0;
		}
		System.out.println("river not found.");
		return 0;
	}
	/**
	 * showAllRivers() will print out all of the rivers and their lengths.
	 */
	public void showAllRivers(){
		for(int a = 0; a < rivers.size(); a++){
			System.out.println("River: " + rivers.get(a) + ", Length: " + lengths.get(a) + " miles.");
		}
	}
}
