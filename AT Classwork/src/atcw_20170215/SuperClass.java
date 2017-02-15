package atcw_20170215;

public class SuperClass {
	String name;
	int age;
	
	SuperClass(String _name, int _age){
		name = _name;
		age = _age;
	}
	
	public String toString(){
		return name + ", " + age;
	}
	
	int ageInFiveYears(){
		return age+5;
	}
}
