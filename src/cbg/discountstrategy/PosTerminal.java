
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PosTerminal {

    private Receipt receipt;

    public final void startNewSale(String customerId, ReceiptOutputStrategy
            receiptOutputStrategy, SaleOutputStrategy saleOutputStrategy,
                DataAccessStrategy dataAccessStrategy) {
        Receipt newReceipt = new Receipt(customerId, receiptOutputStrategy,
                saleOutputStrategy, dataAccessStrategy);
        this.receipt = newReceipt;
    }

    public final void addProductToSale(String productId, int productQty,
            DataAccessStrategy dataAccessStrategy) {
        //Requires validation

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
