package com.CoreService.QP.CoreService.exception.customExceptions;

public class ResultNotFoundException extends RuntimeException{
    public ResultNotFoundException() {
        super("Not Found 404");
    }

    public ResultNotFoundException(String message) {
        super(message);
    }
}
