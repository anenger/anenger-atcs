package helloworld_20160920;
import java.util.Scanner;
import java.util.Random;

public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		Scanner sc = new Scanner(System.in);
		String testString = sc.nextLine();
		double testNum = Math.floor(Math.random() * 101);
		
		if (testString.equals("password")){
			System.out.println("Congratulations, you have the right password");
		}
		else{
			System.out.println("Incorrect password");
		}
		System.out.println(testString + " " + testNum);
		
		
	}

}
