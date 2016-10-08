
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class NoDiscount implements DiscountStrategy {

    private final double NO_DISCOUNT = 0;
    private final String PROMOTION_NAME = "No Discount";

    @Override
    public final double getDiscount(double unitPrice, int productQty) {
        return NO_DISCOUNT;
    }

    @Override
    public final String getPromotionName() {
        return PROMOTION_NAME;
    }

}
