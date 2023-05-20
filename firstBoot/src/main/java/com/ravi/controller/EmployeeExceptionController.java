package com.ravi.controller;


import com.ravi.exception.EmployeeNotfoundException;
import com.ravi.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionController extends RuntimeException {



    @ExceptionHandler(value
            = EmployeeNotfoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(EmployeeNotfoundException ex)
    {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), "Employee Id not found.");
    }


}
