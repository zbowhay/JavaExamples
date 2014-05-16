/**
 * @author Zac Bowhay
 * Countries.java is a super class that handles some geographic elements
 * Created on November 23, 2012  
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Countries implements BoundarySegments{
	// ints that represent the area of the country and the length of its boundary
	public int area, boundaryLength;
	// Strings that represent the capital of the country and the name of the country
	public String capital, country;
	// ArrayList<String> that contain all of the cities in the country and the country's neighbors
	public ArrayList<String> cities, neighbors;
	/**
	 * Countries() is the base constructor for Countries class
	 */
	public Countries(){
		area = 0;
		boundaryLength = 0;
		cities = new ArrayList<String>();
		neighbors = new ArrayList<String>();
		setNeighbors(neighbors);
		capital = "";
		country = "";
	}
	/**
	 * Countries(String name, int a, int l) is the overloaded constructor of Countries.java it allows you
	 * to specify a name for the country and its area
	 * @param name the name of the country
	 * @param a the country's area
	 * @param l the country's boundary length
	 */
	public Countries(String name, int a, int l){
		area = a;
		boundaryLength = l;
		cities = new ArrayList<String>();
		neighbors = new ArrayList<String>();
		setNeighbors(neighbors);
		capital = "";
		country = name;
	}
	/**
	 * area() returns the int, area.
	 * @return area is the int that represents the area of the country
	 */
	public int area(){
		return area;
	}
	/**
	 * boundaryLength() returns the int, boundaryLength
	 * @return boundaryLength is the int that represents the length of the country's boundary
	 */
	public int boundaryLength(){
		return boundaryLength;
	}
	/**
	 * getCities() returns an ArrayList<String> that contains all of the cities in a country
	 * @return cities is the ArrayList<String> that contains all of the cities in a country
	 */
	public ArrayList<String> getCities(){
		return cities;		
	}
	/**
	 * getCountry() returns a String, country.
	 * @return country is the String that represents the name of the country.
	 */
	public String getCountry(){
		return country;
	}
	/**
	 * capital() returns a String, capital.
	 * @return capital is a String that represents the capital of the country
	 */
	public String capital(){
		return capital;
	}
	/**
	 * neighbors() returns an ArrayList<String>, neighbors.
	 * @return neighbors is an ArrayList<String> that contains all of the country's neighbors
	 */
	public ArrayList<String> neighbors(){
		return neighbors;
	}
	/**
	 * distance(String city1, String city2) will an int representing the distance between city1 and city2
	 * @param city1 the first city name entered
	 * @param city2 the second city name entered
	 * @return returns an int that represents the distance between city1 and city2
	 */
	public int distance(String city1, String city2){
		//This method would obtain the locations of city1 and city2 then return the distance between
		// the two cities.
		return 0;
	}
	/**
	 * setBoundaryLength() sets boundaryLength to n
	 */
	public void setBoundaryLength(){
		Scanner in = new Scanner(System.in);
		System.out.println("What would you like the boundary length to be?(int)");
		int n = in.nextInt();
		boundaryLength = n;
	}
	/**
	 * setNeighbors(ArrayList<String> neighs) will update neighbors to neighs
	 * @param neighs the new neighbors that will be in neighbors.
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
