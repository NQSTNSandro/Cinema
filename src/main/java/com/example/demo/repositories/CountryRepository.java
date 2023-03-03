package com.example.demo.repositories;

import com.example.demo.moduls.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
