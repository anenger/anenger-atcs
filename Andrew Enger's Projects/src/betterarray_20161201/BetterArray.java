package betterarray_20161201;

public class BetterArray {
	public static void main(String[] args){
		Array a1 = new Array(10000);
		a1.fill(-100,100);
		a1.insertionsort();
		Array a2 = new Array(10000);
		a2.fill(-100,100);
		a2.sort();
		System.out.println(a1.toString());
		a1.insert(0, 999);
		System.out.println(a1.toString());
		System.out.println(a1.average());
		System.out.println(a1.max());
		System.out.println(a1.min());
	}
}
