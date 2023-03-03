package com.example.demo.repositories;

import com.example.demo.moduls.Session_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session_,Integer> {
}
