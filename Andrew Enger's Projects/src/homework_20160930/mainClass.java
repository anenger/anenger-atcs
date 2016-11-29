package homework_20160930;
import java.util.Scanner;
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Table Creator - Enter a number of rows and columns you would like: ");
		Scanner input = new Scanner(System.in);
		int check1 = input.nextInt();
		for (int x = 0; x < check1; x++){
			if (x % 2 == 0){
				for (int y = 0; y < check1; y++){
					if (y % 2 == 0){
						System.out.print("X");
					}
					else{
						System.out.print("O");
					}
				}
			}
			else{
				for (int z = 0; z < check1; z++){
					if (z % 2 == 0){
						System.out.print("O");
					}
					else{
						System.out.print("X");
					}
				}	
			}
		System.out.println();
		}
		
		
	}

}
