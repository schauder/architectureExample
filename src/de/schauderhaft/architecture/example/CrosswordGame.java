package de.schauderhaft.architecture.example;

import java.util.HashSet;
import java.util.Set;

public class CrosswordGame {
    private final Set<String> knownWords;

    public CrosswordGame(Set<String> knownWords) {
        this.knownWords = knownWords;
    }

    private final Set<String> usedWords = new HashSet<String>();
    private int points;

    public int submit(String word) {
        if (isWordKnown(word))
            return points;

        points += calculatePointsForLegalWord(word);
        return points;
    }

    private int calculatePointsForLegalWord(String word) {
        int newPoints = 0;
        if (wasWordAlreadyUsed(word))
            newPoints = 1;
        else {
            usedWords.add(word);
            newPoints = word.length();
        }
        return newPoints;
    }

    private boolean wasWordAlreadyUsed(String word) {
        return usedWords.contains(word);
    }

    private boolean isWordKnown(String word) {
        return !knownWords.contains(word);
    }
}
