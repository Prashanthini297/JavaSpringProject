package com.example.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.User;
import com.example.librarymanagement.service.BookService;
import com.example.librarymanagement.service.UserService;

import java.util.List;

//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public String getAllUsers(Model model) {
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//        return "users"; // Will return the users.html template
//    }
//
//    @GetMapping("/new")
//    public String showAddUserForm() {
//        return "addUser"; // Will return the addUser.html template
//    }
//
//    @PostMapping
//    public String addUser(@RequestParam String name) {
//        User user = new User();
//        user.setName(name);
//        userService.save(user);
//        return "redirect:/users";
//    }
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService; // For interacting with books

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users"; // Will return the users.html template
    }
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        List<User> users = userService.findAll(); // Fetch all users
        model.addAttribute("books", books);
        model.addAttribute("users", users); // Add users to the model
        return "books"; // books.html template
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

    @GetMapping("/{userId}/borrowedBooks")
    public String getBorrowedBooks(@PathVariable Long userId, Model model) {
        User user = userService.findById(userId);
        if (user != null) {
            model.addAttribute("borrowedBooks", user.getBorrowedBooks());
        } else {
            model.addAttribute("message", "User not found.");
        }
        return "users/borrowedBooks"; // A new template for displaying borrowed books
    }
//
//    @PostMapping("/{userId}/borrow")
//    public String borrowBook(@PathVariable Long userId, @RequestParam Long bookId, @RequestParam int quantity) {
//        User user = userService.findById(userId);
//        if (user != null) {
//            userService.borrowBook(userId, bookId, quantity); // Delegate logic to the service layer
//        }
//        return "redirect:/users/" + userId + "/borrowedBooks";
//    }
//
//    @PostMapping("/{userId}/return")
//    public String returnBook(@PathVariable Long userId, @RequestParam Long bookId) {
//        User user = userService.findById(userId);
//        if (user != null) {
//            userService.returnBook(userId, bookId); // Delegate return logic to the service layer
//        }
//        return "redirect:/users/" + userId + "/borrowedBooks";
//    }
}

