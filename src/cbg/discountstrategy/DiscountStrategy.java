
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface DiscountStrategy {

    public abstract double getDiscount(double unitPrice, int productQty);

    public abstract String getPromotionName();
}
