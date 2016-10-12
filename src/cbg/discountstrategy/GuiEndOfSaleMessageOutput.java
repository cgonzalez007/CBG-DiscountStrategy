
package cbg.discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author cgonz
 */
public class GuiEndOfSaleMessageOutput implements
        EndOfSaleMessageOutputStrategy {

    @Override
    public final void outputEndOfSaleMessage(String saleOutput) {
        JOptionPane.showMessageDialog(null, saleOutput);
    }

}
