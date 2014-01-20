package de.schauderhaft.architecture.example;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputView {

	private static final String INPUT_LENTGH = "                                         ";

	JFrame frame = new JFrame("CrossWord");

	JTextField inputfield = new JTextField(INPUT_LENTGH);
	JButton submit = new JButton("submit");
	ScoreBoard score = new ScoreBoard();

	public InputView() {
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(inputfield);
		frame.getContentPane().add(submit);
		frame.getContentPane().add(score.getScorePanel());
		frame.pack();
	}

	public JFrame getInputView() {
		return frame;
	}

}
