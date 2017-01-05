package exploremath1_20170102;

public class FibonacciSum {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		int hold = 0;
		int evensum = 0;
		while (num2 < 4000000){
			if (num2 % 2 == 0){
				evensum+=num2;
			}
			hold = num2;
			num2 = num1 + num2;
			num1 = hold;
		}
		System.out.println(evensum);
	}

}
