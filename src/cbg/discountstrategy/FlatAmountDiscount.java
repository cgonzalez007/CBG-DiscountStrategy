
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class FlatAmountDiscount implements DiscountStrategy{
    private double flatAmount;

    public FlatAmountDiscount(double flatAmount) {
        //Requires validation
        this.flatAmount = flatAmount;
    }
    
    @Override
    public final double getDiscount(double unitPrice, int productQty) {
        // requires validation!!! 
        return flatAmount * productQty; 
    }

    public final double getFlatAmount() {
        return flatAmount;
    }

    public final void setFlatAmount(double flatAmount) {
        //Requires validation
        this.flatAmount = flatAmount;
    }
    
}
