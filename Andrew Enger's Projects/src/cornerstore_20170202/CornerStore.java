
//Andrew and Mikayla's Implementation of the Store
//February 15, 2017

package cornerstore_20170202;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class CornerStore {

	//setting up global values 
	static Scanner input = new Scanner(System.in);
	static String mainpassword = "Pelican";
	static int maxid = 0;
	public static void main(String[] args) {
		//setting up local variables
		//our implementation was an arraylist of items defined in the Item class
		//this was an efficient implementation because all the information is contained
		//in one single variable.
		ArrayList<Item> Manifest = readFile("booklist.csv");
		boolean storeloop = true;
		System.out.println("Welcome to Andrew and Mikayla's bookstore!");
		//loop of actions you can do in the store
		while (storeloop){
			System.out.println("What would you like to do?");
			System.out.println("1. Add a book (Administrator)");
			System.out.println("2. Remove a book (Administrator)");
			System.out.println("3. Purchase a book");
			System.out.println("4. Search for a book");
			System.out.println("5. Quit");
			System.out.println("Choose an option: ");
			int switchint = input.nextInt();
			input.nextLine();
			if (switchint == 1){
				//checks for password (Pelican)
				if (enterPassword() == true){
					String id = String.valueOf(getMaxID(Manifest) + 1);
					String name = "";
					String price = "";
					String quantity = "";
					System.out.println("Enter the book name, book price, and book quantity: ");
					name = input.nextLine();
					price = input.nextLine();
					quantity = input.nextLine();
					try{
						Manifest = addItem(id, name, price, quantity, Manifest);
					}catch(Exception e){
						System.out.println("ERROR: " + e);
					}
				}
			}
			else if(switchint == 2){
				//checks for password (Pelican)
				if (enterPassword() == true){
					try{
					//gets the index of the searched value
					System.out.println("Search for an item: ");
					int searchindex = search(input.nextLine(), Manifest);
					System.out.println("Search returned: " + Manifest.get(searchindex));
					System.out.println("Would you like to remove this item?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int yn = input.nextInt();
					if (yn == 1){
						Manifest.remove(searchindex);
					}	
					else{
						System.out.println("Cancelled.");
					}
					}catch(Exception e){
						System.out.println("ERROR: " + e);
					}
				}
			}
			else if(switchint == 3){
				//purchase book based on quantity and scanner input
				try{
				System.out.println("What book would you like to purchase?");
				printArray(Manifest);
				System.out.println("Type the name: ");
				int searchindex = search(input.nextLine(), Manifest);
				if (searchindex != -1){
					System.out.println("Found book: " + Manifest.get(searchindex));
					System.out.println("Would you like to purchase this item?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int yn = input.nextInt();
					if (yn == 1){
						int quantity = Manifest.get(searchindex).getQuantity();
						if (quantity >= 1){
							Manifest.get(searchindex).setQuantity(quantity - 1);
							System.out.println("Purchased!");
						}
						else{
							System.out.println("Not enough books!");
						}
					}	
					else{
						System.out.println("Cancelled.");
					}
				}
				}catch(Exception e){
					System.out.println("ERROR: " + e);
				}
			}
			else if(switchint == 4){
				System.out.println("Search for a book: ");
				String searchstring = input.nextLine();
				System.out.println("Search returned: " + Manifest.get(search(searchstring, Manifest)));
			}
			//save and exit
			else if(switchint == 5){
				System.out.println("Goodbye!");
				writeFile("booklist.csv", Manifest);
				storeloop = false;
			}
			else{
				System.out.println("You have not entered a number. Try again.");
			}
			System.out.println("Please remember to save!");
		}
	}
	
	//reads from the file specified in arguments (wants very specific format of id, name, price, quantity)
	static ArrayList<Item> readFile(String filename){
		FileReader fr;
		ArrayList<Item> fileArray = new ArrayList<Item>();
		try{
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> datastring = new ArrayList<String>();
			String input = "";
			while((input = br.readLine()) != null){
				datastring.add(input);
			}
			//System.out.println(datastring.size());
			for (int i = 0; i < datastring.size(); i++){
				String[] list = new String[0];
				list = datastring.get(i).split(",");
				try{
					Item i1 = new Item(list[0], list[1], list[2], list[3]);
					fileArray.add(i1);
				}catch(Exception e){
					System.out.println("ERROR: " + e);
				}
			}
			br.close();
		}catch(Exception e){
			System.out.println("ERROR: " + e);
		}
		return fileArray;
	}

	//Writes to the file specified in arguments
	static void writeFile(String filename, ArrayList<Item> itemlist){
		try {
			FileWriter fw = new FileWriter(filename);
			for (int x = 0; x < itemlist.size(); x++){
				fw.write(itemlist.get(x).toString() + "\n");
			}
			fw.close();
		}catch(Exception e){
			System.out.println("ERROR: " + e);
		}
	}
	
	//Adds an item to an arraylist specified in arguments
	static ArrayList<Item> addItem(String id, String name, String price, String quantity, ArrayList<Item> itemlist){
		try{
			Item i1 = new Item(id, name, price, quantity);
			itemlist.add(i1);
			System.out.println("Successfully added book");
		}catch(Exception e){
			System.out.println("ERROR: " + e);
		}
		return itemlist;
	}
	
	//maximum id field in the arraylist (specific to our bookstore)
	static int getMaxID(ArrayList<Item> itemlist){
		int currentmax = 0;
		for (int x = 0; x < itemlist.size(); x++){
			if (currentmax < itemlist.get(x).getNumber()){
				currentmax = itemlist.get(x).getNumber();
			}
		}
		return currentmax;
	}
	
	//searches using binary search, shortens the array until it finds the value
	//only works when sorted
	static int search(String name, ArrayList<Item> itemlist){
		sortArray(itemlist);
		int min = 0;
		int max = itemlist.size() - 1;
		//if item is higher than index, make the max
		while(min <= max){
			int index = (max + min)/2;
			if (itemlist.get(index).getName().substring(0, name.length()).compareToIgnoreCase(name) > 0){
				max = index - 1;
			}
			else if (itemlist.get(index).getName().substring(0, name.length()).compareToIgnoreCase(name) < 0)
				min = index + 1;
			else if (itemlist.get(index).getName().substring(0, name.length()).compareToIgnoreCase(name) == 0){
				return index;
			}
			}
		return -1;
		}
	
	//bubblesort
	static ArrayList<Item> sortArray(ArrayList<Item> itemlist){
		for (int x = itemlist.size() - 1; x > 0; x--){
			for (int y = 0; y < x; y++){
				if (itemlist.get(x).getName().compareTo(itemlist.get(y).getName()) < 0){
					swap(x, y, itemlist);
				}
			}
		}
		return itemlist;
	}
	
	//swaps two values
	static void swap(int x, int y, ArrayList<Item> i1){
		Item tempitem = i1.get(y);
		i1.set(y, i1.get(x));
		i1.set(x, tempitem);
	}
	
	//debugging method
	static void printArray(ArrayList<Item> i1){
		for (int x = 0; x < i1.size(); x++){
			System.out.println(i1.get(x).toString());
		}
	}
	
	static boolean enterPassword(){
		System.out.println("Enter your password:");
		String password = input.nextLine();
		if (password.equals(mainpassword)){
			System.out.println("Correct password.");
			return true;
		}
		else{
			System.out.println("Incorrect password.");
			return false;
		}
	}
	
}
