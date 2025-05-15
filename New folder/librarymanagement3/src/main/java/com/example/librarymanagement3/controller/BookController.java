package com.example.librarymanagement3.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement3.model.Book;
import com.example.librarymanagement3.service.BookService;


@Controller
public class BookController {
 
    @Autowired
    private BookService bookService;
 
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
 
    @GetMapping("/search-books")
    public String searchBooks(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.searchBooksByTitle(title);
        model.addAttribute("books", books);
        return "search-books";
    }
}


