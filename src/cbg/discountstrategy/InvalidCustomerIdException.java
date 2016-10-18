
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class InvalidCustomerIdException extends IllegalArgumentException{
    private static final String MESSAGE = "Sorry, the customer ID entered is"
            + " invalid.";

    public InvalidCustomerIdException() {
        super(MESSAGE);
    }

    public InvalidCustomerIdException(String s) {
        super(s);
    }

    public InvalidCustomerIdException(String message, Throwable cause) {
        super(MESSAGE, cause);
    }

    public InvalidCustomerIdException(Throwable cause) {
        super(cause);
    }
    
}
