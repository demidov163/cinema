package com.demidov.cinema.impl.service.managemodel;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.model.entities.Film;

import java.util.List;

public interface FilmService {
    Film createFilm(String name, int durationMinutes, int basePrice) throws CinemaProcessModelException;

    List<Film> getAllActualFilms();

    void deleteFilm(Integer id);
}
