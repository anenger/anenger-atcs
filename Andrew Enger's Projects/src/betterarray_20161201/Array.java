package betterarray_20161201;

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
		if (index < mainArray.length && index >= 0){
			mainArray[index] = value;
		}
		else{
			System.out.println("This index is out of bounds.");
			System.out.println("Resizing the array...");
			resize(index - mainArray.length + 1);
			mainArray[index] = value;
		}
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

	int getValue(int index){
		return mainArray[index];
	}
	
	void sort(){
		for (int x = 0; x < mainArray.length; x++){
			for (int y = x; y<mainArray.length; y++){
				if (mainArray[x] > mainArray[y]){
					swap(x, y);
				}
			}
		}
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

	void shiftValues(){
		resize(1);
		for (int x = 0; x < mainArray.length; x++){
			mainArray[x + 1] = mainArray[x];
		}
	}
	
	void shiftValues(int iterator, int index){
		for (int x = index; x < mainArray.length; x++){
			mainArray[x + iterator] = mainArray[x];
		}
	}

	public String toString(){
		String arrayString = "";
		for (int x = 0; x < mainArray.length; x++){
			arrayString += x + ":" + mainArray[x] + " ";
		}
		return arrayString;
	}
}
