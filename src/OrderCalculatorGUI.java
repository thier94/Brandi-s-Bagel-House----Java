import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
   The OrderCalculatorGUI class creates the GUI for the
   Brandi's Bagel House application.
   Name: Mamethierno Gadiaga
   Date: 11/5/2017
 */

public class OrderCalculatorGUI extends JFrame
{

	// Declaring the fields of the class	
	private GreetingPanel banner;                     // To display a greeting
	private ButtonsPanel buttonsPanel;                // To hold the buttons
	private OrderPanel orderPanel;                    // to hold the order panel
	private SummaryPanel summaryPanel;                // To reference the summary panel
	private final static double TAX_RATE = 0.06;      // Sales tax rate	
	private static int numberOfShots;

	/**
      Constructor, initializes the fields and the methods inherited
      from the JFrame class
	 */

	public OrderCalculatorGUI()
	{
		// Display a title of the window or Jframe object
		setTitle("Order Calculator");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// not letting the user to resize the window
		setResizable (false);

		// Setting the layout of the content pane
		setLayout (new BorderLayout (3, 1));

		// Create the custom panels.
		banner = new GreetingPanel();
		buttonsPanel = new ButtonsPanel ();
		orderPanel = new OrderPanel ();
		summaryPanel = new SummaryPanel ();

		// Register the action listeners.
		ButtonsPanel.getCalcButton().addActionListener(new CalcButtonListener());
		ButtonsPanel.getExitButton().addActionListener(new ExitButtonListener());
		BagelPanel.getBagelComboBox().addActionListener(new BagelComboBoxListener ());
		CoffeePanel.getCoffeeComboBox().addActionListener(new CoffeeComboBoxListener ());
		ToppingPanel.getToppingComboBox().addActionListener(new ToppingComboBoxListener ());

		// Registering the slider
		SliderPanel.getSlider().addChangeListener(new SliderListener ());

		// Adding the custom panels to the content pane of the JFrame object
		add(banner, BorderLayout.NORTH);
		add(orderPanel, BorderLayout.WEST);
		add (summaryPanel, BorderLayout.EAST);
		add (buttonsPanel, BorderLayout.SOUTH); 

		// packing and displaying the order calculator frame
		pack();
		setVisible(true);
	}

	/**
	 * private inner class that handles the events generated by the calculate buttons
	 * It implements the ActionListener interface
	 */
	private class CalcButtonListener implements ActionListener
	{
		/**
		 * the actionPerformed method take an actionEvent object as argument 
		 * it produce a a message box that summarizes the order 
		 */
		public void actionPerformed(ActionEvent e)
		{
			// Variables to hold the subtotal, tax, and total
			double subtotal, tax, total;

			// Calculate the subtotal.
			subtotal = BagelPanel.getBagelCost() + 
					ToppingPanel.getToppingCost() +
					CoffeePanel.getCoffeeCost() * OrderCalculatorGUI.numberOfShots;

			// Calculate the sales tax.
			tax = subtotal * OrderCalculatorGUI.getTaxRate();

			// Calculate the total.
			total = subtotal + tax;

			// Display the charges.
			JOptionPane.showMessageDialog(null,
					String.format("Subtotal: $%,.2f\n" +
							"Tax: $%,.2f\n" +
							"Total: $%,.2f",
							subtotal, tax, total));
		}
	}


	/**
	 * private inner class that handles the events generated by the Exit button
	 * It implements the ActionListener interface
	 */
	private class ExitButtonListener implements ActionListener
	{
		/**
		 * the actionPerformed method take an actionEvent object as argument
		 * it closes the program when the exit button is clicked
		 */
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	/**
	 * private inner class that handles the events generated by the bagel ComboBox
	 * It implements the ActionListener interface
	 */
	private class BagelComboBoxListener implements ActionListener
	{
		/**
		 * the actionPerformed method take an actionEvent object as argument
		 * it displays the total info panel and changes the label that represents the selected bagel
		 */
		public void actionPerformed(ActionEvent e)
		{

		    String bagelSelection;   // holds the option selected from the bagel comboBox

			// Getting the selected item from the bagel comboBox and store it in the bagelSelection variable
			bagelSelection =  (String) BagelPanel.getBagelComboBox().getSelectedItem();

			// Displaying the selected bagel option and the corresponding price
			PurchaseInfoPanel.getBagelRow().setText(bagelSelection + String.format(" $%.2f",  BagelPanel.getBagelCost()));

			// Setting the labels for the TotalInfoPanel
			TotalInfoPanel.lblSubtotal.setText("Subtotal: " + String.format("$%.2f", BagelPanel.getBagelCost()
					+ ToppingPanel.getToppingCost()
					+ CoffeePanel.getCoffeeCost()));
			TotalInfoPanel.lblTax.setText("Tax: " + String.format("$%.2f", OrderCalculatorGUI.getTaxRate()));

			TotalInfoPanel.lblTotal.setText("Total: " + String.format("$%.2f",  BagelPanel.getBagelCost()
					+ ToppingPanel.getToppingCost()
					+ CoffeePanel.getCoffeeCost() + OrderCalculatorGUI.getTaxRate()));

			// Checking if the selected value is "No Bagel"
			if (bagelSelection != BagelPanel.getBagelComboBoxString() [0])
			{
				// Displaying the toppingPanel
				OrderPanel.getToppingPanel().setVisible(true);

				// Displaying the totalInfoPanel
				TotalInfoPanelSupport.getTotalInfoPanel().setVisible(true);
			}
			else 
			{
				// Hiding the toppingPanel
				OrderPanel.getToppingPanel().setVisible(false);

				// Hiding the totalInfoPanel
				TotalInfoPanelSupport.getTotalInfoPanel().setVisible(false);
			}
			
			System.out.println(BagelPanel.getBagelComboBox().getActionCommand());
			//System.out.println((((EventObject) BagelPanel.getBagelComboBox().getSelectedItem()).getSource ().toString()));
			System.out.println(BagelPanel.getBagelComboBox().getSelectedItem().toString());
			System.out.println(BagelPanel.getBagelComboBox().getSelectedIndex());
			System.out.println(BagelPanel.getBagelComboBox().getSelectedObjects());
			
			
		}
	}

