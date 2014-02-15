package de.schauderhaft.architecture.example.swing.thomas.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;

import de.schauderhaft.architecture.example.CrosswordGame;

public class TCPServer {

    private CrosswordGame game;

    public TCPServer(CrosswordGame game) {
	this.game = game;
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

	    int answer = game.submit(clientSentence);

	    responseAnswer(connectionSocket, answer);

	    inFromClient.close();
	    connectionSocket.close();
	}
    }

    private void responseAnswer(Socket connectionSocket, int answer)
	    throws IOException {
	DataOutputStream outToClient = new DataOutputStream(
		connectionSocket.getOutputStream());
	outToClient.writeBytes(String.valueOf(answer));
	outToClient.close();
    }

    public static void main(String argv[]) throws Exception {
	CrosswordGame game = new CrosswordGame(new HashSet<String>(
		Arrays.asList("Haus", "Maus", "Auto")));
	int port = 6789;
	if (argv.length > 0) {
	    port = Integer.valueOf(argv[0]);
	}
	TCPServer server = new TCPServer(game);
	server.startServer(port);
    }
}
