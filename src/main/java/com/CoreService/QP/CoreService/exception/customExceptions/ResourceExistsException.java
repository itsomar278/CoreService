package com.CoreService.QP.CoreService.exception.customExceptions;

public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException() {
        super("This Already Exists");
    }

    public ResourceExistsException(String message) {
        super(message);
    }

}