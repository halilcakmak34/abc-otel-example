package com.oteller.example.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotAvailableDataException extends RuntimeException {

    public NotAvailableDataException(String message) {
        super(String.format("Failed message : %s ", message));
    }

}
