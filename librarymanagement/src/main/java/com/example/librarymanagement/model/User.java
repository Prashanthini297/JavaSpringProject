package com.example.librarymanagement.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class User {
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	private String name;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @OneToMany(mappedBy = "borrowedBy", cascade = CascadeType.ALL)
	    private List<Book> borrowedBooks = new ArrayList<>();

	    public User() {}

	    @Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", borrowedBooks=" + borrowedBooks + "]";
		}

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

		public List<Book> getBorrowedBooks() {
			return borrowedBooks;
		}

		public void setBorrowedBooks(List<Book> borrowedBooks) {
			this.borrowedBooks = borrowedBooks;
		}

		public User(String name) {
	        this.name = name;
	    }

	    // Getters and Setters
	    // toString() method
	
	}

