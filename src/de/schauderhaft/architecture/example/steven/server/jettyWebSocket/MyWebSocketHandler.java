package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class MyWebSocketHandler {

	@OnWebSocketClose
	public void onClose(Session session, int statusCode, String reason) {
		System.out.println("Closed connection from " + session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort()
				+ " because of code " + statusCode + " (" + reason + ")");
	}

	@OnWebSocketError
	public void onError(Session session, Throwable t) {
		System.out.println("Error with client " + session.getRemoteAddress().getAddress() + ": " + t.getMessage());
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		System.out.println("New connection from " + session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort()
				+ ", sending welcome message");
		try {
			session.getRemote().sendString("Welcome, client! I started a new game for you and am ready to receive your words.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnWebSocketMessage
	public void onMessage(Session session, String message) {
		System.out.println("Message from " + session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort() + ": " + message);
	}
}