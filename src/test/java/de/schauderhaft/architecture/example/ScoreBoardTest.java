package de.schauderhaft.architecture.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Component;

import org.junit.Test;

import de.schauderhaft.architecture.example.thomas.client.swing.ScoreBoard;

public class ScoreBoardTest {

    ScoreBoard underTest = new ScoreBoard();

    @Test
    public void panelIsNotNull() {
        assertNotNull(underTest.getScorePanel());
    }

    @Test
    public void scoreBoardShouldHaveTwoComponents() throws Exception {

        Component[] components = underTest.getScorePanel().getComponents();
        assertEquals(2, components.length);
    }
}
