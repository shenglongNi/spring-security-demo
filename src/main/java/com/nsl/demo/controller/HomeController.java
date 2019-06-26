package com.nsl.demo.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return "this page need Roles " + username;
    }

}
