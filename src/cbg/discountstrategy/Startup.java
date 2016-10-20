
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Startup {

    public static void main(String[] args) {
        //Configurations
        DataAccessStrategy dataAccess = new InMemoryDataStorage();

        ReceiptOutputStrategy receiptOutput = new ConsoleReceiptOutput();
        ReceiptFormatStrategy receiptFormat = new ConsoleReceiptFormat2();

        SaleMessageOutputStrategy saleMessageOutput
                = new GuiSaleMessageOutput();
        EndOfSaleMessageFormatStrategy endOfSaleMessageFormat = 
                new GuiEndOfSaleMessageFormat2();

        PosTerminal posTerminal = new PosTerminal();

        posTerminal.startNewSale("C003", receiptOutput,
                receiptFormat, saleMessageOutput,
                endOfSaleMessageFormat, dataAccess);
        posTerminal.addProductToSale("P101", 500, dataAccess);
        posTerminal.addProductToSale("P102", 2, dataAccess);
        posTerminal.addProductToSale("P103", 14, dataAccess);
        posTerminal.addProductToSale("P104", 23, dataAccess);
        
        posTerminal.closeSale();

    }

}
