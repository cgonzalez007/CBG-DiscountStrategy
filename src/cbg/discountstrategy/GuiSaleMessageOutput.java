
package cbg.discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author cgonz
 */
public class GuiSaleMessageOutput implements
        SaleMessageOutputStrategy {

    @Override
    public final void outputSaleMessage(String saleOutput) {
        JOptionPane.showMessageDialog(null, saleOutput);
    }

}
