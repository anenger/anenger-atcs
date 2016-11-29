package atcw_20161021;

public class methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(fiveMore(square(5)));
		
		int[] primes = new int[5];
		for (int x=0; x<primes.length;x++){
			System.out.println(primes[x]);
		}
	}

	static int square(int x){
		int square = x*x;
		return square;
	}
	
	static void print(int n){
		System.out.println(n);
	}
	
	static int fiveMore(int x){
		int sum = x + 5;
		return sum;
	}
	
}
