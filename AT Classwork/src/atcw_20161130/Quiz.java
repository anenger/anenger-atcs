package atcw_20161130;
//Test
public class Quiz {
	int score;
	int lives;
	String name;
	Quiz(int s, int l, String n){
		score = s; 
		lives = l;
	}
	int getScore(){
		return score;
	}
	void setScore(int s){
		score = s;
	}
	int getLives(){
		return lives;
	}
	void setLives(int l){
		lives = l;
	}
	void lostLife(){
		lives = lives - 1;
	}
}
