package com.example.librarymanagement3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagement3.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}