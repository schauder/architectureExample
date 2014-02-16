package de.schauderhaft.architecture.example.swing.thomas.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.schauderhaft.architecture.example.CrosswordGame;

public class TCPServer {

    private Map<String, CrosswordGame> hostname2game = new HashMap<String, CrosswordGame>();
    private Set<String> words;

    public TCPServer(final Set<String> words) {
	this.words = words;

    }

    public void startServer(int port) throws IOException {
	String clientSentence;
	ServerSocket welcomeSocket = new ServerSocket(port);
	while (true) {
	    Socket connectionSocket = welcomeSocket.accept();
	    BufferedReader inFromClient = new BufferedReader(
		    new InputStreamReader(connectionSocket.getInputStream()));
	    clientSentence = inFromClient.readLine();
	    System.out.println("Received: " + clientSentence);

	    // fehlende Validierung auf 2 Inhalte!
	    String[] split = clientSentence
		    .split(ServerConst.MESSAGE_SEPARATOR);

	    String hostname = split[0];
	    CrosswordGame game = getOrCreateCrossworGame(hostname);

	    String word = split[1];
	    int answer = game.submit(word);

	    responseAnswer(connectionSocket, answer);

	    inFromClient.close();
	    connectionSocket.close();
	}
    }

    private CrosswordGame getOrCreateCrossworGame(String hostname) {
	// fehlende Validierung des Hostnamens
	if (!hostname2game.containsKey(hostname)) {
	    hostname2game.put(hostname, new CrosswordGame(words));
	}
	return hostname2game.get(hostname);

    }

    private void responseAnswer(Socket connectionSocket, int answer)
	    throws IOException {
	DataOutputStream outToClient = new DataOutputStream(
		connectionSocket.getOutputStream());
	outToClient.writeBytes(String.valueOf(answer));
	outToClient.close();
    }

    public static void main(String argv[]) throws Exception {
	HashSet<String> knownWords = new HashSet<String>(Arrays.asList("Haus",
		"Maus", "Auto"));
	int port = 6789;
	if (argv.length > 0) {
	    port = Integer.valueOf(argv[0]);
	}
	TCPServer server = new TCPServer(knownWords);
	server.startServer(port);
    }
}
