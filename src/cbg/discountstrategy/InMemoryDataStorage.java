
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class InMemoryDataStorage implements DataAccessStrategy {

    Customer[] customers = new Customer[]{
        new Customer("C001","Trebek","Alex"),
        new Customer("C010","Connery","Sean"),
        new Customer("C100","Reynolds","Burt")
    };
    Product[] products = new Product[]{
        new Product()
    };

    @Override
    public Customer findCustomer(String customerId) {
        //requires validation!
        Customer foundCustomer = null;
        for(Customer customer : customers){
            if(customerId.equals(customer.getCustomerId())){
                foundCustomer = customer;
            }
        }
        return foundCustomer;
    }

    @Override
    public Product findProduct(String productId) {
        // requires validation!
        Product foundProduct = null;
        for(Product product : products){
            if(productId.equals(product.getProductId())){
                foundProduct = product;
            }
        }
        return foundProduct;
    }

}
