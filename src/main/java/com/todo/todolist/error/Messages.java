package com.todo.todolist.error;

public enum Messages {
    INCORRECT_PASSWORD("Incorrect password or Username"),
    USER_NOT_FOUND("user not found");
    Messages(String message){
        this.message=message;
    }
     String message;
    public String getMessage(){
        return this.message;
    }

}
