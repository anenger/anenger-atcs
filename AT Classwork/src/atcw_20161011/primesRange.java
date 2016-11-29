package atcw_20161011;
//Andrew Enger 10.16.16
import java.util.Scanner;

public class primesRange {
	public static void main(String[] args){
		int counter = 0;
		int r1 = 0;
		int r2 = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("This system will print all prime numbers in a certain positive range, and determine if they are relatively prime.");
		System.out.println("Please enter a range using two numbers: ");
		r1 = userInput.nextInt();
		r2 = userInput.nextInt();
		for (int i = r1; i <= r2; i++){
			for (int x = 1; x <= r2; x++){
				if (i%x == 0){
					counter++;
				}	
			}
			if (counter == 2){
				System.out.println("The number " + i + " is prime");
			}
			counter = 0;
		}
		int max = 0;
		if (r1 >= r2){
			max = r1;
		}
		else{
			max = r2;
		}
		counter = 0;
		for (int i=2; i<=max; i++){
			if (r1 % i == 0 && r2 % i==0) {
                counter++;
            }
		}
		if (counter == 0) {
            System.out.println(r1 + " and " + r2 + " are relatively prime.");
        } else {
            System.out.println(r1 + " and " + r2 + " are not relatively prime.");
        }

	}
}
