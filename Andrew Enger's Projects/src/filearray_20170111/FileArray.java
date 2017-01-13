package filearray_20170111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
			String[] sa;
			while((input = br.readLine()) != null){
			}
			sa = input.split(",");
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
				if (i < (mainArray.length - 1)){
					fw.write(mainArray[i] + ",");
				}
				else{
					fw.write(mainArray[i] + "");
				}
			}
			fw.close();
		}catch(Exception e){
			
		}
	}
	
	void enterArray(int[] a){
		mainArray = a;
	}
	int[] returnArray(){
		return mainArray;
	}
	
	int length(){
		return mainArray.length;
	}
	
	void resize(int size){
		int[] copyArray = new int[mainArray.length + size];
		for (int i = 0; i < mainArray.length; i++){
			if (i < copyArray.length){
				copyArray[i] = mainArray[i];
			}
		}
		mainArray = copyArray;
	}
	
	void push(int value){
		resize(1);
		mainArray[mainArray.length - 1] = value;
	}

	int pop(){
		int value = mainArray[mainArray.length - 1];
		resize(-1);
		return value;
	}
	
	public String toString(){
		String csv = "";
		for(int i = 0; i < mainArray.length; i++){
			if (i < (mainArray.length - 1)){
				csv += mainArray[i] + ",";
			}
			else{
				csv += mainArray[i];
			}
		}
		return csv;
	}
	
//	void fill(int min, int max){
//		int random = 0;
//		int range = (max - min) + 1;
//		for (int x = 0; x < mainArray.length; x++){
//			random = (int)(Math.random() * range) + min;
//			mainArray[x] = random;
//		}
//	}
}
