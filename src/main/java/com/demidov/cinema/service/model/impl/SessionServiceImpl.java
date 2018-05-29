package com.demidov.cinema.service.model.impl;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.model.entities.Session;
import com.demidov.cinema.model.repositories.FilmRepository;
import com.demidov.cinema.model.repositories.HallRepository;
import com.demidov.cinema.model.repositories.SessionRepository;
import com.demidov.cinema.service.model.SessionService;
import com.demidov.cinema.service.purchase.CinemaPriceCalculationService;
import com.demidov.cinema.service.validators.EntityParametersValidator;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private ObjectFactory<Session> sessionFactory;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    @Qualifier("session")
    private EntityParametersValidator<Session> parametersValidator;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CinemaPriceCalculationService cinemaPriceCalculationService;


    @Override
    public void createSession(Integer filmId, Integer hallId, Date sessionDate) throws CinemaProcessModelException {
        Session newSession = sessionFactory.getObject();

        try {
            newSession.setFilm(filmRepository.findOne(filmId));
            newSession.setHall(hallRepository.findOne(hallId));
            newSession.setDate(sessionDate);
            newSession.setPrice(cinemaPriceCalculationService.calculateSessionPrice(newSession.getFilm().getBasePrice(), sessionDate));
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





    @Override
    public Optional<Session> getSessionById(Integer sessionId) {
        return Optional.of(sessionRepository.findOne(sessionId));
    }


}
