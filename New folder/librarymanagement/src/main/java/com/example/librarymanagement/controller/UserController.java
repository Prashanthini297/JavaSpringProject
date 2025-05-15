package com.example.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.model.User;
import com.example.librarymanagement.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users"; // Will return the users.html template
    }

    @GetMapping("/new")
    public String showAddUserForm() {
        return "addUser"; // Will return the addUser.html template
    }

    @PostMapping
    public String addUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userService.save(user);
        return "redirect:/users";
    }
}
