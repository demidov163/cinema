package com.demidov.cinema.test;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.service.managemodel.HallService;
import com.demidov.cinema.test.context.TestConfig;
import com.demidov.cinema.test.preparation.DataLoadingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes={TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class HallServiceTest {

    @Autowired
    private HallService hallService;

    @Autowired
    private DataLoadingService testDataLoading;

    @Test(expected = CinemaProcessModelException.class)
    @Transactional
    public void createHallWithNegativeNumber() throws CinemaProcessModelException {
        hallService.createHall("", -1, new int[][]{{1, 1}, {0, 1}});
    }
}
