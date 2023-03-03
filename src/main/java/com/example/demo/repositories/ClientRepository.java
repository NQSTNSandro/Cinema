package com.example.demo.repositories;

import com.example.demo.moduls.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
