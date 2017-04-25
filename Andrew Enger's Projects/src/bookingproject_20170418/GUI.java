package bookingproject_20170418;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	private JFrame mainFrame;
	private JButton addButton;
	private JButton getButton;
	private JButton removeButton;
	private JTextArea ta;
	private Database users;
	private JComboBox userComboBox;
	
	GUI(Database _users) {
		users = _users;
		mainFrame = new JFrame("Scheduler");
	    mainFrame.setSize(1000,600);
	    mainFrame.setLayout(new FlowLayout());
	    
	    addButton = new JButton("Add User");
	    addButton.setActionCommand("add");
	    addButton.addActionListener(new ButtonClickListener());
	    
	    getButton = new JButton("Get Users");
	    getButton.setActionCommand("get");
	    getButton.addActionListener(new ButtonClickListener());
	    
	    removeButton = new JButton("Schedule Appointment");
	    removeButton.setActionCommand("schedule");
	    removeButton.addActionListener(new ButtonClickListener());
	    
	    ta = new JTextArea("", 15, 30);
	    
	    mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });
	    mainFrame.add(getButton);
	    mainFrame.add(removeButton);
	    mainFrame.add(addButton);
	    mainFrame.add(ta);
	    mainFrame.setVisible(true);  
	}
	/*
	void showUsers(){
		String[] usernames = new String[users.getSize()];
		for (int x = 0; x < usernames.length; x++){
			usernames[x] = users.getUser(x).getName();
		}
		userComboBox = new JComboBox<Object>(usernames);
		mainFrame.add(userComboBox);
	}
	*/
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command == "add"){
				String name = JOptionPane.showInputDialog("Enter full name: ");
				if (name != null){
					users.add(new User(name));
				}
				ta.setText(users.toString());
			}
			else if (command == "get"){
				ta.setText(users.toString());
			}
			else if (command == "schedule"){
				showUsers();
			}
		}		
	}
}
