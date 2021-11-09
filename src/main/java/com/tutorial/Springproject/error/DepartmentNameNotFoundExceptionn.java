package com.tutorial.Springproject.error;

public class DepartmentNameNotFoundExceptionn extends Exception{

    public DepartmentNameNotFoundExceptionn() {
        super();
    }

    public DepartmentNameNotFoundExceptionn(String message) {
        super(message);
    }

    public DepartmentNameNotFoundExceptionn(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNameNotFoundExceptionn(Throwable cause) {
        super(cause);
    }

    protected DepartmentNameNotFoundExceptionn(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
