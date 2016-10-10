
package cbg.discountstrategy;


/**
 *
 * @author cgonz
 */

public class Receipt {

    private Customer customer;
    private LineItem[] lineItems;
    private ReceiptOutputStrategy receiptOutputStrategy;
    private ReceiptOutputFormatStrategy receiptOutputFormatStrategy;
    private SaleOutputStrategy saleOutputStrategy;
    private SaleOutputFormatStrategy saleOutputFormatStrategy;

    public Receipt(String customerId, ReceiptOutputStrategy 
            receiptOutputStrategy, ReceiptOutputFormatStrategy 
            receiptOutputFormatStrategy, SaleOutputStrategy 
            saleOutputStrategy, SaleOutputFormatStrategy 
            saleOutputFormatStrategy, DataAccessStrategy dataAccessStrategy) {
        //Requires validation
        this.receiptOutputStrategy = receiptOutputStrategy;
        this.receiptOutputFormatStrategy = receiptOutputFormatStrategy;
        this.saleOutputStrategy = saleOutputStrategy;
        this.saleOutputFormatStrategy = saleOutputFormatStrategy;

        this.customer = dataAccessStrategy.findCustomer(customerId);

        LineItem[] newLineItems = new LineItem[0];
        this.lineItems = newLineItems;
    }

    public final void addLineItem(String productId, int productQty,
            DataAccessStrategy dataAccessStrategy) {
        //Requires validation
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[temp.length - 1] = new LineItem(dataAccessStrategy.findProduct
        (productId), productQty);
        lineItems = temp;
        temp = null;
    }

    public final void doOutput() {
        // does output base on configured format strategy objects
        receiptOutputStrategy.outputSaleReceipt(receiptOutputFormatStrategy.
                getFormattedReceiptContent(customer, lineItems,
                    getSaleSubTotal(), getSaleSavingsTotal(), getSaleTaxTotal(),
                         getSaleGrandTotal(), getTotalItemsSold()));

        saleOutputStrategy.outputSale(saleOutputFormatStrategy.
                getFormattedSaleOutput(customer, lineItems,
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

    public final ReceiptOutputStrategy getReceiptOutputStrategy() {
        return receiptOutputStrategy;
    }

    public final void setReceiptOutputStrategy(ReceiptOutputStrategy receiptOutputStrategy) {
        //Requires validation
        this.receiptOutputStrategy = receiptOutputStrategy;
    }

    public final SaleOutputStrategy getSaleOutputStrategy() {
        return saleOutputStrategy;
    }

    public final void setSaleOutputStrategy(SaleOutputStrategy saleOutputStrategy) {
        //Requires validation
        this.saleOutputStrategy = saleOutputStrategy;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        //Requires validation
        this.lineItems = lineItems;
    }

    public final ReceiptOutputFormatStrategy getReceiptOuputFormatStrategy() {
        return receiptOutputFormatStrategy;
    }

    public final void setReceiptOuputFormatStrategy(ReceiptOutputFormatStrategy receiptOutputFormatStrategy) {
        //Requires validation
        this.receiptOutputFormatStrategy = receiptOutputFormatStrategy;
    }

    public final SaleOutputFormatStrategy getSaleOutputFormatStrategy() {
        return saleOutputFormatStrategy;
    }

    public final void setSaleOutputFormatStrategy(SaleOutputFormatStrategy saleOutputFormatStrategy) {
        //Requires validation
        this.saleOutputFormatStrategy = saleOutputFormatStrategy;
    }
}
