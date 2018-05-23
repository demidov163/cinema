package com.demidov.cinema.model.repositories;


import com.demidov.cinema.model.entities.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
