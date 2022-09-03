package com.bridgelabz.lmsadminservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Purpose : LMSException to Handle the Exceptions
 * Version : 1.0
 * @author : Aviligonda Sreenivasulu
 * */
@ResponseStatus
public class LMSException extends RuntimeException {
    private int statusCode;
    private String statusMessage;

    public LMSException(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
