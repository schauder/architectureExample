package de.schauderhaft.architecture.example.swing.thomas.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public String request(String word) {

	Socket clientSocket = null;
	DataOutputStream socketToServer = null;
	BufferedReader responseFromServer = null;
	try {
	    clientSocket = new Socket("localhost", 6789);
	    socketToServer = new DataOutputStream(
		    clientSocket.getOutputStream());

	    socketToServer.writeBytes(word + '\n');

	    responseFromServer = new BufferedReader(new InputStreamReader(
		    clientSocket.getInputStream()));
	    String response = responseFromServer.readLine();
	    System.out.println("FROM SERVER: " + response);

	    return response;
	} catch (IOException e) {
	    throw new RuntimeException("Ohne Server keine Kekse!");
	} finally {
	    // close should be in finally block
	    closeStream(clientSocket, socketToServer, responseFromServer);
	}
    }

    private void closeStream(Socket clientSocket, DataOutputStream socketOut,
	    BufferedReader fromServer) {
	if (clientSocket != null) {
	    try {
		clientSocket.close();
	    } catch (IOException e) {
		System.err.println(e);
	    }
	}
	if (socketOut != null) {
	    try {
		socketOut.close();
	    } catch (IOException e) {
		System.err.println(e);
	    }

	}
	if (fromServer != null) {

	    try {
		fromServer.close();
	    } catch (IOException e) {
		System.err.println(e);
	    }
	}

    }

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