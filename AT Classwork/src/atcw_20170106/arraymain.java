package atcw_20170106;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class arraymain {

	private int[] array1;

	arraymain() {
		array1 = new int[0];
	}

	void readFile(String file) {
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String input;
			String[] dataString = null;
			while ((input = br.readLine()) != null) {
				System.out.println(input);
			}
			dataString = input.split(",");
			int[] data = new int[dataString.length];
			for (int i = 0; i < dataString.length; i++) {
				data[i] = Integer.parseInt(dataString[i]);
			}
			array1 = data;
			fr.close();
			br.close();
		} catch(Exception e) {
		}
	}
	int[] returnArray() {
		return array1;
	}
	void writeFile(String file){
		FileWriter fw;
		try{
			fw = new FileWriter(file);
			for(int i = 0; i < array1.length; i++){
				fw.write(array1[i] + ",");
			}
			fw.close();
		} catch (Exception e) {
		}
	}
	void enterArray(int[] a) { //array a is assigned to array1
		array1 = a;
	}
}