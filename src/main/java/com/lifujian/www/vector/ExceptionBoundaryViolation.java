package com.lifujian.www.vector;

public class ExceptionBoundaryViolation extends Exception {
    
    private static final long serialVersionUID = 1L;

    public ExceptionBoundaryViolation() {
        super();
    }
    
    public ExceptionBoundaryViolation(String msg) {
        super(msg);
    }
    
    public ExceptionBoundaryViolation(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public ExceptionBoundaryViolation(Throwable cause) {
        super(cause);
    }
}
