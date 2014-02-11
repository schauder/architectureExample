package de.schauderhaft.architecture.example;

import java.util.Arrays;
import java.util.HashSet;

public class GuiStarter {

	public static void main(String[] args) {

		InputView view = new InputView();

		CrosswordGame crosswordGame = new CrosswordGame(new HashSet<String>(
				Arrays.asList("Haus", "Maus", "Auto")));

		CrossWordController controller = new CrossWordController(view,
				crosswordGame);
		controller.start();

	}
}
