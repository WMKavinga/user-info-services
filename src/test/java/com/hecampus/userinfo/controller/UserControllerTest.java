package com.hecampus.userinfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hecampus.userinfo.dto.UserDTO;
import com.hecampus.userinfo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetExample() throws Exception {
        List<UserDTO> users = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setId("6215de18f9e9eb37bec461ea");
        user.setName("Kavinga");
        user.setEmail("kv@gmail.com");
        user.setPwd("");
        users.add(user);
        Mockito.when(userService.getUserList()).thenReturn(users);
        mockMvc.perform(get("/user")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Kavinga")));
    }

}
