package com.demidov.cinema.impl.service.validators;

import com.demidov.cinema.impl.model.entities.Hall;
import com.demidov.cinema.impl.model.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("hall")
public class HallValidator extends AbstractEntityParameterValidator<Hall> {

    @Autowired
    private HallRepository hallRepository;


    @Override
    protected void validateActualEntityParameters(Hall entity, StringBuilder errorBuilder) {
        checkValidation(errorBuilder, validateHallNumber(entity.getHallNumber()));
        //todo check other parameters
    }

    private Optional<String> validateHallNumber(Integer hallNumber) {
        if (hallNumber == null || hallNumber <= 0) {
            return Optional.of(String.format("Hall number %s is incorrect, should be more then zero", hallNumber));
        }

        Hall hallByNumber = hallRepository.findByHallNumber(hallNumber);
        if (hallByNumber != null) {
            return Optional.of(String.format("Hall with number %s has already be created.", hallNumber));
        }

        return Optional.empty();
    }

}
