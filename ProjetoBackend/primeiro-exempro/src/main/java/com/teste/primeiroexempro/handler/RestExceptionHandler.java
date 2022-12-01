package com.teste.primeiroexempro.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.primeiroexempro.model.error.ErrorMessage;
import com.teste.primeiroexempro.model.exception.ResourceNotFoundException;

@ControllerAdvice  // controlador de qualquer erro dentro da api restfull 
public class RestExceptionHandler {


    
    @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
    ErrorMessage error = new ErrorMessage("not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  }
  
