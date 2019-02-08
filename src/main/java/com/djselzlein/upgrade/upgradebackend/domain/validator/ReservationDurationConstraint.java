package com.djselzlein.upgrade.upgradebackend.domain.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ReservationDurationValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReservationDurationConstraint {

    int min() default 1;

    int max() default 3;

    String message() default "Reservation period must be between {min} and {max} days";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
