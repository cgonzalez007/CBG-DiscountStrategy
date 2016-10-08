
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface SaleOutputFormatStrategy {

    public abstract String getFormattedSaleOutput(Customer customer,
            LineItem[] lineItems);
}
