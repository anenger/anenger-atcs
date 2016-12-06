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

	void resize(int size, int index){
		int[] copyArray = new int[mainArray.length + size];
		for (int i = 0; i < mainArray.length; i++){
			if (i < copyArray.length){
				copyArray[i] = mainArray[i];
				if (index >= i){
					copyArray[i + index] = mainArray[i];
				}
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
		resize(-1, index);
	}

	int getValue(int index){
		return mainArray[index];
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

	void shiftValues(int iterator, int index){
		for (int x = index; x < mainArray.length; x++){
			mainArray[x + iterator] = mainArray[x];
		}
	}
	void shiftValues(){
		resize(1);
		for (int x = 0; x < mainArray.length; x++){
			mainArray[x + 1] = mainArray[x];
		}
	}

	public String toString(){
		String arrayString = "";
		for (int x = 0; x < mainArray.length; x++){
			arrayString += x + ":";
			arrayString += mainArray[x];
			arrayString += " ";
		}
		return arrayString;
	}
}
