import javax.swing.*;
import java.awt.*;

/**
   The CoffeePanel class allows the user to select coffee.
 */

public class CoffeePanel extends JPanel
{
	// The following constants are used to indicate
	// the cost of coffee.
	public final static double NO_COFFEE = 0.0;
	public final static double REGULAR_COFFEE = 1.25;
	public final static double DECAF_COFFEE = 1.25;
	public final static double CAPPUCCINO_COFFEE = 2.00;
	public final static double REDEYE_COFFEE = 1.50;
	private JLabel lblCoffee;                                        // represents the label for the coffee comboBox
	private static JComboBox coffeeCBox;                             // represents the coffee comboBox
	private static String [] optionsForCoffee = { "No coffee",       // represents the array that represents the coffee ComboBox
			"Regular",
			"Decaf",
			"Cappuccino",
			"Redeye"
	};

	/**
      Constructor
	 */

	public CoffeePanel()
	{
		// Create a GridLayout manager with 
		// two rows and one column.
		setLayout(new GridLayout(2, 1));

		// Creating the label and coffee ComboBox
		lblCoffee = new JLabel ("Coffee:");
		coffeeCBox = new JComboBox (optionsForCoffee);

		// Adding the component to the coffee panel
		add (lblCoffee);
		add (coffeeCBox);
	}

	/**
      getCoffeeCost method 
      @return The cost of the selected coffee.
	 */

	public static double getCoffeeCost()
	{
		double coffeeCost = 0.0;

		if ((String) coffeeCBox.getSelectedItem () == optionsForCoffee [0])
		{
			coffeeCost = NO_COFFEE;
		}   
		else if ((String) coffeeCBox.getSelectedItem () == optionsForCoffee [1])
		{
			coffeeCost = REGULAR_COFFEE; 
		}
		else if ((String) coffeeCBox.getSelectedItem () == optionsForCoffee [2])
		{
			coffeeCost = DECAF_COFFEE;
		}
		else if ((String) coffeeCBox.getSelectedItem () == optionsForCoffee [3])
		{
			coffeeCost = CAPPUCCINO_COFFEE;
		}
		else if ((String) coffeeCBox.getSelectedItem () == optionsForCoffee [4])
		{
			coffeeCost = (REDEYE_COFFEE );
		}

		return coffeeCost;
	}

	/**
	 * The getCoffeeComboBox method
	 * @return the coffee ComboBox
	 */
	public static JComboBox getCoffeeComboBox ()
	{
		return coffeeCBox;
	}

	/**
	 * the getCoffeeComboBoxString method
	 * @return an array that represents the coffee ComboBox
	 */
	public static String[] getCoffeeComboBoxString ()
	{
		return optionsForCoffee;
	}  
}
