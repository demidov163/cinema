package com.demidov.cinema.impl.service.validators;

import com.demidov.cinema.impl.model.entities.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("session")
public class SessionValidator extends AbstractEntityParameterValidator<Session> {

    @Override
    protected void validateActualEntityParameters(Session entity, StringBuilder errorBuilder) {
         checkValidation(errorBuilder, validatePrice(entity.getPrice()));
        //todo add other validation
    }
     private Optional<String> validatePrice(Integer price) {
         if (price == null || price < 0 || price > 500000) {
             return Optional.of(String.format("Price %d is invalid ", price));
         }
         return Optional.empty();
     }
}
