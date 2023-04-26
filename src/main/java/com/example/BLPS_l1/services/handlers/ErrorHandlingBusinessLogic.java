package com.example.BLPS_l1.services.handlers;

import com.example.BLPS_l1.services.mail.service.web.model.dto.MessageDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingBusinessLogic {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalStateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(406).body(errorResponse);
    }

    @ExceptionHandler({JsonMappingException.class, JsonParseException.class})
    protected ResponseEntity<ErrorResponse> handleThereIsNoSuchUserException(Exception exc) {
        return new ResponseEntity<>(new ErrorResponse(exc.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorResponse> onUnrecognizedPropertyExceptionException(UnrecognizedPropertyException exc) {
        return new ResponseEntity<>(new ErrorResponse("Введены недопустимые поля: asd"), HttpStatus.BAD_REQUEST);
    }

    @Getter
    @RequiredArgsConstructor
    public static class ErrorResponse {
        private final String message;
    }
}