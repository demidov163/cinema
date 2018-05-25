package com.demidov.cinema.test;

import com.demidov.cinema.model.entities.Film;
import com.demidov.cinema.model.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestDataLoading {

    @Autowired
    private FilmRepository filmRepository;

    public void loadAll(){
        loadFilms();
    }

    public void loadFilms() {
        List<Film> films = filmRepository.findByName("filmFirst");
        if (films.isEmpty()) {
            Film filmFirst = new Film();
            filmFirst.setName("filmFirst");
            filmFirst.setBasePrice(8000);
            filmFirst.setDurationMinuts(100);
            filmRepository.save(filmFirst);

        }
    }
}
