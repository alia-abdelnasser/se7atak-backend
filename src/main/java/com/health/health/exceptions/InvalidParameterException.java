package com.health.health.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jdms3112 on 2/27/2018.
 */
@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends Exception {

    public InvalidParameterException(String message) {

        super(message);
    }

}
