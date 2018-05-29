package com.demidov.cinema.service.model;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.entities.Session;

import java.util.Date;
import java.util.Optional;

public interface SessionService {
    void createSession(Integer filmId, Integer hallId, Date sessionDate) throws CinemaProcessModelException;

    Optional<Session> getSessionById(Integer sessionId);
}
