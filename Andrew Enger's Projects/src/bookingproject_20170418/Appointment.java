package bookingproject_20170418;

public class Appointment {
	private User fromUser;
	private User toUser;
	private Band band;
	private Room room;
	
	Appointment(User _user1, User _user2, Band _band, Room _room){
		fromUser = _user1;
		toUser = _user2;
		band = _band;
		room = _room;
	}
}
