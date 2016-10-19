
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PosTerminal {

    private Receipt receipt;

    public final void startNewSale(String customerId, ReceiptOutputStrategy 
            receiptOutput, ReceiptFormatStrategy 
            receiptFormat, SaleMessageOutputStrategy 
            saleMessageOutput, EndOfSaleMessageFormatStrategy
            endOfSaleMessageFormat, DataAccessStrategy
            dataAccess) {

        Receipt newReceipt = new Receipt(customerId, receiptOutput,
                receiptFormat, saleMessageOutput,
                endOfSaleMessageFormat, dataAccess);
        setReceipt(newReceipt);
    }

    public final void addProductToSale(String productId, int productQty,
            DataAccessStrategy dataAccess) {
        receipt.addLineItem(productId, productQty, dataAccess);

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
