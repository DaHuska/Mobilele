package org.softuni.mobilele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearNotInTheFutureValidator implements ConstraintValidator<YearNotInTheFuture, Integer> {
    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        if (year == null) {
            return true;
        }
        Integer currentYear = Year.now().getValue();

        return currentYear > year;
    }
}
