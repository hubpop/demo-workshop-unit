package com.gsk.demoworkshopunits.controller;

import com.google.gson.Gson;
import com.gsk.demoworkshopunits.model.User;
import com.gsk.demoworkshopunits.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    private MockMvc mockMvc;

    private UserRepository userRepository;
    private Gson gson;

    @Autowired
    public UserControllerTest(MockMvc mockMvc, UserRepository userRepository) {
        this.mockMvc = mockMvc;
        this.userRepository = userRepository;
        gson = new Gson();
    }

    @Test
    void getAll() throws Exception {
        //given
        userRepository.add(new User("Joe", "Doe"));

        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/user/find-all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Map map = gson.fromJson(mvcResult.getResponse().getContentAsString(), Map.class);

        //then
        Assertions.assertEquals(1, map.size());
    }

    @Test
    void getById() {
    }

    @Test
    void addUser() {
    }
}