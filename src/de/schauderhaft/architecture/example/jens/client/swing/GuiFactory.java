package de.schauderhaft.architecture.example.jens.client.swing;

import de.schauderhaft.architecture.example.CrosswordGame;

public interface GuiFactory {

    /** create and starts an UI properly bound to the game */
    void create(CrosswordGame game);

}
