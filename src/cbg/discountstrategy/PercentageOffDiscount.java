
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PercentageOffDiscount implements DiscountStrategy {
    private double percentageOff;
    private String promotionName;

    public PercentageOffDiscount(double percentageOff, String promotionName) {
        this.percentageOff = percentageOff;
        this.promotionName = promotionName;
    }

    @Override
    public final double getDiscount(double unitPrice, int productQty) {
       // requires validation!
       return (unitPrice*percentageOff) * productQty;
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
