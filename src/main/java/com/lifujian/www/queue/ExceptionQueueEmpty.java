package com.lifujian.www.queue;

public class ExceptionQueueEmpty extends Exception {

    private static final long serialVersionUID = 1L;
    
    public ExceptionQueueEmpty() {
        super();
    }

    public ExceptionQueueEmpty(String msg) {
        super(msg);
    }
    
    public ExceptionQueueEmpty(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public ExceptionQueueEmpty(Throwable cause) {
        super(cause);
    }

}
