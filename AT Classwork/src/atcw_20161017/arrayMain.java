package atcw_20161017;

public class arrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[20];
		int counter = 0;
		int position = 0;
		for (int x = 0; x < 100; x++){
			for (int y = 1; y <= x; y++){
				if (y%x == 0){
					counter++;
				}	
			}
			if (counter == 2){
				System.out.println("The number " + x + " is prime");
			}
			counter = 0;
		
	}
		
	}
}
