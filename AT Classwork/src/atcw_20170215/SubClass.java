package atcw_20170215;

public class SubClass extends SuperClass {
	String school;
	int grade;
	
	SubClass(String _name, int _age, String _school, int _grade){
		super(_name, _age);
		school = _school;
		grade = _grade;
	}
	
	public String toString(){
		return super.toString() + ", " + school + ", " + grade;
	}
}
