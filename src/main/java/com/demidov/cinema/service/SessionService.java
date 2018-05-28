package com.demidov.cinema.service;

import com.demidov.cinema.exceptions.CinemaProcessModelException;

import java.util.Date;

public interface SessionService {
    void createSession(Integer filmId, Integer hallId, Date sessionDate, Integer price) throws CinemaProcessModelException;

}
