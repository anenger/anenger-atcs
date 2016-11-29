package hailstone_20161007;
import java.util.Scanner;
public class task1 {
	public static void main(String[] args) {
		int hailstone = 0;
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
			if (hailstone != 1){
			System.out.print(hailstone + ", ");
			}
			else{
			System.out.print(hailstone);
			}
		}
		
	}
}
