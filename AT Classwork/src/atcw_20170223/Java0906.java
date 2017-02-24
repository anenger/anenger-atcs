package atcw_20170223;
// Java0906.java
// This program demonstrates how to pass information to the
// superclass by using the <super> Java keyword.


public class Java0906
{
	public static void main(String args[])
	{
		System.out.println("\nJAVA0906\n");
		Student6 tom = new Student6(12,17,5.6);
		tom.showData();
		System.out.println();
	}
}


class Person6
{
	protected int age;
	protected double height;

	public Person6(int a, double h)
	{
		System.out.println("Person Parameter Constructor");
		age = a;
		height = h;
	}

	public int getAge()
	{
		return age;
	}
}


class Student6 extends Person6
{
	protected int grade;

	public Student6(int g, int a, double h)
	{
		super(a, h);   // this must be the first call
		grade = g;
		System.out.println("Student Parameter Constructor");
	}

	public int getGrade()
	{
		return grade;
	}

	public void showData()
	{
		System.out.println("Student's Grade is " + getGrade());
		System.out.println("Student's Age is " + getAge());
	}
}


