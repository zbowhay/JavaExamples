/**s
 * @author Zac Bowhay
 * Cities.java inherits from States.java and handles all aspects of a city as a geographical element
 * Created November 23, 2012.
 */
import java.util.ArrayList;

public class Cities extends States{
	// perCapita represents the per capita of the city
	public int perCapita;
	// isCapital represents whether or not the Cities object is a capital of a state or country
	public boolean isCapital;
	// nameOfCity represents the name of the city
	public String nameOfCity;
	/**
	 * Cities() is the base constructor for the class Cities.java
	 */
	public Cities(){
		nameOfCity = "City";
		area = 0;
		country = "";
		boundaryLength = 0;
		neighbors = new ArrayList<String>();
		attractions = new ArrayList<String>();
		perCapita = 0;
		isCapital = false;
	}
	/**
	 * Cities(String cityName, int pC, boolean capital) is the overloaded contructor for Cities.java that allows 
	 * for a user to specify the per capita of the city, the name of the city, and if it is a capital of a state or country.
	 * @param cityName represents the name of the city.
	 * @param pC represents the per capita income of the city
	 * @param capital represents if this city is a capital of a state or country.
	 */
	public Cities(String cityName, int pC, boolean capital){
		nameOfCity = cityName;
		area = 0;
		country = "";
		boundaryLength = 0;
		neighbors = new ArrayList<String>();
		attractions = new ArrayList<String>();
		perCapita = pC;
		isCapital = capital;
	}
	/**
	 * setPerCapita(int n) allows a user to specify the per capita of the city
	 * @param n the new per capita of the city
	 */
	public void setPerCapita(int n){
		perCapita = n;
	}
	/**
	 * setCapital(boolean amI) allows a user to determine if the city is a capital or not
	 * @param amI the boolean that is entered by the user that will become the value of isCapital
	 */
	public void setCapital(boolean amI){
		isCapital = amI;
	}
	/**
	 * getCityName() returns the name of the city
	 * @return returns the name of the city
	 */
	public String getCityName(){
		return nameOfCity;
	}
	/**
	 * getNameOfState() returns the name of the state that the city is in
	 * @return returns the name of state.
	 */
	public String getNameOfState(){
		return super.nameOfState;
	}
	/**
	 * setNameOfState(String n) will change the name of the state that the city is in to n.
	 * @param n represents the new name of the state that the city is in
	 */
	public void setNameOfState(String n){
		super.nameOfState = n;
	}
}
