package com.demidov.cinema.service.validators;


import com.demidov.cinema.model.entities.Film;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Qualifier("Film")
public class FilmValidator extends AbstractEntityParameterValidator<Film> {
    //any kind of letter from any language and numbers, space, -, ',
    private static final String FILM_NAME_PATTERN = "^[\\p{L}0-9 .'-]+$";
    private Pattern pattern = Pattern.compile(FILM_NAME_PATTERN);



    protected void validateActualEntityParameters(Film entity, StringBuilder errorBuilder) {
        checkValidation(errorBuilder, validateName(entity.getName()));
        checkValidation(errorBuilder, validatePrice(entity.getBasePrice()));
        checkValidation(errorBuilder, validateDuration(entity.getDurationMinuts()));
    }

    private Optional<String> validateName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Optional.of("Film name can not be empty");
        }
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return Optional.empty();
        } else {
            return Optional.of(String.format("Film name - %s has incorrect format. ", name));
        }
    }

    private Optional<String> validatePrice(int basePrice){
        if (basePrice < 100) {
            return Optional.of("Film's Base Price should be more then 1 rub");
        } else if (basePrice > 500000){
            return Optional.of("Film's Base Price should be less 5000 rub");
        }
        return Optional.empty();
    }

    private Optional<String> validateDuration(int durationMin){
        if (durationMin < 1) {
            return Optional.of("Film's Duration should be more then one minute");
        } else if (durationMin > 24 * 60){
            return Optional.of("Film's Duration should be less one day");
        }
        return Optional.empty();
    }


}
