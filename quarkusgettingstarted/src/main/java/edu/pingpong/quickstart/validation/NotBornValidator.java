package edu.pingpong.quickstart.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBornValidator implements ConstraintValidator<NotBorn, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {

        if (date == null) return true;

        // How works between, not completely understanding wich math operation makes
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(today, date) > 0;
    }
}
