
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class LineItem {
    private Product product;
    private int productQty;
    private double subTotal;
    private double discount;

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final int getProductQty() {
        return productQty;
    }

    public final void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public final double getSubTotal() {
        return subTotal;
    }

    public final void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public final double getDiscount() {
        return discount;
    }

    public final void setDiscount(double discount) {
        this.discount = discount;
    }
    public final double getLineTotal(){
        return subTotal - discount;
    }
    
}
