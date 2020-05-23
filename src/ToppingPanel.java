import javax.swing.*;
import java.awt.*;

/**
   The ToppingPanel class allows the user to select
   the toppings for the bagel.
*/

public class ToppingPanel extends JPanel
{
   // The following constants are used to indicate
   // the cost of toppings.
   public final static double CREAM_CHEESE = 0.50;
   public final static double BUTTER = 0.25;
   public final static double PEACH_JELLY = 0.75;
   public final static double BLUEBERRY_JAM = 0.75;
   public final static double NO_TOPPING = 0.00;
   private JLabel lblTopping;
   private static JComboBox toppingCBox;
   private static String [] optionsForToppings = { "No Topping",
           "Cream Cheese",
           "Buttter",
           "Peach jelly",
           "Blueberry jam"
                        };

   /**
      Constructor
   */

   public ToppingPanel()
   {
      // Create a GridLayout manager with 
      // two rows and one column.
      setLayout(new GridLayout(2, 1));

     // Creating the label for the topping
      lblTopping = new JLabel ("Topping:");
      
      // Creating the topping combo box
      toppingCBox = new JComboBox (optionsForToppings);
      
      // Adding the component to the topping panel
      add (lblTopping);
      add (toppingCBox);
      
      // setting the visibility of the panel
      setVisible(false);
   }

   /**
      getToppingCost method
      @return The cost of the selected toppings.
   */

   public static double getToppingCost()
   {
      double toppingCost = 0.0;

      if ((String) toppingCBox.getSelectedItem () == optionsForToppings [1])
      {
    	  toppingCost += CREAM_CHEESE; 
      }    
      else if ((String) toppingCBox.getSelectedItem () == optionsForToppings [2])
      {
    	  toppingCost += BUTTER; 
      }        
      else if ((String) toppingCBox.getSelectedItem () == optionsForToppings [3])
      {
    	  toppingCost += PEACH_JELLY;  
      }     
      else if ((String) toppingCBox.getSelectedItem () == optionsForToppings [4])
      {
    	  toppingCost += BLUEBERRY_JAM;  
      }
      else if ((String) toppingCBox.getSelectedItem () == optionsForToppings [0])
      {
    	  toppingCost += NO_TOPPING;
      }
 
      return toppingCost;
   }
   
   /**
    * the getToppingComboBox () method
    * @return the topping comboBox
    */
   public static JComboBox getToppingComboBox ()
   {
	   return toppingCBox;
   }
   
   /**
    * the getToppingComboBoxString () method
    * @return an array that represent the topping comboBox
    */
   public static String[] getToppingComboBoxString ()
   {
	   return optionsForToppings;
   }
}
