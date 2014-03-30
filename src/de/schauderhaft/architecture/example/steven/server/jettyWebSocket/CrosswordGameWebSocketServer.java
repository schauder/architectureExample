package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class CrosswordGameWebSocketServer {

	private static final int PORT = 8080;

	HashSet<String> knownWords;

	public CrosswordGameWebSocketServer() {

		System.out.println("Filling dictionary");
		try {
			knownWords = new HashSet<String>();
			fillDictionary(knownWords);
		} catch (IOException e) {
			System.out.println("Exception filling dictionary: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Starting web server at port " + PORT);
		try {
			startWebServer();
		} catch (Exception e) {
			System.out.println("Exception starting web server: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new CrosswordGameWebSocketServer();
	}

	private void fillDictionary(HashSet<String> knownWords) throws IOException {
		knownWords.addAll(readFile("ressource/dictionary/altamer.0"));
		knownWords.addAll(readFile("ressource/dictionary/altamer.1"));
		knownWords.addAll(readFile("ressource/dictionary/altamer.2"));
		knownWords.addAll(readFile("ressource/dictionary/american.0"));
		knownWords.addAll(readFile("ressource/dictionary/american.1"));
		knownWords.addAll(readFile("ressource/dictionary/american.2"));
		knownWords.addAll(readFile("ressource/dictionary/british.0"));
		knownWords.addAll(readFile("ressource/dictionary/british.1"));
		knownWords.addAll(readFile("ressource/dictionary/british.2"));
		knownWords.addAll(readFile("ressource/dictionary/english.0"));
		knownWords.addAll(readFile("ressource/dictionary/english.1"));
		knownWords.addAll(readFile("ressource/dictionary/english.2"));
		knownWords.addAll(readFile("ressource/dictionary/english.3"));

		System.out.println("There are " + knownWords.size() + " words in the dictionary.\n");
	}

	private Set<String> readFile(String path) throws IOException {
		HashSet<String> set = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line;
		while ((line = br.readLine()) != null) {
			set.add(line);
		}
		br.close();
		return set;
	}

	private void startWebServer() throws Exception, InterruptedException {
		Server server = new Server(PORT);
		WebSocketHandler wsHandler = new WebSocketHandler() {
			@Override
			public void configure(WebSocketServletFactory factory) {
				factory.register(MyWebSocketHandler.class);
			}
		};
		server.setHandler(wsHandler);
		server.start();
		server.join();
	}
}