package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

//Rest API
// @RestController
// public class UserController {

// (DI)
//     private UserService uService;

//     public UserController(UserService uService) {
//         this.uService = uService;
//     }

//     @GetMapping("")
//     public String getHomePage() {
//         return this.uService.handleHello();
//     }

// }

//MVC
@Controller
public class UserController {

    // DI
    private UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {

        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String CreateUserPage(Model model, @ModelAttribute("newUser") User createUser1) {
        System.out.println("Run hereeee" + createUser1);
        return "hello";
    }

}
