
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class ConsoleReceiptOutput implements ReceiptOutputStrategy {

    @Override
    public final void outputSaleReceipt(String receiptOutput) {
        //Requires validation
        System.out.println(receiptOutput);
    }

}
