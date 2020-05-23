import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is responsible for displaying the subtotal, tax amount and total on the application
 */
public class TotalInfoPanel extends JPanel
{
	// Declaring the fields of the panel
	private JLabel lblEmpty;
	public static JLabel lblSubtotal;
	public static JLabel lblTax;
	public static JLabel lblTotal;
	
	
	public TotalInfoPanel ()
	{
		// Setting the visibility of the panel
		setVisible (false);

		// Setting the layout of the panel
		setLayout (new GridLayout (4, 1));
		
		// Creating the subtotal, tax, total labels and empty label
		lblEmpty = new JLabel ("");
		lblSubtotal = new JLabel ("Subtotal: " + String.format("$%.2f", BagelPanel.getBagelCost()
				                                                      + ToppingPanel.getToppingCost()
				                                                      + CoffeePanel.getCoffeeCost()));
		lblTax = new JLabel ("Tax: " + String.format("$%.2f", OrderCalculatorGUI.getTaxRate()));
		lblTotal = new JLabel ("Total: " + String.format("$%.2f",  BagelPanel.getBagelCost()
                + ToppingPanel.getToppingCost()
                + CoffeePanel.getCoffeeCost() + OrderCalculatorGUI.getTaxRate()));
		
		// Adding the created label to the Total info panel
		add (lblEmpty);
		add (lblSubtotal);
		add (lblTax);
		add (lblTotal);
	}
}
