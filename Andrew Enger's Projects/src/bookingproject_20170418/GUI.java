package bookingproject_20170418;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	private JFrame mainFrame;
	private JPanel loginPanel;
	private JPanel userPanel;
	private JButton loginButton;
	private JButton createAccountButton;
	private JButton addButton;
	private JButton getButton;
	private JButton removeButton;
	private JButton backButton;
	private JLabel headerLabel;
	private JTextField usernametf;
	private JPasswordField passwordtf;
	private JTextArea ta;
	private Database users;

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
	    
	    backButton = new JButton("Back");
	    backButton.setActionCommand("back");
	    backButton.setBounds(50, 50, 50, 50);
	    backButton.addActionListener(new ButtonClickListener());
	    
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

	    userPanel.add(backButton);
		userPanel.add(getButton);
		userPanel.add(removeButton);
		userPanel.add(addButton);
		userPanel.add(ta);
		userPanel.setVisible(false);
	    
	    mainFrame.add(loginPanel);
	    mainFrame.add(userPanel);
	    mainFrame.setVisible(true);
	}
	
	void login(){
		try{
		if ((usernametf.getText().equals("admin")) && 
				(new String(passwordtf.getPassword()).equals("password"))){
				mainFrame.setTitle("Admin");
				headerLabel.setText("Administrator Access");
		}else if(users.find(usernametf.getText()).getPassword().equals(new String(passwordtf.getPassword()))){
				mainFrame.setTitle("User");
				headerLabel.setText("Welcome " + users.find(usernametf.getText()).getName());
		}
		userPanel.add(headerLabel);
		loginPanel.setVisible(false);
		userPanel.setVisible(true);
		usernametf.setText(null);
		passwordtf.setText(null);
		}catch(Exception e){
			JOptionPane.showMessageDialog(mainFrame, "Your username or password is incorrect");
		}
	}
	
	void createUser(){
		String name = JOptionPane.showInputDialog(mainFrame, "Enter full name: ");
		String id = name.substring(0, 2).toLowerCase() + name.substring(name.indexOf(' ') + 1, name.length()).toLowerCase(); 
		if (name != null && users.find(id) == null){
				String type = (String)JOptionPane.showInputDialog(mainFrame, 
						"Select user type: ", 
						"User Type", 
						JOptionPane.PLAIN_MESSAGE, 
						null, 
						new String[]{"Student","Teacher"}, 
						"Student");
				if (type.equals("Student")){
					String password = (String)JOptionPane.showInputDialog(mainFrame,
							"Enter a password");
					users.add(new Student(name, password));
				}else if (type.equals("Teacher")){
					String teacherPass = (String)JOptionPane.showInputDialog(mainFrame,
							"Enter the special teacher code");
					if (teacherPass.equals("packer")){
						String password = (String)JOptionPane.showInputDialog(mainFrame,
								"Enter a password");
						users.add(new Teacher(name, password));
					}
				}
		}else if(users.find(id) != null){
			JOptionPane.showMessageDialog(mainFrame, "This user already exists");
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
				createUser();
			}
			else if	(command == "back"){
				mainFrame.setTitle("Login");
				headerLabel.setText("Welcome to the PCI Scheduler!");
				loginPanel.add(headerLabel);
				loginPanel.setVisible(true);
				userPanel.setVisible(false);
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
