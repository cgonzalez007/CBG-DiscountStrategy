
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface EndOfSaleMessageFormatStrategy {

    public abstract String getFormattedEndOfSaleMessage(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold);
}
