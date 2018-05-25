package com.demidov.cinema.service.validators;

import com.demidov.cinema.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.model.entities.CinemaEntity;

public interface EntityParametersValidator<T extends CinemaEntity> {
    void validateEntityParameters(T entity) throws CinemaValidateParametersException;
}
