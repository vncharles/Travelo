package com.fit.Travelo.exception;

public class MethodNotAllowedException extends RuntimeException {
    private int errorCode;
    public MethodNotAllowedException(int errorCode , String message){
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
