package filearray_20170111;

public class Main {

	public static void main(String[] args) {
		FileArray a1 = new FileArray();
		int[] array = new int[20];
	//	a1.fill(0, 20);
		a1.enterArray(array);
		System.out.println(a1);
		a1.push(20);
		a1.writeFile("test.txt");
		System.out.println(a1);
		a1.readFile("test.txt");
		System.out.println(a1);
	}

}
