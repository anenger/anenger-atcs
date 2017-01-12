package atcw_20170105;

public class Fibonacci {

	public static void main(String[] args) {
		fib(11, 1, 1);
		System.out.println(fib(13));
	}
	
	static void fib(int i, int a, int b){
		System.out.println(a+b);
		if (i>0){
			fib(i-1, b, a+b);
		}
	}
	
	static int fib(int n){
		if (n<2){
			return 1;
		}
		else{
			return fib(n-1) + fib(n-2);
		}
	}

}
