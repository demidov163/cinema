package com.demidov.cinema.model.repositories;


import com.demidov.cinema.model.entities.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    List<Film> findAllByArchived(boolean isArchived);
    List<Film> findLikeNameStartingWith(String name);
}
