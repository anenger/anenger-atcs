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
	private JDialog schedulePopup;
	private String[] bandArray;

	GUI(Database _users) {
		users = _users;
		mainFrame = new JFrame("Scheduler");
	    mainFrame.setSize(1000,600);
	    mainFrame.setLayout(null);
	    
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
	    mainFrame.add(getButton);
	    mainFrame.add(removeButton);
	    mainFrame.add(addButton);
	    mainFrame.add(ta);
	    mainFrame.setVisible(true);  
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command == "add"){
				String name = JOptionPane.showInputDialog("Enter full name: ");
				if (name != null){
					users.add(new Student(name));
					
				}
				ta.setText(users.toString());
			}
			else if (command == "get"){
				ta.setText(users.toString());
			}
			else if (command == "schedule"){
				if (users.getSize() != 0){
					String first = (String)JOptionPane.showInputDialog(mainFrame, "Pick yourself: ", "Schedule Appointment", JOptionPane.PLAIN_MESSAGE, null, users.getUsernames(), null);
					User firstUser = users.find(first);
					System.out.println(firstUser.getName() + first);
					if (firstUser != null){
						String second = (String)JOptionPane.showInputDialog(mainFrame, "Pick another user: ", "Schedule Appointment", JOptionPane.PLAIN_MESSAGE, null, users.getUsernames(), null);
						User secondUser = users.find(second);
						firstUser.addAppointment(new Appointment(firstUser, secondUser, "", ""));
						System.out.println(firstUser.getAppointments());
					}
				
			}
				
		}		
	}
}
}
