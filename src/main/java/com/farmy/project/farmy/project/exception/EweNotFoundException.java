package com.farmy.project.farmy.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EweNotFoundException extends RuntimeException {

    public EweNotFoundException(String message) {
        super(message);
    }

}
