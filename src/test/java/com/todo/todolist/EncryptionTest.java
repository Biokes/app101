package com.todo.todolist;

import org.junit.jupiter.api.Test;

import static com.todo.todolist.utils.Encryption.*;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptionTest {

    @Test
    void encryptTest(){
        String password = "password";
        assertTrue(compare(encrypt(password),password));
        assertTrue(compare(encrypt("biokes12346"),"biokes12346"));
        assertTrue(compare(encrypt("b hciue 123 46"),"b hciue 123 46"));

    }
}
