
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class InMemoryDataStorage implements DataAccessStrategy {

    Customer[] customers = new Customer[]{
        new Customer("C001", "Trebek", "Alex"),
        new Customer("C002", "Connery", "Sean"),
        new Customer("C103", "Reynolds", "Burt")
    };
    Product[] products = new Product[]{
        new Product("P101", "Men's Socks", 19.95, new NoDiscount()),
        new Product("P102", "Red Sweater", 24.99, new 
            PercentageOffDiscount(.25, "25% Off")),
        new Product("P103", "Women's blouse", 49.99, new 
            FlatAmountDiscount(5.00, "$5 off")),
        new Product("P104", "Blue Shirt", 9.99, new 
            PercentageOffBasedOnQuantityDiscount(5, 0.20, "20% off when you "
        + "purchase 5"))
    };

    @Override
    public final Customer findCustomer(String customerId) {
        //requires validation!
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customerId.equals(customer.getCustomerId())) {
                foundCustomer = customer;
            }
        }
        return foundCustomer;
    }

    @Override
    public final Product findProduct(String productId) {
        // requires validation!
        Product foundProduct = null;
        for (Product product : products) {
            if (productId.equals(product.getProductId())) {
                foundProduct = product;
            }
        }
        return foundProduct;
    }

}
