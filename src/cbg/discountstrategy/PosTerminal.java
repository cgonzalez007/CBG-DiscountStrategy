
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PosTerminal {
    private Receipt receipt;
    private SaleOutputStrategy SaleOutputStrategy;
    
    public final void startNewSale(){
        Receipt newReceipt = new Receipt();  
        this.receipt = newReceipt;
    }
    public final void addProductToSale(String productId, int productQty, 
            DataAccessStrategy dataAccessStrategy){
    
    }
    public final void closeSale(){
        
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    
}
