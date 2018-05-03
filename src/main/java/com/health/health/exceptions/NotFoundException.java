package com.health.health.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jdms3112 on 2/27/2018.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found.")
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
