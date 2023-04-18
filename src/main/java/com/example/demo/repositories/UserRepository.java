package com.example.demo.repositories;

import com.example.demo.moduls.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
