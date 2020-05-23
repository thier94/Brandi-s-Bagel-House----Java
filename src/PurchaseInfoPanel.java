import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

/**
 * this class summarizes an order by giving the price of each selected item
 * and the number of shots selected by the user
 *
 */
public class PurchaseInfoPanel extends JPanel
{
	// Declaring the fields of the panel
	private static JLabel bagelRow;
	private static JLabel toppingRow;
	private static JLabel coffeeRow;
	public static JLabel shotRow;
	public static double bagelCost = BagelPanel.getBagelCost();
	public static double toppingCost = ToppingPanel.getToppingCost();
	public static double coffeeCost = CoffeePanel.getCoffeeCost();


	public PurchaseInfoPanel ()
	{
		// Setting the visibility of the panel
		setVisible (true);

		// Setting the layout of the panel
		setLayout (new GridLayout (4, 1));

		bagelRow = new JLabel (BagelPanel.getBagelComboBoxString()[0] + String.format("  $%.2f", bagelCost ));
		toppingRow = new JLabel (ToppingPanel.getToppingComboBoxString()[0] + String.format("  $%.2f", toppingCost));
		coffeeRow = new JLabel (CoffeePanel.getCoffeeComboBoxString()[0] + String.format("  $%.2f", coffeeCost));
		shotRow = new JLabel ("(Includes " + OrderCalculatorGUI.getNumberOfShots() + " shots)"
		                                   + String.format("  $%.2f ", coffeeCost * OrderCalculatorGUI.getNumberOfShots()));

		// Adding the the components to the Purchase info panel
		add (bagelRow);
		add (toppingRow);
		add (coffeeRow);
		add (shotRow);
	}

	/**
	 * 
	 * @return
	 */
	public static JLabel getBagelRow ()
	{
		return bagelRow;
	}

	/**
	 * 
	 * @return
	 */
	public static JLabel getToppingRow ()
	{
		return toppingRow;
	}

	/**
	 * 
	 * @return
	 */
	public static JLabel getCoffeeRow ()
	{
		return coffeeRow;
	}
}
