package com.demidov.cinema.test;


import com.demidov.cinema.model.entities.Hall;
import com.demidov.cinema.model.repositories.HallRepository;
import com.demidov.cinema.test.preparation.DataLoadingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@ContextConfiguration(locations = "classpath:com/demidov/cinema/context/model-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HallDaoTest {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private DataLoadingService testDataLoading;

    @Test
    @Transactional
    @Rollback
    public void testHallSave() {
        Integer[][] places = {{0, 1}, {1,1}};
        Hall hall = new Hall();
        hall.setName("hall " + new Date());
        hall.setPlacecoeff((float) (3 / 4));
        hall.setPlaces(places);

        Hall savedHall = hallRepository.save(hall);

        Assert.assertTrue(savedHall.getId() != 0);
    }

}
