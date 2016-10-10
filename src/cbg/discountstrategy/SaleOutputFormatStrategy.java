
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface SaleOutputFormatStrategy {

    public abstract String getFormattedSaleOutput(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold);
}
