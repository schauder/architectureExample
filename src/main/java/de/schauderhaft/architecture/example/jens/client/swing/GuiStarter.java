package de.schauderhaft.architecture.example.jens.client.swing;

import javax.swing.SwingUtilities;

import de.schauderhaft.architecture.example.steven.client.jettyWebSocket.CommonClientAdapter;

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
        try {
            GuiFactory factory = new SwingGuiFactory();
            // factory.create(new TCPClient()); // Thomas
            factory.create(new CommonClientAdapter()); // Steven
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
