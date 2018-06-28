package com.demidov.cinema.impl.service.managemodel.impl;

import com.demidov.cinema.impl.exceptions.CinemaProcessModelException;
import com.demidov.cinema.impl.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.impl.model.entities.Hall;
import com.demidov.cinema.impl.model.repositories.HallRepository;
import com.demidov.cinema.impl.service.managemodel.HallService;
import com.demidov.cinema.impl.service.util.NumbersUtil;
import com.demidov.cinema.impl.service.validators.EntityParametersValidator;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private ObjectFactory<Hall> hallFactory;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    @Qualifier("hall")
    private EntityParametersValidator<Hall> hallEntityParametersValidator;

    @Override
    public Hall createHall(String name, int hallNumber, int[][] places) throws CinemaProcessModelException {

        Hall newHall = hallFactory.getObject();
        newHall.setPlaces(NumbersUtil.matrixConvertToInteger(places));
        newHall.setPlacecoeff(1.0f);
        newHall.setHallNumber(hallNumber);
        try {
            hallEntityParametersValidator.validateEntityParameters(newHall);
        } catch (CinemaValidateParametersException e) {
            throw new CinemaProcessModelException(e);
        }

        newHall.setName(StringUtils.isEmpty(name) ? generateHallName(newHall) : name);

        return hallRepository.save(newHall);
    }

    @Override
    public void deleteHall(Integer id) {
        hallRepository.delete(id);
    }

    @Override
    public Hall getHallByHallNumber(Integer hallNumber) {
        // TODO: Detach?
        return hallRepository.findByHallNumber(hallNumber);
    }

    private String generateHallName(Hall entity) {
        return String.format("Hall#%d", entity.getHallNumber());
    }
}
