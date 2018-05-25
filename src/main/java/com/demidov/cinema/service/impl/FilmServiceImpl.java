package com.demidov.cinema.service.impl;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.model.entities.Film;
import com.demidov.cinema.model.factories.FilmFactory;
import com.demidov.cinema.model.repositories.FilmRepository;
import com.demidov.cinema.service.FilmService;
import com.demidov.cinema.service.validators.EntityParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmFactory filmFactory;

    @Autowired
    @Qualifier("Film")
    private EntityParametersValidator<Film> filmEntityParametersValidator;

    @Override
    public void createFilm(String name, int durationMinutes, int basePrice) throws CinemaProcessModelException {
        List<Film> byName = filmRepository.findByName(name);
        if (!byName.isEmpty()) {
            throw new CinemaProcessModelException(String.format("Film with name %s has already created. ", name));
        }

        Film newFilm = filmFactory.getObject();
        newFilm.setName(name);
        newFilm.setDurationMinuts(durationMinutes);
        newFilm.setBasePrice(basePrice);

        try {
            filmEntityParametersValidator.validateEntityParameters(newFilm);
        } catch (CinemaValidateParametersException e) {
            throw new CinemaProcessModelException(e);
        }

        filmRepository.save(newFilm);
    }
}
