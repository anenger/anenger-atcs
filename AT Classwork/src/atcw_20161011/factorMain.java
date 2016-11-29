package atcw_20161011;

public class factorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		int counter = 0;
		for (int i = 1; i <= n; i++){
			if (n%i == 0){
				System.out.println(n/i + ", " + i);
				counter++;
			}
		}
		System.out.println("This number has " + counter + " factors.");
		if (counter == 2){
			System.out.println("This number is prime.");
		}
	}

}
