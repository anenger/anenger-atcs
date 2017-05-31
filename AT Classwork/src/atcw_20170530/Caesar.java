package atcw_20170530;

public class Caesar {

	public static void main(String[] args){
		String input = "DAHHK SKNHZ";
		
		input = input.toUpperCase();
		
		String output = "";
		
		int key = 4;
		
		while (key < 0){
			key = 26 + key;
		}
		
		for (int x = 0; x < input.length(); x++){
			char letter = input.charAt(x);
			int ascii = (int)letter;
			if (ascii != 32){
				output += (char)(((ascii - 65) + key) % 26 + 65);
			}else{
				output += (char)(ascii);
			}
		}
		
		System.out.println(input + " shifted by " + key + " equals " + output);
	}

}
