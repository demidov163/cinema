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
    public void createHall(int hallNumber, int[][] places) throws CinemaProcessModelException {

        Hall newHall = hallFactory.getObject();
        newHall.setPlaces(NumbersUtil.matrixConvertToInteger(places));
        newHall.setPlacecoeff(getPlaceCoefficient(places));
        newHall.setHallNumber(hallNumber);
        try {
            hallEntityParametersValidator.validateEntityParameters(newHall);
        } catch (CinemaValidateParametersException e) {
            throw new CinemaProcessModelException(e);
        }

        newHall.setName(generateHallName(newHall));

        hallRepository.save(newHall);
    }

    @Override
    public void deleteHall(Integer id) {
        hallRepository.delete(id);
    }

    @Override
    public Hall getHallByHallNumber(Integer hallNumber) {
        return hallRepository.findByHallNumber(hallNumber);
    }

    private float getPlaceCoefficient(int[][] places) {
        //todo implement coefficient calculation
        return 1;
    }

    private String generateHallName(Hall entity) {
        return String.format("Hall#%d", entity.getHallNumber());
    }
}
