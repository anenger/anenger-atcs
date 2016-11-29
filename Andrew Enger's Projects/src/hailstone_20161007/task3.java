package hailstone_20161007;
public class task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hailstone = 0;
		int tracker = 0;
		System.out.println("Printing every sequence from 1 to 100");
		for (int i = 1; i <= 100; i++){
			tracker = 0;
			hailstone = i;
				while (hailstone != 1){
					if (hailstone % 2 == 0){
						hailstone = hailstone / 2;
					}
					else{
						hailstone = (hailstone * 3) + 1;
					}
					tracker++;
				}
			System.out.println("If the number is: " + i + " the count is: " +  tracker);
		}
	}

}
