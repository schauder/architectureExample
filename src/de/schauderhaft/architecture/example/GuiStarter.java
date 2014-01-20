package de.schauderhaft.architecture.example;

import javax.swing.JFrame;

public class GuiStarter {

	public static void main(String[] args) {

		InputView view = new InputView();
		view.getInputView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getInputView().setVisible(true);
	}
}
