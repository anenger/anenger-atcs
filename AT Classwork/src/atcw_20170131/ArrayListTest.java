package atcw_20170131;
import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args){
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a1.add("Hello");
		a1.add("World");
		a1.add("Test");
		a2.add(1);
		a2.add(2);
		a2.add(3);
		System.out.println(a1);
		System.out.println(a2);
		a1.set(2, "Stuff");
		
		//a1.forEach(a1.get());
		
		for (int i = 0; i<a1.size(); i++){
			System.out.println(a1.get(i));
		}
	}
}
