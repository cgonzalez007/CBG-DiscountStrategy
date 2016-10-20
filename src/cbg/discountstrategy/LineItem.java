
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class LineItem {

    private Product product;
    private int productQty;
    private static final int MIN_PRODUCT_QTY = 1;
    private static final int MAX_PRODUCT_QTY = 99;

    public LineItem(Product product, int productQty) {
        this.product = product;
        setProduct(product);
        setProductQty(productQty);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //Requires validation
        this.product = product;
    }

    public final int getProductQty() {
        return productQty;
    }

    public final void setProductQty(int productQty) throws 
            IllegalArgumentException {
        //Requires validation
        if(productQty < MIN_PRODUCT_QTY|| productQty > MAX_PRODUCT_QTY){
            throw new IllegalArgumentException("Invalid Product Quantity");
        }
        this.productQty = productQty;
    }

    public final double getSubTotal() {
        return product.getUnitPrice() * productQty;
    }

    public final double getDiscountTotal() {
        return product.getDiscountStrategy().getDiscount(product.getUnitPrice(),
                productQty);
    }

    public final double getLineTotal() {
        return getSubTotal() - getDiscountTotal();
    }

}
