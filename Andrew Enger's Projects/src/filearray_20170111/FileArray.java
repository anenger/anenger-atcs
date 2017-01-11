package filearray_20170111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileArray {
	private int[] mainArray;
	FileArray(){
		mainArray = new int[0];
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
				if (i<mainArray.length - 1){
					fw.write(mainArray[i] + ",");
				}
				else{
					fw.write(mainArray[i]);
				}
			}
			fw.close();
		}catch(Exception e){
			
		}
	}
	void enterArray(int[] a){
		mainArray = a;
		writeFile("out.txt");
	}
	int[] returnArray(){
		return mainArray;
	}
}
