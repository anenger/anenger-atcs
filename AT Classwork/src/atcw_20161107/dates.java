package atcw_20161107;
import java.util.Date;
import java.util.Scanner;

public class dates {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
		Date now = new Date();				//Create a new Date object for this moment
		System.out.println("The date right now is: " + now.toString());
		System.out.println("Enter a number of days: ");
		int daysFromNow = in.nextInt();				//What we're looking for
		
		
		long seconds = 1000;					//The number of milliseconds in a second
		long minutes = seconds * 60;			//The number of milliseconds in a minute
		long hours = minutes * 60;			//The number of milliseconds in an hour
		long days = hours * 24;				//The number of milliseconds in a day
		long time = days * daysFromNow;		//The number of milliseconds "daysFromNow" days
		
		Date future = new Date(time + now.getTime()); //Create a new Date object for the future
		System.out.println(future.toString());			//Print out the date in the future
		

	}

}
