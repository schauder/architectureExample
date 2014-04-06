package de.schauderhaft.architecture.example.thomas.client.swing;

import java.util.Arrays;
import java.util.HashSet;

import de.schauderhaft.architecture.example.CrosswordGame;

public class GuiStarter {

    public static void main(String[] args) {

        InputView view = new InputView();

        CrosswordGame crosswordGame = new CrosswordGame(new HashSet<String>(
                Arrays.asList("Haus", "Maus", "Auto")));

        CrosswordController controller = new CrosswordController(view,
                crosswordGame);
        controller.start();

    }
}
