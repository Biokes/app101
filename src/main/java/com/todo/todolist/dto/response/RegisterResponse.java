package com.todo.todolist.dto.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterResponse {
    private Long id;
    private String email;
}
