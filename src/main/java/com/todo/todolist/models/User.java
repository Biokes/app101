package com.todo.todolist.models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String email;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeUpdated;
    @PreUpdate
    private void setTimeUpdated(){
        this.timeUpdated= LocalDateTime.now();
    }
}
