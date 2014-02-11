package de.schauderhaft.architecture.example.swing.thomas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputView {

    JFrame frame = new JFrame("CrossWord");

    JTextField inputfield = new JTextField();
    JButton submit = new JButton("submit");
    ScoreBoard score = new ScoreBoard();

    public InputView() {
        inputfield.setPreferredSize(new Dimension(80, 20));
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(inputfield);
        frame.getContentPane().add(submit);

        frame.getContentPane().add(score.getScorePanel());
        frame.pack();
    }

    public JFrame getInputView() {
        return frame;
    }

    public void addActionForSubmit(ActionListener action) {
        submit.addActionListener(action);
    }

    /**
     * Access to inputfield
     * 
     * @return
     */
    public String getInput() {
        return inputfield.getText();

    }

    public void newScore(int points) {
        score.newScore(points);

    }

}
