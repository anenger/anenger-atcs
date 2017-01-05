package exploremath1_20170102;

public class SumSquareDifference {

	public static void main(String[] args) {
		
		int natnumbers = 100;
		int sumsquares = 0;
		int squaresum = 0;
		int sum = 0;
		
		for (int x = 1; x <= natnumbers; x++){
			sumsquares += x*x;
		}
		
		for (int x = 1; x <= natnumbers; x++){
			squaresum += x;
		}
		
		squaresum *= squaresum;
		sum = squaresum - sumsquares;
		System.out.println(sum);
	}

}
