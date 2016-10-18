
package cbg.discountstrategy;

/**
 *
 * @author cgonz
 */
public class InvalidProductIdException extends IllegalArgumentException {
    private static final String MESSAGE = "Sorry, the product ID entered is"
            + " invalid.";

    public InvalidProductIdException() {
        super(MESSAGE);
    }

    public InvalidProductIdException(String s) {
        super(s);
    }

    public InvalidProductIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductIdException(Throwable cause) {
        super(cause);
    }
    
}
