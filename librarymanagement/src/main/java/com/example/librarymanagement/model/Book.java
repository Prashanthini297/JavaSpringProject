package com.example.librarymanagement.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//	public boolean isBorrowed() {
//		return borrowed;
//	}
//	public void setBorrowed(boolean borrowed) {
//		this.borrowed = borrowed;
//	}
//	public User getBorrowedBy() {
//		return borrowedBy;
//	}
//	public void setBorrowedBy(User borrowedBy) {
//		this.borrowedBy = borrowedBy;
//	}
//	private String title;
//    private String author;
//    private boolean borrowed;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User borrowedBy;
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", borrowed=" + borrowed + ", borrowedBy="
//				+ borrowedBy + "]";
//	}



	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String title;

	    @Column(nullable = false)
	    private String author;

	    @Column(nullable = false)
	    private int quantity;

	    @Column
	    private LocalDate borrowedDate;

	    @Column
	    private LocalDate returnDate;

	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public LocalDate getBorrowedDate() {
			return borrowedDate;
		}

		public void setBorrowedDate(LocalDate borrowedDate) {
			this.borrowedDate = borrowedDate;
		}

		public LocalDate getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
		}

		public User getBorrowedBy() {
			return borrowedBy;
		}

		public void setBorrowedBy(User borrowedBy) {
			this.borrowedBy = borrowedBy;
		}

		@ManyToOne
	    @JoinColumn(name = "user_id")
	    private User borrowedBy; // User who borrowed the book

	    public Book() {}

	    public Book(String title, String author, int quantity) {
	        this.title = title;
	        this.author = author;
	        this.quantity = quantity;
	    }


	    // Getters and Setters
	    // toString() method for better readability
	}
    
	
