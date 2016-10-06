
package cbg.discountstrategy;

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
       
        LineItem[] newLineItems = new LineItem[0];
        this.lineItems = newLineItems;
    }
    
    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        //Requires validation
        this.customer = customer;
    }
    
    public final void doOutput(){
        saleOutputStrategy.outputSale(getReceiptFormat());
        receiptOutputStrategy.outputSaleReceipt(getReceiptFormat());
        
    }
    private String getReceiptFormat(){
        String receiptOutput = "";
        
        return receiptOutput;
    }

    public final ReceiptOutputStrategy getReceiptOutputFormat() {
        return receiptOutputStrategy;
    }

    public final void setReceiptOutputFormat(ReceiptOutputStrategy 
            receiptOutputFormat) {
        //Requires Output
        this.receiptOutputStrategy = receiptOutputFormat;
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
    
}
