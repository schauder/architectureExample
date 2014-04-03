package de.schauderhaft.architecture.example.jens.client.swing;

import javax.swing.SwingUtilities;

import de.schauderhaft.architecture.example.swing.thomas.server.TCPClient;

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
	factory.create(new TCPClient());
    }
}
