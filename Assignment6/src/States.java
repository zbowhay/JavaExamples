/**
 * @author Zac Bowhay
 * States.java is a class that extends Countries and allows for the handling of seperate States
 * a country might possess.
 */
import java.util.ArrayList;

public class States extends Countries implements BoundarySegments{
	// attractions will contain all of the major attractions that a state contains.
	public ArrayList<String> attractions = new ArrayList<String>();
	public String nameOfState;
	/**
	 * States() is base constructor for the class States.
	 */
	public States(){
		capital = "";
		cities = new ArrayList<String>();
		neighbors = new ArrayList<String>();
		country = super.country;
		area = 0;
		boundaryLength = 0;
		setNeighbors(neighbors);
		nameOfState = "";
	}
	/**
	 * States(String name, String cap, String cntry) is an overloaded constructor that allows you to enter the 
	 * capital of the state, the name of the state, and the country it is in.
	 * @param cap String that will be set as the capital of the state
	 * @param cntry String that will be set as the country the state resides in
	 */
	public States(String name, String cap, String cntry){
		capital = cap;
		cities = new ArrayList<String>();
		cities.add(cap);
		neighbors = new ArrayList<String>();
		country = cntry;
		area = 0;
		boundaryLength = 0;
		setNeighbors(neighbors);
		nameOfState = name;
	}
	/**
	 * addAttraction(String attract) will add attract to the ArrayList<String> attractions
	 * @param attract the String that will be added to attractions
	 */
	public void addAttraction(String attract){
		attractions.add(attract);
	}
	/**
	 * removeAttraction(String attract) will remove the element that resembles attract from 
	 * attractions if it is in there.
	 * @param attract String that represents the attraction to be removed 
	 */
	public void removeAttraction(String attract){
		if(attractions.contains(attract)){
			for(int a = 0; a <  attractions.size(); a++){
				if(attractions.get(a).equalsIgnoreCase(attract))
					attractions.remove(a);
				break;
			}
			System.out.println(attract + " has been removed.");
		}else{
			System.out.println(attract + " is not in attractions.");
		}
	}
	/**
	 * getAttractions() will return the ArrayList<String>, attractions, which contains all of the states attractions.
	 * @return returns the ArrayList<String>, attractions, that contains all of the states attractions
	 */
	public ArrayList<String> getAttractions(){
		return attractions;
	}
	/**
	 * setNeighbors(ArrayList<String> neighs) will update neighbors to neighs
	 * @param neighs is the ArrayList<String> that neighbors will be updated to
	 */
	public void setNeighbors(ArrayList<String> neighs){
		while(neighbors.size() >= 1){
			neighbors.remove(0);
		}
		for(int a = 0; a < neighs.size(); a++){
			neighbors.add(neighs.get(a));
		}
	}
}
