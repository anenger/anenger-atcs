package atcw_20170223;
// Java0901.java
// This program demonstrates fundamental inheritance with <extends>.
// There are no constructors yet, which results in Java handling the
// construction and assigning default values to the attributes.


public class Java0901
{
	public static void main(String args[])
	{
		System.out.println("\nJAVA0901\n");
		Student tom = new Student();
		tom.showAge();
		tom.showGrade();
		System.out.println();
	}
}


class Person
{
	private int age;

	public void showAge()
	{
		System.out.println("Person's Age is " + age);
	}
}


class Student extends Person
{
	private int grade;

	public void showGrade()
	{
		System.out.println("Student's Grade is " + grade);
	}
}



