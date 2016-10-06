
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Startup {
    public static void main(String[] args) {
        DataAccessStrategy dataAccess = new InMemoryDataStorage();
        SaleOutputStrategy saleOutputStrategy = new GuiSaleOutput();
        ReceiptOutputStrategy receiptOutputFormat = new ConsoleReceiptOutput();
               
        PosTerminal posTerminal = new PosTerminal();
        
        posTerminal.startNewSale("C002",receiptOutputFormat, saleOutputStrategy,
                dataAccess);
        posTerminal.addProductToSale("P101",2,dataAccess);
        posTerminal.addProductToSale("P102",1,dataAccess);
        posTerminal.addProductToSale("P103",4,dataAccess);
        posTerminal.addProductToSale("P104",3,dataAccess);
        posTerminal.closeSale();
        
    }
}
