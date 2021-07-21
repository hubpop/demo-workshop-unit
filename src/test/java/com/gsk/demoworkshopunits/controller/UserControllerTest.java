package com.gsk.demoworkshopunits.controller;

import com.google.gson.Gson;
import com.gsk.demoworkshopunits.model.User;
import com.gsk.demoworkshopunits.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void getById() throws Exception {
        //given
        userRepository.add(new User("Joe", "Doe"));

        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        User returnedUser = gson.fromJson(mvcResult.getResponse().getContentAsString(), User.class);

        //then
        Assertions.assertEquals("Joe", returnedUser.getName());
        Assertions.assertEquals("Doe", returnedUser.getLastName());
    }

    @Test
    void addUser() throws Exception {
        //given
        User newUser = new User("John", "Dole");

        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/user/add")
                .content(gson.toJson(newUser))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String returnedId = mvcResult.getResponse().getContentAsString();

        //then
        Assertions.assertEquals("2", returnedId);
    }
}