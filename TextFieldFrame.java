package swingDemo;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextFieldFrame extends JFrame {
	
	private JTextField textField1; //text field with set size
	private JTextField textField2; //text field constructed with text
	private JTextField textField3; //text field with text and size
	private JPasswordField passwordField;//password field with text
	
	//TextFieldFrame constructor adds JTextFields to JFrame 
	public TextFieldFrame() {
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout()); //set frame layout
		
		//construct textfield with 10 columns
		textField1 = new JTextField(10);
		add(textField1);//add textField1 to JFrame
		
		//construck textfield with default text
		textField2 = new JTextField("Enter text here");
		add(textField2);//add textField2 to JFrame
		
		//construct textField with default text and 21 columns
		textField3 = new JTextField("Uneditable text field", 21);
		textField3.setEditable(false);//disable editing
		add(textField3);
		
		//construct passwordField with default text
		passwordField = new JPasswordField("HIdden text");
		add(passwordField);
		
		//register even handlers
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}//end TextFieldFrame constructor
		
		//private inner class for event handling
		private class TextFieldHandler implements ActionListener{
			
			//process text field events
			public void actionPerformed(ActionEvent event) {
				
				String string = ""; //declare string to display
				
				//user pressed Enter in JTextField tetField1
				if(event.getSource() == textField1)
					string = String.format("textField1: %s", event.getActionCommand());
				
				//user pressed Enter in JTextFfield textField2
				else if (event.getSource() == textField2)
					string = String.format("textField2: %s", event.getActionCommand());
				
				else if (event.getSource() == textField3)
					string = String.format("textField3: %s", event.getActionCommand());
				else if (event.getSource() == passwordField)
					string = String.format("passwordField: %s", new String(passwordField.getPassword()));
				
				//display JTextField content
				JOptionPane.showMessageDialog(null, string);
				 
			}//end method actionPerformed
		}//end private inner class TextFieldhandler
	}//end class TextField Frame


