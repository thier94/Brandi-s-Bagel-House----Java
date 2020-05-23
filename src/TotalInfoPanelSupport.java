import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a panel that we use as support for the total info panel
 */
public class TotalInfoPanelSupport extends JPanel 
{
    // Declaring the fields of the class
	private static JPanel totalInfoPanel;
	private JPanel emptyPanel;
	
	
	public TotalInfoPanelSupport ()
	{
		// Setting the visibility of the panel
		setVisible (true);

		// Setting the layout of the Summary panel
		setLayout (new BorderLayout ());
		
		// Creating the fields of the 2 panels
		totalInfoPanel = new TotalInfoPanel ();
		emptyPanel = new EmptyPanel ();
		
		// Adding the total info panel to the north region of the panel
		add (totalInfoPanel, BorderLayout.NORTH);
		
		// Adding the Empty panel to the center region of the panel
		add (emptyPanel, BorderLayout.CENTER);
	}
	
	public static JPanel getTotalInfoPanel ()
	{
		return totalInfoPanel;
	}
}
