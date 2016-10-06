
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PercentageOffBasedOnQuantityDiscount implements DiscountStrategy {
    private int minQtyNeeded;
    private double percentageOff;
    private final double NO_DISCOUNT = 0;

    public PercentageOffBasedOnQuantityDiscount(int minQtyNeeded, double percentageOff) {
        this.minQtyNeeded = minQtyNeeded;
        this.percentageOff = percentageOff;
    }
    
    @Override
    public final double getDiscount(double unitPrice, int productQty) {
        // requires validation! Do not use this for final version!!!
        if (productQty>= minQtyNeeded){
            return (unitPrice*minQtyNeeded) * percentageOff;
        } else{
            return NO_DISCOUNT;
        }
    }

    public final int getMinQtyNeeded() {
        return minQtyNeeded;
    }

    public final void setMinQtyNeeded(int minQtyNeeded) {
        //Requires validation
        this.minQtyNeeded = minQtyNeeded;
    }

    public final double getPercentageOff() {
        return percentageOff;
    }

    public final void setPercentageOff(double percentageOff) {
        //Requires validation
        this.percentageOff = percentageOff;
    }
    
}
