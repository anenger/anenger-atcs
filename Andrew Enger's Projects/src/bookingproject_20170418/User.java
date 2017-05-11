package bookingproject_20170418;

import java.util.ArrayList;

public class User {
	private String name;
	private String password;
	private String id;
	private ArrayList<Appointment> appointments;
	User(String _name, String _password, ArrayList<Appointment> _appointments){
		name = _name;
		password = _password;
		id = _name.substring(0, 2).toLowerCase() + _name.substring(_name.indexOf(' ') + 1, _name.length()).toLowerCase(); 
		System.out.println("ID: " + id);
		appointments = _appointments;
	}
	User(String _name, String _password){
		name = _name;
		password = _password;
		id = _name.substring(0, 2).toLowerCase() + _name.substring(_name.indexOf(' ') + 1, _name.length()).toLowerCase(); 
		System.out.println("ID: " + id);
		appointments = new ArrayList<Appointment>();
	}
	
	User(String _name, String _password, String _id){
		name = _name;
		password = _password;
		id = _id;
		appointments = new ArrayList<Appointment>();
	}
	
	String getName(){
		return name;
	}
	
	String getID(){
		return id;
	}
	
	String getPassword(){
		return password;
	}
	
	ArrayList<Appointment> getAppointments(){
		return appointments;
	}
	
	Appointment getAppointment(int x){
		return appointments.get(x);
	}
	
	Object[][] getAppointmentsArray(){
		Object[][] array = new Object[appointments.size()][1];
		for (int x = 0; x < appointments.size(); x++){
			array[x][0] = appointments.get(x);
		}
		return array;
	}
	
	void addAppointment(Appointment _appointment){
		appointments.add(_appointment);
	}
	
	public String toString(){
		return name;
	}
}
