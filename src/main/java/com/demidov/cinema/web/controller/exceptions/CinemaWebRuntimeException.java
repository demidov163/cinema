package com.demidov.cinema.web.controller.exceptions;

public class CinemaWebRuntimeException extends RuntimeException {

    public CinemaWebRuntimeException(Exception ex) {
        super(ex);
    }
}
