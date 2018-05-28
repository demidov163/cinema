package com.demidov.cinema.service.impl;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.model.entities.Session;
import com.demidov.cinema.model.factories.SessionFactory;
import com.demidov.cinema.model.repositories.FilmRepository;
import com.demidov.cinema.model.repositories.HallRepository;
import com.demidov.cinema.model.repositories.SessionRepository;
import com.demidov.cinema.service.SessionService;
import com.demidov.cinema.service.validators.EntityParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    @Qualifier("session")
    private EntityParametersValidator<Session> parametersValidator;

    @Autowired
    private SessionRepository sessionRepository;


    @Override
    public void createSession(Integer filmId, Integer hallId, Date sessionDate, Integer price) throws CinemaProcessModelException {
        Session newSession = sessionFactory.getObject();

        try {
            newSession.setFilm(filmRepository.findOne(filmId));
            newSession.setHall(hallRepository.findOne(hallId));
            newSession.setDate(sessionDate);
            newSession.setPrice(price);
        } catch (Exception e) {
            throw new CinemaProcessModelException(e);

        }

        try {
            parametersValidator.validateEntityParameters(newSession);
        } catch (CinemaValidateParametersException e) {
            throw new CinemaProcessModelException(e);

        }

        sessionRepository.save(newSession);
    }
}
