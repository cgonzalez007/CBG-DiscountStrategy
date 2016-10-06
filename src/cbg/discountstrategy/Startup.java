
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Startup {
    public static void main(String[] args) {
        DataAccessStrategy dataAccess = new InMemoryDataStorage();
        ReceiptOutputFormat receiptOutputFormat = new ConsoleReceiptOutput();
        SaleOutputStrategy saleOutputStrategy = new GuiSaleOutput();
                
        PosTerminal posTerminal = new PosTerminal();
        
        posTerminal.startNewSale();
        posTerminal.addProductToSale();
        posTerminal.addProductToSale();
        posTerminal.addProductToSale();
        posTerminal.closeSale();
        
    }
}
