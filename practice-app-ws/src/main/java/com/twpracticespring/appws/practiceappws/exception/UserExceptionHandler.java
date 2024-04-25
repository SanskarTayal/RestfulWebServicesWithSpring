package com.twpracticespring.appws.practiceappws.exception;

import com.twpracticespring.appws.practiceappws.exception.UserServiceException;
import com.twpracticespring.appws.practiceappws.ui.model.respomse.ErrorMessageForException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
       // ErrorMessageForException errormessage = new ErrorMessageForException(new Date(), "Triggered CustomErrorMessage");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException e) {
        String message = e.getLocalizedMessage();
        if (message == null)
            message = "Exception caught";

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}