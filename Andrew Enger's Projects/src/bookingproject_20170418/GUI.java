package bookingproject_20170418;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	private JFrame mainFrame;
	private JPanel loginPanel;
	private JPanel createPanel;
	private JPanel userPanel;
	private JButton loginButton;
	private JButton createAccountButton;
	private JButton addButton;
	private JButton getButton;
	private JButton removeButton;
	private JLabel headerLabel;
	private JTextField usernametf;
	private JPasswordField passwordtf;
	private JTextArea ta;
	private Database users;
	private JComboBox userComboBox;
	private JDialog schedulePopup;
	private String[] bandArray;

	GUI(Database _users) {
		users = _users;
		mainFrame = new JFrame("Login");
	    mainFrame.setSize(1000,600);
	    mainFrame.setLayout(null);
	    
	    loginPanel = new JPanel();
	    loginPanel.setBounds(0,0,1000,600);
	    loginPanel.setBackground(Color.ORANGE);
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
	    userPanel.setBackground(Color.ORANGE);
	    userPanel.setLayout(null);
	    
	    addButton = new JButton("Add User");
	    addButton.setActionCommand("add");
	    addButton.setBounds(450, 400, 100, 25);
	    addButton.addActionListener(new ButtonClickListener());
	    
	    getButton = new JButton("Get Users");
	    getButton.setActionCommand("get");
	    getButton.setBounds(600, 135, 100, 25);
	    getButton.addActionListener(new ButtonClickListener());
	    
	    removeButton = new JButton("Schedule Appointment");
	    removeButton.setActionCommand("schedule");
	    removeButton.setBounds(400, 425, 200, 25);
	    removeButton.addActionListener(new ButtonClickListener());
	    
	    ta = new JTextArea("");
	    ta.setBounds(400, 100, 200, 100);
	    
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
	    
	    mainFrame.add(loginPanel);
	    mainFrame.add(userPanel);
	    mainFrame.setVisible(true);
	}
	
	void login(){
		if ((usernametf.getText().equals("admin")) && 
				(new String(passwordtf.getPassword()).equals("password"))){
				mainFrame.setTitle("Admin");
				headerLabel.setText("Administrator Access");
				userPanel.add(headerLabel);
				userPanel.add(getButton);
				userPanel.add(removeButton);
				userPanel.add(addButton);
				userPanel.add(ta);
				loginPanel.setVisible(false);
				userPanel.setVisible(true);
		}else if(users.find(usernametf.getText()).getPassword().equals(new String(passwordtf.getPassword()))){
				mainFrame.setTitle("Admin");
				headerLabel.setText("Welcome " + users.find(usernametf.getText()).getName());
				userPanel.add(headerLabel);
				userPanel.add(getButton);
				userPanel.add(removeButton);
				userPanel.add(addButton);
				userPanel.add(ta);
				loginPanel.setVisible(false);
				userPanel.setVisible(true);
		}
	}
	
	boolean createUser(){
		String name = JOptionPane.showInputDialog("Enter full name: ");
		if (name != null){
			if (users.find(name) == null){
				String type = (String)JOptionPane.showInputDialog(mainFrame, 
						"Select user type: ", 
						"User Type", 
						JOptionPane.PLAIN_MESSAGE, 
						null, 
						new String[]{"Student","Teacher"}, 
						"Student");
				if (type.equals("Student")){
					users.add(new Student(name));
				}else if (type.equals("Teacher")){
					users.add(new Teacher(name));
				}
				return true;
			}else{
				JOptionPane.showMessageDialog(mainFrame, "This user already exists");
				return false;
			}
		}else{
			return false;
		}
	}
	
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
				login();
			}
			else if (command == "create"){
				
			}
			else if	(command == "back"){
				
			}
			else if (command == "add"){
				createUser();
				ta.setText(users.toString());
			}
			else if (command == "get"){
				ta.setText(users.toString());
			}
			else if (command == "schedule"){
				try{
					if (users.getSize() >= 2){
						User firstUser = users.find((String)JOptionPane.showInputDialog(mainFrame, "Pick yourself: ", "Schedule Appointment", JOptionPane.PLAIN_MESSAGE, null, users.getUsernames(), null));
						System.out.println(firstUser);
						if (firstUser != null){
							User secondUser = users.find((String)JOptionPane.showInputDialog(mainFrame, "Pick another user: ", "Schedule Appointment", JOptionPane.PLAIN_MESSAGE, null, users.getUsernames(), null));
							String[] bandOptions = {"A Band", "B Band", "C Band", "D Band", "E Band", "F Band", "G Band", "Community", "Break"};
							String band = (String)JOptionPane.showInputDialog(mainFrame, 
									"Pick a band: ", 
									"Schedule Appointment", 
									JOptionPane.PLAIN_MESSAGE, 
									null, bandOptions, 
									null);
							firstUser.addAppointment(new Appointment(firstUser, secondUser, band, ""));
							secondUser.addAppointment(new Appointment(firstUser, secondUser, band, ""));
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
