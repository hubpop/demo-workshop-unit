package com.gsk.demoworkshopunits.repository;

import com.gsk.demoworkshopunits.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<Long, User> userData;
    private int count;

    public UserRepository() {
        this.userData = new HashMap<>();
        count = 0;
    }

    public Map<Long, User> findAll() {
        return userData;
    }

    public User findUserById(Long id) {
        return userData.get(id);
    }

    public Long add(User user) {
        Long generatedId = getNextId();
        userData.put(generatedId, user);
        return generatedId;
    }

    private Long getNextId() {
        count += 1;
        return (long) count;
    }
}
