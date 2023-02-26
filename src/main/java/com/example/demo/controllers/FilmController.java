package com.example.demo.controllers;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/film", produces = "application/json",consumes ="application/json" )
@ResponseBody
public class FilmController {
    private final FilmService service;

    @PostMapping("add")
    public ResponseEntity<Integer> save(@RequestBody FilmDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }



}
