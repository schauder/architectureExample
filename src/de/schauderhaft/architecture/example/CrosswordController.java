package de.schauderhaft.architecture.example;

import javax.swing.JFrame;

public class CrossWordController {

	private InputView view;
	private CrosswordGame crosswordGame;

	public CrossWordController(InputView view, CrosswordGame crosswordGame) {
		super();
		this.view = view;
		this.crosswordGame = crosswordGame;
	}

	public void start() {

		WordInputComponent inputWordComponent = new WordInputComponent(view,
				crosswordGame);
		inputWordComponent.combineView2game();

		view.getInputView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getInputView().setVisible(true);

	}

}
