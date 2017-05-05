package bookingproject_20170418;

import java.util.ArrayList;

public class Teacher extends User {
	
	Teacher(String _name, String _password, ArrayList<Appointment> _appointment) {
		super(_name, _password, _appointment);
	}
	
	Teacher(String _name, String _password) {
		super(_name, _password);
	}

}
