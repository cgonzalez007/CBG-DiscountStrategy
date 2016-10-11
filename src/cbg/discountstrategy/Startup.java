
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Startup {

    public static void main(String[] args) {
        //Configurations
        DataAccessStrategy dataAccess = new InMemoryDataStorage();

        ReceiptOutputStrategy receiptOutputStrategy = new 
            ConsoleReceiptOutput();
        ReceiptOutputFormatStrategy receiptOutputFormatStrategy = new
            ConsoleReceiptFormat2();

        SaleOutputStrategy saleOutputStrategy = new GuiSaleOutput();
        SaleOutputFormatStrategy saleOutputFormatStrategy = new 
            GuiSaleOutputFormat2();

        PosTerminal posTerminal = new PosTerminal();

        posTerminal.startNewSale("C002", receiptOutputStrategy,
                receiptOutputFormatStrategy, saleOutputStrategy,
                saleOutputFormatStrategy, dataAccess);
        posTerminal.addProductToSale("P101", 2, dataAccess);
        posTerminal.addProductToSale("P102", 23, dataAccess);
        posTerminal.addProductToSale("P103", 14, dataAccess);
        posTerminal.addProductToSale("P104", 9, dataAccess);
        posTerminal.closeSale();

    }
    
}
