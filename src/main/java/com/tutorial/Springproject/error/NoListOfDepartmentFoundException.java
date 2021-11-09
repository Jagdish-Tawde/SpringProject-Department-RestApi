package com.tutorial.Springproject.error;

public class NoListOfDepartmentFoundException extends Exception{
    public NoListOfDepartmentFoundException() {
        super();
    }

    public NoListOfDepartmentFoundException(String message) {
        super(message);
    }

    public NoListOfDepartmentFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoListOfDepartmentFoundException(Throwable cause) {
        super(cause);
    }

    protected NoListOfDepartmentFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
