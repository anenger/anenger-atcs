package toothpick_20161107;

public class toothpickMain {

	public static void main(String[] args){
		
		int toothpicks = 45;
		int rows = 0;
		int finalrows = 0;
		
		for (rows = 1; rows*3 < toothpicks; rows++){
			for (int x = 1; x < rows; x++){
				finalrows++;
				System.out.println(finalrows);
			}
		}
		
	}
	
}
