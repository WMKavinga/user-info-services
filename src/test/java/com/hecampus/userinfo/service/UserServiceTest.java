package com.hecampus.userinfo.service;

import com.hecampus.userinfo.dto.UserDTO;
import com.hecampus.userinfo.model.User;
import com.hecampus.userinfo.repository.UserRepository;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    public void addUsers() {

        User user = new User();
        user.setId("01");
        user.setName("Kavinga");
        user.setEmail("kavinga@gmail.com");
        user.setPwd("123");


        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getName()).isNotNull();
    }

    @Test
    public void getUsers() {

        List<User> userList = new ArrayList<>();
      User user1 = new User("01", "Kavinga", "kavinga@gmail.com", "123");
      userList.add(user1);

      Mockito.when(userRepository.findAll()).thenReturn(userList);

      List<UserDTO> users = userService.getUserList();
      assertThat(users.get(0).getId()).isEqualTo("01");

    }
}
