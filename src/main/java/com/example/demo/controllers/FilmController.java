package com.example.demo.controllers;

import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Film")
@ResponseBody
public class FilmController {
@Autowired
    private final FilmService service;
    public void save(){
    service.save();
}



}
