package com.readersdigest.onepass.exception;

/**
 * The Class ServiceException.
 *
 * @author shsingh
 */
public class ServiceException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new service exception.
     */
    public ServiceException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new service exception.
     *
     * @param message
     *            the message
     */
    public ServiceException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new service exception.
     *
     * @param cause
     *            the cause
     */
    public ServiceException(final Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new service exception.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}
