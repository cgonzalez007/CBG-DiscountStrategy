
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
                        saleOutputFormatStrategy, DataAccessStrategy
                            dataAccessStrategy) {
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
        temp[temp.length - 1] = new 
            LineItem(dataAccessStrategy.findProduct(productId), productQty);
        lineItems = temp;
        temp = null;
    }

    public final void doOutput() {
        // does output base on configured format strategy objects
        receiptOutputStrategy.outputSaleReceipt(receiptOutputFormatStrategy.
                getFormattedReceiptContent(customer, lineItems));
        saleOutputStrategy.outputSale(saleOutputFormatStrategy.
                getFormattedSaleOutput(customer, lineItems));
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
        //Requires validation
        this.receiptOutputStrategy = receiptOutputStrategy;
    }

    public final SaleOutputStrategy getSaleOutputStrategy() {
        return saleOutputStrategy;
    }

    public final void setSaleOutputStrategy(SaleOutputStrategy 
            saleOutputStrategy) {
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

    public final void setReceiptOuputFormatStrategy(ReceiptOutputFormatStrategy
            receiptOutputFormatStrategy) {
        //Requires validation
        this.receiptOutputFormatStrategy = receiptOutputFormatStrategy;
    }

    public final SaleOutputFormatStrategy getSaleOutputFormatStrategy() {
        return saleOutputFormatStrategy;
    }

    public final void setSaleOutputFormatStrategy(SaleOutputFormatStrategy
            saleOutputFormatStrategy) {
        //Requires validation
        this.saleOutputFormatStrategy = saleOutputFormatStrategy;
    }
}
