package de.schauderhaft.architecture.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ScoreBoardTest {

	ScoreBoard underTest = new ScoreBoard();

	@Test
	public void panelIsNotNull() {
		assertNotNull(underTest.getScorePanel());
	}
}
