package com.todo.todolist.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProfileRequest{
    private Long id;
    private String newPassword;
    private String oldPassword;
}
