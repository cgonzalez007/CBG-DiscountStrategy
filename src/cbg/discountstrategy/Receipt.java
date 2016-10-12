
package cbg.discountstrategy;

import java.time.LocalDateTime;


/**
 *
 * @author cgonz
 */

public class Receipt {

    private Customer customer;
    private LineItem[] lineItems;
    private ReceiptOutputStrategy receiptOutput;
    private ReceiptFormatStrategy receiptFormat;
    private EndOfSaleMessageOutputStrategy endOfSaleMessageOutput;
    private EndOfSaleMessageFormatStrategy endOfSaleMessageFormat;

    public Receipt(String customerId, ReceiptOutputStrategy 
            receiptOutput, ReceiptFormatStrategy 
            receiptFormat, EndOfSaleMessageOutputStrategy 
            endOfSaleMessageOutput, EndOfSaleMessageFormatStrategy 
            endOfSaleMessageFormat, DataAccessStrategy dataAccess) {
        //Requires validation
        this.receiptOutput = receiptOutput;
        this.receiptFormat = receiptFormat;
        this.endOfSaleMessageOutput = endOfSaleMessageOutput;
        this.endOfSaleMessageFormat = endOfSaleMessageFormat;

        this.customer = dataAccess.findCustomer(customerId);

        LineItem[] newLineItems = new LineItem[0];
        this.lineItems = newLineItems;
    }
    public final void addLineItem(String productId, int productQty,
            DataAccessStrategy dataAccess){
        LineItem addedLineItem = new LineItem(dataAccess.findProduct
        (productId), productQty);
        addLineItemToArray(addedLineItem);
    }
    
    private void addLineItemToArray(LineItem addedLineItem) {
        //Requires validation
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[temp.length - 1] = addedLineItem;
        lineItems = temp;
        temp = null;
    }

    public final void doOutput() {
        // does output base on configured format strategy objects
        receiptOutput.outputSaleReceipt(receiptFormat.
                getFormattedReceiptContent(customer, lineItems,
                getSaleSubTotal(), getSaleSavingsTotal(), getSaleTaxTotal(),
                getSaleGrandTotal(), getTotalItemsSold(),getTodaysDateAndTime()));

        endOfSaleMessageOutput.outputEndOfSaleMessage(endOfSaleMessageFormat.
                getFormattedEndOfSaleMessage(customer, lineItems, 
                getSaleSubTotal(), getSaleSavingsTotal(), getSaleTaxTotal(), 
                getSaleGrandTotal(), getTotalItemsSold()));
    }

    /*Helper methods that calculate certain parts of the Receipt(sub total,
    total items sold, tax, total savings). Required when a sale is to be 
    outputted.*/
    public final double getSaleSubTotal() {
        double saleSubTotal = 0;
        for (LineItem lineItem : lineItems) {
            saleSubTotal += lineItem.getLineTotal();
        }
        return saleSubTotal;
    }

    public final double getSaleSavingsTotal() {
        double saleSavingsTotal = 0;
        for (LineItem lineItem : lineItems) {
            saleSavingsTotal += lineItem.getDiscountTotal();
        }
        return saleSavingsTotal;
    }
    //***Sales Tax not configured yet***
    public final double getSaleTaxTotal() {
        double saleTaxTotal = 0;
        //To be done when tax is configured for this project  
        return saleTaxTotal;
    }

    public final double getSaleGrandTotal() {
        return getSaleSubTotal() + getSaleTaxTotal();
    }

    public final int getTotalItemsSold() {
        int totalItemsSold = 0;
        for (LineItem lineItem : lineItems) {
            totalItemsSold += lineItem.getProductQty();
        }
        return totalItemsSold;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        //Requires validation
        this.customer = customer;
    }
    
    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        //Requires validation
        this.lineItems = lineItems;
    }

    public final ReceiptOutputStrategy getReceiptOutput() {
        return receiptOutput;
    }

    public final void setReceiptOutput(ReceiptOutputStrategy receiptOutput) {
         //Requires validation
        this.receiptOutput = receiptOutput;
    }

    public final ReceiptFormatStrategy getReceiptFormat() {
        return receiptFormat;
    }

    public final void setReceiptFormat(ReceiptFormatStrategy receiptFormat) {
        //Requires Validation
        this.receiptFormat = receiptFormat;
    }

    public final EndOfSaleMessageOutputStrategy getEndOfSaleMessageOutput() {
        return endOfSaleMessageOutput;
    }

    public final void setEndOfSaleMessageOutput(EndOfSaleMessageOutputStrategy 
            endOfSaleMessageOutput) {
        //Requires validation
        this.endOfSaleMessageOutput = endOfSaleMessageOutput;
    }

    public final EndOfSaleMessageFormatStrategy getEndOfSaleMessageFormat() {
        return endOfSaleMessageFormat;
    }

    public final void setEndOfSaleMessageFormat(EndOfSaleMessageFormatStrategy
            endOfSaleMessageFormat) {
         //Requires validation
        this.endOfSaleMessageFormat = endOfSaleMessageFormat;
    }
    // get an unformatted date
    public final LocalDateTime getTodaysDateAndTime() {  
        return LocalDateTime.now();
    }
    
}
