//package com.example.librarymanagement.controller;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.librarymanagement.model.Book;
//import com.example.librarymanagement.service.BookService;
//
//@Controller
//@RequestMapping("/books")
//public class BookController {
//
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping
//    public String getAllBooks(Model model) {
//        List<Book> books = bookService.findAll();
//        model.addAttribute("books", books);
//        return "books"; // Will return the books.html template
//    }
//
//    @GetMapping("/new")
//    public String showAddBookForm() {
//        return "addBook"; // Will return the addBook.html template
//    }
//
//    @PostMapping
//    public String addBook(@RequestParam String title, @RequestParam String author) {
//        Book book = new Book();
//        book.setTitle(title);
//        book.setAuthor(author);
//        bookService.save(book);
//        return "redirect:/books";
//    }
////    @GetMapping("/search")
////    public List<Book> searchBooksByTitle(@RequestParam String title) {
////        return bookService.searchByTitle(title);
////}
//    @GetMapping("/books/search")
//    public String searchBooks(@RequestParam("title") String title, Model model) {
//        List<Book> books = bookService.searchByTitle(title);
//        model.addAttribute("books", books);
//        return "books/search";
//    }
//
//}

package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books"; // books.html template
    }

    @GetMapping("/new")
    public String showAddBookForm() {
        return "addBook"; // addBook.html template
    }

    @PostMapping
    public String addBook(@RequestParam String title, @RequestParam String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.searchByTitle(title);
        if (books.isEmpty()) {
            model.addAttribute("message", "No books found for the title: " + title);
        }
        model.addAttribute("books", books);
        return "books/search"; // books/search.html template
    }
    @GetMapping("/{bookId}/borrow")
    public String borrowBook(@PathVariable Long bookId) {
        Book book = bookService.findById(bookId);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            bookService.save(book);
        }
        return "redirect:/books";
    }

    @GetMapping("/{bookId}/return")
    public String returnBook(@PathVariable Long bookId) {
        Book book = bookService.findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            bookService.save(book);
        }
        return "redirect:/books";
    }


}
