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
	    
	    removeButton = new JButton("Remove Random Room");
	    removeButton.setActionCommand("remove");
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
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command == "add"){
				String name = JOptionPane.showInputDialog("Enter full name");
				users.add(new User(name));
				ta.setText(users.toString());
			}
			else if (command == "get"){
				ta.setText(users.toString());
			}
		}		
	}
}
