package apexam_20170501;

public class MainClass {
	public static void main(String[] args){
		int[] scores = {2,2,4,4};
		//System.out.println("LENGTH: " + scores.length);
		//System.out.println(max(average(scores, 0, scores.length/2), average(scores, scores.length/2, scores.length)));
		int[][] arr = new int[][]{
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25},
		};
		for (int r = 0; r < arr.length; r++){
			for (int c = 0; c < arr[r].length; c++){
				System.out.print(arr[r][c] + " ");
			}
			System.out.println("");
		}
		for(int[] x : arr){
			for(int y: x){
				System.out.println(y);
			}
		}
	}

	static int average(int[] scores, int start, int end){
	  int sum = 0;
	  for (int x = start; x < end; x++){
	    sum += scores[x];
	  }
	  return sum/scores.length;
	}

	static int max(int a, int b){
	System.out.println(a + " " + b);
	  if (a > b){
	    return a;
	  }else if (a < b){
	    return b;
	  }else{
	    return a;
	  }
	}
}
