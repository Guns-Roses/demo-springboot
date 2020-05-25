package com.springboot.demo.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {

    private static Calculator cal=new Calculator();

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    @Test
    void add() {

        cal.add(2,2);
        assertEquals(4,cal.getResult());
    }

    @Test
    void subtract() {
    }

    @Test
    void multipe() {
    }

    @Test
    void divide() {
    }

    @Test
    void getResult() {
    }
}