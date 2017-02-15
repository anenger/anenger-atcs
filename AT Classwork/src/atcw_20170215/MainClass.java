package atcw_20170215;

public class MainClass {
	public static void main(String [] args){
		SuperClass a = new SuperClass("Harry", 16);
		SubClass b = new SubClass("Samantha", 17, "Packer", 12);
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a.ageInFiveYears());
		System.out.println(b.ageInFiveYears());
	}
}
