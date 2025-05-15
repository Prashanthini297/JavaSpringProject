package com.example.demolibrary.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demolibrary.model.Book;
public interface BookRepository extends JpaRepository<Book, Long>{

}
