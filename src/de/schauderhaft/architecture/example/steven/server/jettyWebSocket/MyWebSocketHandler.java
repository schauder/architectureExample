package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import de.schauderhaft.architecture.example.CrosswordGame;

@WebSocket
public class MyWebSocketHandler {

	Set<String> knownWords;
	private Map<String, CrosswordGame> games;

	public MyWebSocketHandler() {

		System.out.print("New connection detected! Instantiating new WebSocket, filling dictionary. ");
		try {
			knownWords = Helper.fillDictionary();
			System.out.println("There are " + knownWords.size() + " words in the dictionary.");
		} catch (IOException e) {
			System.out.println("Exception filling dictionary: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		String clientIdentifier = extractClientIdentifier(session);
		System.out.println("New connection from " + clientIdentifier + ", sending welcome message");
		try {
			// games.put(clientIdentifier, new CrosswordGame(knownWords));
			session.getRemote().sendString("Welcome, client! I started a new game for you and am ready to receive your words.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnWebSocketMessage
	public void onMessage(Session session, String message) {
		System.out.println("Message from " + session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort() + ": " + message);
	}

	@OnWebSocketClose
	public void onClose(Session session, int statusCode, String reason) {
		System.out.println("Closed connection from " + session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort()
				+ " because of code " + statusCode + " (" + reason + ")");
	}

	@OnWebSocketError
	public void onError(Session session, Throwable t) {
		System.out.println("Error with client " + session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort() + ": " + t.getMessage());
	}

	/**
	 * Extracts an identifier string from a session so that every connection can
	 * be identified.
	 * 
	 * @param session
	 *            from which to extract the identifier
	 * @return string identifier
	 */
	private String extractClientIdentifier(Session session) {
		String clientIdentifier = session.getRemoteAddress().getAddress() + ":" + session.getRemoteAddress().getPort();
		return clientIdentifier;
	}

}