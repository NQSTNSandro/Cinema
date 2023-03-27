package com.example.demo.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/", produces = "text/html")
@ResponseBody
public class IndexController {
    @SneakyThrows
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<String> save(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("html/index.html")).getFile());
        return ResponseEntity.ok(Files.readString(file.toPath()));
    }
}
