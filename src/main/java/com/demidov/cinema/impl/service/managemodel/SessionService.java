package com.demidov.cinema.impl.service.managemodel;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Session;

import java.util.Date;
import java.util.Optional;

public interface SessionService {
    Session createSession(Integer filmId, Integer hallId, Date sessionDate) throws CinemaProcessModelException;

    Optional<Session> getSessionById(Integer sessionId);
}
