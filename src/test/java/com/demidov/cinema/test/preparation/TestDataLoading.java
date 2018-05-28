package com.demidov.cinema.test.preparation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:com/demidov/cinema/context/model-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDataLoading {

    @Autowired
    private DataLoadingService dataLoadingService;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDataLoading() {
         dataLoadingService.saveHalls();
    }


}
