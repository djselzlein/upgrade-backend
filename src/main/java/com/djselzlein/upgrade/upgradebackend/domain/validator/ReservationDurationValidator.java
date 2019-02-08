package com.djselzlein.upgrade.upgradebackend.domain.validator;

import com.djselzlein.upgrade.upgradebackend.domain.service.dto.ReservationDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;

public class ReservationDurationValidator implements ConstraintValidator<ReservationDurationConstraint, ReservationDTO> {

    private Integer minimum;
    private Integer maximum;

    @Override
    public void initialize(ReservationDurationConstraint constraintAnnotation) {
        minimum = constraintAnnotation.min();
        maximum = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(ReservationDTO reservation, ConstraintValidatorContext ctx) {
        if (!reservation.getArrivalDate().isBefore(reservation.getDepartureDate())) {
            return false;
        }

        final long reservationPeriod = Duration.between(reservation.getArrivalDate().atStartOfDay(),
                reservation.getDepartureDate().atStartOfDay()).toDays();

        if (reservationPeriod < minimum) {
            return false;
        }
        if (reservationPeriod > maximum) {
            return false;
        }
        return true;
    }

}
