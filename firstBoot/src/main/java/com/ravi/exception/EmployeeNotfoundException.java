package com.ravi.exception;

public class EmployeeNotfoundException extends RuntimeException {


    private String message;

    public EmployeeNotfoundException() {
    }

    public EmployeeNotfoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
