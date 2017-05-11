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
	
	boolean set(int x, User _user){
		return (userList.set(x, _user) != null);
	}
	
	User getUser(int x){
		return userList.get(x);
	}
	//returns an array of the arraylist userList
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
			usernames[x] = userList.get(x).getName();
		}
		return usernames;
	}
	
	User find(String _userid){
		User user;
		for (int x = 0; x < userList.size(); x++){
			String idString = userList.get(x).getID();
			if (idString.compareTo(_userid) == 0){
				user = userList.get(x);
				return user;
			}
		}
		return null;
	}
	
	int findIndex(String _userid){
		for (int x = 0; x < userList.size(); x++){
			if (userList.get(x).getID().equals(_userid)){
				return x;
			}
		}
		return -1;
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
