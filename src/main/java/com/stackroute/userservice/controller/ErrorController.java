package com.stackroute.userservice.controller;

import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    //method for handle TrackAlreadyExistException
    @ExceptionHandler(value= TrackAlreadyExistException.class)
    public ResponseEntity<Object> exception1()
    {
        return new ResponseEntity<>("Track already exists", HttpStatus.NOT_FOUND);
    }
    //method for handle TrackNotFoundException
    @ExceptionHandler(value= TrackNotFoundException.class)
    public ResponseEntity<Object> exception2()
    {

        return new ResponseEntity<>("Track not found", HttpStatus.NOT_FOUND);
    }

}


