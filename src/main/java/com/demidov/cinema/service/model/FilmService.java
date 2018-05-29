package com.demidov.cinema.service.model;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.entities.Film;

import java.util.List;

public interface FilmService {
    void createFilm(String name, int durationMinutes, int basePrice) throws CinemaProcessModelException;

    List<Film> getAllActualFilms();

    void deleteFilm(Integer id);
}
