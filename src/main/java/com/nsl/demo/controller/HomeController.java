package com.nsl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/home")
    public String homeIndex() {
        return "Welcome to home page1";
    }

    @RequestMapping("/secure")
    public String securePage() {
        return "Resource is protected";
    }

    @RequestMapping("/customLogin")
    public String customLoginPage() {

        return "Custom login Page";
    }

}
