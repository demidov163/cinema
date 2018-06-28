package com.demidov.cinema.impl.service.validators;

import com.demidov.cinema.impl.exceptions.CinemaValidateParametersException;
import com.demidov.cinema.impl.model.entities.CinemaEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public abstract class AbstractEntityParameterValidator<T extends CinemaEntity> implements EntityParametersValidator<T> {

    protected void checkValidation(StringBuilder errorBuilder, Optional<String> nameOptional) {
        if (nameOptional.isPresent()) {
           errorBuilder.append(nameOptional.get()).append("\n");
        }
    }

    protected abstract void validateActualEntityParameters(T entity, StringBuilder errorBuilder);

    @Override
    public void validateEntityParameters(T entity) throws CinemaValidateParametersException {
        StringBuilder errorBuilder = new StringBuilder();

        validateActualEntityParameters(entity, errorBuilder);

        if (StringUtils.isNotEmpty(errorBuilder)) {
            throw new CinemaValidateParametersException(errorBuilder.toString());
        }
    }
}
