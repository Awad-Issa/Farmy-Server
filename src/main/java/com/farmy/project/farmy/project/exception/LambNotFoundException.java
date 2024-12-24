package com.farmy.project.farmy.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LambNotFoundException extends RuntimeException {

    public LambNotFoundException(String message) {
        super(message);
    }
}
