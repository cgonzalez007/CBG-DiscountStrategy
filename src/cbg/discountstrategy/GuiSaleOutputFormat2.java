
package cbg.discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author cgonz
 */
public class GuiSaleOutputFormat2 implements SaleOutputFormatStrategy{
    
    @Override
    public String getFormattedSaleOutput(Customer customer, LineItem[] 
            lineItems, double saleSubTotal, double saleSavingsTotal, 
            double saleTaxTotal, double saleGrandTotal, int totalItemsSold) {
        DecimalFormat df = new DecimalFormat("$0.00");
        String formattedSaleOutput = null;
        formattedSaleOutput = customer.getFirstName()+ " " + 
                customer.getLastName() + "\nID: " + customer.getCustomerId()+
                "\n";
        formattedSaleOutput += 
                  "Total Items Sold: " + totalItemsSold
                + "\nTotal Savings:      " + df.format(saleSavingsTotal)
                + "\nSub Total:              " + df.format(saleSubTotal)
                + "\nTax:                         " + df.format(saleTaxTotal)
                + "\nTotal:                       " + df.format(saleGrandTotal)
                +"\n"; 
        formattedSaleOutput += "Have a Nice Day!";
        return formattedSaleOutput;
    }
    
}
