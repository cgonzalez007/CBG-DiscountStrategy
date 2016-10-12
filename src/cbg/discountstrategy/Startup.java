
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

        EndOfSaleMessageOutputStrategy endOfSaleMessageOutput
                = new GuiEndOfSaleMessageOutput();
        EndOfSaleMessageFormatStrategy endOfSaleMessageFormat = 
                new GuiEndOfSaleMessageFormat2();

        PosTerminal posTerminal = new PosTerminal();

        posTerminal.startNewSale("C002", receiptOutput,
                receiptFormat, endOfSaleMessageOutput,
                endOfSaleMessageFormat, dataAccess);
        posTerminal.addProductToSale("P104", 9, dataAccess);
        posTerminal.addProductToSale("P101", 2, dataAccess);
        posTerminal.addProductToSale("P103", 14, dataAccess);
        posTerminal.addProductToSale("P102", 23, dataAccess);
        
        posTerminal.closeSale();

    }

}
