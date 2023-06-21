package com.cybersoft.cozastoreJava21.Exception;

public class CustomException extends RuntimeException{
    public String message;
    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
