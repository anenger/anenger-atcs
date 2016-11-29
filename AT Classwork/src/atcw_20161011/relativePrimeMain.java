package atcw_20161011;

public class relativePrimeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 4;
		int n2 = 8;
		int counter = 0;
		for (int x = 2; x <= n1; x++){
			if (n1%x == 0 && n2%x == 0){
				System.out.println("These numbers are not relatively prime");
			}	
		}
	}

}
