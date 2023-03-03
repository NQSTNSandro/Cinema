package com.example.demo.controllers;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.moduls.Film;
import com.example.demo.services.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/film", produces = "application/json")
@Tag(name = "CinemaAPI", description = "Работа с фильмами")
@ResponseBody
public class FilmController {
    private final FilmService service;

    @Operation(
            operationId = "create",
            summary = "Создать новый фильм",
            tags = {"CinemaAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания фильма")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    public ResponseEntity<Integer> save(@RequestBody FilmDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Operation(
            operationId = "read",
            summary = "Прочитать список фильмов",
            tags = {"CinemaAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Film.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения фильмов")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    public ResponseEntity<List<Film>> read() {
        return ResponseEntity.ok(service.read());
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody FilmDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Integer> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(service.remove(id));
    }


}
