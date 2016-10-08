
package cbg.discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author cgonz
 */
public class ConsoleReceiptFormat1 implements ReceiptOutputFormatStrategy {

    @Override
    public final String getFormattedReceiptContent(Customer customer,
            LineItem[] lineItems) {
        DecimalFormat df = new DecimalFormat("$0.00");
        String receiptFormat = null;

        receiptFormat = "\t\tKohl's Department Store\n\t\t"
                + "09/30/2016 12:37:23 PM" + "\n\n" + "\t\tCustomer: "
                + customer.getFirstName() + " " + customer.getLastName() + 
                "\n\n";
        receiptFormat += "ProdID\tProduct\t\tPrice\t\tQty\t"
                + "Before Savings\n======\t=======\t\t=====\t\t===\t==========="
                + "===\n";
        for (LineItem lineItem : lineItems) {
            receiptFormat
                    += lineItem.getProduct().getProductId() + "\t"
                    + lineItem.getProduct().getProductName() +
                    "\t"+ df.format(lineItem.getProduct().getUnitPrice())
                    + "\t\t" + lineItem.getProductQty() + "\t"
                    + df.format(lineItem.getSubTotal()) + "\n"
                    + "\n\tPromotion: \t" + lineItem.getProduct().
                    getDiscountStrategy().getPromotionName()
                    + "\n\tYou Save: \t" + df.format(lineItem.
                            getDiscountTotal())
                    + "\n\tAfter Savings: \t"
                    + df.format(lineItem.getLineTotal()) + "\n\n";
        }
        double subTotal = 0;
        double totalSavings = 0;
        double grandTotal = 0;
        for (LineItem lineItem : lineItems) {
            subTotal += lineItem.getLineTotal();
            totalSavings += lineItem.getDiscountTotal();
            grandTotal += lineItem.getLineTotal();
        }
        receiptFormat += "\n\t\t\t\tTotal Savings:  " + df.format(totalSavings)
                + "\n\t\t\t\tSub Total:      " + df.format(subTotal) + "\n"
                + "\t\t\t\tGrand Total:    " + df.format(grandTotal) + "\n";

        receiptFormat += "\n\n\t\tHave a Nice Day!";

        return receiptFormat;
    }

}
