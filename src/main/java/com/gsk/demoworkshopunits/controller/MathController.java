package com.gsk.demoworkshopunits.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathController {

    @ResponseBody
    @GetMapping(value = "add/{a}/{b}", produces = "application/json")
    public int add(int a, int b) {
        return a + b;
    }

    @ResponseBody
    @GetMapping(value = "subtract/{a}/{b}", produces = "application/json")
    public int subtract(int a, int b) {
        return a - b;
    }

    @ResponseBody
    @GetMapping(value = "multiply/{a}/{b}", produces = "application/json")
    public int multiply(int a, int b) {
        return a * b;
    }

    @ResponseBody
    @GetMapping(value = "divide/{a}/{b}", produces = "application/json")
    public int divide(int a, int b) {
        return a / b;
    }

}
