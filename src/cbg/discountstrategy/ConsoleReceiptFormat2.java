
package cbg.discountstrategy;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cgonz
 */
public class ConsoleReceiptFormat2 implements ReceiptOutputFormatStrategy {

    @Override
    public final String getFormattedReceiptContent(Customer customer,
            LineItem[] lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold) {
        LocalDateTime todaysDate = LocalDateTime.now();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        DateTimeFormatter dateFormatter
                = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");

        String receiptFormat = "\t\tKohl's Department Store\n\t\t"
                + todaysDate.format(dateFormatter) + "\n\n" + "\t\tCustomer: "
                + customer.getFirstName() + " " + customer.getLastName()
                + "\n\t\t      ID: " + customer.getCustomerId()
                + "\n\n";
        receiptFormat += "ProdID\tProduct\t\tPrice\t\tQty\t"
                + "Before Savings\n======\t=======\t\t=====\t\t===\t==========="
                + "===\n";
        for (LineItem lineItem : lineItems) {
            receiptFormat
                    += lineItem.getProduct().getProductId() + "\t"
                    + lineItem.getProduct().getProductName()
                    + "\t" + money.format(lineItem.getProduct().getUnitPrice())
                    + "\t\t" + lineItem.getProductQty() + "\t"
                    + money.format(lineItem.getSubTotal()) + "\n"
                    + "\n\tPromotion: \t" + lineItem.getProduct().
                    getDiscountStrategy().getPromotionName()
                    + "\n\tYou Save: \t" + money.format(lineItem.
                            getDiscountTotal())
                    + "\n\tAfter Savings: \t"
                    + money.format(lineItem.getLineTotal()) + "\n\n";
        }
        
        receiptFormat += 
                  "\n\t\t\t\tTotal Items Sold: " + totalItemsSold
                + "\n\t\t\t\tTotal Savings:    " + money.format
                    (saleSavingsTotal)
                + "\n\t\t\t\tSub Total:        " + money.format(saleSubTotal)
                + "\n\t\t\t\tTax:              " + money.format(saleTaxTotal)
                + "\n\t\t\t\tTotal:            " + money.format(saleGrandTotal);

        receiptFormat += "\n\n\t\tHave a Nice Day!";

        return receiptFormat;
    }

}
