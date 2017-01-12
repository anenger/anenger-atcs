package atcw_20170106;

public class tryCatch {

	public static void main(String[] args) {
		
		int[] x = new int[20];
		
		try{
			System.out.println(x[21]);
		} catch(Exception e){
			System.out.println("Error");
			System.out.println(e);
		}
		
		System.out.println("Hello");
		
		
	}

}
