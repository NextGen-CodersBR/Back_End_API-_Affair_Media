package com.Illusion0DEV.Application.Utils;

public class Simple_Exception extends RuntimeException {
    public  Simple_Exception(String message) {
        super(message);
    }

    public Simple_Exception() {
        super();
    }

    public Simple_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Simple_Exception(Throwable cause) {
        super(cause);
    }

    protected Simple_Exception(String message, Throwable cause, boolean enable_suppression, boolean writable_stack_trace) {
        super(message, cause, enable_suppression, writable_stack_trace);
    }
}
