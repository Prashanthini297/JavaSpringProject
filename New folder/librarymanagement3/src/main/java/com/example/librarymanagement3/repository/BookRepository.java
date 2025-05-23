package com.example.librarymanagement3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagement3.model.Book;


@Repository 
public interface BookRepository extends JpaRepository<Book, Long> {
	 List<Book> findByTitleContainingIgnoreCase(String title);
	
}