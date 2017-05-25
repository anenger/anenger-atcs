package atcw_20170515;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;

public class Get {

	public static void main(String[] args){
		int x = 0;
		int length = (int)Math.sqrt(getSize());
		while(true){
			try {
				String color = get(x*length);
				put(x*length, "00ff00");
				put((x-1)*length, color);
				x++;
				wait(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static boolean put(int x, String color) throws Exception{
			
		URL url = new URL("http://pbn.minsky.co/api/?" + x + "=" + color);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("PUT");
		
		if (http.getResponseCode() == 200){
			return true;
		}
		return false;
	}
	
	static String get(int square) throws Exception{
		
		URL url = new URL("http://pbn.minsky.co/api/colors");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
	    String line;
	    String result = "";
		while ((line = br.readLine()) != null) {
			result += line;
		}
	    br.close();
	    
	    JSONObject jsonObject = new JSONObject(result);
	    
	    
	    String[] colors = new String[jsonObject.getJSONArray("squares").length()];
	   	for (int x = 0; x < colors.length; x++){
	   		colors[x] = jsonObject.getJSONArray("squares").getString(x);
	   	}
	   	
	   	return colors[square];
	}
	
	static int getSize(){
		int size = 0;
		try {
			URL url = new URL("http://pbn.minsky.co/api/size");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
		    String line;
		    String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
		    br.close();
		    
		    JSONObject js = new JSONObject(result);
		    size = js.getInt("size");
	    
		}catch(Exception e){
			System.out.println(e);
		}
		
		return size;
	}
	
	static void wait(int x){
		Date start = new Date();
		Date now = new Date();
		
		while (now.getTime() - start.getTime() < x){
			now = new Date();
		}
	}

}
