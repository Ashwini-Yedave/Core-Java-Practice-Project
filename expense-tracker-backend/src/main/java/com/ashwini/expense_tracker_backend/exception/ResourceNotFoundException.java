package com.ashwini.expense_tracker_backend.exception;

//custome  exception
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
