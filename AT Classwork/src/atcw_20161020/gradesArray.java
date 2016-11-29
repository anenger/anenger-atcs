package atcw_20161020;

public class gradesArray {

	public static void main(String[] args) {
		// declaring variables
		final int length = 100;
		int[] grades = new int[length];
		int grade = 0;
		int mean = 0;
		int min = 0;
		int max = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int sum = 0;
		double arraysum = 0;
		double sd = 0;
		// filling the array with random numbers
		for (int x = 0; x < length; x++) {
			grades[x] = (int) (Math.random() * 40 + 60);
			// System.out.print(grades[x] + ", ");
		}
		// System.out.println("");
		// taking the average
		for (int x = 0; x < length; x++) {
			mean += grades[x];
		}
		mean /= length;
		System.out.println("The average is " + mean);

		// finding the minimum
		min = grades[0];
		for (int x = 0; x < length; x++) {
			if (min > grades[x]) {
				min = grades[x];
			}
		}
		System.out.println("The min is " + min);

		// finding the maximum
		max = grades[0];
		for (int x = 0; x < length; x++) {
			if (max < grades[x]) {
				max = grades[x];
			}
		}
		System.out.println("The max is " + max);

		// finding individual grades
		for (int x = 0; x < length; x++) {
			if (grades[x] > 60 && grades[x] < 70) {
				d++;
			} else if (grades[x] > 70 && grades[x] < 80) {
				c++;
			} else if (grades[x] > 80 && grades[x] < 90) {
				b++;
			} else if (grades[x] > 90 && grades[x] < 100) {
				a++;
			}
		}
		System.out.println("There are " + a + " A's, " + b + " B's, " + c + " C's and " + d + " D's.");

		// finding the sum of all values
		for (int x = 0; x < length; x++) {
			sum += grades[x];
		}
		System.out.println("The sum of all values is " + sum);

		// finding the standard deviation
		for (int x = 0; x < length; x++) {
			arraysum = (grades[x] - mean) * (grades[x] - mean);
		}
		sd = Math.sqrt(arraysum / length);
		System.out.println("The standard deviation is " + sd);
	}

}
