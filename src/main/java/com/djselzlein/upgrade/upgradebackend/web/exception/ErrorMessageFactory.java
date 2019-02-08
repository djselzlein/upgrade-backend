package com.djselzlein.upgrade.upgradebackend.web.exception;

import org.hibernate.exception.ConstraintViolationException;

public class ErrorMessageFactory {

    public static ErrorMessage from(ConstraintViolationException constraintViolation) {
        if (constraintViolation.getConstraintName().contains("RESERVATION_DATE_NAME_UQ_INDEX_A")) {
            return new ErrorMessage("reservation_period",
                    "There is no availability for requested period. Please check availability and try again.");
        }
        return new ErrorMessage(constraintViolation.getConstraintName(), constraintViolation.getMessage());
    }

}
