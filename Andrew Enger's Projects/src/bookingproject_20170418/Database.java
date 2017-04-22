package bookingproject_20170418;

import java.util.ArrayList;

public class Database {
	ArrayList<User> userList;

	public Database(ArrayList<User> _userList) {
		userList = _userList;
	}
	
	public Database(){
		userList = new ArrayList<User>();
	}
	
	ArrayList<User> getUserList(){
		return userList;
	}
	
	boolean add(User _user){
		return userList.add(_user);
	}
	
	public String toString(){
		String users = "";
		for(int x = 0; x < userList.size(); x++){
			users += userList.get(x).getName() + " (" + userList.get(x).getAppointments() + ") " + "\n";
		}
		return users;
	}

}
