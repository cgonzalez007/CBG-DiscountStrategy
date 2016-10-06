
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Product {

    private String productId;
    private String productName;
    private double unitPrice;
    private DiscountStrategy discountStrategy;

    public Product(String productId, String productName, double unitPrice, 
            DiscountStrategy discountStrategy) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.discountStrategy = discountStrategy;
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        //Requires validation
        this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        //Requires validation
        this.productName = productName;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
        //Requires validation
        this.unitPrice = unitPrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    

}
