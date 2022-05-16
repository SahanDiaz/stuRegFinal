package com.sys.regfinal.controllers;

import com.sys.regfinal.entity.User;
import com.sys.regfinal.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }


    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users",
                userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "create_user";
    }

    @PostMapping("users")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/users/{id}")
    public String updateUsers(@PathVariable Long id,
                                @ModelAttribute("user") User user , Model model) {
        User oldUser = userService.getUserById(id);
        oldUser.setUserId(id);
        oldUser.setFullName(user.getFullName());
        oldUser.setPassword(user.getPassword());
//        oldUser.setEnabled(user.getEnabled());
        oldUser.setStuRegNum(user.getStuRegNum());
        oldUser.setAddress(user.getAddress());
        oldUser.setEmail(user.getEmail());
        oldUser.setNic(user.getNic());
        oldUser.setContactNumber(user.getContactNumber());

        userService.updateUser(oldUser);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
