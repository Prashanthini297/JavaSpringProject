package com.example.librarymanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.User;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.UserRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
   

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
//
//    public Book borrowBook(Long bookId, Long userId) {
//        Book book = findById(bookId);
//        User user = userRepository.findById(userId).orElse(null);
//
//        if (book != null && !book.isBorrowed() && user != null) {
//            book.setBorrowedBy(user);
//            book.setBorrowed(true);
//            return save(book);
//        }
//        // Handle errors (e.g., book not found, book already borrowed, user not found)
//        return null;
//    }
//
//    public Book returnBook(Long bookId) {
//        Book book = findById(bookId);
//        if (book != null && book.isBorrowed()) {
//            book.setBorrowedBy(null);
//            book.setBorrowed(false);
//            return save(book);
//        }
//        // Handle errors (e.g., book not found, book not borrowed)
//        return null;
//    }

//    public List<Book> searchByTitle(String title) {
//        return bookRepository.findByTitleContainingIgnoreCase(title);
//    }

	
//
//	    @Autowired
//	    private BookRepository bookRepository;
//
//	    @Autowired
//	    private UserRepository userRepository;
//
//	    // Get all books
//	    public List<Book> findAll() {
//	        return bookRepository.findAll();
//	    }
//
//	    // Find book by ID
//	    public Book findById(Long id) {
//	        return bookRepository.findById(id).orElse(null);
//	    }
//
//	    // Save or update book
//	    public Book save(Book book) {
//	        return bookRepository.save(book);
//	    }
//
//	    // Delete book by ID
//	    public void deleteById(Long id) {
//	        bookRepository.deleteById(id);
//	    }
//
////	    // Borrow book
//public void borrowBook(Long bookId, Long userId, int quantity) {
//	        Book book = bookRepository.findById(bookId).orElse(null);
//	        User user = userRepository.findById(userId).orElse(null);
//
//	        if (book != null && user != null && book.getQuantity() >= quantity) {
//            // Reduce quantity
//	            book.setQuantity(book.getQuantity() - quantity);
//	            // Mark book as borrowed
//            book.setBorrowed(true);
//	            book.setBorrowedDate(new Date()); // Record the borrowed date
//          // Update user's borrowed books map
//	            user.getBorrowedBooks().put(bookId, quantity);
//
//	            bookRepository.save(book);
//	            userRepository.save(user);
//	        }
//	    }
//
//	    // Return book
//	    public void returnBook(Long bookId, Long userId) {
//	        Book book = bookRepository.findById(bookId).orElse(null);
//	        User user = userRepository.findById(userId).orElse(null);
//	        if (book != null && user != null && user.getBorrowedBooks().containsKey(bookId)) {
//	            int borrowedQuantity = user.getBorrowedBooks().remove(bookId); // Remove from user's borrowed books
//	            // Restore quantity
//	            book.setQuantity(book.getQuantity() + borrowedQuantity);
//           // Mark book as available
//	            book.setBorrowedDate(null);
//	            book.setBorrowed(false);
//	    bookRepository.save(book);
//	            userRepository.save(user);
//	        }
////	    }
	    public void borrowBook(Long bookId, Long userId, int quantity) {
	        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found."));
	        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));

	        if (book.getQuantity() >= quantity) {
	            book.setQuantity(book.getQuantity() - quantity);
	            book.setBorrowedDate(LocalDate.now());
	            book.setBorrowedBy(user);
	            bookRepository.save(book);

	            user.getBorrowedBooks().add(book);
	            userRepository.save(user);
	        } else {
	            throw new RuntimeException("Insufficient book quantity.");
	        }
	    }

	    public void returnBook(Long bookId, Long userId) {
	        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found."));
	        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));

	        if (user.getBorrowedBooks().contains(book)) {
	            book.setQuantity(book.getQuantity() + 1);
	            book.setReturnDate(LocalDate.now());
	            book.setBorrowedBy(null);
	            bookRepository.save(book);

	            user.getBorrowedBooks().remove(book);
	            userRepository.save(user);
	        } else {
	            throw new RuntimeException("This book was not borrowed by the user.");
	        }
	    }

	    // Search books by title
	    public List<Book> searchByTitle(String title) {
	        return bookRepository.findByTitleContainingIgnoreCase(title);
	    }
	
  }
	

