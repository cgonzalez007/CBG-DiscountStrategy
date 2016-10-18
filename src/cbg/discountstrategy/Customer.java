
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class Customer {

    private String customerId;
    private String lastName;
    private String firstName;

    public Customer(String customerId, String lastName, String firstName) {
        //Requires validation
        setCustomerId(customerId);
        setLastName(lastName);
        setFirstName(firstName);
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) throws 
            IllegalArgumentException {
        //Requires validation
        if(customerId.length() < 4 ){
            throw new IllegalArgumentException("Customer ID cannot be less than"
                    + " four characters");
        }
        this.customerId = customerId;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName)throws 
            IllegalArgumentException {
        //Requires validation
        if(lastName.length() < 2 ){
            throw new IllegalArgumentException("Last name cannot be less than"
                    + " two characters");
        }
        
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) throws 
            IllegalArgumentException {
        //Requires validation
        if(firstName.length() < 2 ){
            throw new IllegalArgumentException("First name cannot be less than"
                    + " two characters");
        }
        this.firstName = firstName;
    }

}
