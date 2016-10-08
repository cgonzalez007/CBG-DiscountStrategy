
package cbg.discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author cgonz
 */
public class GuiSaleOutput implements SaleOutputStrategy {

    @Override
    public final void outputSale(String saleOutput) {
        JOptionPane.showMessageDialog(null, saleOutput);
    }

}
