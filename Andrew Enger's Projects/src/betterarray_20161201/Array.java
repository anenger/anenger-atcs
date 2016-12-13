package betterarray_20161201;
import java.util.Date;

public class Array {
	private int[] mainArray;
	Array(int l){
		mainArray = new int[l];
	}

	void resize(int size){
		int[] copyArray = new int[mainArray.length + size];
		for (int i = 0; i < mainArray.length; i++){
			if (i < copyArray.length){
				copyArray[i] = mainArray[i];
			}
		}
		mainArray = copyArray;
	}

	void push(int value){
		resize(1);
		mainArray[mainArray.length - 1] = value;
	}

	int pop(){
		int value = mainArray[mainArray.length - 1];
		resize(-1);
		return value;
	}

	void insert(int index, int value){
		shiftValues(1, index);
		mainArray[index] = value;
	}

	void remove(int index){
		mainArray[index] = 0;
		shiftValues(-1, index);
		resize(-1);
	}
	
	void update(int index, int value){
		mainArray[index] = value;
	}
	
	void swap(int i1, int i2){
		int value = mainArray[i1];
		mainArray[i1] = mainArray[i2];
		mainArray[i2] = value;
	}
	
	int max(){
		int max = mainArray[0];
		for (int x = 0; x < mainArray.length; x++){
			if (mainArray[x] > max){
				max = mainArray[x];
			}
		}
		return max;
	}
	
	int min(){
		int min = mainArray[0];
		for (int x = 0; x < mainArray.length; x++){
			if (mainArray[x] < min){
				min = mainArray[x];
			}
		}
		return min;
	}
	
	int average(){
		int average = 0;
		int sum = 0;
		for (int x = 0; x < mainArray.length; x++){
			sum += mainArray[x];
		}
		average = sum / mainArray.length;
		return average;
	}
	
	int size(){
		int size = mainArray.length;
		return size;
	}

	int getValue(int index){
		return mainArray[index];
	}
	
	void sort(){
		Date d1 = new Date();
		for (int x = mainArray.length - 1; x > 0; x--){
			for (int y = 0; y < x; y++){
				if (mainArray[x] < mainArray[y]){
					swap(y, x);
				}
			}
		}
		Date d2 = new Date();
		System.out.println(d2.getTime() - d1.getTime() + " milliseconds to complete bubble sort.");
	}
	
	void insertionsort(){
		Date d1 = new Date();
		for (int x = 0; x < mainArray.length; x++){
			for (int y = x; y > 0; y--){
				if (mainArray[y] < mainArray[y-1]){
					swap(y, y-1);
				}
			}
		}
		Date d2 = new Date();
		System.out.println(d2.getTime() - d1.getTime() + " milliseconds to complete insertion sort.");
	}
	
	int sum(){
		int sum = 0;
		for (int x = 0; x < mainArray.length; x++){
			sum += mainArray[x];
		}
		return sum;
	}

	boolean checkIndex(int index){
		if (index < mainArray.length && index >= 0){
			return true;
		}
		else {
			System.out.println("This index is out of bounds.");
			return false;
		}
	}
	
	void fill(int min, int max){
		int random = 0;
		int range = (max - min) + 1;
		for (int x = 0; x < mainArray.length; x++){
			random = (int)(Math.random() * range) + min;
			mainArray[x] = random;
		}
	}
	
	void shiftValues(){
		resize(1);
		for (int x = 0; x < mainArray.length; x++){
			mainArray[x + 1] = mainArray[x];
		}
	}
	
	void shiftValues(int shift, int index){
		resize(shift);
		for (int x = mainArray.length - 1; x >= index; x--){
			if (x == 0){
				mainArray[x] = mainArray[x + 1];
			}
			else{
				mainArray[x] = mainArray[x - shift];
			}
		}
	}
	
	int[] getArray(){
		return mainArray;
	}

	public String toString(){
		String arrayString = "";
		for (int x = 0; x < mainArray.length; x++){
			arrayString += mainArray[x] + "," + " ";
		}
		return arrayString;
	}
}
