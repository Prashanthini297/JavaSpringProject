package com.example.demolibrary.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demolibrary.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
