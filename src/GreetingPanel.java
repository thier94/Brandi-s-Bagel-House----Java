import java.awt.BorderLayout;

import javax.swing.*;

/**
   The GreetingPanel class displays a greeting in a panel.
 */

public class GreetingPanel extends JPanel
{
	// Declaring the fields of the GreetingPanel class
	private JLabel greeting; // To display a greeting

	/**
      Constructor
	 */

	public GreetingPanel()
	{
		// Create the label.
		greeting = new JLabel("Welcome to Brandi's Bagel House");

		// Add the label to this panel.
		add(greeting);
	}
}
