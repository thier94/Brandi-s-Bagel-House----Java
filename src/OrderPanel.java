import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrderPanel extends JPanel
{
	// Declaring the fields of the OrderPanel class
	private  JPanel bagelPanel;
	private JPanel coffeePanel;
	private static JPanel toppingPanel;
	private static JPanel sliderPanel;

	public OrderPanel ()
	{
		// Setting the title of the panel
		setBorder(BorderFactory.createTitledBorder("Order"));

		// Setting the layout of the order panel to a 4 x 1 grid layout
		setLayout (new GridLayout (4, 1));

		// Creating the bagel, coffee, topping and slider panels
		bagelPanel = new BagelPanel ();
		toppingPanel = new ToppingPanel ();
		coffeePanel = new CoffeePanel ();
		sliderPanel = new SliderPanel ();

		// Adding the created panels to the Orderpanel
		add (bagelPanel);	
		add (toppingPanel);
		add (coffeePanel);
		add (sliderPanel);
	}

	/**
	 * the getToppingPanel 
	 * @return the topping panel object
	 */
	public static  JPanel getToppingPanel ()
	{
		return toppingPanel;
	}

	/**
	 * The getSliderPanel
	 * @return the Slider panel object
	 */
	public static JPanel getSliderPanel ()
	{
		return sliderPanel;
	}
}
