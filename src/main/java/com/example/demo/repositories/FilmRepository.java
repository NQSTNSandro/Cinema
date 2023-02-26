package com.example.demo.repositories;

import com.example.demo.moduls.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Integer> {
}
