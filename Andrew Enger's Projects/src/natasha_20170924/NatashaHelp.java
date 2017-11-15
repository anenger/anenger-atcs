package natasha_20170924;

import java.util.Scanner;
public class NatashaHelp {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the number of variables you would like to store:");
		int vars = input.nextInt();
		int i = 0;
		int total = 0;
		while (i < vars){
			System.out.println("Enter a value:");
			int temp = input.nextInt();
			total = total + temp;
			i++;
		}
		System.out.println((total / vars) + " is your average.");
	}

}
