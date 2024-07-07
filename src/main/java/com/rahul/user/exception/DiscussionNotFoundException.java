package com.rahul.user.exception;

public class DiscussionNotFoundException extends RuntimeException {
    public DiscussionNotFoundException(String message) {
        super(message);
    }
}