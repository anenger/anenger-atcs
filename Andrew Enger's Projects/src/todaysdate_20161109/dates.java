package todaysdate_20161109;
import java.util.Date;
import java.util.Scanner;

public class dates {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Type the number of days you want from right now: ");
		int daysFromNow = in.nextInt();
		Date now = new Date();
		
		long seconds = 1000;
		long minutes = seconds * 60;
		long hours = minutes * 60;
		long days = hours * 24;
		long newDate = days + daysFromNow;
		Date future = new Date(newDate);
		System.out.println(future);
		
		
	}
}
