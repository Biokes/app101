package com.todo.todolist.services;

import com.todo.todolist.data.UsersRepo;
import com.todo.todolist.dto.request.RegisterRequest;
import com.todo.todolist.dto.request.UpdateProfileRequest;
import com.todo.todolist.dto.response.RegisterResponse;
import com.todo.todolist.dto.response.UpdateProfileResponse;
import com.todo.todolist.error.UserNotFoundException;
import com.todo.todolist.models.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.todo.todolist.error.Messages.USER_NOT_FOUND;
import static com.todo.todolist.utils.Encryption.encrypt;


@Service
@AllArgsConstructor
public class ToDoUserService implements UserServices{
    private final UsersRepo repo;
    @Override
    public RegisterResponse registerUser(RegisterRequest register1) {
        ModelMapper mapper = new ModelMapper();
        register1.setPassword(encrypt(register1.getPassword()));
        User user = mapper.map(register1, User.class);
        repo.save(user);
        return mapper.map(user, RegisterResponse.class);
    }
    public long count() {
        return repo.count();
    }
    public void deleteAll() {
        repo.deleteAll();
    }
    public User findUserById(long id) {
        return repo.findById(id)
                .orElseThrow(()-> new UserNotFoundException(USER_NOT_FOUND.getMessage()));
    }

    @Override
    public UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest) {
        return null;
    }
}
