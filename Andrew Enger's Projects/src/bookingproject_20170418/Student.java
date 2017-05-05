package bookingproject_20170418;

import java.util.ArrayList;

public class Student extends User {
	
	Student(String _name, String _password, ArrayList<Appointment> _appointment) {
		super(_name, _password, _appointment);
	}
	Student(String _name, String _password) {
		super(_name, _password);
	}

}
