
package cbg.discountstrategy;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author cgonz
 */
public class GuiSaleOutputFormat2 implements SaleOutputFormatStrategy {

    @Override
    public String getFormattedSaleOutput(Customer customer, LineItem[] 
            lineItems, double saleSubTotal, double saleSavingsTotal,
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold) {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        String formattedSaleOutput = customer.getFirstName() + " "
                + customer.getLastName() + "\nID: " + customer.getCustomerId()
                + "\n";
        formattedSaleOutput
                += "Total Items Sold: " + totalItemsSold
                + "\nTotal Savings:      " + money.format(saleSavingsTotal)
                + "\nSub Total:              " + money.format(saleSubTotal)
                + "\nTax:                         " + money.format(saleTaxTotal)
                + "\nTotal:                       " + money.format
                (saleGrandTotal) + "\n";
        return formattedSaleOutput;
    }

}
