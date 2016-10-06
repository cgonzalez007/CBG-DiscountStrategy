
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class NoDiscount implements DiscountStrategy {
    private final double NO_DISCOUNT = 0;
    @Override
    public final double getDiscount(double unitPrice, int productQty) {
        return NO_DISCOUNT;
    }
    
}
