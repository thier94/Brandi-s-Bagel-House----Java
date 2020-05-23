import javax.swing.*;
import java.awt.*;

/**
   The BagelPanel class allows the user to select either
   a white or whole wheat bagel.
 */

public class BagelPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// The following constants are used to indicate
	// the cost of each type of bagel.
	public final static double WHITE_BAGEL = 1.25;
	public final static double WHEAT_BAGEL = 1.50;
	public final static double SESAME_BAGEL = 1.50;
	public final static double NO_BAGEL = 0.00;
	private JLabel lblBagel;                                    // a label for the bagel comboBox
	private static JComboBox<?> bagelCBox;                         // the bagel comboBox
	private static String [] optionsForBagel = { "No Bagel",    // String that represents the bagel comboBox
			"White Bagel",
			"wheat Bagel",
			"Sesame Bagel"
	};

	/**
      Constructor
	 */

	public BagelPanel()
	{
		// Create a GridLayout manager with 
		// two rows and one column.
		setLayout(new GridLayout(2, 1));

		// Creating the label and the comboBox
		lblBagel = new JLabel ("Bagel:");
		bagelCBox = new JComboBox<Object> (optionsForBagel);

		// Adding the components to the bagel panel
		add(lblBagel);
		add(bagelCBox);
	}

	/**
      getBagelCost method
      @return The cost of the selected bagel.
	 */

	public static double getBagelCost()
	{
		double bagelCost = 0.0;

		if ((String) bagelCBox.getSelectedItem () == optionsForBagel [0])
		{
			bagelCost = NO_BAGEL;
		}   
		else if ((String) bagelCBox.getSelectedItem () == optionsForBagel [1])
		{
			bagelCost = WHITE_BAGEL; 
		}
		else if ((String) bagelCBox.getSelectedItem () == optionsForBagel [2])
		{
			bagelCost = WHEAT_BAGEL;
		}
		else if ((String) bagelCBox.getSelectedItem () == optionsForBagel [3])
		{
			bagelCost = SESAME_BAGEL;
		}

		return bagelCost;
	}

	/**
	 * The getBagelComboBox method
	 * @return the bagel combo box
	 */
	public static JComboBox<?> getBagelComboBox ()
	{
		return bagelCBox;
	}

	/**
	 * The getBagelComboBoxString method
	 * @return the array that represents the bagel comboBox
	 */
	public static String[] getBagelComboBoxString ()
	{
		return optionsForBagel;
	}
	
}
