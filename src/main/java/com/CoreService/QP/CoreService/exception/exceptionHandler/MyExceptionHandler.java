package com.CoreService.QP.CoreService.exception.exceptionHandler;

import com.CoreService.QP.CoreService.exception.customExceptions.EmptyResultException;
import com.CoreService.QP.CoreService.exception.exceptionResponse.ExceptionResponse;
import com.CoreService.QP.CoreService.exception.customExceptions.ResourceExistsException;
import com.CoreService.QP.CoreService.exception.customExceptions.ResultNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<Object> handleAlreadyExists(ResourceExistsException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
        return responseEntity;
    }

    @ExceptionHandler(EmptyResultException.class)
    public ResponseEntity<Object> handleEmptyResult(EmptyResultException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
        return responseEntity;
    }

    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResultNotFoundException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage("Something went wrong from the server side , please try again later");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}