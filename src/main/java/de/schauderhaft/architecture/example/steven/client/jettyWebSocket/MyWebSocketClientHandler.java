package de.schauderhaft.architecture.example.steven.client.jettyWebSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class MyWebSocketClientHandler {

    private final CountDownLatch closeLatch = new CountDownLatch(1);

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out
                .println("Connection established. Ready to send words to server");
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) throws IOException {

        try {
            int totalPoints = Integer.valueOf(message);

            System.out.println("new Points: " + totalPoints);
        } catch (NumberFormatException nfe) {
            System.out.println(message);
        }
        String input = makeInput();
        session.getRemote().sendString(input);
    }

    private static String makeInput() {
        BufferedReader console = new BufferedReader(new InputStreamReader(
                System.in));
        String zeile = null;
        try {
            zeile = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zeile;
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("WebSocket Closed. Code:" + statusCode);
    }

    public boolean awaitClose(int duration, TimeUnit unit)
            throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

}
