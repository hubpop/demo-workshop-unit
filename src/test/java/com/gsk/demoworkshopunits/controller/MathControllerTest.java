package com.gsk.demoworkshopunits.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MathControllerTest {

    @Autowired
    MathController mathController;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5, 7",
            "4, 11, 15"
    })
    void add(int a, int b, int result) {
        //given

        //when
        int calculatedResult = mathController.add(a, b);
        //then
        Assertions.assertEquals(result, calculatedResult);

    }

    @ParameterizedTest
    @CsvSource({
            "2, 5, -3",
            "29, 17, 12"
    })
    void subtract(int a, int b, int result) {
        //given

        //when
        int calculatedResult = mathController.subtract(a, b);
        //then
        Assertions.assertEquals(result, calculatedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 5, 10",
            "4, 11, 44"
    })
    void multiply(int a, int b, int result) {
        //given

        //when
        int calculatedResult = mathController.multiply(a, b);
        //then
        Assertions.assertEquals(result, calculatedResult);

    }

    @ParameterizedTest
    @CsvSource({
            "15, 3, 5",
            "22, 11, 2"
    })
    void divide(int a, int b, int result) {
        //given

        //when
        int calculatedResult = mathController.divide(a, b);
        //then
        Assertions.assertEquals(result, calculatedResult);

    }
}