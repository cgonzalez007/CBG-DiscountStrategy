package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface ReceiptOutputFormatStrategy {

    public abstract String getFormattedReceiptContent(Customer customer,
            LineItem[] lineItems);
}
