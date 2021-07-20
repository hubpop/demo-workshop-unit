package com.gsk.demoworkshopunits.service;

import com.gsk.demoworkshopunits.model.User;
import com.gsk.demoworkshopunits.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class UserServiceTest {

    @Autowired
    @InjectMocks
    private UserService service;

    @MockBean
    private UserRepository repository;

    private User simpleUser;

    @Test
    @DisplayName("Should return empty list")
    void findAll() {
        //given
        Map<Long, User> emptyMap = new HashMap<>();

        doReturn(emptyMap).when(repository).findAll();

        //when
        Map<Long, User> returnedUser = service.findAll();

        //then
        assertEquals(returnedUser.size(), 0);
    }

    @Test
    @DisplayName("Should return user by id")
    void findById() {
        //given
        simpleUser = new User("Joe", "Doe");

        doReturn(simpleUser).when(repository).findUserById(1L);

        //when
        User returnedUser = service.findById(1L);

        //then
        Assertions.assertEquals(simpleUser, returnedUser);
    }

    @Test
    void add() {
        //given
        simpleUser = new User("Joe", "Doe");

        doReturn(2L).when(repository).add(simpleUser);

        //when
        Long generatedUserId = service.add(simpleUser);

        //then
        Assertions.assertEquals(2L, generatedUserId);
    }
}