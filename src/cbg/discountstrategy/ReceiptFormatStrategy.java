package cbg.discountstrategy;

import java.time.LocalDateTime;

/**
 *
 * @author cgonz
 */
public interface ReceiptFormatStrategy {

    public abstract String getFormattedReceiptContent(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold,
            LocalDateTime getTodaysDateAndTime);
}
