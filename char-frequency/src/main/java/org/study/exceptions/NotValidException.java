package org.study.exceptions;

public class NotValidException extends RuntimeException {
    public NotValidException(String message) {
        super(message);
    }
}