package atcw_20161130;

public class PrepForQuiz {
	static int times2(int x){
		return x*2;
	}
	public static void main(String[] args){
		Quiz q1 = new Quiz(10, 3, "L of a quiz");
		q1.lostLife();
		System.out.println(q1.getLives());
		q1.setScore(times2(q1.getScore()));
		System.out.println(q1.getScore());
		System.out.println();
	}
}
