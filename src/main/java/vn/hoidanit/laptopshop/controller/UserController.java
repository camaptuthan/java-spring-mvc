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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = uService.getAllUser();
        model.addAttribute("newUser1", users);
        return "/admin/user/table-user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = uService.findUserById(id);
        model.addAttribute("userDetail", user);
        return "/admin/user/user-detail";
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

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = uService.findUserById(id);

        model.addAttribute("userUpdate", user);
        return "/admin/user/user-update";
    }

    @PostMapping(value = "/admin/user/update")

    public String UpdateUserPage(Model model, @ModelAttribute("userUpdate") User userUpdate) {
        User user = this.uService.findUserById(userUpdate.getId());
        if (user != null) {
            user.setAddress(userUpdate.getAddress());
            user.setFullName(userUpdate.getFullName());
            user.setPhone(userUpdate.getPhone());
            this.uService.SaveUser(user);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("user", new User());
        return "admin/user/user-delete";
    }

    @PostMapping("/admin/user/delete")
    public String DeleteUserPage(Model model, @ModelAttribute("user") User user) {
        this.uService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }

}
