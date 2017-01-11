package filearray_20170111;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileArray {
	FileArray(){
		int[] array = new int[0];
	}
	static void readFile(String filename){
		FileReader fr;
		try{
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String input;
			while((input = br.readLine()) != null){
				System.out.println(input);
			}
			br.close();
		}catch(Exception e){
			
		}
	}
	static void writeFile(){
		
	}
}
