import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

/**
 * The slider panel class holds the slider
 */
public class SliderPanel extends JPanel
{
	// Declaring the fields of the  slider class
	private JLabel lblNumberOfShots;
	private static JSlider slider;


	/**
	 * constructor
	 */
	public SliderPanel ()
	{
		// Create a GridLayout manager with 
		// two rows and one column.
		setLayout(new GridLayout(2, 1));

		// Creating the label for the slider
		lblNumberOfShots = new JLabel ("Number of shots:");

		// Creating the slider
		slider = new JSlider (JSlider.HORIZONTAL, 0, 5, 0);

		// Setting the major tick mark of the slider
		slider.setMajorTickSpacing(1);

		// Displaying the tick marks of the slider
		slider.setPaintTicks(true);

		// Displaying the numeric label at the major tick marks
		slider.setPaintLabels(true);

		// Setting the visibility of the slider panel to false
		setVisible (false);

		// Adding the component to the panel
		add (lblNumberOfShots);
		add (slider);  
	}	

	/**
	 * The getSlider method 
	 * @return the slider object
	 */
	public static JSlider getSlider ()
	{
		return slider;
	}

}

