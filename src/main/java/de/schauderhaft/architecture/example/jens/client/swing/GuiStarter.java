package de.schauderhaft.architecture.example.jens.client.swing;

import java.util.Arrays;
import java.util.HashSet;

import javax.swing.SwingUtilities;

import de.schauderhaft.architecture.example.CrosswordGame;

public class GuiStarter {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                new GuiStarter().go();
            }
        });
    }

    private void go() {
        GuiFactory factory = new SwingGuiFactory();
        factory.create(new CrosswordGame(new HashSet<String>(Arrays.asList(
                "Auto", "Maus", "Haus"))));
        factory.create(new CrosswordGame(new HashSet<String>(Arrays.asList(
                "Auto", "Maus", "Haus"))));
        factory.create(new CrosswordGame(new HashSet<String>(Arrays.asList(
                "Auto", "Maus", "Haus"))));
    }
}
