package com.example.demolibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demolibrary.model.Book;
import com.example.demolibrary.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	 private BookService bookService;

	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	    }

	    @GetMapping
	    public String getAllBooks(Model model) {
	        model.addAttribute("books", bookService.getAllBooks());
	        return "manage-books";
	    }

	    @PostMapping("/add")
	    public String addBook(@ModelAttribute Book book) {
	        bookService.addBook(book);
	        return "redirect:/books";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteBook(@PathVariable Long id) {
	        bookService.deleteBook(id);
	        return "redirect:/books";
	    }
	}

