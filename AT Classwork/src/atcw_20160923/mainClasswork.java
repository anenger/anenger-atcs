package atcw_20160923;
//Andrew Enger Classwork 09/23/16
import java.util.Objects;
import java.util.Scanner;

public class mainClasswork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the system. Are you a new user?");
		System.out.println("Type Y for yes and N for no");
		Scanner userInput = new Scanner(System.in);
		String newUserChoice = userInput.nextLine();
		if (Objects.equals(newUserChoice, "Y")){
			System.out.print("Enter a username: ");
			String username = userInput.nextLine();
			System.out.print("Enter a password: ");
			String password = userInput.nextLine();
			System.out.println("Your username is: " + username + " and password is: " + password);
		}
		else{
			int systemChoice = userInput.nextInt();
			System.out.println("Goodbye!");
		}
		
		
	}

}
