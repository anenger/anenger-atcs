package learningclasses_20161120;
//Andrew Enger 11.22.16

import java.util.Scanner;

public class LearningClasses {
	//this class could be used as a kind of banking system that stores more information
	//not really practical because it has no security, but the concept is there
	public static void main(String[] args){
		Person[] people = new Person[5];
		people[0] = new Person("Joseph", 21, 20000, "Male", "Healthy"); //uses fully defined constructor
		people[1] = new Person("John"); //uses 1 argument and randomizes the rest
		people[2] = new Person("Michael");
		people[3] = new Person("Anna");
		people[4] = new Person("Andrew", 21, 0, "Male", "Healthy");
		Scanner scan = new Scanner(System.in);
		int transfer = 0;
		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
//		System.out.println(p4);
//		System.out.println(p5);
		
		System.out.println("Enter an amount you would like to transfer: ");
		transfer = scan.nextInt();
		System.out.println("Choose who you would like to transfer it from: ");
		for(int x = 0; x<people.length; x++){
			System.out.println(x + ". " + people[x].getName());
		}
		int first = scan.nextInt();
		System.out.println(people[first].getMoney() + " is " + people[first].getName() + "'s balance.");
		System.out.println("Choose who you would like to transfer it to: ");
		for(int x = 0; x<people.length; x++){
			System.out.println(x + ". " + people[x].getName());
		}
		int second = scan.nextInt();
		scan.close();
		people[first].transferMoney(people[second], transfer);
	}
}
