package cart.exception;

import java.util.NoSuchElementException;

public class NotExistElementException extends NoSuchElementException {

    private String message;

    public NotExistElementException(String message) {
        this.message = message;
    }

}
