package com.example.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.librarymanagement.model.Book;
@Repository 
public interface BookRepository extends JpaRepository<Book, Long> {
	 List<Book> findByTitleContainingIgnoreCase(String title);
	
}