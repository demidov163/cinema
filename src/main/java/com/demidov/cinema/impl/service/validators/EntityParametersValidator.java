package com.demidov.cinema.impl.service.validators;

import com.demidov.cinema.impl.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.impl.model.entities.CinemaEntity;

public interface EntityParametersValidator<T extends CinemaEntity> {
    void validateEntityParameters(T entity) throws CinemaValidateParametersException;
}
