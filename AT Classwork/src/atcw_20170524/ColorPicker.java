package atcw_20170524;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONObject;

public class ColorPicker extends Frame implements ActionListener{

	private Panel pa1;

	private JColorChooser colorPicker;
	
	private Integer currentButton;
	
	private Color current = Color.WHITE;

	private JButton send;
	private JButton setAll;
	private JButton update;
	private JButton save;
	private JButton saveas;
	private JButton load;
	
	private JLabel size;
	
	private JList text;
	private JScrollPane scroll;
	private DefaultListModel listModel;
	
	private String[] colors = get();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<ArrayList<String>> saved = readFile("images.csv");
	
	private int squareLength = (int)Math.sqrt(colors.length);
	
	public ColorPicker(){
		setLayout(null);
		setResizable(false);
		setBackground(new Color(0,255,187));
		setTitle("Paint By Numbers");
		
		pa1 = new Panel();
		pa1.setLayout(null);
		pa1.setBounds(40, 60, 80 + 40*squareLength + 700, 200 + 40*squareLength);
		
		for(int x = 0; x < colors.length; x++){
			buttons.add(new JButton());
			buttons.get(x).setBounds(40*(x%squareLength), 40*(x/squareLength), 40, 40);
			buttons.get(x).setActionCommand(x + "");
			buttons.get(x).addActionListener(new ButtonClickListener());
			buttons.get(x).setBackground(hex2Rgb(colors[x]));
			buttons.get(x).setOpaque(true);
			buttons.get(x).setBorderPainted(false);
			pa1.add(buttons.get(x));
		}
		
		colorPicker = new JColorChooser();
		colorPicker.setBounds(40*(squareLength) + 20, 140, 675, 300);
		colorPicker.getSelectionModel().addChangeListener(new ColorSelection());
		colorPicker.setPreviewPanel(new JPanel());
		colorPicker.setChooserPanels(new AbstractColorChooserPanel[]{colorPicker.getChooserPanels()[0], colorPicker.getChooserPanels()[1]});
		
		send = new JButton();
		send.setBounds(40*(squareLength) + 20, 0, 80, 40);
		send.setText("Send");
		send.setActionCommand("send");
		send.addActionListener(new ButtonClickListener());
		
		setAll = new JButton();
		setAll.setBounds(40*(squareLength) + 100, 0, 80, 40);
		setAll.setText("Set all");
		setAll.setActionCommand("setAll");
		setAll.addActionListener(new ButtonClickListener());
		
		update = new JButton();
		update.setBounds(40*(squareLength) + 180, 0, 80, 40);
		update.setText("Update");
		update.setActionCommand("update");
		update.addActionListener(new ButtonClickListener());
		
		save = new JButton();
		save.setBounds(40*(squareLength) + 340, 0, 80, 40);
		save.setText("Save");
		save.setActionCommand("save");
		save.addActionListener(new ButtonClickListener());
		
		saveas = new JButton();
		saveas.setBounds(40*(squareLength) + 500, 0, 80, 40);
		saveas.setText("Save As");
		saveas.setActionCommand("saveas");
		saveas.addActionListener(new ButtonClickListener());
		
		load = new JButton();
		load.setBounds(40*(squareLength) + 420, 0, 80, 40);
		load.setText("Load");
		load.setActionCommand("load");
		load.addActionListener(new ButtonClickListener());
		
		size = new JLabel(squareLength + " x " + squareLength);
	    size.setBounds(40*(squareLength) + 20, 60, 80, 40);
	    size.setHorizontalAlignment(JLabel.LEFT);
	    size.setFont(new Font("Futura", Font.PLAIN, 20));
		
		scroll = new JScrollPane();
		
		listModel = new DefaultListModel<Object>();
		updateList(saved);
		
		text = new JList(listModel);
		
		scroll.setViewportView(text);
		scroll.setBounds(40*(squareLength) + 340, 40, 240, 80);
		
		setSize(80 + 40*squareLength + 700, 200 + 40*squareLength);
		
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
		pa1.add(save);
		pa1.add(load);
		pa1.add(saveas);
		pa1.add(scroll);
		pa1.add(size);
		pa1.setVisible(true);
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
	
	static ArrayList<ArrayList<String>> readFile(String filename){
		FileReader fr;
		ArrayList<ArrayList<String>> fileArray = new ArrayList<ArrayList<String>>();
		try{
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> datastring = new ArrayList<String>();
			String input = "";
			while((input = br.readLine()) != null){
				datastring.add(input);
			}
			for (int i = 0; i < datastring.size(); i++){
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(datastring.get(i).split(",")));
				try{
					fileArray.add(list);
				}catch(Exception e){
					System.out.println("ERROR: " + e);
				}
			}
			br.close();
		}catch(Exception e){
			System.out.println("ERROR: " + e);
		}
		return fileArray;
	}
	
