package cornerstore_20170202;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class CornerStore {

	static ArrayList<Item> Manifest = new ArrayList<Item>();
	public static void main(String[] args) {
		readFile("output.csv");
		
	}
	
	static void readFile(String filename){
		FileReader fr;
		try{
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> datastring = new ArrayList<String>();
			String input = "";
			while((input = br.readLine()) != null){
				datastring.add(input);
			}
			datastring.trimToSize();
			for (int i = 0; i < datastring.size(); i++){
				String[] list;
				list = datastring.get(i).split(",");
				Item i1 = new Item(list[0], list[1], list[2], list[3]);
				Manifest.add(i1);
			}
			br.close();
		}catch(Exception e){
		}
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
