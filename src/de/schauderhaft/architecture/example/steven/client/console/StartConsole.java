package de.schauderhaft.architecture.example.steven.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import de.schauderhaft.architecture.example.CrosswordGame;
import de.schauderhaft.architecture.example.wordlibrary.Library;

public class StartConsole {

	private static CrosswordGame game;

	public static void main(String[] args) throws IOException {

		HashSet<String> knownWords = new HashSet<String>();
		fillDictionary(knownWords);

		System.out.println("Game started!");
		System.out.println("There are " + knownWords.size()
				+ " words in the dictionary.\n");
		game = new CrosswordGame(knownWords);

		int runde = 1;
		int pointsTotalLastRound = 0;

		while (true) {

			System.out.print("Round " + runde++ + " Input: ");
			String input = makeInput();

			int pointsTotal = game.submit(input);
			System.out.println("\"" + input + "\" gives "
					+ (pointsTotal - pointsTotalLastRound) + " points! Sum: "
					+ pointsTotal);
			pointsTotalLastRound = pointsTotal;
		}
	}

	private static String makeInput() {
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		String zeile = null;
		try {
			zeile = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zeile;
	}

	private static void fillDictionary(HashSet<String> knownWords)
			throws IOException {
		knownWords.addAll(Library.getAllWords());
	}

}
