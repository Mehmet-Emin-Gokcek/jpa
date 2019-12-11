package com.springboot.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {


    @Autowired
    private UserRepository userRepository;



    @Test
    @Sql({"/data.sql"})
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    @Sql({"/data.sql"})
    public void findUserById() {
        User user = userRepository.findById(1L);
        assertNotNull(user);
    }
}