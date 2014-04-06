package de.schauderhaft.architecture.example.thomas.client.swing;

import javax.swing.JFrame;

import de.schauderhaft.architecture.example.CrosswordGame;

public class CrosswordController {

    private final InputView view;
    private final CrosswordGame crosswordGame;

    public CrosswordController(InputView view, CrosswordGame crosswordGame) {
        super();
        this.view = view;
        this.crosswordGame = crosswordGame;
    }

    public void start() {

        view.addActionForSubmit(new WordInputActionListener(view, crosswordGame));

        view.getInputView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.getInputView().setVisible(true);

    }

}
