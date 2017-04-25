package bookingproject_20170418;

import java.util.ArrayList;

public class Teacher extends User {
	
	Teacher(String _name, ArrayList<Appointment> _appointment) {
		super(_name, _appointment);
	}
	
	Teacher(String _name) {
		super(_name);
	}

}
