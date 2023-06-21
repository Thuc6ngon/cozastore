package com.cybersoft.cozastoreJava21.Exception;

public class UserNotFoundException extends RuntimeException {
    private String message;
    public UserNotFoundException(String message){

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
