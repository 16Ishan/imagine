package com.imagine.book.exceptions;

public class InvalidUsernameException extends RuntimeException
{
    public InvalidUsernameException(String message) {
        super(message);
    }

    public InvalidUsernameException(String message, Throwable cause) {
        super(message, cause);
    }
}
