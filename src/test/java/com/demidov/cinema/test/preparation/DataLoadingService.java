package com.demidov.cinema.test.preparation;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.model.entities.Film;
import com.demidov.cinema.model.entities.Hall;
import com.demidov.cinema.service.FilmService;
import com.demidov.cinema.service.HallService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DataLoadingService {

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
            String filmName = "filmFirst";
            List<Film> allActualFilms = filmService.getAllActualFilms();
            Optional<Film> first = allActualFilms.stream().filter(film -> filmName.startsWith(film.getName())).findFirst();
            if (first.isPresent()) {
                filmService.deleteFilm(first.get().getId());
            }
            String newFilmName = filmName + " " + new Date().getTime();
            filmService.createFilm(newFilmName, 100, 8000);

            allActualFilms = filmService.getAllActualFilms();
            first = allActualFilms.stream().filter(film -> newFilmName.equals(film.getName())).findFirst();
            Assert.assertTrue(first.isPresent());
        } catch (CinemaProcessModelException e) {
            e.printStackTrace();
        }
    }

    public void saveHalls() {
        int hallNumber = 2;
        try {
            Hall hallByHallNumber = hallService.getHallByHallNumber(hallNumber);
            if (hallByHallNumber != null)  {
                hallService.deleteHall(hallByHallNumber.getId());
            }
            hallService.createHall(hallNumber, new int[][]{{1, 1}, {0, 1}});
        } catch (CinemaProcessModelException e) {
            e.printStackTrace();
        }
    }
}
