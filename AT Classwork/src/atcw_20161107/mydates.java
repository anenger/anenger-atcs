package atcw_20161107;
import java.util.Date;
import java.util.Scanner;

public class mydates {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		Date now = new Date();
		System.out.println("The current date is " + now.toString());
		System.out.println("Type the number of days you want from right now: ");
		int daysFromNow = in.nextInt();
		
	
		long seconds = 1000;
		long minutes = seconds * 60;
		long hours = minutes * 60;
		long days = hours * 24;
		long time = days * daysFromNow;
		Date future = new Date(time + now.getTime());
		System.out.println(future);
	
	}
}
