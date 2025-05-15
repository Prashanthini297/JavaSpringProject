package com.example.librarymanagement3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement3.service.UserService;





@Controller
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/borrow-book")
    public String borrowBook(@RequestParam("userId") Long userId,
                             @RequestParam("bookId") Long bookId,
                             @RequestParam("quantity") int quantity) {
        userService.borrowBook(userId, bookId, quantity);
        return "redirect:/users";
    }
 
    @PostMapping("/return-book")
    public String returnBook(@RequestParam("userId") Long userId) {
        userService.returnBook(userId);
        return "redirect:/users";
    }
 
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-details";
    }
}
