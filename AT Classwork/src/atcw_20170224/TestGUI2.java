package atcw_20170224;

import java.awt.*;
import java.awt.event.*;

public class TestGUI2 extends Frame implements ActionListener{

	private Panel pa1;
	private Panel pa2;
	private Panel pa3;
	
	private TextField tfNumber;
	private Label lbl;
	
	private Button btnCountUp;
	private Button btnCountDown;
	private Button btnGet;
	
	private int count = 0;
	
	private Color color1 = new Color(0,255,187);
	
	public TestGUI2(){
		setLayout(null);
		setResizable(false);
		setBackground(color1);
		
		pa1 = new Panel();
		pa2 = new Panel();
		pa3 = new Panel();
		
		tfNumber = new TextField(count + "", 10);
		lbl = new Label("Counter: ");
		
		btnCountUp = new Button("+");
		btnCountDown = new Button("-");
		btnGet = new Button("RESET");
		
		tfNumber.setEditable(false);
		
		pa1.setBounds(200, 75, 100, 50);
		pa1.setBackground(Color.BLUE);
		
		pa2.setBounds(150, 225, 200, 50);
		pa2.setBackground(Color.BLUE);
		
		pa3.setBounds(200, 375, 100, 50);
		pa3.setBackground(Color.BLUE);
		
		pa1.add(lbl);
		pa1.add(tfNumber);
		
		pa2.add(btnCountUp);
		pa2.add(btnCountDown);
		
		pa3.add(btnGet);
		
		add(pa1);
		add(pa2);
		add(pa3);
		
		setTitle("Counter");
		setSize(500, 500);
		
		btnCountUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				count++;
				tfNumber.setText(count + "");
			}
		});
		
		btnCountDown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				count--;
				tfNumber.setText(count + "");
			}
		});
		
		btnGet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println(tfNumber.getText());
			}
		});
		
		addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent evt) {
	             System.exit(0);  // terminate the program
	          }
	      });
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		TestGUI2 app = new TestGUI2();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt){
		
	}
	
	
}
