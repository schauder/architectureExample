package de.schauderhaft.architecture.example.steven.client.jettyWebSocket;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import de.schauderhaft.architecture.example.steven.server.jettyWebSocket.CommunicationBuffer;

@WebSocket
public class MyWebSocketClientHandler {

    private final CommunicationBuffer buffer;

    private final CountDownLatch closeLatch = new CountDownLatch(1);

    public MyWebSocketClientHandler(CommunicationBuffer buffer) {
        this.buffer = buffer;
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out
                .println("Connection established. Ready to send words to server");
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) throws IOException {

        try {
            int totalPoints = Integer.valueOf(message);

            buffer.putPoints(totalPoints);
        } catch (NumberFormatException nfe) {
            System.out.println(message);
        }
        String input = buffer.pullInput();
        session.getRemote().sendString(input);
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
