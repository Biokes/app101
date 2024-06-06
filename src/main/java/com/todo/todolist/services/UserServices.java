package com.todo.todolist.services;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.todo.todolist.dto.request.RegisterRequest;
import com.todo.todolist.dto.request.UpdateProfileRequest;
import com.todo.todolist.dto.response.RegisterResponse;
import com.todo.todolist.dto.response.UpdateProfileResponse;
import com.todo.todolist.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServices{
    RegisterResponse registerUser(RegisterRequest register1);
    long count();

    void deleteAll();

    User findUserById(long l);

    UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest);
}
