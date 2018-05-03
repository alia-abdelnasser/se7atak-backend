package com.health.health.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jdms3112 on 3/4/2018.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exist.")
public class AlreadyExistException extends Exception {

    public AlreadyExistException(String message) {
        super(message);
    }

}
