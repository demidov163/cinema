package com.demidov.cinema.model.repositories;

import com.demidov.cinema.model.entities.Film;
import com.demidov.cinema.model.entities.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Integer> {
    List<Session> findByDateBetween(Date startSessionDate, Date endSessionDate);
    List<Session> findByFilm(Film film);

}
