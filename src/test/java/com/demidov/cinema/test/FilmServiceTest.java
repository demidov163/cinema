package com.demidov.cinema.test;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.service.managemodel.FilmService;
import com.demidov.cinema.test.context.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@ContextConfiguration(classes={TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @Test
    @Transactional
    @Rollback
    public void FilmCreationTest() {
        try {
            filmService.createFilm("!New Cinema", 122, 32323);
        } catch (CinemaProcessModelException e) {
            Assert.assertTrue(e.getMessage() != null);
        }
    }

}
