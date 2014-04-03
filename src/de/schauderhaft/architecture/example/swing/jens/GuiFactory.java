package de.schauderhaft.architecture.example.swing.jens;

import de.schauderhaft.architecture.example.swing.thomas.server.TCPClient;

public interface GuiFactory {

    /** create and starts an UI properly bound to the game */
    void create(TCPClient client);

}
