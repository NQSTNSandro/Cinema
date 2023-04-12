package com.example.demo.repositories;

import com.example.demo.DTO.FilmDto;
import com.example.demo.moduls.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session,Integer> {



}
