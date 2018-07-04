package com.wp.offer.Wikipedia.Exception;

/**
 * for HTTP 404 errors
 * Created by suneel on 03/07/2018.
 */
public class DataFormatException extends RuntimeException {
    public DataFormatException() {
        super();
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}
