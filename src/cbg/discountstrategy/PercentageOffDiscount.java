
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class PercentageOffDiscount implements DiscountStrategy {
    private double percentageOff;

    public PercentageOffDiscount(double percentageOff) {
        this.percentageOff = percentageOff;
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
        this.percentageOff = percentageOff;
    }
    
}
