package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
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
    private final UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;

    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = uService.getAllUserByEmail("1@gmail.com");
        System.out.println(arrUsers);
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = uService.getAllUser();
        model.addAttribute("newUser1", users);
        return "/admin/user/table-user";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String CreateUserPage(Model model, @ModelAttribute("newUser") User createUser1) {
        System.out.println("Run hereeee" + createUser1);
        this.uService.SaveUser(createUser1);
        return "redirect:/admin/user";
    }

}
