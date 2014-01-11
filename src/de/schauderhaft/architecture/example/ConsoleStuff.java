package de.schauderhaft.architecture.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStuff {

    public static void main(String[] args) {

        System.out.println("Spiel gestartet!");
        System.out.print("Runde 1 Eingabe: ");
        String input = makeInput();
        System.out.println(input + " bringt " + machMalPunkte(input)
                + " Punkte! Gesamt: XXX");
    }

    private static int machMalPunkte(String input) {
        return 42;

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

}
