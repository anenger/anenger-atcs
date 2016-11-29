package learningclasses_20161120;
import java.util.Scanner;
/* assignment 
 * Create three different person objects.
 * Use 3 different person methods.
 * Change the value of the int danger in one of your objects.  Discuss why this is dangerous.
 * Println one of the objects.  Discuss what you notice about the method toString()
 * Add a variable to the person class
 * Make a new method in the person class. (be creative)
 * Use that method for one of your person objects.
 */

public class Person {
		private String name;
		private int age;
		private String health = "";
		private String relationship = "";
		private int money;
		private String gender = "";
		Scanner input = new Scanner(System.in);
		
		//was working weirdly, had to save for another project
//		Person(){
//			System.out.println("Please input a name, a gender, and an amount of money:");
//			name = input.nextLine();
//			gender = input.nextLine();
//			money = input.nextInt();
//			input.close();
//		}
		Person(String n){
			name = n;
			age = (int)(Math.random()*100);
			money = (int)(Math.random()*10000);
		}
		Person(String n, int a){
			name = n;
			age = a;
		}
		Person(String n, int a, int m){
			name = n;
			age = a;
			money = m;
		}
		Person(String n, int a, int m, String g){
			name = n;
			age = a;
			money = m;
			gender = g;
		}
		Person(String n, int a, int m, String g, String h){
			name = n;
			age = a;
			money = m;
			gender = g;
			health = h;
		}
		void setHealth(String h) {
			health=h;
		}
		String getHealth(){
			return health;
		}
		void setRelationship(String r, Person p){
			relationship="is " + r + " with " + p + ".";
		}
		String getRelationship(){
			return relationship;
		}
		void setName(String n){
			name = n;
		}
		String getName() {
			return name;
		}
		void setAge(int a){
			age = a;
		}
		int getAge() {
			return age;
		}
		void setMoney(int m){
			money = m;
		}
		int getMoney(){
			return money;
		}
		void transferMoney(Person p2, int t){
			if (money >= t){
				money -= t;
				p2.setMoney(p2.money + t);
				System.out.println("You have successfully transferred " + t + " into " + p2.getName() + "'s account.");
				System.out.println("Their balance is " + p2.getMoney() + ".");
			}
			else{
				System.out.println("There is not enough money in " + getName() + "'s account");
				System.out.println("Their balance is " + getMoney() + ", and they need " + t + ".");
			}
		}
		void growUp() {
			age++;
		}
		void growUp(int x) {
			age += x;
		}
		public String toString(){
			return name + " " + age + " " + money + " " + health + " " + gender;
		}
	}