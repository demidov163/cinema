package com.demidov.cinema.impl.exceptions;

public class CinemaPurchaseProcessingException extends Exception {

    public CinemaPurchaseProcessingException() {
    }

    public CinemaPurchaseProcessingException(String message) {
        super(message);
    }

    public CinemaPurchaseProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CinemaPurchaseProcessingException(Throwable cause) {
        super(cause);
    }
}
