package de.schauderhaft.architecture.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordInputActionListener implements ActionListener {

	InputView view;
	CrosswordGame game;

	public WordInputActionListener(InputView view, CrosswordGame game) {
		super();
		this.view = view;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String word = view.getInput().trim();
		int points = game.submit(word);
		view.newScore(points);

	}

}
