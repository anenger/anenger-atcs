package hailstone_20161007;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		System.out.println("Type the number you want to put into the hailstone sequence: ");
		//Scanner input = new Scanner(System.in);
		int value = 0;
		int counter = 0;
		for (int x = 1; x < 1000; x++){
		value = x;
		while (value != 1){
			if (value % 2 == 0){
				value = value/2;
				counter++;
			}
			else if (value % 2 != 0){
				value = 3*value + 1;
				counter++;
			}
		}
		System.out.println("The value is: " + x + " and there are " + counter + " numbers in its sequence.");
		counter = 0;
		}
	}
}
