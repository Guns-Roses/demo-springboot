package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvxutao
 * @date 2020-05-25 16:38
 */
@RestController
@RequestMapping("/api")
public class Usercontroller {

    @RequestMapping("/")
    String home() {
        return "hello";
    }

}
