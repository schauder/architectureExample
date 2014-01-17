package de.schauderhaft.architecture.example;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputView {

	JFrame frame = new JFrame("CrossWord");
	
	JTextField inputfield = new  JTextField("");
	
	public  InputView() {
		frame.getContentPane().add(inputfield);
		frame.pack();
	}
	
	public JFrame getInputView() {
		return frame;
	}
	
}
