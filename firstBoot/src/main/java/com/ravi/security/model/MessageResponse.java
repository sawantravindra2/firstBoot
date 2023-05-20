package com.ravi.security.model;

public class MessageResponse {

   public MessageResponse(String message){
        this.message=message;
    }


    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
