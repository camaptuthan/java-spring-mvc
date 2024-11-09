package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    private UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }

    @GetMapping("")
    public String getHomePage() {
        return this.uService.handleHello();
    }

}
