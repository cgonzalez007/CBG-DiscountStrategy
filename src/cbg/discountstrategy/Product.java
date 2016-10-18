
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
        setProductId(productId);
        setProductName(productName);
        setUnitPrice(unitPrice);
        setDiscountStrategy(discountStrategy);
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId)throws
            IllegalArgumentException {
        //Requires validation
        if(productId.length()< 4){
            throw new IllegalArgumentException("Product ID cannot be less than"
                    + " four characters");
        }
        this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName)throws 
            IllegalArgumentException {
        //Requires validation
        if(productName.length()< 5){
            throw new IllegalArgumentException("Product name cannot be less "
                    + "than five characters");
        }
        this.productName = productName;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) throws
            IllegalArgumentException{
        //Requires validation
        if(unitPrice < 0){
            throw new IllegalArgumentException("Unit price cannot be less "
                    + "than $0.00");
        }
        this.unitPrice = unitPrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

}
