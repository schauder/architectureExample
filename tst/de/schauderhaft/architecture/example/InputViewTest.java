package de.schauderhaft.architecture.example;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InputViewTest {

	@Test
	public void viewShouldHaveInputField() {
		InputView view = new InputView();
		Component[] components = view.getInputView().getContentPane()
				.getComponents();
		componentsAssertTrue(components, JTextField.class);

	}

	@Test
	public void viewShouldHaveSubmitButton() {
		InputView view = new InputView();
		Component[] components = view.getInputView().getContentPane()
				.getComponents();
		componentsAssertTrue(components, JButton.class);

	}

	private <T extends Component> void componentsAssertTrue(
			Component[] components, Class<T> clazz) {
		boolean fieldExists = false;

		for (Component c : components) {
			if (clazz.isInstance(c)){
				fieldExists = true;
			}
		}
		assertTrue(fieldExists);
	}
}
