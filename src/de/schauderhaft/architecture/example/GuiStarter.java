package de.schauderhaft.architecture.example;

import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JFrame;

public class GuiStarter {

	public static void main(String[] args) {

		InputView view = new InputView();

		CrosswordGame crosswordGame = new CrosswordGame(new HashSet<String>(
				Arrays.asList("Haus", "Maus", "Auto")));

		CrosswordController controller = new CrosswordController(view,
				crosswordGame);
		controller.combineView2game();

		view.getInputView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getInputView().setVisible(true);
	}
}
