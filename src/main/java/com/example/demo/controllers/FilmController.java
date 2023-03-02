package com.example.demo.controllers;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.moduls.Film;
import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/film", produces = "application/json", consumes = "application/json")
@ResponseBody
public class FilmController {
    private final FilmService service;

    @PostMapping("/add")
    public ResponseEntity<Integer> save(@RequestBody FilmDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Film>> read() {
        List<Film> list = service.read();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") int id, @RequestBody FilmDTO dto) {
        final boolean updated = service.update(dto, id);
        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = service.remove(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
