//Euler 19, How many Sundays fell on the first of the month during
//the twentieth century (1 Jan 1901 to 31 Dec 2000)?
public class Euler19 {
	private static int year, month, day, daysInMonth, sum, dayOfWeek;
	private static boolean isLeapYear;
	public static void main(String[] args){
		year = 1901;
		month = 1;
		day = 7;
		sum = 0;
		daysInMonth = 30;
		dayOfWeek = 1;
		isLeapYear = false;
		//years
		// this loop will determine if its a leap year
		for(int a = year; a <= 2000; a++){
			if(year%4==0){
	            if(year == 2000){
	                isLeapYear = true;
	            }
	            isLeapYear = true;
	        }else{
	            isLeapYear = false;
	        }
			//months
			// This loop will set the number of days for each month
			for(int b = month; b <= 12; b++){
				if(month==4|month==6|month==9|month==11){
		            daysInMonth = 30;
				}else if(month==2){
		            if(isLeapYear){
		                daysInMonth = 29;
		            }else{
		                daysInMonth = 28;
		            }
		        }else{
		        	daysInMonth = 31;
		        }
				//days
				for(int c = day; c <= daysInMonth; c++){
					// adds up all sundays on first of month
					if(day == 1 && dayOfWeek == 6 /*Sunday*/){
						sum++;
					}
					day++;
					dayOfWeek++;
					// reset day of week
					if(dayOfWeek > 7){
						dayOfWeek = 1;
					}
					// reset the days
					if(day > daysInMonth){
						day = 1;
					}	
				}
				month++;
				// reset the months
				if(month > 12){
					month = 1;
				}
			}
			year++;
		}
		System.out.println("There have been " + sum + " Sundays on the first of the month.");
	}
}
