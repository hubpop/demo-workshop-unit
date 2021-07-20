package com.gsk.demoworkshopunits.controller;

import com.gsk.demoworkshopunits.model.User;
import com.gsk.demoworkshopunits.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/find-all", produces = "application/json")
    public Map<Long, User> getAll() {
        return userService.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = "application/json")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/add")
    public Long addUser(@RequestBody User user){
        return userService.add(user);
    }
}
