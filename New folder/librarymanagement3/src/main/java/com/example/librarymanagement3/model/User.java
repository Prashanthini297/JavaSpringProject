package com.example.librarymanagement3.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users1")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
 
    private Book book; // Mapping to the borrowed book
 
    private int borrowedQuantity;
    private LocalDate borrowDate;
    private LocalDate returnDate;
 
    // Getters and Setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Book getBook() {
        return book;
    }
 
    public void setBook(Book book) {
        this.book = book;
    }
 
    public int getBorrowedQuantity() {
        return borrowedQuantity;
    }
 
    public void setBorrowedQuantity(int borrowedQuantity) {
        this.borrowedQuantity = borrowedQuantity;
    }
 
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
 
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
 
    public LocalDate getReturnDate() {
        return returnDate;
    }
 
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

 
 
