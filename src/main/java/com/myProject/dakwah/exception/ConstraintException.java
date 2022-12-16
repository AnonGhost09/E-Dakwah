package com.myProject.dakwah.exception;

public class ConstraintException extends RuntimeException{
    public ConstraintException() {
        super("Data is exist");
    }

    public ConstraintException(String message) {
        super(message);
    }
}
