package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class CrosswordGameWebSocketServer {

	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		new CrosswordGameWebSocketServer();
	}

	public CrosswordGameWebSocketServer() {

		System.out.println("Starting web server at port " + PORT);
		try {
			startWebServer();
		} catch (Exception e) {
			System.out.println("Exception starting web server: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void startWebServer() throws Exception, InterruptedException {
		Server server = new Server(PORT);
		WebSocketHandler wsHandler = new WebSocketHandler() {
			@Override
			public void configure(WebSocketServletFactory factory) {
				// this is the class that shall be instantiated for each
				// incoming websocket upgrade request
				factory.register(MyWebSocketHandler.class);
			}
		};
		server.setHandler(wsHandler);
		server.start();
		server.join();
	}
}