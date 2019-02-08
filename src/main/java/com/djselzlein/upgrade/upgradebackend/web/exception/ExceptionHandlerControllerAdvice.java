package com.djselzlein.upgrade.upgradebackend.web.exception;

import com.djselzlein.upgrade.upgradebackend.web.exception.ErrorMessage;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    List<ErrorMessage> onConstraintValidationException(
//            ConstraintViolationException e) {
//        List<ErrorMessage> errors = new ArrayList<>();
//        for (ConstraintViolation violation : e.getConstraintViolations()) {
//            errors.add(new ErrorMessage(violation.getPropertyPath().toString(), violation.getMessage()));
//        }
//        return errors;
//    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage onConstraintValidationException(
            ConstraintViolationException constraintViolation) {
        return ErrorMessageFactory.from(constraintViolation);
    }
}
