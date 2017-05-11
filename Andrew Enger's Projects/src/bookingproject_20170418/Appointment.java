package bookingproject_20170418;

public class Appointment {
	private User fromUser;
	private User toUser;
	private String band;
	private String room;
	
	Appointment(User _user1, User _user2, String _band, String _room){
		fromUser = _user1;
		toUser = _user2;
		band = _band;
		room = _room;
	}
	
	public String toString(){
		return fromUser.toString() + ", " + toUser.toString() + ", " + band + ", " + room;
	}
}
