package hailstone_20161007;
import java.util.Scanner;

public class task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hailstone = 0;
		int tracker = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Input a number to print the hailstone sequence of:");
		hailstone = input.nextInt();
		while (hailstone != 1){
			if (hailstone % 2 == 0){
				hailstone = hailstone / 2;
			}
			else{
				hailstone = (hailstone * 3) + 1;
			}
			tracker++;
			System.out.print(hailstone + ", ");
		}
		System.out.println();
		System.out.println("This is the amount of digits: " + tracker);
	}
}
