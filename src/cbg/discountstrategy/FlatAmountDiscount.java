
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class FlatAmountDiscount implements DiscountStrategy{
    private double flatAmount;
    private String promotionName;

    public FlatAmountDiscount(double flatAmount, String promotionName) {
        this.flatAmount = flatAmount;
        this.promotionName = promotionName;
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

    @Override
    public final String getPromotionName() {
        return promotionName;
    }

    public final void setPromotionName(String promotionName) {
        //Requires validation
        this.promotionName = promotionName;
    }
    
}
