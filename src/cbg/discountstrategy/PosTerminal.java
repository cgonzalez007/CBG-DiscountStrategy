
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PosTerminal {

    private Receipt receipt;

    public final void startNewSale(String customerId, ReceiptOutputStrategy 
            receiptOutputStrategy, ReceiptOutputFormatStrategy 
                receiptOuputFormatStrategy, SaleOutputStrategy 
                    saleOutputStrategy, SaleOutputFormatStrategy
                        saleOutputFormatStrategy, DataAccessStrategy
                            dataAccessStrategy) {
        Receipt newReceipt = new Receipt(customerId, receiptOutputStrategy,
                receiptOuputFormatStrategy, saleOutputStrategy,
                saleOutputFormatStrategy, dataAccessStrategy);
        this.receipt = newReceipt;
    }

    public final void addProductToSale(String productId, int productQty,
            DataAccessStrategy dataAccessStrategy) {
        receipt.addLineItem(productId, productQty, dataAccessStrategy);

    }

    public final void closeSale() {
        receipt.doOutput();
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        //Requires validation
        this.receipt = receipt;
    }

}
