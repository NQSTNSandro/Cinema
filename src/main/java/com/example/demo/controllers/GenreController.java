package com.example.demo.controllers;

import com.example.demo.DTO.GenreDto;
import com.example.demo.moduls.Booking;
import com.example.demo.moduls.Genre;
import com.example.demo.services.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/genre", produces = "application/json")
@Tag(name = "GenreApi", description = "Работа с жанрами")
@ResponseBody
public class GenreController extends ControllerInterface<GenreService, GenreDto> {
    public GenreController(GenreService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать новый жанр",
            tags = {"GenreApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания жанра")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody GenreDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список жанров",
            tags = {"GenreApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Genre.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка жанров")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<GenreDto>> read() {
        return super.read();
    }
    @Operation(
            operationId = "delete",
            summary = "Удалить жанр",
            tags = {"GenreApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка удаления жанра")
            }
    )
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/delete/{id}")
    @Override
    public ResponseEntity<Integer> delete(@PathVariable(name = "id")int id) {
        return super.delete(id);
    }
    @Operation(
            operationId = "update",
            summary = "Обновить информацию о жанре",
            tags = {"GenreApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка обновления жанра")
            }
    )

    @RequestMapping(method = RequestMethod.POST,
            value = "/update")
    @Override
    public ResponseEntity<Integer> update(@RequestBody GenreDto dto) {
        return super.update(dto);
    }
}
