package com.sofy.book.exception;

public class BookDaoServiceException extends Exception{
    public BookDaoServiceException() {
    }

    public BookDaoServiceException(String message) {
        super(message);
    }

    public BookDaoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDaoServiceException(Throwable cause) {
        super(cause);
    }
}
