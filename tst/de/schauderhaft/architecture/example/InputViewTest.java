package de.schauderhaft.architecture.example;

import static org.junit.Assert.assertTrue;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	@Test
	public void inputViewShouldHavePanelForScore() {
		InputView view = new InputView();
		Component[] components = view.getInputView().getContentPane()
				.getComponents();
		componentsAssertTrue(components, JPanel.class);

	}

	private <T extends Component> void componentsAssertTrue(
			Component[] components, Class<T> clazz) {
		boolean fieldExists = false;

		for (Component c : components) {
			if (clazz.isInstance(c)) {
				fieldExists = true;
			}
		}
		assertTrue(fieldExists);
	}

}
