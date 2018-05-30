package com.demidov.cinema.service.managemodel.impl;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.model.entities.Film;
import com.demidov.cinema.model.repositories.FilmRepository;
import com.demidov.cinema.service.managemodel.FilmService;
import com.demidov.cinema.service.validators.EntityParametersValidator;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ObjectFactory<Film> filmFactory;

    @Autowired
    @Qualifier("Film")
    private EntityParametersValidator<Film> filmEntityParametersValidator;

    @Override
    @Transactional
    public void createFilm(String name, int durationMinutes, int basePrice) throws CinemaProcessModelException {
        List<Film> byName = filmRepository.findByNameIgnoreCase(name);
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

    @Override
    public List<Film> getAllActualFilms() {
        // TODO: Detach?
        return filmRepository.findAllByArchived(false);
    }

    @Override
    @Transactional
    public void deleteFilm(Integer id) {
        filmRepository.delete(id);
    }
}
