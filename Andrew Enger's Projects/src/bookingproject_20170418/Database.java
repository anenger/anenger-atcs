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
	
	User getUser(int x){
		return userList.get(x);
	}
	
	User[] getUsers(){
		User[] users = new User[userList.size()];
		for (int x = 0; x < userList.size(); x++){
			users[x] = userList.get(x);
		}
		return users;
	}
	
	String[] getUsernames(){
		String[] usernames = new String[userList.size()];
		for (int x = 0; x < userList.size(); x++){
			usernames[x] = userList.get(x).getName() + ", " + userList.get(x).getClass().getSimpleName();
		}
		return usernames;
	}
	
	User find(String _user){
		User user;
		String userString;
		for (int x = 0; x < userList.size(); x++){
			userString = userList.get(x).getName() + ", " + userList.get(x).getClass().getSimpleName();
			if (userString.compareTo(_user) == 0){
				user = userList.get(x);
				return user;
			}
		}
		return null;
	}
	
	int getSize(){
		return userList.size();
	}
	
	public String toString(){
		String users = "";
		for(int x = 0; x < userList.size(); x++){
			users += userList.get(x).getName() + ", " + userList.get(x).getClass().getSimpleName() + ", (" + userList.get(x).getAppointments().size() + ") " + "\n";
		}
		return users;
	}

}
