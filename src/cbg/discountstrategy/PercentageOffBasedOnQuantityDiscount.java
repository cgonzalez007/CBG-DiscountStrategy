
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PercentageOffBasedOnQuantityDiscount implements DiscountStrategy {

    private int qtyNeeded;
    private double percentageOff;
    private final double NO_DISCOUNT = 0;
    private String promotionName;

    public PercentageOffBasedOnQuantityDiscount(int qtyNeeded, double 
            percentageOff, String promotionName) {
        this.qtyNeeded = qtyNeeded;
        this.percentageOff = percentageOff;
        this.promotionName = promotionName;
    }

    @Override
    public final double getDiscount(double unitPrice, int productQty) {
        // requires validation! Do not use this for final version!!!
        if (productQty >= qtyNeeded) {
            return (unitPrice * qtyNeeded) * percentageOff;
        } else {
            return NO_DISCOUNT;
        }
    }

    public final int getQtyNeeded() {
        return qtyNeeded;
    }

    public final void setQtyNeeded(int qtyNeeded) {
        //Requires validation
        this.qtyNeeded = qtyNeeded;
    }

    public final double getPercentageOff() {
        return percentageOff;
    }

    public final void setPercentageOff(double percentageOff) {
        //Requires validation
        this.percentageOff = percentageOff;
    }

    @Override
    public final String getPromotionName() {
        return promotionName;
    }

    public final void setPromotionName(String promotionName) {
        //Requires validation
        this.promotionName = promotionName;
    }

}
