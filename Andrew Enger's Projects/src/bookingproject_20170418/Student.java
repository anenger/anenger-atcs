package bookingproject_20170418;

import java.util.ArrayList;

public class Student extends User {
	
	Student(String _name, ArrayList<Appointment> _appointment) {
		super(_name, _appointment);
	}
	Student(String _name) {
		super(_name);
	}

}
