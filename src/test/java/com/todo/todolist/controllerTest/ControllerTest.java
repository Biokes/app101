package com.todo.todolist.controllerTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testRegister() {
        String details = "{\"password\" : \"password\", \"email\" : \"biokes@gmail.com\"}";
        try {
            mockMvc.perform(post("/api/v1/register/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(details))
                    .andExpect(status().isCreated());

        }
        catch(Exception error){
            assertThat(error).isNull();
        }
    }
}
