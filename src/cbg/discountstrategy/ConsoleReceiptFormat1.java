
package cbg.discountstrategy;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cgonz
 */
public class ConsoleReceiptFormat1 implements ReceiptFormatStrategy {

    @Override
    public final String getFormattedReceiptContent(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold) {
        DecimalFormat df = new DecimalFormat("$0.00");
        LocalDateTime todaysDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter
                = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");

        String receiptFormat = "\t\tKohl's Department Store\n\t\t"
                + todaysDate.format(dateFormatter) + "\n\n" + "\t\tCustomer: "
                + customer.getFirstName() + " " + customer.getLastName()
                + "\n\t\tCustomer ID: " + customer.getCustomerId()
                + "\n\n";
        receiptFormat += "ProdID\tProduct\t\tPrice\t\tQty\t"
                + "Before Savings\n======\t=======\t\t=====\t\t===\t==========="
                + "===\n";
        for (LineItem lineItem : lineItems) {
            receiptFormat
                    += lineItem.getProduct().getProductId() + "\t"
                    + lineItem.getProduct().getProductName()
                    + "\t" + df.format(lineItem.getProduct().getUnitPrice())
                    + "\t\t" + lineItem.getProductQty() + "\t"
                    + df.format(lineItem.getSubTotal()) + "\n"
                    + "\n\tPromotion: \t" + lineItem.getProduct().
                    getDiscountStrategy().getPromotionName()
                    + "\n\tYou Save: \t" + df.format(lineItem.
                            getDiscountTotal())
                    + "\n\tAfter Savings: \t"
                    + df.format(lineItem.getLineTotal()) + "\n\n";
        }
        
        receiptFormat += 
                  "\n\t\t\t\tTotal Items Sold: " + totalItemsSold
                + "\n\t\t\t\tTotal Savings:    " + df.format(saleSavingsTotal)
                + "\n\t\t\t\tSub Total:        " + df.format(saleSubTotal)
                + "\n\t\t\t\tTax:              " + df.format(saleTaxTotal)
                + "\n\t\t\t\tTotal:            " + df.format(saleGrandTotal);

        receiptFormat += "\n\n\t\tHave a Nice Day!";

        return receiptFormat;
    }

}
