
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class FlatAmountDiscount implements DiscountStrategy {

    private double flatAmount;
    private String promotionName;

    public FlatAmountDiscount(double flatAmount, String promotionName) {
        setFlatAmount(flatAmount);
        setPromotionName(promotionName);
    }

    @Override
    public final double getDiscount(double unitPrice, int productQty) {
        // requires validation!!! 
        return flatAmount * productQty;
    }

    public final double getFlatAmount() {
        return flatAmount;
    }

    public final void setFlatAmount(double flatAmount) throws 
            IllegalArgumentException{
        //Requires validation
        if(flatAmount < 0){
            throw new IllegalArgumentException("Flat amount must be greater"
                    + " than $0.00");
        }
        this.flatAmount = flatAmount;
    }

    @Override
    public final String getPromotionName() {
        return promotionName;
    }

    public final void setPromotionName(String promotionName) throws
            IllegalArgumentException{
        //Requires validation
        if(promotionName.length() < 5){
            throw new IllegalArgumentException("Promotion name must be "
                    + "greater than 5 characters");
        }
        this.promotionName = promotionName;
    }

}
