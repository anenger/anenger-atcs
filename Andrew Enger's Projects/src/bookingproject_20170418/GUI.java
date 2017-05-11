package bookingproject_20170418;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI {
	private JFrame mainFrame;
	private JPanel loginPanel;
	private JPanel userPanel;
	private JButton loginButton;
	private JButton createAccountButton;
	private JButton addButton;
	private JButton getButton;
	private JButton scheduleButton;
	private JButton backButton;
	private JLabel headerLabel;
	private JTextField usernametf;
	private JPasswordField passwordtf;
	//private JScrollPane scheduleScroll;
	//private JTable scheduleList;
	private Object[][] appointmentStrings;
	private JTextArea ta;
	private Database users;
	private User loggedIn;

	GUI(Database _users) {
		users = _users;
		mainFrame = new JFrame("Login");
	    mainFrame.setSize(1000,600);
	    mainFrame.setLayout(null);
	    
	    loginPanel = new JPanel();
	    loginPanel.setBounds(0,0,1000,600);
	    loginPanel.setBackground(new Color(207, 0, 15, (int)(0.75 * 255)));
	    loginPanel.setLayout(null);
	    
	    loginButton = new JButton("Login");
	    loginButton.setBounds(425, 300, 150, 40);
	    loginButton.setActionCommand("login");
	    loginButton.addActionListener(new ButtonClickListener());
	    
	    createAccountButton = new JButton("Create an account");
	    createAccountButton.setBounds(425, 340, 150, 40);
	    createAccountButton.setActionCommand("create");
	    createAccountButton.addActionListener(new ButtonClickListener());
	    
	    usernametf = new JTextField();
	    usernametf.setBounds(425, 200, 150, 50);
	    usernametf.setActionCommand("username");
	    usernametf.addActionListener(new KeyboardListener());
	    
	    passwordtf = new JPasswordField();
	    passwordtf.setBounds(425, 250, 150, 50);
	    passwordtf.setActionCommand("password");
	    passwordtf.addActionListener(new KeyboardListener());
	    
	    headerLabel = new JLabel("Welcome to the PCI Scheduler!");
	    headerLabel.setBounds(300, 20, 400, 100);
	    headerLabel.setHorizontalAlignment(JLabel.CENTER);
	    headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
	    
	    userPanel = new JPanel();
	    userPanel.setSize(1000,600);
	    userPanel.setBackground(new Color(102, 160, 255));
	    userPanel.setLayout(null);
	    
	    addButton = new JButton("Add User");
	    addButton.setActionCommand("add");
	    addButton.setBounds(450, 400, 100, 25);
	    addButton.addActionListener(new ButtonClickListener());
	    
	    getButton = new JButton("Get Users");
	    getButton.setActionCommand("get");
	    getButton.setBounds(450, 375, 100, 25);
	    getButton.addActionListener(new ButtonClickListener());
	    
	    scheduleButton = new JButton("Schedule Appointment");
	    scheduleButton.setActionCommand("schedule");
	    scheduleButton.setBounds(400, 425, 200, 25);
	    scheduleButton.addActionListener(new ButtonClickListener());
	    
	    backButton = new JButton("Back");
	    backButton.setActionCommand("back");
	    backButton.setBounds(50, 50, 50, 50);
	    backButton.addActionListener(new ButtonClickListener());
	    
	    ta = new JTextArea("");
	    ta.setBounds(200, 100, 600, 100);
	    
	    //scheduleList = new JTable(new Object[][]{{}}, new String[]{"Appointments"});
	    //scheduleScroll = new JScrollPane(scheduleList);
	    
	    //scheduleScroll.setBounds(400, 100, 200, 100);
	     
	    mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });
	    
	    userPanel.setVisible(false);  
	    
	    loginPanel.add(headerLabel);
	    loginPanel.add(loginButton);
	    loginPanel.add(createAccountButton);
	    loginPanel.add(usernametf);
	    loginPanel.add(passwordtf);
	    loginPanel.setVisible(true);

	    userPanel.add(backButton);
		userPanel.add(getButton);
		userPanel.add(scheduleButton);
		userPanel.add(addButton);
		userPanel.add(ta);
		//userPanel.add(scheduleScroll);
		userPanel.setVisible(false);
	    
	    mainFrame.add(loginPanel);
	    mainFrame.add(userPanel);
	    mainFrame.setVisible(true);
	}
	
	User login(){
		User user1 = null;
		try{
		if ((usernametf.getText().equals("admin")) && 
				(new String(passwordtf.getPassword()).equals("password"))){
				user1 = new User("Admin", "password", "admin");
				mainFrame.setTitle("Admin");
				headerLabel.setText("Administrator Access");
			    addButton.setBounds(400, 350, 200, 50);
			    scheduleButton.setBounds(400, 300, 200, 50);
			    getButton.setBounds(400, 250, 200, 50);
			    ta.setText("");
			    getButton.setText("Get Users");
				getButton.setActionCommand("get");
				userPanel.add(headerLabel);
				userPanel.add(addButton);
				loginPanel.setVisible(false);
				userPanel.setVisible(true);
				usernametf.setText(null);
				passwordtf.setText(null);
		}else if(users.find(usernametf.getText()).getPassword().equals(new String(passwordtf.getPassword()))){
				user1 = users.find(usernametf.getText());
				mainFrame.setTitle("User");
				headerLabel.setText("Welcome " + users.find(usernametf.getText()).getName());
				userPanel.add(headerLabel);
				userPanel.remove(addButton);
				scheduleButton.setBounds(400, 300, 200, 50);
				getButton.setBounds(400, 250, 200, 50);
				ta.setText("");
				getButton.setText("Get Appointments");
				getButton.setActionCommand("appointments");
				loginPanel.setVisible(false);
				userPanel.setVisible(true);
				usernametf.setText(null);
				passwordtf.setText(null);
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(mainFrame, "Your username or password is incorrect");
		}
		return user1;
	}
	
	void createUser(){
		String firstname;
		String lastname;
		String name;
		String id;
		try{
		firstname = JOptionPane.showInputDialog(mainFrame, "Enter first name: ");
		if ((firstname.length() > 2) && (firstname.indexOf(' ') == -1)){
			lastname = JOptionPane.showInputDialog(mainFrame, "Enter last name: ");
			if ((firstname.length() > 2) && (firstname.indexOf(' ') == -1)){
				name = firstname + " " + lastname;
				id = name.substring(0, 2).toLowerCase() + name.substring(name.indexOf(' ') + 1, name.length()).toLowerCase(); 
				if (name != null && users.find(id) == null){
				String type = (String)JOptionPane.showInputDialog(mainFrame, 
						"Select user type: ", 
						"User Type", 
						JOptionPane.PLAIN_MESSAGE, 
						null, 
						new String[]{"Student","Teacher"}, 
						"Student");
				if (type.equals("Student")){
					String password1 = (String)JOptionPane.showInputDialog(mainFrame,
							"Enter a password");
					if (password1 != null){
						String password2 = (String)JOptionPane.showInputDialog(mainFrame,
							"Repeat your password");
						if (password1.equals(password2)){
							if (users.add(new Student(name, password1))){
								JOptionPane.showMessageDialog(mainFrame, "User " + name + " successfully created");
							}
						}
					}
				}else if (type.equals("Teacher")){
					String teacherPass = (String)JOptionPane.showInputDialog(mainFrame,
							"Enter the special teacher code");
					if (teacherPass.equals("packer")){
						String password = (String)JOptionPane.showInputDialog(mainFrame,
								"Enter a password");
						users.add(new Teacher(name, password));
					}
				}
			}else{
				JOptionPane.showMessageDialog(mainFrame, "This user already exists!");
			}
		}else{
			JOptionPane.showMessageDialog(mainFrame, "Please enter a valid last name.");
		}
		}else{
			JOptionPane.showMessageDialog(mainFrame, "Please enter a valid first name.");
	}
	}catch (Exception e){
		System.out.println(e.getMessage());
	}
	}
	
	/*
	
	void updateTable(){
		DefaultTableModel tableModel = (DefaultTableModel)scheduleList.getModel();
		tableModel.setRowCount(0);
		for (Object[] x : appointmentStrings){
			tableModel.addRow(x);
		}
		scheduleList.setModel(tableModel);
		scheduleList.repaint();
	}
	
	*/
	
	private class KeyboardListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			if (command == "username"){
				passwordtf.requestFocus();
			}else if(command == "password"){
				loginButton.requestFocus();
			}
		}
	}
	
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command == "login"){
				loggedIn = login();
			}
			else if (command == "create"){
				createUser();
			}
			else if	(command == "back"){
				mainFrame.setTitle("Login");
				headerLabel.setText("Welcome to the PCI Scheduler!");
				loginPanel.add(headerLabel);
				loginPanel.setVisible(true);
				userPanel.setVisible(false);
				loggedIn = null;
			}
			else if (command == "add"){
				createUser();
				ta.setText(users.toString());
			}
			else if (command == "get"){
				ta.setText(users.toString());
			}
			else if (command == "appointments"){
				String appointmentString = "";
				for(int x = 0; x < loggedIn.getAppointments().size(); x++){
					appointmentString += loggedIn.getAppointment(x).toString() + "\n";
				}
				ta.setText(appointmentString);
			}
			else if (command == "schedule"){
				try{
					if (users.getSize() >= 2){
						String user1 = (String)JOptionPane.showInputDialog(
								mainFrame, 
								"Pick yourself: ", 
								"Schedule Appointment", 
								JOptionPane.PLAIN_MESSAGE, 
								null, users.getUsernames(), 
								null);
						user1 = user1.substring(0, 2).toLowerCase() + user1.substring(user1.indexOf(' ') + 1, user1.length()).toLowerCase(); 
						if (user1 != null){
						User firstUser = users.find(user1);
						if (firstUser != null){
							String user2 = (String)JOptionPane.showInputDialog(mainFrame, "Pick another user: ", "Schedule Appointment", JOptionPane.PLAIN_MESSAGE, null, users.getUsernames(), null);
							if (user2 != null){
								user2 = user2.substring(0, 2).toLowerCase() + user2.substring(user2.indexOf(' ') + 1, user2.length()).toLowerCase(); 
								User secondUser = users.find(user2);
								String[] bandOptions = {"A Band", "B Band", "C Band", "D Band", "E Band", "F Band", "G Band", "Community", "Break"};
								String band = (String)JOptionPane.showInputDialog(mainFrame, 
									"Pick a band: ", 
									"Schedule Appointment", 
									JOptionPane.PLAIN_MESSAGE, 
									null, bandOptions, 
									null);
								if (band != null){
									String room = (String)JOptionPane.showInputDialog(mainFrame, 
											"Enter a room name: ", 
											"Schedule Appointment", 
											JOptionPane.PLAIN_MESSAGE);
									if (room != null){
										firstUser.addAppointment(new Appointment(firstUser, secondUser, band, room));
										secondUser.addAppointment(new Appointment(firstUser, secondUser, band, room));
										users.set(users.findIndex(user1), firstUser);
										users.set(users.findIndex(user2), secondUser);
										loggedIn = firstUser;
									}
								}
							}
						}
						
					}
				}	
					else if(users.getSize() < 2){
						JOptionPane.showMessageDialog(mainFrame, "There are not enough users in the array.");
					}
				}catch(Exception e1){
					System.out.println(e1.getMessage());
				}
				
		}		
	}
}
}
