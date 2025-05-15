package com.example.librarymanagement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.model.User;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.UserRepository;
@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
	

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private BookRepository bookRepository; // For interacting with book-related logic

	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

	    public User findById(Long userId) {
	        return userRepository.findById(userId).orElse(null);
	    }

	    public void save(User user) {
	        userRepository.save(user);
	    }

//	    public void borrowBook(Long userId, Long bookId, int quantity) {
//	        User user = findById(userId);
//	        Book book = bookRepository.findById(bookId).orElse(null);
//
//	        if (user != null && book != null && book.getQuantity() >= quantity) {
//	            // Reduce book quantity
//	            book.setQuantity(book.getQuantity() - quantity);
//	            bookRepository.save(book);
//
//	            // Add to user's borrowed books
//	            user.getBorrowedBooks().put(bookId, quantity);
//	            userRepository.save(user);
//	        }
//	    }
//
//	    public void returnBook(Long userId, Long bookId) {
//	        User user = findById(userId);
//	        Book book = bookRepository.findById(bookId).orElse(null);
//
//	        if (user != null && book != null && user.getBorrowedBooks().containsKey(bookId)) {
//	            // Increase book quantity
//	            int borrowedQuantity = user.getBorrowedBooks().get(bookId);
//	            book.setQuantity(book.getQuantity() + borrowedQuantity);
//	            bookRepository.save(book);
//
//	            // Remove from user's borrowed books
//	            user.getBorrowedBooks().remove(bookId);
//	            userRepository.save(user);
//	        }
	    }
	


