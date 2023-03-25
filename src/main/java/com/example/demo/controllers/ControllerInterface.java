package com.example.demo.controllers;

import com.example.demo.services.ServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ControllerInterface<S extends ServiceInterface,D> {
    private final S service;

    public ResponseEntity<Integer> save(D dto){
        return ResponseEntity.ok(service.save(dto));
    }
    public ResponseEntity<List<D>> read() {
        return ResponseEntity.ok(service.read());
    }

    public ResponseEntity<Integer> delete(int id){
        return ResponseEntity.ok(service.remove(id));
    }

    public ResponseEntity<Integer> update(D dto){
        return ResponseEntity.ok(service.update(dto));
    }

}