	static void writeFile(String filename, ArrayList<ArrayList<String>> designs){
		try {
			FileWriter fw = new FileWriter(filename);
			for (ArrayList<String> x : designs){
				for (String y : x){
					fw.write(y + ",");
				}
				fw.write("\n");
			}
			fw.close();
		}catch(Exception e){
			System.out.println("ERROR: " + e);
		}
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
	
	void setAll(ArrayList<String> c){
		for (int x = 0; x<buttons.size(); x++){
			buttons.get(x).setBackground(hex2Rgb(c.get(x + 1)));
			colors[x] = Rgb2hex(hex2Rgb(c.get(x + 1)).getRed(), hex2Rgb(c.get(x + 1)).getGreen(), hex2Rgb(c.get(x + 1)).getBlue());
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
		String[] newColors = get();
		if (newColors != null){
			colors = newColors;
			squareLength = (int)Math.sqrt(colors.length);
			for (int x = 0; x < colors.length; x++){
				buttons.get(x).setBackground(hex2Rgb(colors[x]));
			}
		}
	}
	
	void redraw(){
		for (int x = 0; x < buttons.size(); x++){
			if (buttons.get(x) != null)	pa1.remove(buttons.get(x));
		}
		for(int x = 0; x < colors.length; x++){
			buttons.add(new JButton());
			buttons.get(x).setBounds(40*(x%squareLength), 40*(x/squareLength), 40, 40);
			buttons.get(x).setActionCommand(x + "");
			buttons.get(x).addActionListener(new ButtonClickListener());
			buttons.get(x).setBackground(hex2Rgb(colors[x]));
			buttons.get(x).setOpaque(true);
			buttons.get(x).setBorderPainted(false);
			pa1.add(buttons.get(x));
		}
	}
	
	void updateList(ArrayList<ArrayList<String>> sa){
		listModel.removeAllElements();
		for (int x = 0; x < sa.size(); x++){
			listModel.addElement(sa.get(x).get(0));
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
				int sl = squareLength;
				updateColors();
				if (sl != squareLength){
					redraw();
				}
			}
			else if(e.getActionCommand() == "setAll"){
				setAll(current);
			}
			else if(e.getActionCommand() == "save"){
				int index = text.getSelectedIndex();
				if (index != -1){
					ArrayList<String> design = new ArrayList<String>(Arrays.asList(colors));
					design.add(0, saved.get(index).get(0));
					saved.set(index, design);
					writeFile("images.csv", saved);
				}
			}
			else if(e.getActionCommand() == "saveas"){
				String name = JOptionPane.showInputDialog(pa1, "Enter name of design", null);
				if (name != null){
					ArrayList<String> design = new ArrayList<String>(Arrays.asList(colors));
					design.add(0, name);
					saved.add(design);
					writeFile("images.csv", saved);
				}
				updateList(saved);
			}
			else if(e.getActionCommand() == "load"){
				setAll(saved.get(text.getSelectedIndex()));
			}
			else{
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
	            System.out.println(current.toString());
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
