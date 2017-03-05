package testgui_20170228;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class QuizGUI extends Frame implements ActionListener {
	
	private int whichQuestion = 0;
	private int score = 0;
	
	private Panel pa1;
	private Panel pa2;
	private Panel pa3;
	private Panel welcomePanel;
	private Panel endPanel;
	
	private Label welcomeLabel;
	private Label scoreLabel;
	private Label questionLabel;
	private Label answerLabel1;
	private Label answerLabel2;
	private Label answerLabel3;
	private Label answerLabel4;
	private Label endLabel;

	private Button ba;
	private Button bb;
	private Button bc;
	private Button bd;
	private Button startButton;
	private Button restartButton;
	
	private Font font1;
	private Font font2;
	private Font font3;
	
	WindowListener wl = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    };
	
	QuizGUI(){
		setLayout(null);
		
		font1 = new Font("Futura", Font.BOLD, 28);
		font2 = new Font("Futura", Font.PLAIN, 26);
		font3 = new Font("Futura", Font.BOLD, 18);
		
		setBackground(new Color(100,100,100));
	
		welcomePanel = new Panel();
		welcomeLabel = new Label();
		questionLabel = new Label();
		startButton = new Button();
		
		pa1 = new Panel();
		pa2 = new Panel();
		pa3 = new Panel();
		
		ba = new Button();
		bb = new Button();
		bc = new Button();
		bd = new Button();
		
		scoreLabel = new Label();
		questionLabel = new Label();
		answerLabel1 = new Label();
		answerLabel2 = new Label();
		answerLabel3 = new Label();
		answerLabel4 = new Label();
		
		endPanel = new Panel();
		restartButton = new Button();
		endLabel = new Label();
		
		welcomePanel.setBounds(0, 0, 1000, 750);
		welcomePanel.setBackground(Color.BLUE);
		welcomePanel.setVisible(true);
		welcomePanel.setLayout(null);
		
		welcomeLabel.setText("Welcome to the US History Quiz!");
		welcomeLabel.setBounds(200, 200, 600, 100);
		welcomeLabel.setAlignment(Label.CENTER);
		welcomeLabel.setFont(font1);
		welcomeLabel.setBackground(Color.WHITE);
		
		startButton.setBounds(440,500,120,50);
		startButton.setLabel("Start");
		startButton.setFont(font2);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				welcomePanel.setVisible(false);
				pa1.setVisible(true);
				pa2.setVisible(true);
				pa3.setVisible(true);
				nextScreen();
			}
		});
		startButton.setVisible(true);
		
		pa1.setBounds(0, 0, 1000, 200);
		pa1.setBackground(Color.WHITE);
		pa1.setVisible(false);
		pa1.setLayout(null);
		
		pa2.setBounds(0, 200, 1000, 350);
		pa2.setBackground(Color.GRAY);
		pa2.setVisible(false);
		pa2.setLayout(null);
		
		pa3.setBounds(0, 550, 1000, 200);
		pa3.setBackground(Color.WHITE);
		pa3.setVisible(false);
		pa3.setLayout(null);
		
		scoreLabel.setBounds(50, 75, 200, 50);
		scoreLabel.setFont(font1);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setAlignment(Label.CENTER);
		scoreLabel.setText("");
		scoreLabel.setVisible(true);
		
		questionLabel.setBounds(50, 50, 900, 50);
		questionLabel.setText("");
		questionLabel.setAlignment(Label.CENTER);
		questionLabel.setVisible(true);
		questionLabel.setFont(font1);
		questionLabel.setBackground(Color.WHITE);
		
		answerLabel1.setBounds(50, 100, 900, 50);
		answerLabel1.setText("");
		answerLabel1.setAlignment(Label.CENTER);
		answerLabel1.setVisible(true);
		answerLabel1.setFont(font2);
		answerLabel1.setBackground(Color.WHITE);
		
		answerLabel2.setBounds(50, 150, 900, 50);
		answerLabel2.setText("");
		answerLabel2.setAlignment(Label.CENTER);
		answerLabel2.setVisible(true);
		answerLabel2.setFont(font2);
		answerLabel2.setBackground(Color.WHITE);
		
		answerLabel3.setBounds(50, 200, 900, 50);
		answerLabel3.setText("");
		answerLabel3.setAlignment(Label.CENTER);
		answerLabel3.setVisible(true);
		answerLabel3.setFont(font2);
		answerLabel3.setBackground(Color.WHITE);
		
		answerLabel4.setBounds(50, 250, 900, 50);
		answerLabel4.setText("");
		answerLabel4.setAlignment(Label.CENTER);
		answerLabel4.setVisible(true);
		answerLabel4.setFont(font2);
		answerLabel4.setBackground(Color.WHITE);
		
		ba.setBounds(325, 25, 50, 50);
		ba.setLabel("A");
		ba.setFont(font3);
		ba.addActionListener(this);
		
		bb.setBounds(425, 25, 50, 50);
		bb.setLabel("B");
		bb.setFont(font3);
		bb.addActionListener(this);
		
		bc.setBounds(525, 25, 50, 50);
		bc.setLabel("C");
		bc.setFont(font3);
		bc.addActionListener(this);
		
		bd.setBounds(625, 25, 50, 50);
		bd.setLabel("D");
		bd.setFont(font3);
		bd.addActionListener(this);
		
		endPanel.setBounds(0, 0, 1000, 750);
		endPanel.setBackground(Color.GRAY);
		endPanel.setVisible(true);
		endPanel.setLayout(null);
		
		endLabel.setText("Welcome to the US History Quiz!");
		endLabel.setBounds(325, 200, 350, 100);
		endLabel.setAlignment(Label.CENTER);
		endLabel.setFont(font1);
		endLabel.setBackground(Color.WHITE);
		
		restartButton.setBounds(440,500,120,50);
		restartButton.setLabel("Restart");
		restartButton.setFont(font2);
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				score = 0;
				whichQuestion = 0;
				endPanel.setVisible(false);
				welcomePanel.setVisible(true);
			}
		});
		restartButton.setVisible(true);
		
		add(welcomePanel);
		welcomePanel.add(welcomeLabel);
		welcomePanel.add(startButton);
		
		add(pa1);
		add(pa2);
		add(pa3);
		
		pa1.add(scoreLabel);
		
		pa2.add(questionLabel);
		pa2.add(answerLabel1);
		pa2.add(answerLabel2);
		pa2.add(answerLabel3);
		pa2.add(answerLabel4);
		
		pa3.add(ba);
		pa3.add(bb);
		pa3.add(bc);
		pa3.add(bd);
		
		add(endPanel);
		endPanel.add(restartButton);
		endPanel.add(endLabel);
		
	    addWindowListener(wl);
		setTitle("US History Quiz");
		setResizable(false);
		setSize(1000,750);
		setVisible(true);
		
	
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		QuizGUI gui = new QuizGUI();
	}
	
	void nextScreen(){
		whichQuestion++;
		if (whichQuestion == 1){
			scoreLabel.setText("Score: " + score + "/4");
			questionLabel.setText("Who was the first president of the United States?");
			answerLabel1.setText("A: George Washington");
			answerLabel2.setText("B: Abraham Lincoln");
			answerLabel3.setText("C: John Adams");
			answerLabel4.setText("D: Alexander Hamilton");
		}
		else if (whichQuestion == 2){
			scoreLabel.setText("Score: " + score + "/4");
			questionLabel.setText("When was the bombing of Pearl Harbor?");
			answerLabel1.setText("A: September 3, 1939");
			answerLabel2.setText("B: December 7, 1941");
			answerLabel3.setText("C: June 22, 1942");
			answerLabel4.setText("D: May 7, 1945");
		}
		else if (whichQuestion == 3){
			scoreLabel.setText("Score: " + score + "/4");
			questionLabel.setText("Who was the president during the Cuban Missile Crisis?");
			answerLabel1.setText("A: Richard Nixon");
			answerLabel2.setText("B: Dwight Eisenhower");
			answerLabel3.setText("C: John F Kennedy");
			answerLabel4.setText("D: Harry Truman");
		}
		else if (whichQuestion == 4){
			scoreLabel.setText("Score: " + score + "/4");
			questionLabel.setText("What is the capital of New York State?");
			answerLabel1.setText("A: New York City");
			answerLabel2.setText("B: Albany");
			answerLabel3.setText("C: Buffalo");
			answerLabel4.setText("D: Syracuse");
		}
		else if (whichQuestion == 5){
			pa1.setVisible(false);
			pa2.setVisible(false);
			pa3.setVisible(false);
			endPanel.setVisible(true);
			endLabel.setText("Your score is: " + score + "/4");
		}
	}
	
	void checkQuestion(String answer){
		if (answer.equals("A") && whichQuestion == 1){
			score++;
		}
		else if (answer.equals("B") && whichQuestion == 2){
			score++;
		}
		else if (answer.equals("C") && whichQuestion == 3){
			score++;
		}
		else if (answer.equals("B") && whichQuestion == 4){
			score++;
		}
		System.out.println(score);
		nextScreen();
	}

	@Override
	public void actionPerformed(ActionEvent evt){
		checkQuestion(evt.getActionCommand());
	}
}