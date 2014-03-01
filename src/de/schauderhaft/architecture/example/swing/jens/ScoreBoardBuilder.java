package de.schauderhaft.architecture.example.swing.jens;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class ScoreBoardBuilder {

    private final JLabel textbox = new JLabel("Points:");

    public ValueApi getApi() {
        return new ValueApi() {
            @Override
            public void setValue(int submit) {
                textbox.setText("Points: " + submit);
            }
        };
    }

    public JComponent getComponent() {
        return textbox;
    }

}
