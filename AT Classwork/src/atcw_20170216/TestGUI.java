package atcw_20170216;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
 
// An AWT program inherits from the top-level container java.awt.Frame
public class TestGUI extends Frame implements ActionListener{
   private Label lblCount;    // Declare a Label component 
   private Panel pa1;
   private Panel pa2;
   private TextField tfCount; // Declare a TextField component 
   private Button btnCountUp;   // Declare a Button component
   private Button btnCountDown;
   private Button btnReset;
   private String input = "";     // Counter's value
   private int count = 0;
 
   // Constructor to setup GUI components and event handlers
   public TestGUI () {
      setLayout(new FlowLayout());
         // "super" Frame (a Container) sets its layout to FlowLayout, which arranges
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      pa1 = new Panel();
      add(pa1);
      
      pa2 = new Panel();
      add(pa2);
      
      pa1.setLayout(new FlowLayout());
      pa2.setLayout(new FlowLayout());
      
      lblCount = new Label("Counter");  // construct the Label component
      add(lblCount);                    // "super" Frame adds Label
      
      tfCount = new TextField("", 25); // construct the TextField component
      tfCount.setEditable(true);       // set to read-only
      pa1.add(tfCount);                     // "super" Frame adds TextField
 
      btnCountUp = new Button("UP");   // construct the Button component
      pa2.add(btnCountUp);                    // "super" Frame adds Button
      
      btnCountDown = new Button("DOWN");
      pa2.add(btnCountDown);
      
      btnReset = new Button("RESET");
      pa2.add(btnReset);
 
      btnCountUp.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt){
    		  count++;
    		  tfCount.setText(count + "");
    	  }
      });
      btnCountDown.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt){
    		  count--;
    		  tfCount.setText(count + "");
    	  }
      });
      btnReset.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent evt){
    		  count = 0;
    		  tfCount.setText(count + "");
    	  }
      });
         // btnCount is the source object that fires ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //  an ActionEvent handler called actionPerformed().
         // Clicking btnCount invokes actionPerformed().
 
      pack();
      setTitle("Test GUI");  // "super" Frame sets its title
      setVisible(true);         // "super" Frame shows
      
      // For inspecting the components/container objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
      addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent evt) {
             System.exit(0);  // terminate the program
          }
       });
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      TestGUI app = new TestGUI();
         // or simply "new AWTCounter();" for an anonymous instance
   }
 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
	  System.out.println(evt.getSource());
   }
}