	/**
	 * private inner class that handles the events generated by the coffee ComboBox
	 * It implements the ActionListener interface
	 */
	private class CoffeeComboBoxListener implements ActionListener
	{
		/**
		 * the actionPerformed method take an actionEvent object as argument
		 * it displays the total info panel and changes the label that represents the selected coffee
		 */
		public void actionPerformed(ActionEvent e)
		{
			String coffeeSelection;                 // holds the selected value from the coffee comboBox

			// getting the selected value and storing it in the coffeeSelection variable
			coffeeSelection = (String) CoffeePanel.getCoffeeComboBox().getSelectedItem();

			// Setting the text of the selected coffee label to the selected coffee
			PurchaseInfoPanel.getCoffeeRow().setText(coffeeSelection + String.format(" $%.2f", CoffeePanel.getCoffeeCost()));

			// Setting the labels for the TotalInfoPanel
			TotalInfoPanel.lblSubtotal.setText("Subtotal: " + String.format("$%.2f", BagelPanel.getBagelCost()
					+ ToppingPanel.getToppingCost()
					+ CoffeePanel.getCoffeeCost()));
			TotalInfoPanel.lblTax.setText("Tax: " + String.format("$%.2f", OrderCalculatorGUI.getTaxRate()));

			TotalInfoPanel.lblTotal.setText("Total: " + String.format("$%.2f",  BagelPanel.getBagelCost()
					+ ToppingPanel.getToppingCost()
					+ CoffeePanel.getCoffeeCost() + OrderCalculatorGUI.getTaxRate()));

			// Checking if the selected coffee is "Redeye"
			if (coffeeSelection.toString() == CoffeePanel.getCoffeeComboBoxString() [4])
			{
				// Displaying the slider
				OrderPanel.getSliderPanel().setVisible(true);
			}
			else 
			{
				// Hiding the slider
				OrderPanel.getSliderPanel().setVisible(false);
			}

			// Checking of the selected value is "No Coffee"
			if (coffeeSelection != CoffeePanel.getCoffeeComboBoxString() [0])
			{
				// Displaying the totalInfoPanel
				TotalInfoPanelSupport.getTotalInfoPanel().setVisible(true);
			}
			else
			{
				// Hiding the totalInfoPanel
				TotalInfoPanelSupport.getTotalInfoPanel().setVisible(false);
			}
		}
	}

	/**
	 *private inner class that handles the events generated by the topping ComboBox
	 * It implements the ActionListener interface
	 */
	private class ToppingComboBoxListener implements ActionListener
	{
		/**
		 * the method changes the label that represents the selected topping
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String toppingSelection;      // holds the value selected from the topping ComboBox

			// Storing the selected value into a variable 
			toppingSelection =  (String) ToppingPanel.getToppingComboBox().getSelectedItem();

			// Setting the text of the selectedtopping's label to the selected topping
			PurchaseInfoPanel.getToppingRow().setText(toppingSelection + String.format(" $%.2f", ToppingPanel.getToppingCost()));

			// Setting the labels for the TotalInfoPanel
			TotalInfoPanel.lblSubtotal.setText("Subtotal: " + String.format("$%.2f", BagelPanel.getBagelCost()
					+ ToppingPanel.getToppingCost()
					+ CoffeePanel.getCoffeeCost()));
			TotalInfoPanel.lblTax.setText("Tax: " + String.format("$%.2f", OrderCalculatorGUI.getTaxRate()));

			TotalInfoPanel.lblTotal.setText("Total: " + String.format("$%.2f",  BagelPanel.getBagelCost()
					+ ToppingPanel.getToppingCost()
					+ CoffeePanel.getCoffeeCost() + OrderCalculatorGUI.getTaxRate()));
		}
	}

	private class SliderListener implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e)
		{	
			numberOfShots = SliderPanel.getSlider().getValue();
			
			PurchaseInfoPanel.shotRow.setText("(Includes " + OrderCalculatorGUI.getNumberOfShots() + " shots)"
		                                   + String.format("  $%.2f ", CoffeePanel.getCoffeeCost() * OrderCalculatorGUI.getNumberOfShots()));
			
			            // Setting the labels for the TotalInfoPanel
						TotalInfoPanel.lblSubtotal.setText("Subtotal: " + String.format("$%.2f", BagelPanel.getBagelCost()
								+ ToppingPanel.getToppingCost()
								+ CoffeePanel.getCoffeeCost()));
						TotalInfoPanel.lblTax.setText("Tax: " + String.format("$%.2f", OrderCalculatorGUI.getTaxRate()));

						TotalInfoPanel.lblTotal.setText("Total: " + String.format("$%.2f",  BagelPanel.getBagelCost()
								+ ToppingPanel.getToppingCost()
								+ CoffeePanel.getCoffeeCost() * OrderCalculatorGUI.getNumberOfShots() + OrderCalculatorGUI.getTaxRate()));
			
			System.out.println(numberOfShots);
		}
	}

	public static int getNumberOfShots ()
	{
		return numberOfShots;
	}

	/**
	 * getTaxRate ()
	 * @return the tax rate
	 */
	public static double getTaxRate ()
	{
		return TAX_RATE;
	}

	/**
      main method, run the program 
	 */

	public static void main(String[] args)
	{
		new OrderCalculatorGUI();
	}
}