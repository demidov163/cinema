package com.demidov.cinema.service.impl;

import com.demidov.cinema.exceptions.CinemaProcessModelException;
import com.demidov.cinema.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.model.entities.Hall;
import com.demidov.cinema.model.factories.HallFactory;
import com.demidov.cinema.model.repositories.HallRepository;
import com.demidov.cinema.service.HallService;
import com.demidov.cinema.service.util.NumbersUtil;
import com.demidov.cinema.service.validators.EntityParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallFactory hallFactory;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    @Qualifier("hall")
    private EntityParametersValidator<Hall> hallEntityParametersValidator;

    @Override
    @Transactional
    public void createHall(String name, int[][] places) throws CinemaProcessModelException {
        List<Hall> foundedHall = hallRepository.findByNameIgnoreCase(name);
        if (!foundedHall.isEmpty()) {
            throw new CinemaProcessModelException(String.format("Hall with name %s has already created. ", name));
        }

        Hall newHall = hallFactory.getObject();
        newHall.setName(name);
        newHall.setPlaces(NumbersUtil.matrixConvertToInteger(places));
        newHall.setPlacecoeff(getPlaceCoefficient(places));

        try {
            hallEntityParametersValidator.validateEntityParameters(newHall);
        } catch (CinemaValidateParametersException e) {
            throw new CinemaProcessModelException(e);
        }

        hallRepository.save(newHall);
    }

    private float getPlaceCoefficient(int[][] places) {
        return 1;
    }
}
