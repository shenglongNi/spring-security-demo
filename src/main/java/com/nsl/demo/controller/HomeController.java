package com.nsl.demo.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/needRole")
    @PreAuthorize("hasRole('ADMIN')")  //进方法之前进行权限认证
    public String needRolePage() {
        System.out.println("===========进入==============");
        return "this page need Roles";
    }

}
