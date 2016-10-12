
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class GuiEndOfSaleMessageFormat1 implements 
        EndOfSaleMessageFormatStrategy {

    @Override
    public final String getFormattedEndOfSaleMessage(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold) {
        String formattedEndOfSaleMessage = "Transaction Complete";

        return formattedEndOfSaleMessage;
    }

}
