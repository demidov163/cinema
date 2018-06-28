package com.demidov.cinema.impl.exceptions;


public class CinemaProcessModelException extends Exception {

    public CinemaProcessModelException() {
        super();
    }

    public CinemaProcessModelException(String message) {
        super(message);
    }

    public CinemaProcessModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public CinemaProcessModelException(Throwable cause) {
        super(cause);
    }
}
