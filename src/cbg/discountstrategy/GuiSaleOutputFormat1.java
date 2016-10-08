
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class GuiSaleOutputFormat1 implements SaleOutputFormatStrategy{

    @Override
    public final String getFormattedSaleOutput(Customer customer, LineItem[] lineItems) {
        String formattedSaleOutput = "Transaction Complete";
        
        return formattedSaleOutput;
    }
    
}
