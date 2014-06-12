package de.schauderhaft.architecture.example.steven.client.jettyWebSocket;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class Client {

    public static void main(String[] args) throws IOException,
            URISyntaxException {
        new Client().run(new URI("ws://localhost:8080/"));
    }

    public void run(URI destinationUri) throws IOException {

        WebSocketClient client = new WebSocketClient();
        MyWebSocketClientHandler socketHandler = new MyWebSocketClientHandler();
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