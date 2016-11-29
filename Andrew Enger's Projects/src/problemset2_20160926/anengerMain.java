package problemset2_20160926;
//Andrew Enger 9.27.16 Homework
import java.util.Scanner;

public class anengerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		int switchInt = 0;
		int characters = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter your first and last name: ");
		name = userInput.nextLine();
		System.out.println("Welcome " + name + "!");
		System.out.println("Choose an option: ");
		System.out.println("1. Alphabetic characters");
		System.out.println("2. First and last name");
		System.out.println("3. Correct your name");
		System.out.println("4. Vowel count");
		switchInt = userInput.nextInt();
		switch (switchInt){
		case 1:
			String countName = name;
			countName = countName.replaceAll("-", "");
			countName = countName.replaceAll(" ", "");
			characters = countName.length();
			System.out.println(name +  " has " + characters + " alphabetic characters");
		break;
		case 2:
			int space = name.indexOf(" ");
			if (space >= 0){
				String firstPart = name.substring(0, space);
				String secondPart = name.substring(space).trim();
				System.out.println("Your first name is " + firstPart + " and your last name is " + secondPart);
			}
			else{
				String firstName = name.substring(0);
				System.out.println("Your first name is " + firstName);
			}	
		break;
		case 3:
			Scanner capsNameInput = new Scanner(System.in);
			System.out.println("Please enter your name with random capitalization (try to confuse me): ");
			String capsName = capsNameInput.nextLine();
			int capsSpace = capsName.indexOf(" ");
			int hyphen = capsName.indexOf("-");
			String firstCaps = capsName.substring(0, capsSpace).toLowerCase();
			String secondCaps = capsName.substring(capsSpace).toLowerCase().trim();
			String capsLetter1 = firstCaps.substring(0, 1).toUpperCase();
			String capsLetter2 = secondCaps.substring(0, 1).toUpperCase();
			if (hyphen >= 0){
				String hyphenName = capsName.substring(hyphen).toLowerCase();
				String hyphenLetter = hyphenName.substring(1,2).toUpperCase();
				firstCaps = capsLetter1 + firstCaps.substring(1);
				secondCaps = capsLetter2 + secondCaps.substring(1, secondCaps.indexOf("-"));
				hyphenName = hyphenLetter + hyphenName.substring(2);
				System.out.println("Your corrected name is " + firstCaps + " " + secondCaps + "-" + hyphenName);
			}
			else{
			firstCaps = capsLetter1 + firstCaps.substring(1);
			secondCaps = capsLetter2 + secondCaps.substring(1);
			System.out.println("Your corrected name is: " + firstCaps + " " + secondCaps);	
			}
		break;
		case 4:
			String vowelName = name;
			vowelName = vowelName.replaceAll("a|e|i|o|u|A|E|I|O|U", "");
			int vowelLength = name.length() - vowelName.length();
			if (vowelLength == 1){
			System.out.println("You have " + vowelLength + " vowel in your name"); 
			}
			else{
			System.out.println("You have " + vowelLength + " vowels in your name"); 
			}
		break;
		}
		
		
		
		
	}

}
