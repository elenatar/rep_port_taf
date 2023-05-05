package com.taf.business.exceptions;

public class ProcessingException extends RuntimeException{
    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
