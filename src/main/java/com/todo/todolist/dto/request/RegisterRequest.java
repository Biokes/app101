package com.todo.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String password;
    private String email;
}
