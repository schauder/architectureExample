package de.schauderhaft.architecture.example.steven.client.jettyWebSocket;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import de.schauderhaft.architecture.example.steven.server.jettyWebSocket.CommunicationBuffer;

public class Client {

    private final CommunicationBuffer buffer;

    public Client(CommunicationBuffer buffer) {
        this.buffer = buffer;
    }

    public void run(URI destinationUri) throws IOException {

        WebSocketClient client = new WebSocketClient();
        MyWebSocketClientHandler socketHandler = new MyWebSocketClientHandler(
                buffer);
        try {
            client.start();
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            System.out.println("Connecting to " + destinationUri);
            client.connect(socketHandler, destinationUri, request);

            socketHandler.awaitClose(5, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}