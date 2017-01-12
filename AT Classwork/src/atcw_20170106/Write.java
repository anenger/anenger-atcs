package atcw_20170106;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		FileWriter fw = new FileWriter("out.txt");
		System.out.println("What would you like to write?");
		String s1 = in.nextLine();
		for (int i = 0; i<10; i++){
				fw.write(s1 + (int)(Math.random()*10) + "\n");
			}
		fw.close();
		
	}

}
