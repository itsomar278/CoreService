package com.CoreService.QP.CoreService.exception.customExceptions;

public class EmptyResultException extends RuntimeException
{

    public EmptyResultException()
    {
        super("Empty Result");
    }

    public EmptyResultException(String message)
    {
        super(message);
    }

}