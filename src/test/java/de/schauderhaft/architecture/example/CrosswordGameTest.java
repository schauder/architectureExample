package de.schauderhaft.architecture.example;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CrosswordGameTest {
    private final Set<String> knownWords = new HashSet<String>();
    {
        knownWords.add("word");
        knownWords.add("crossword");
    }

    @Test
    public void newLegalWordResultsInFullPoints() {
        CrosswordGame game = createGame();
        int points = game.submit("word");
        assertEquals(4, points);
    }

    private CrosswordGame createGame() {
        return new CrosswordGame(knownWords);
    }

    @Test
    public void newLongLegalWordResultsInFullPoints() {
        CrosswordGame game = createGame();
        int points = game.submit("crossword");
        assertEquals(9, points);
    }

    @Test
    public void pointsForWordsAddUp() {
        CrosswordGame game = createGame();
        game.submit("word");
        int points = game.submit("crossword");
        assertEquals(4 + 9, points);
    }

    @Test
    public void duplicateWordsGiveOnlySinglePoint() {
        CrosswordGame game = createGame();
        int firstPoints = game.submit("word");
        int secondPoints = game.submit("word");
        assertEquals(firstPoints + 1, secondPoints);
    }

    @Test
    public void zeroPointsForUnknownWords() {
        CrosswordGame game = createGame();
        int points = game.submit("dfcguhj");
        assertEquals(0, points);
    }

}
