package atcw_20170317;

public class Test {
	public static void main(String[] args){
		System.out.println(countSheep(0));
	}
	static int[] correct = new int[10];
	
	static int countSheep(int n){    
			int i = 1;
			int currentNum = 0;
			while(checkAnswers() == false && n != 0){
				currentNum = n*i;
				checkDigits(currentNum);
				i++;
			}
			return(currentNum);
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
				digit = n % 10;
				n /= 10;
				correct[digit] = 1;
			}
		}
}
