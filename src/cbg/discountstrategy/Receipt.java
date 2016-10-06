
package cbg.discountstrategy;

import java.util.Date;
import java.text.DecimalFormat;
/**
 *
 * @author cgonz
 */

public class Receipt {
    private Customer customer;
    private ReceiptOutputStrategy receiptOutputStrategy;
    private SaleOutputStrategy saleOutputStrategy;
    private LineItem[] lineItems;

    public Receipt(String customerId,ReceiptOutputStrategy receiptOutputStrategy, 
            SaleOutputStrategy saleOutputStrategy, DataAccessStrategy 
                    dataAccessStrategy) {
        //Requires validation
        this.receiptOutputStrategy = receiptOutputStrategy;
        this.saleOutputStrategy = saleOutputStrategy;
        
        this.customer = dataAccessStrategy.findCustomer(customerId);      
       
        LineItem[] newLineItems = new LineItem[1];
        this.lineItems = newLineItems;
    }
    public final void addLineItem(String productId, int productQty,
            DataAccessStrategy dataAccessStrategy){
        //Requires validation
        LineItem[] temp = new LineItem[lineItems.length+1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[temp.length-1] = new 
            LineItem(dataAccessStrategy.findProduct(productId),productQty);
        lineItems = temp;
        temp = null;
    }
    public final void doOutput(){
        saleOutputStrategy.outputSale(getReceiptFormat());
        receiptOutputStrategy.outputSaleReceipt(getReceiptFormat());
        
    }
    private String getReceiptFormat(){
        Date date = new Date();
        String receiptFormat = "Kohls Department Store\n"+
                date.getDate()+"\n"+ "Customer: " + customer.getFirstName()
                + " " + customer.getLastName() + " ";
        receiptFormat += ;
        
        
        return receiptFormat;
    }
    private String getLineItemsFormatted(){
        DecimalFormat format = new DecimalFormat();
        String formattedLineItems = "Product\tPrice\tQty\tSub Total\tDiscount\t"
                + "Line Total\n-------\t-----";
        
        for(LineItem lineItem : lineItems){
            
        }
    }
    private String getTotalsFormatted(){
        DecimalFormat format = new DecimalFormat();
        
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        //Requires validation
        this.customer = customer;
    }
    
    public final ReceiptOutputStrategy getReceiptOutputStrategy() {
        return receiptOutputStrategy;
    }

    public final void setReceiptOutputStrategy(ReceiptOutputStrategy 
            receiptOutputStrategy) {
        //Requires Output
        this.receiptOutputStrategy = receiptOutputStrategy;
    }

    public final SaleOutputStrategy getSaleOutputStrategy() {
        return saleOutputStrategy;
    }

    public final void setSaleOutputStrategy(SaleOutputStrategy 
            saleOutputStrategy) {
        //Requires Output
        this.saleOutputStrategy = saleOutputStrategy;
    }    

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        //Requires validation
        this.lineItems = lineItems;
    }
    public static void main(String[] args) {
        
    }
}
