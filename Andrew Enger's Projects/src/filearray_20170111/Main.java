package filearray_20170111;

public class Main {

	public static void main(String[] args) {
		FileArray a1 = new FileArray();
		int[] array = new int[20];
		for (int x = 0; x<array.length; x++){
			array[x] = (int)(Math.random()*10);
		}
		a1.enterArray(array);
		a1.writeFile("test.txt");
		a1.readFile("test.txt");
		for (int i = 0; i<a1.length(); i++){
			System.out.println(a1.returnArray()[i]);
		}
	}

}
