package betterarray_20161201;
import java.util.Scanner;
//this system could be used to keep a database of users such as in a big company or otherwise
//it would be very easy when inputting user data to store it in this array because of push, pop, sort, etc
//specifically, I am using this betterarray to keep track of student id numbers
//I can store values in specific slots, add a value anywhere in the array, shift all other values up,
//in this case I would probably have two arrays, one to store the students name and one to store their id number
//the reason there are a lot of input.nextLine(); is because the old values from the scanner were getting stuck in the scanner, and that was the only way i could think of to clear them out

public class BetterArray {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		//creating a betterarray with the student id number
		Array a1 = new Array();
		boolean loop = true;
		while (loop){
			System.out.println("Choose an option: ");
			System.out.println("1: Add new student");
			System.out.println("2: Edit a student");
			System.out.println("3. Delete a student");
			System.out.println("4. Fill array with random student ID numbers");
			System.out.println("5. Get system data");
			System.out.println("6. Close program");
			int switchint = input.nextInt();
			input.nextLine();
			switch(switchint){
			case 1:
				System.out.println("Please enter the new student's ID number: ");
				System.out.println("ID Number: ");
				int id = input.nextInt();
				input.nextLine();
				a1.push(id);
				System.out.println("ID stored.");
				System.out.println("");
			break;
			case 2:
				System.out.println("Current students in the system are: ");
				System.out.println(a1);
				System.out.println("Enter the index of the student you would like to edit: ");
				int i = input.nextInt();
				input.nextLine();
				if (a1.checkIndex(i) == true){
					System.out.println(a1.get(i) + " is the ID value you have chosen. Please enter the updated ID value: ");
					int val = input.nextInt();
					input.nextLine();
					a1.update(i, val);
					System.out.println("The value at place " + i + " is now " + val);
				}
				System.out.println("");
			break;
			case 3:
				System.out.println("Current students in the system are: ");
				System.out.println(a1);
				System.out.println("Please input the index of the ID value you would like to delete: ");
				int i2 = input.nextInt();
				input.nextLine();
				if (a1.checkIndex(i2) == true){
					System.out.println(a1.get(i2) + " is the ID value you have chosen. Are you sure you want to delete this value?");
					System.out.println("Y or N");
					String check = input.nextLine();
					input.nextLine();
						if (check.equals("Y")){
							a1.remove(i2);
						}
						else{
							System.out.println("Student kept.");
						}
				}
				System.out.println("");
			break;
			case 4:
				System.out.println("Pick two values between 0 and infinity: ");
				System.out.println("1: ");
				int v1 = input.nextInt();
				input.nextLine();
				System.out.println("2: ");
				int v2 = input.nextInt();
				input.nextLine();
				System.out.println("Choose the new length of the array: ");
				int l = input.nextInt();
				input.nextLine();
				a1.resize(l - a1.size());
				a1.fill(v1, v2);
				System.out.println("Array filled.");
			break;
			case 5:
				System.out.println(a1);
				System.out.println("The minimum ID number is: " + a1.min());
				System.out.println("The maximum ID number is: " + a1.max());
				System.out.println("Would you like to sort the ID values?");
				System.out.println("Y or N");
				String c1 = input.nextLine();
				if (c1.equals("Y")){
					a1.insertionsort();
				}
				else{
					System.out.println("Values kept");
				}
			break;
			case 6:
				loop = false;
			break;
			}
		}
	//showing further capabilities of the betterarray
		Array a2 = new Array(200);
		System.out.println(a2);
		a2.fill(2);
		System.out.println(a2);
		a2.fill(-20, 20);
		System.out.println(a2);
		a2.bubblesort();
		System.out.println(a2);
		a2.fill(-20, 20);
		System.out.println(a2);
		a2.insertionsort();
		System.out.println(a2);
		System.out.println(a2.average());
		System.out.println(a2.max());
		System.out.println(a2.min());
}
}