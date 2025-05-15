package com.example.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LibrarymanagementApplication {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext();
		
		SpringApplication.run(LibrarymanagementApplication.class, args);
	}

}
