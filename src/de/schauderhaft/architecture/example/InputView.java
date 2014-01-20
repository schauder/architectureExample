package de.schauderhaft.architecture.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputView {

	JFrame frame = new JFrame("CrossWord");

	JTextField inputfield = new JTextField("");
	JButton submit = new JButton("submit");
	ScoreBoard score = new ScoreBoard();

	public InputView() {
		frame.getContentPane().add(inputfield);
		frame.getContentPane().add(submit);
		frame.getContentPane().add(score.getScorePanel());
		frame.pack();
	}

	public JFrame getInputView() {
		return frame;
	}

}
