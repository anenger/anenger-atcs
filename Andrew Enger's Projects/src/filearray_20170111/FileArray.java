package filearray_20170111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileArray {
	private int[] mainArray;
	FileArray(int l){
		mainArray = new int[l];
	}
	void readFile(String filename){
		FileReader fr;
		try{
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String input;
			while((input = br.readLine()) != null){
				input += input;
			}
			String[] sa = input.split(",");
			int[] data = new int[sa.length];
			for(int x = 0; x < sa.length; x++){
				data[x] = Integer.parseInt(sa[x]);
			}
			mainArray = data;
			br.close();
		}catch(Exception e){
			
		}
	}
	void writeFile(String filename){
		try {
			FileWriter fw = new FileWriter(filename);
			for (int i = 0; i < mainArray.length; i++){
				fw.write(mainArray[i] + "\n");
			}
			fw.close();
		}catch(Exception e){
			
		}
	}
	void enterArray(int[] a){
		writeFile("out.txt");
	}
	int[] returnArray(){
		return mainArray;
	}
}
