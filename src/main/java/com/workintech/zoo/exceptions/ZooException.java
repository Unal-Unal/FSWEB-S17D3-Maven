package com.workintech.zoo.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ZooException extends RuntimeException {
    private HttpStatus status;

    // Constructor
    public ZooException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    // Getter
    public HttpStatus getHttpStatus() {
        return this.status;
    }

    // Setter
    public void setHttpStatus(HttpStatus status) {
        this.status = status;
    }
}
