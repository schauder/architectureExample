package de.schauderhaft.architecture.example.swing.thomas.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
		System.in));
	Socket clientSocket;
	try {
	    clientSocket = new Socket("localhost", 6789);

	    DataOutputStream socketOut = new DataOutputStream(
		    clientSocket.getOutputStream());

	    BufferedReader fromServer = new BufferedReader(
		    new InputStreamReader(clientSocket.getInputStream()));

	    String sentence = inFromUser.readLine();
	    socketOut.writeBytes(sentence + '\n');
	    String modifiedSentence = fromServer.readLine();
	    System.out.println("FROM SERVER: " + modifiedSentence);
	    socketOut.close();
	    fromServer.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}