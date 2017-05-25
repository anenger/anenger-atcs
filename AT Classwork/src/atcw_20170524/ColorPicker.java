package atcw_20170524;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONObject;

public class ColorPicker extends Frame implements ActionListener{

	private Panel pa1;

	private JColorChooser colorPicker;
	
	private Integer currentButton;
	
	private Color current;
	
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JButton send;
	private JButton setAll;
	private JButton update;
	
	private String[] colors = get();
	
	
	public ColorPicker(){
		setLayout(null);
		setResizable(true);
		setBackground(new Color(0,255,187));
		
		pa1 = new Panel();
		pa1.setLayout(null);
		pa1.setBounds(40, 40, 1500, 1000);
		
		int squareLength = (int)Math.sqrt(colors.length);
		
		for(int x = 0; x < colors.length; x++){
			buttons.add(new JButton(x + ""));
			buttons.get(x).setBounds(40*(x%squareLength), 40*(x/squareLength), 40, 40);
			buttons.get(x).setActionCommand(x + "");
			buttons.get(x).addActionListener(new ButtonClickListener());
			buttons.get(x).setBackground(hex2Rgb(colors[x]));
			buttons.get(x).setOpaque(true);
			pa1.add(buttons.get(x));
		}
		
		colorPicker = new JColorChooser();
		colorPicker.setBounds(40*(squareLength) + 20, 160, 500, 200);
		colorPicker.getSelectionModel().addChangeListener(new ColorSelection());
		colorPicker.setPreviewPanel(new JPanel());
		colorPicker.setChooserPanels(new AbstractColorChooserPanel[]{colorPicker.getChooserPanels()[0]});
		
		send = new JButton();
		send.setBounds(40*(squareLength) + 20, 40, 80, 40);
		send.setText("Send");
		send.setActionCommand("send");
		send.addActionListener(new ButtonClickListener());
		
		setAll = new JButton();
		setAll.setBounds(40*(squareLength) + 20, 80, 80, 40);
		setAll.setText("Set all");
		setAll.setActionCommand("setAll");
		setAll.addActionListener(new ButtonClickListener());
		
		update = new JButton();
		update.setBounds(40*(squareLength) + 20, 120, 80, 40);
		update.setText("Update");
		update.setActionCommand("update");
		update.addActionListener(new ButtonClickListener());
		
		setSize(1500,1000);
		
		addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent evt) {
	             System.exit(0);  // terminate the program
	          }
	      });
		
		pa1.add(send);
		pa1.add(setAll);
		pa1.add(update);
		pa1.add(colorPicker);
		add(pa1);
		setVisible(true);
	}
	
	public static void main(String[] args){
		ColorPicker app = new ColorPicker();
	}
	
	static String[] get(){
		String[] colorArray = null;
		try{
		URL url = new URL("http://pbn.minsky.co/api/colors");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
	    String line;
	    String result = "";
		while ((line = br.readLine()) != null) {
			result += line;
		}
	    br.close();
	    
	    JSONObject jsonObject = new JSONObject(result);
	    colorArray = new String[jsonObject.getJSONArray("squares").length()];
	   	for (int x = 0; x < colorArray.length; x++){
	   		colorArray[x] = jsonObject.getJSONArray("squares").getString(x);
	   	}
		}catch(Exception e1){
			System.out.println(e1);
		}
	   	return colorArray;
	}
	
	static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 0, 2 ), 16 ),
	            Integer.valueOf( colorStr.substring( 2, 4 ), 16 ),
	            Integer.valueOf( colorStr.substring( 4, 6 ), 16 ) );
	}
	
	static String Rgb2hex(int r, int g, int b) {
	    return String.format("%02X%02X%02X", r, g, b);
	}
	
	void setAll(Color c){
		for (int x = 0; x<colors.length; x++){
			buttons.get(x).setBackground(c);
			colors[x] = Rgb2hex(c.getRed(), c.getGreen(), c.getBlue());
		}
	}
	
	String getColorCommand(){
		String command = "http://pbn.minsky.co/api/?";
		for (int x = 0; x < colors.length; x++){
			if (x != colors.length - 1){
				command += x + "=" + colors[x] + "&";
			}else if(x == colors.length - 1){
				command += x + "=" + colors[x];
			}
		}
		System.out.println(command);
		return command;
	}
	
	boolean send(String s) throws Exception{
		URL url = new URL(s);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("PUT");
		
		if (http.getResponseCode() == 200){
			return true;
		}
		return false;
	}
	
	void updateColors(){
		colors = get();
		for (int x = 0; x < colors.length; x++){
			buttons.get(x).setBackground(hex2Rgb(colors[x]));
		}
	}

	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "send"){
				try {
					send(getColorCommand());
					System.out.println("Sent command");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
			else if(e.getActionCommand() == "update"){
				updateColors();
			}
			else if(e.getActionCommand() == "setAll"){
				setAll(current);
			}else{
				currentButton = new Integer(e.getActionCommand());
				buttons.get(currentButton).setBackground(current);
					
				int r = buttons.get(currentButton).getBackground().getRed();
				int g = buttons.get(currentButton).getBackground().getGreen();
				int b = buttons.get(currentButton).getBackground().getBlue();
					
				colors[currentButton] = Rgb2hex(r,g,b);
				System.out.println(currentButton + " " + colors[currentButton]);		
			}
		}
	}
	
	
	 class ColorSelection implements ChangeListener {
	        public void stateChanged(ChangeEvent e) {
	            current = colorPicker.getColor();
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
