package com.example.demo.repositories;


import com.example.demo.moduls.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Set;


public interface FilmRepository extends JpaRepository<Film,Integer> {
    @Query(value = "select id,title from film where id in("
            + "(select film_id from session where date between '2023-12-01' AND '2023-12-31' group by film_id having count(*)>=2)\n"
            + "intersect\n"
            + "(select film_id from session where date between '2024-01-01' AND '2024-01-31' group by film_id having count(*)>=2)\n"
            + "intersect\n"
            + "(select film_id from session where date between '2024-02-01' AND '2024-02-29' group by film_id having count(*)>=2))",
    nativeQuery = true)
    public Set<Object[]> winterFilms();
}
