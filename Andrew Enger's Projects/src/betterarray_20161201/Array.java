package betterarray_20161201;
import java.util.Date;

public class Array {
	private int[] mainArray;
	Array(int l){
		mainArray = new int[l];
	}
	Array(){
		mainArray = new int[0];
	}

	//adds "size" slots to the array, copies all old values over
	void resize(int size){
		int[] copyArray = new int[mainArray.length + size];
		for (int i = 0; i < mainArray.length; i++){
			if (i < copyArray.length){
				copyArray[i] = mainArray[i];
			}
		}
		mainArray = copyArray;
	}

	//adds one spot to the end of the array and fills it with the inputted value
	void push(int value){
		resize(1);
		mainArray[mainArray.length - 1] = value;
	}

	//removes the last value from the array, resizes the array, and returns the value
	int pop(){
		int value = mainArray[mainArray.length - 1];
		resize(-1);
		return value;
	}

	//inserts the "value" at the "index", moves all other values up which therefore resizes the array +1
	void insert(int index, int value){
		shiftValues(1, index);
		mainArray[index] = value;
	}

	//removes a value from the array and deletes the index of the value, shifts all values above it down
	void remove(int index){
		mainArray[index] = 0;
		shiftValues(-1, index);
		resize(-1);
	}
	
	//updates a specific value in the array, must specify an index to change, does not shift any other values
	void update(int index, int value){
		mainArray[index] = value;
	}
	
	//swaps two values at indices "i1" and "i2"
	void swap(int i1, int i2){
		int value = mainArray[i1];
		mainArray[i1] = mainArray[i2];
		mainArray[i2] = value;
	}
	
	//returns the maximum value in the array, starts at the first value and checks if any are greater than it
	int max(){
		if (mainArray.length > 0){
			int max = mainArray[0];
				for (int x = 0; x < mainArray.length; x++){
					if (mainArray[x] > max){
						max = mainArray[x];
					}
				}
			return max;
		}
		else{
			return 0;
		}
	}
	
	//returns the minimum value in the array, starts at the first value and checks if any are smaller than it
	int min(){
		if (mainArray.length > 0){
			int min = mainArray[0];
			for (int x = 0; x < mainArray.length; x++){
				if (mainArray[x] < min){
					min = mainArray[x];
				}
			}
		return min;
		}
		else{
			return 0;
		}
	}
	
	//takes the average of the array by adding all values and then dividing by the length (number of values)
	//double to return a more accurate average
	double average(){
		double average = 0;
		double sum = this.sum();
		average = sum / mainArray.length;
		return average;
	}
	
	//returns the size of the array
	int size(){
		return mainArray.length;
	}

	//returns a value at the "index"
	int get(int index){
		return mainArray[index];
	}
	
	//sorts using the bubblesort algorithm
	//prints the amount of time it took in ms
	void bubblesort(){
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
	
	//sorts using the insertionsort algorithm
	//prints the amount of time it took in ms
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
	
	//takes the sum of all values of the array, used in average
	int sum(){
		int sum = 0;
		for (int x = 0; x < mainArray.length; x++){
			sum += mainArray[x];
		}
		return sum;
	}
	//checks if the specific index is in the array
	boolean checkIndex(int index){
		if (index < mainArray.length && index >= 0){
			return true;
		}
		else {
			System.out.println("This index is out of bounds.");
			return false;
		}
	}
	
	//fills the array with random values
	void fill(int min, int max){
		int random = 0;
		int range = (max - min) + 1;
		for (int x = 0; x < mainArray.length; x++){
			random = (int)(Math.random() * range) + min;
			mainArray[x] = random;
		}
	}
	
	//fills the array with values "counter" apart, e.g. 0,2,4,6 or 0,3,6,9
	void fill(int counter){
		for (int x = 0; x < mainArray.length; x++){
			mainArray[x] = x*counter;
			
		}
	}
	
	//shifts the values by 1 starting at the first place
	void shiftValues(){
		resize(1);
		for (int x = 0; x < mainArray.length; x++){
			mainArray[x + 1] = mainArray[x];
		}
	}
	
	//shifts the values by "shift" starting at "index"
	//overload of shiftValues
	void shiftValues(int shift, int index){
		resize(shift);
		for (int x = mainArray.length - 1; x > index; x--){
				mainArray[x] = mainArray[x - shift];
		}
	}
	
	//returns the array as an array
	int[] getArray(){
		return mainArray;
	}

	//returns the array as a string of comma-seperated values
	public String toString(){
		String arrayString = "";
		for (int x = 0; x < mainArray.length; x++){
			arrayString += mainArray[x] + "," + " ";
		}
		return arrayString;
	}
}
