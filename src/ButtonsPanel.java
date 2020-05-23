import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonsPanel extends JPanel
{
	// Declaring the fields of the ButtonsPanel class
	private static JButton calcButton;    // To calculate the cost
	private static JButton exitButton;    // To exit the application


	/**
	 * Constructor
	 */
	public ButtonsPanel()
	{
		// Create the buttons.
		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");

		// Add the buttons to the button panel.
		add(calcButton);
		add(exitButton);
	}

	public static JButton getCalcButton ()
	{
		return calcButton;
	}

	public static JButton getExitButton ()
	{
		return exitButton;
	}
}
