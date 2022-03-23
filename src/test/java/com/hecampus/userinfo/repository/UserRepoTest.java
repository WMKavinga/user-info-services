package com.hecampus.userinfo.repository;


import com.hecampus.userinfo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MockMvc mvc;

    @Test
    public void saveUser() {
        User user = new User();

        user.setId("01");
        user.setName("Kavinga");
        user.setEmail("kavinga@gmail.com");
        user.setPwd("123");


        assertEquals(user, userRepository.save(user));
    }

    @Test
    public void getUser() {
        Optional<User> persistedUser = userRepository.findById("01");
        assertEquals("kavinga@gmail.com", persistedUser.get().getEmail());
    }

}
