package com.djselzlein.upgrade.upgradebackend.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;

public class ArrivalDateValidator implements ConstraintValidator<ArrivalDateConstraint, LocalDate> {

    private Integer minimumAhead;
    private Integer maximumAdvance;

    @Override
    public void initialize(ArrivalDateConstraint constraintAnnotation) {
        this.minimumAhead = constraintAnnotation.minBefore();
        this.maximumAdvance = constraintAnnotation.maxAdvance();
    }

    @Override
    public boolean isValid(LocalDate arrivalDate, ConstraintValidatorContext context) {
        if (arrivalDate == null) {
            return false;
        }

        final long daysAhead = Duration.between(LocalDate.now().atStartOfDay(), arrivalDate.atStartOfDay()).toDays();
        if (daysAhead < minimumAhead) {
            return false;
        }
        if (daysAhead > maximumAdvance) {
            return false;
        }
        return true;
    }
}
