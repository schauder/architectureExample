package de.schauderhaft.architecture.example;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard {

	JPanel container = new JPanel();
	JLabel text = new JLabel("Points:");
	JLabel points = new JLabel("0");

	public ScoreBoard() {
		container.add(text);
		container.add(points);

	}

	public JPanel getScorePanel() {
		return container;
	}

	/**
	 * Add new value to label.
	 * 
	 * @param newScore
	 */
	public void newScore(int newScore) {
		points.setText(Integer.valueOf(newScore).toString());
	}

}
