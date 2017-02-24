package atcw_20170223;
// Java0903.java
// This program shows that the subclass does not have access to the private data
// of the superclass.  This program will not compile.


public class Java0903
{
	public static void main(String args[])
	{
		System.out.println("\nJAVA0903\n");
		Student3 tom = new Student3();
		tom.showData();
		System.out.println();
	}
}


class Person3
{
	protected int age;

	public Person3()
	{
		System.out.println("Person Constructor");
		age = 17;
	}
}


class Student3 extends Person3
{
	private int grade;

	public Student3()
	{
		System.out.println("Student Constructor");
		grade = 12;
	}

	public void showData()
	{
		System.out.println("Student's Grade is " + grade);
		System.out.println("Student's Age is " + age);
	}
}


