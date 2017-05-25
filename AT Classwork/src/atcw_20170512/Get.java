package atcw_20170512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Get {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Pick an operation: ");
		System.out.println("1. Cos");
		System.out.println("2. Sin");
		System.out.println("3. Tan");
		System.out.println("4. Arccos");
		System.out.println("5. Arcsin");
		System.out.println("6. Arctan");
		System.out.println("7. Absolute value");
		System.out.println("8. Log");
		System.out.println("9. Simplify");
		String operation = input.nextLine();
		if (operation.equals("1")){
			operation = "cos";
		}else if(operation.equals("2")){
			operation = "sin";
		}else if(operation.equals("3")){
			operation = "tan";
		}else if(operation.equals("4")){
			operation = "arccos";
		}else if(operation.equals("5")){
			operation = "arcsin";
		}else if(operation.equals("6")){
			operation = "arctan";
		}else if(operation.equals("7")){
			operation = "abs";
		}else if(operation.equals("8")){
			operation = "log";
		}else if(operation.equals("9")){
			operation = "simplify";
		}else{
			operation =  null;
		}
		System.out.println("Enter a valid expression for your function: ");
		String expression = input.nextLine();
		if (expression != null){
			URL url = new URL("https://newton.now.sh/" + operation + "/" + expression + "/");
			URL url1 = new URL("https://api.wolframalpha.com/v1/simple?i=Who+is+the+prime+minister+of+India%3F&appid=DEMO");
			System.out.println(url);
			HttpURLConnection http = (HttpURLConnection) url1.openConnection();
			http.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String line;
			String result = "";
			while ((line = br.readLine()) != null){
				result += line;
			}
			br.close();
			String[] split = result.split(",");
			for (String s : split){
				System.out.println(s);
			}
		}
	}

}
