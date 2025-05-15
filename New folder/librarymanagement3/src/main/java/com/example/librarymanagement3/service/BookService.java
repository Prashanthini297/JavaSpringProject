package com.example.librarymanagement3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement3.model.Book;
import com.example.librarymanagement3.repository.BookRepository;

import java.util.List;
@Service
public class BookService {
 
    @Autowired
    private BookRepository bookRepository;
 
    public List<Book> getAllBooks() {

        return bookRepository.findAll();

    }
 
    public List<Book> searchBooksByTitle(String title) {

        return bookRepository.findByTitleContainingIgnoreCase(title);

    }
 
    public void updateBookQuantity(Long id, int quantity) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        book.setQuantity(quantity);

        bookRepository.save(book);

    }

}

 
	

