package com.kma.demo.exceptions;

public class EmptyParameterException extends Exception {
    public EmptyParameterException() {
        super();
    }

    public EmptyParameterException(String message) {
        super(message);
    }

    public EmptyParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyParameterException(Throwable cause) {
        super(cause);
    }
}

