package com.workintech.zoo.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ZooGlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleZooException(ZooException ex) {
        log.error("ZooException occurred: {}", ex.getMessage());
        ZooErrorResponse error = new ZooErrorResponse(
                ex.getMessage(),
                ex.getStatus().value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ZooErrorResponse> handleGeneralException(Exception ex) {
        log.error("Unhandled Exception: {}", ex.getMessage());
        ZooErrorResponse error = new ZooErrorResponse(
                ex.getMessage(),
                500,
                System.currentTimeMillis()
        );
        return ResponseEntity.internalServerError().body(error);
    }
}