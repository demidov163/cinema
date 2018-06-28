package com.demidov.cinema.test.preparation;

import com.demidov.cinema.test.context.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes={TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDataLoading {

    @Autowired
    private DataLoadingService dataLoadingService;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testHallDataLoading() {
         dataLoadingService.saveHalls();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testFilmDataLoading(){
        dataLoadingService.saveFilms();
    }

}
