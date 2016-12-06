package betterarray_20161201;

public class BetterArray {
	public static void main(String[] args){
		Array a1 = new Array(20);
		a1.resize(3);
		System.out.println(a1.toString());
		a1.push(4);
		System.out.println(a1.toString());
		System.out.println(a1.pop());
		System.out.println(a1.toString());
		a1.insert(2, 10);
		a1.insert(3, 80);
		a1.insert(13, 20);
		a1.insert(14, 30);
		a1.insert(15, 40);
		a1.insert(16, 50);
		a1.insert(17, 60);
		a1.insert(18, 70);
		System.out.println(a1.toString());
		a1.remove(13);
		System.out.println(a1.toString());
	}
}
