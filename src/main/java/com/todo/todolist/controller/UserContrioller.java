package com.todo.todolist.controller;

import com.todo.todolist.dto.request.RegisterRequest;
import com.todo.todolist.dto.response.ApiResponse;
import com.todo.todolist.error.UserNotFoundException;
import com.todo.todolist.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class UserContrioller {
    private UserServices userServices;
    @PostMapping("/register/user")
    public ResponseEntity<?> register(@RequestBody RegisterRequest register){
        try{
            userServices.registerUser(register);
            return new ResponseEntity<>(new ApiResponse(true,userServices.registerUser(register)), CREATED);
        }
        catch(UserNotFoundException exceptions){
            return new ResponseEntity<>(new ApiResponse(false,exceptions.getMessage()), BAD_REQUEST);
        }

    }
}
