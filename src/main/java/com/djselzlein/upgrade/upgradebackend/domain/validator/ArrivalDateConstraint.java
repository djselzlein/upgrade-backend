package com.djselzlein.upgrade.upgradebackend.domain.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ArrivalDateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ArrivalDateConstraint {

    int minBefore() default 1;

    int maxAdvance() default 30;

    String message() default "Arrival Date must be at least {minBefore} ahead and up to {maxAdvance} days in advance";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
