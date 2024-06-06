package com.todo.todolist.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.Cipher;
public class Encryption {
    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static String encrypt(String password){
        return encoder.encode(password);
    }
    public static boolean compare(String password,String encrypted){
        return encoder.matches(password, encrypted);

    }
}
