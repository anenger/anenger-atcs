package cornerstore_20170202;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class CornerStore {

	static ArrayList<Item> Manifest = new ArrayList<Item>();
	public static void main(String[] args) {
		Manifest = readFile("booklist.csv");
		for (int x = 0; x < Manifest.size(); x++){
			System.out.println(Manifest.get(x).toString());
		}
	}
	
	static ArrayList<Item> readFile(String filename){
		FileReader fr;
		ArrayList<Item> fileArray = new ArrayList<Item>();
		try{
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> datastring = new ArrayList<String>();
			String input = "";
			while((input = br.readLine()) != null){
				datastring.add(input);
			}
			System.out.println(datastring.size());
			for (int i = 0; i < datastring.size(); i++){
				String[] list = new String[0];
				list = datastring.get(i).split(",");
				Item i1 = new Item(list[0], list[1]);
				fileArray.add(i1);
				System.out.println(fileArray.get(i));
			}
			br.close();
		}catch(Exception e){
		}
		return fileArray;
	}

	void writeFile(String filename){
		try {
			FileWriter fw = new FileWriter(filename);
			Manifest.trimToSize();
			for (int x = 0; x < Manifest.size(); x++){
				fw.write(Manifest.get(x).toString());
			}
			fw.close();
		}catch(Exception e){
		}
	}
	
}
