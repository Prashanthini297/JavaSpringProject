package com.example.librarymanagement3.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement3.model.Book;
import com.example.librarymanagement3.model.User;
import com.example.librarymanagement3.repository.BookRepository;
import com.example.librarymanagement3.repository.UserRepository;


@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private BookRepository bookRepository;
 
    public void borrowBook(Long userId, Long bookId, int quantity) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
 
        if (book.getQuantity() >= quantity) {
            book.setQuantity(book.getQuantity() - quantity);
            user.setBook(book);
            user.setBorrowedQuantity(quantity);
            user.setBorrowDate(LocalDate.now());
            bookRepository.save(book);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Insufficient book quantity");
        }
    }
 
    public void returnBook(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = user.getBook();
 
        book.setQuantity(book.getQuantity() + user.getBorrowedQuantity());
        user.setBorrowedQuantity(0);
        user.setReturnDate(LocalDate.now());
        userRepository.save(user);
        bookRepository.save(book);
    }
 
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}


