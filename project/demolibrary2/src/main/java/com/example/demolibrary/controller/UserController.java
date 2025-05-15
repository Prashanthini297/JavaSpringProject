package com.example.demolibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demolibrary.model.User;
import com.example.demolibrary.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "manage-users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        userService.borrowBook(userId, bookId);
        return "redirect:/users";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long userId, @RequestParam Long bookId) {
        userService.returnBook(userId, bookId);
        return "redirect:/users";
    }

}
