package de.schauderhaft.architecture.example.jens.client.swing;

import de.schauderhaft.architecture.example.common.CommonClient;

public interface GuiFactory {

    /** create and starts an UI properly bound to the game */
    void create(CommonClient client);

}
