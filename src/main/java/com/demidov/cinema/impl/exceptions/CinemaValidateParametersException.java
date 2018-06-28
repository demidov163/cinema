package com.demidov.cinema.impl.exceptions;


public class CinemaValidateParametersException extends Exception {

    public CinemaValidateParametersException() {
        super();
    }

    public CinemaValidateParametersException(String message) {
        super(message);
    }

    public CinemaValidateParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public CinemaValidateParametersException(Throwable cause) {
        super(cause);
    }
}
