package com.wp.offer.Wikipedia.Exception;

/**
 * Created by suneel on 09/07/2018.
 */
public class ViolationException extends RuntimeException {
    public ViolationException() {
        super();
    }

    public ViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViolationException(String message) {
        super(message);
    }

    public ViolationException(Throwable cause) {
        super(cause);
    }
}


