package atcw_20170103;

public class Recursion {

	public static void main(String[] args) {
		System.out.println(recursion(20));
	}
	
	static long recursion(long i){
		if (i>0){
			return recursion(i-1)*i;
		}
		else return 1;
	}
}
