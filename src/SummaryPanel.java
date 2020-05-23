import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is responsible for building the summary panel,
 * which gives a summary of the purchases 
 */
public class SummaryPanel extends JPanel
{
	// Declaring the fields of the class
	private JLabel toppingSelection;
	private JLabel coffeeSelection;
	private JPanel purchaseInfoPanel;
	private JPanel totalInfoPanelSupport;
	
	public SummaryPanel ()
	{
		// Setting the visibility of the panel
		setVisible (true);
		
		// Setting the layout of the Summary panel
		setLayout (new BorderLayout (0, 10));
		setBorder (BorderFactory.createEmptyBorder(5, 0, 0, 0));
			
		// Creating a purchase info panel and the total purchase panel
		purchaseInfoPanel = new PurchaseInfoPanel ();
		totalInfoPanelSupport = new TotalInfoPanelSupport ();
		
		// Adding the created panels to the Summary panel
		add (purchaseInfoPanel, BorderLayout.NORTH);
		add (totalInfoPanelSupport, BorderLayout.CENTER);
	}
}
