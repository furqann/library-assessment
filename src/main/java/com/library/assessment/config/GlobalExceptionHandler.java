package com.library.assessment.config;

import com.library.assessment.model.ErrorMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorMessage> handleConstraintViolationException(final ConstraintViolationException ex) {

    var errors = ex.getConstraintViolations().stream()
        .map(ConstraintViolation::getMessage)
        .toList();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errors));
  }

  @ExceptionHandler(LibraryException.class)
  public ResponseEntity<ErrorMessage> handleLibraryException(final LibraryException ex) {
    return ResponseEntity.status(ex.getHttpCode())
        .body(new ErrorMessage(ex.getHttpCode(), List.of(ex.getMessage())));
  }
}
