package betterarray_20161201;

public class BetterArray {
	public static void main(String[] args){
		Array a1 = new Array(2000);
		a1.fill(-1500, 1500);
		a1.insertionsort();
		System.out.println(a1.toString());
		a1.fill(-1500, 1500);
		a1.sort();
		System.out.println(a1.toString());
		System.out.println(a1.average());
		System.out.println(a1.max());
		System.out.println(a1.min());
	}
}
