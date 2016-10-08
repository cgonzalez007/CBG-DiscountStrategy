
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public interface DataAccessStrategy {

    public abstract Customer findCustomer(String customerId);

    public abstract Product findProduct(String productId);
}
