package com.eureka.cooperfilme.utils.controllerAdvice;

import com.eureka.cooperfilme.utils.standardError.StandardError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardError(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }
}
