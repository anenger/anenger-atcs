package atcw_20170317;

public class GoogleCodejam {
	static int[] correct = new int[10];
	public static void main(String[] args){
		int startNum = 1692;
		int i = 0;
		int n = 0;
		while(checkAnswers() == false && startNum != 0){
			i++;
			n = startNum*i;
			checkDigits(n);
		}
		System.out.println(n);
	}
		
	static boolean checkAnswers(){
		int answers = 0;
		for (int x = 0; x < correct.length; x++){
			if(correct[x] == 1){
				answers++;
			}
		}
		if (answers == 10) {
			return true;
		}
		else return false;
	}
	
	static void checkDigits(int n){
		int digit = 0;
		while (n != 0){
			System.out.println(n);
			digit = n % 10;
			n /= 10;
			correct[digit] = 1;
			System.out.println(digit);
		}
	}
}