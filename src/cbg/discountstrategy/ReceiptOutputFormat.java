
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface ReceiptOutputFormat {
    public abstract void outputSaleReceipt(Customer customer, LineItem[] 
            lineItem);
}
