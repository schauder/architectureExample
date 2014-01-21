package de.schauderhaft.architecture.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrosswordController {

	InputView view;
	CrosswordGame game;

	public CrosswordController(InputView view, CrosswordGame game) {
		super();
		this.view = view;
		this.game = game;
	}

	public void combineView2game() {

		view.addActionForSubmit(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String word = view.getInput().trim();
				int points = game.submit(word);
				view.newScore(points);
			}
		});
	}

}
