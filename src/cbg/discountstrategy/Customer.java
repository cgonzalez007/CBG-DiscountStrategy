
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Customer {

    private String CustomerId;
    private String lastName;
    private String firstName;

    public Customer(String CustomerId, String lastName, String firstName) {
        this.CustomerId = CustomerId;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public final String getCustomerId() {
        return CustomerId;
    }

    public final void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}