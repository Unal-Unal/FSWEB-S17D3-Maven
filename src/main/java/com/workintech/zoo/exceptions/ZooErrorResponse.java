package com.workintech.zoo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZooErrorResponse {
    private String message;
    private int status;
    private long timestamp;

    public ZooErrorResponse() {

    }
}