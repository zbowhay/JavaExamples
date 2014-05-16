// Main method that will be used to test all the other Geographic classes.
// just runs some tests to make sure the class heigharchy is working properly.

public class ClassDesign{
	public static void main(String[] args){
		Countries test = new Countries();
		test.country = "United States of America";
		System.out.println("Test's country: " + test.getCountry());
		States state = new States("Texas","Austin","America");
		System.out.println(state.getCities());
		Cities city = new Cities("Dallas", 500, true);
		city.setNameOfState("Texas");
		System.out.println(city.getNameOfState());
		Rivers river = new Rivers("America");
		river.addRiver("Rio Grande", 500);
		river.showAllRivers();
		System.out.println(river.getCountry());
	}
}
