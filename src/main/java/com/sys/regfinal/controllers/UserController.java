package com.sys.regfinal.controllers;

import com.sys.regfinal.entity.User;
import com.sys.regfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }
    @GetMapping("users/new")
    public String createUserForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "editUser";
    }
    @PostMapping("users")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/edit/{id}")
    public String editUser(@PathVariable Long userId, Model model){
        model.addAttribute("user", userService.getUserById(userId));
        return "editUser";
    }
    @GetMapping("users/edit")
    public String getuser(){
        return "editUser";
    }
    @PostMapping("/users/{id}")
    public  String updateUser(@PathVariable Long id, @ModelAttribute("user") User user, Model model ){
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


}
