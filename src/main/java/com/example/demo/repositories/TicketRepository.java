package com.example.demo.repositories;

import com.example.demo.moduls.Ticket_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket_,Integer> {
}
