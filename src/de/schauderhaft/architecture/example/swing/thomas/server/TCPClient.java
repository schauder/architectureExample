package de.schauderhaft.architecture.example.swing.thomas.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public int request(String word) {

		Socket clientSocket = null;
		DataOutputStream socketToServer = null;
		BufferedReader responseFromServer = null;
		try {
			clientSocket = new Socket("localhost", 10000);
			socketToServer = new DataOutputStream(
					clientSocket.getOutputStream());

			socketToServer.writeBytes(createMessage(word) + '\n');

			responseFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String response = responseFromServer.readLine();
			System.out.println("FROM SERVER: " + response);

			return Integer.valueOf(response);
		} catch (IOException e) {
			throw new RuntimeException("Ohne Server keine Kekse!");
		} finally {
			// close should be in finally block
			closeStream(clientSocket, socketToServer, responseFromServer);
		}
	}

	String createMessage(String word) {
		StringBuilder message = new StringBuilder();
		try {
			message.append(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			throw new RuntimeException("Zugriff auf eigene IP fehlgeschlagen!"
					+ e);
		}
		message.append(ServerConst.MESSAGE_SEPARATOR);
		message.append(word);
		return message.toString();

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

	/**
	 * FŸr Testzwecke zum separaten Starten
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		Socket clientSocket;
		try {
			clientSocket = new Socket("localhost", 10000);

			DataOutputStream socketOut = new DataOutputStream(
					clientSocket.getOutputStream());

			BufferedReader fromServer = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));

			String sentence = inFromUser.readLine();
			System.out.println("Client: Sentece: " + sentence);
			socketOut
					.writeBytes(new TCPClient().createMessage(sentence) + '\n');
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