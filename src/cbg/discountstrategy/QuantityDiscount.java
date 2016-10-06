
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class QuantityDiscount implements DiscountStrategy {
    private int minQtyNeeded;
    private int percentageOff;
    private final int NO_DISCOUNT = 0;

    public QuantityDiscount(int minQtyNeeded, int percentageOff) {
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
        this.minQtyNeeded = minQtyNeeded;
    }

    public final int getPercentageOff() {
        return percentageOff;
    }

    public final void setPercentageOff(int percentageOff) {
        this.percentageOff = percentageOff;
    }
    
}
