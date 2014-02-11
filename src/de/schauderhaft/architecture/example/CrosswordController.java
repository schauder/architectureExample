package de.schauderhaft.architecture.example;

import javax.swing.JFrame;

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
