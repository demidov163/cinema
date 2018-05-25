package com.demidov.cinema.service;

import com.demidov.cinema.exceptions.CinemaProcessModelException;

public interface FilmService {
    void createFilm(String name, int durationMinutes, int basePrice) throws CinemaProcessModelException;
}
