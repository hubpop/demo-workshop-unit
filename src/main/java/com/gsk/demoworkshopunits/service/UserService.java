package com.gsk.demoworkshopunits.service;

import com.gsk.demoworkshopunits.model.User;
import com.gsk.demoworkshopunits.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Map<Long, User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public Long add(User user) {
        return userRepository.add(user);
    }
}
