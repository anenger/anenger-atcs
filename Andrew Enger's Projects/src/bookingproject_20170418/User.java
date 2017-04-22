package bookingproject_20170418;

import java.util.ArrayList;

public class User {
	private String name;
	private ArrayList<Appointment> appointments;
	User(String _name, ArrayList<Appointment> _appointments){
		name = _name;
		appointments = _appointments;
	}
	User(String _name){
		name = _name;
		appointments = new ArrayList<Appointment>();
	}
	
	String getName(){
		return name;
	}
	
	ArrayList<Appointment> getAppointments(){
		return appointments;
	}
	
	void addAppointment(Appointment _appointment){
		appointments.add(_appointment);
	}
}
