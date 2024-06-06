package com.todo.todolist;

import com.todo.todolist.dto.request.RegisterRequest;
import com.todo.todolist.dto.request.UpdateProfileRequest;
import com.todo.todolist.dto.response.RegisterResponse;
import com.todo.todolist.dto.response.UpdateProfileResponse;
import com.todo.todolist.models.User;
import com.todo.todolist.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Slf4j
class ToDoListApplicationTests {
    @Autowired
    private UserServices userServices;
//    @BeforeEach
//    void wipe(){
//        userServices.deleteAll();
//    }
    @Test
    void testUserRegister(){
        RegisterRequest  register1 = new RegisterRequest();
        register1.setPassword("password");
        register1.setEmail("officialBiokes@gmail.com");
        RegisterResponse response =userServices.registerUser(register1);
        assertThat(response).isNotNull();
        log.info("RegisterResponsne ---> {}",response);
    }
    @Test
    @DisplayName("test update user profile")
    void testUpdateProfile(){
        UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest();
        updateProfileRequest.setOldPassword("password");
        updateProfileRequest.setNewPassword("password12");
        updateProfileRequest.setId(120L);
        User user = userServices.findUserById(120L);
//        assertEquals(decrypt(user.getPassword()),updateProfileRequest.getOldPassword());
        UpdateProfileResponse response = userServices.updateProfile(updateProfileRequest);
        assertNotEquals(updateProfileRequest.getOldPassword(),user.getPassword());

    }

}
