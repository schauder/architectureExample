package de.schauderhaft.architecture.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStuff {

	public static void main(String[] args) {

		int runde = 1;

		while (true) {
			System.out.println("Spiel gestartet!");
			System.out.print("Runde " + runde++ + " Eingabe: ");
			String input = makeInput();
			System.out.println(input + " bringt XXX Punkte! Gesamt: XXX");
		}
	}

	private static String makeInput() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String zeile = null;
		try {
			zeile = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zeile;
	}

}
