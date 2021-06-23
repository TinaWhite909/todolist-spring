package com.github.tinawhite909.todolistspring.exception;

public class TaskServiceRuntimeException extends RuntimeException {

    public TaskServiceRuntimeException(String message) {
        super(message);
    }

    public TaskServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
