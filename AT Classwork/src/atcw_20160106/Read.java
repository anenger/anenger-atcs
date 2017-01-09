package atcw_20160106;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read {

	public static void main(String[] args) {
		FileReader fr;
		try{
			fr = new FileReader("out.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String input;
			while((input = br.readLine()) != null){
				System.out.println(input);
			}
		}catch(Exception e){
			
		}

	}

}
