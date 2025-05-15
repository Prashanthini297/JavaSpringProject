package com.example.demolibrary.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demolibrary.model.Book;
import com.example.demolibrary.model.User;
import com.example.demolibrary.repository.BookRepository;
import com.example.demolibrary.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private  UserRepository userRepository;
	@Autowired
    private  BookRepository bookRepository;

    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public String borrowBook(Long userId, Long bookId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isPresent() && bookOpt.isPresent()) {
            User user = userOpt.get();
            Book book = bookOpt.get();

            if (book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                user.getBorrowedBooks().add(book);
                user.setBorrowedDate(new Date());
                bookRepository.save(book);
                userRepository.save(user);
                return "Book borrowed successfully!";
            } else {
                return "No stock available!";
            }
        }
        return "Invalid User or Book!";
    }

    public String returnBook(Long userId, Long bookId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isPresent() && bookOpt.isPresent()) {
            User user = userOpt.get();
            Book book = bookOpt.get();

            if (user.getBorrowedBooks().contains(book)) {
                book.setQuantity(book.getQuantity() + 1);
                user.getBorrowedBooks().remove(book);
                user.setReturnedDate(new Date());
                bookRepository.save(book);
                userRepository.save(user);
                return "Book returned successfully!";
            } else {
                return "Book not borrowed by user!";
            }
        }
        return "Invalid User or Book!";
    }
}

