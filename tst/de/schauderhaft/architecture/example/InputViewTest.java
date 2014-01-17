package de.schauderhaft.architecture.example;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InputViewTest {

	@Test
	public void viewShouldHaveInputField() {
		InputView view = new InputView();
		Component[] components = view.getInputView().getContentPane()
				.getComponents();
		boolean fieldExists = false;
		for (Component c : components) {
			if (c instanceof JTextField) {
				fieldExists = true;
			}
		}
		assertTrue(fieldExists);

	}
	
	
}
