
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
        setQtyNeeded(qtyNeeded);
        setPercentageOff(percentageOff);
        setPromotionName(promotionName);
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

    public final void setQtyNeeded(int qtyNeeded) throws 
            IllegalArgumentException{
        //Requires validation
        if(qtyNeeded < 2){
            throw new IllegalArgumentException("Quantity needed must be greater"
                    + " than 2");
        }
        this.qtyNeeded = qtyNeeded;
    }

    public final double getPercentageOff() {
        return percentageOff;
    }

    public final void setPercentageOff(double percentageOff) throws 
            IllegalArgumentException{
        //Requires validation
        if(percentageOff < 0 || percentageOff > 1){
            throw new IllegalArgumentException("Invalid percentage: Percentage "
                    + "must be greater than 0, and less than 1");
        }
        this.percentageOff = percentageOff;
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
