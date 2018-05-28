package com.demidov.cinema.test.preparation;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.repositories.FilmRepository;
import com.demidov.cinema.service.FilmService;
import com.demidov.cinema.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestDataLoading {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private HallService hallService;

    @Autowired
    private FilmService filmService;

    public void saveAll(){
        saveFilms();
        saveHalls();
    }

    public void saveFilms() {
        try {
            filmService.createFilm("filmFirst", 100, 8000);
        } catch (CinemaProcessModelException e) {
            e.printStackTrace();
        }
    }

    public void saveHalls() {
        try {
            hallService.createHall(1, new int[][]{{1, 1}, {0, 1}});
        } catch (CinemaProcessModelException e) {
            e.printStackTrace();
        }
    }
}
