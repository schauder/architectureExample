package de.schauderhaft.architecture.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConsoleStuff {

	private static CrosswordGame game;

	public static void main(String[] args) throws IOException {

		HashSet<String> knownWords = new HashSet<String>();
		fillDictionary(knownWords);

		System.out.println("Spiel gestartet!");
		System.out.println("Es sind " + knownWords.size() + " W�rter im W�rterbuch.\n");
		game = new CrosswordGame(knownWords);

		int runde = 1;

		while (true) {

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

	private static void fillDictionary(HashSet<String> knownWords) throws IOException {
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
	}

	private static Set<String> readFile(String path) throws IOException {
		HashSet<String> set = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line;
		while ((line = br.readLine()) != null) {
			set.add(line);
		}
		br.close();
		return set;
	}
}
