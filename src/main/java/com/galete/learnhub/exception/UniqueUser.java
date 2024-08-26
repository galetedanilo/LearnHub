package com.galete.learnhub.exception;

public class UniqueUser extends RuntimeException {
    public UniqueUser(String message) {
        super(message);
    }
}
