
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class GuiSaleOutputFormat1 implements SaleOutputFormatStrategy {

    @Override
    public String getFormattedSaleOutput(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold) {
        String formattedSaleOutput = "Transaction Complete";

        return formattedSaleOutput;
    }

}
