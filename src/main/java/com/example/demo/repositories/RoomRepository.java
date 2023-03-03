package com.example.demo.repositories;

import com.example.demo.moduls.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
