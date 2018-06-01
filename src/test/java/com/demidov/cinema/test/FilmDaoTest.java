package com.demidov.cinema.test;

import com.demidov.cinema.model.entities.Film;
import com.demidov.cinema.model.repositories.FilmRepository;
import com.demidov.cinema.test.preparation.DataLoadingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@ContextConfiguration(locations = "classpath:com/demidov/cinema/context/model-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FilmDaoTest {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private DataLoadingService testDataLoading;

    @Rollback(value = false)
    @Before
    public void init() {
        testDataLoading.saveFilms();
    }

    @Test
    @Transactional
    @Rollback
    public void testAddFilm() {
        Film newFilm = new Film();
        String newFilmName = "Film " + new Date();
        newFilm.setName(newFilmName);

        Film save = filmRepository.save(newFilm);
        Film foundFilm = filmRepository.findOne((save.getId()));
        Assert.assertEquals(newFilmName, foundFilm.getName());

    }

    @Test
    public void testFindFilmByName() {
        Optional<Film> firstfiLm = filmRepository.findAllByArchived(false).
                stream().filter(film -> film.getName().startsWith("filmFirst")).findAny();

        Assert.assertTrue(firstfiLm.isPresent());
    }
}
