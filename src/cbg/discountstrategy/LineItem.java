
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class LineItem {

    private Product product;
    private int productQty;

    public LineItem(Product product, int productQty) {
        this.product = product;
        this.productQty = productQty;
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

    public final void setProductQty(int productQty) {
        //Requires validation
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
