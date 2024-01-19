package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ControllerAdvice
public class ExceptionResponseControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ResourceNotFoundException.class, CustomerNotFoundException.class})
    @ResponseBody
    public ErrorResponse handeNotFound(RuntimeException exception) {
        return new ErrorResponse(Instant.now(), exception.getMessage());
    }

//    Zakomentowana alternatywna wersja tego zapisu - dla jednego Exceptiona powinniśmy mieć
//    jeden exception handler a więc jeśli chcecie korzystać z metody poniżej musicie zakomentować metodę powyżej

//    @ExceptionHandler(value = ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handeNotFound(RuntimeException exception) {
//        var responseBody = new ErrorResponse(Instant.now(), exception.getMessage());
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(responseBody);
//    }
}
