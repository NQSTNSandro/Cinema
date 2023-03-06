package com.example.demo.controllers;

import com.example.demo.DTO.SessionDto;
import com.example.demo.moduls.Session;
import com.example.demo.services.SessionService;
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
@RequestMapping(value = "/v1/session", produces = "application/json")
@Tag(name = "SessionAPI", description = "Работа с сеансами")
@ResponseBody
public class SessionController {
    private final SessionService service;
    @Operation(
            operationId = "create",
            summary = "Создать новы  сеанс",
            tags = {"SessionAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания сессии")
            }
    )
    @RequestMapping(method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"})
    public ResponseEntity<Integer> save(@RequestBody SessionDto dto)
    {
        return ResponseEntity.ok(service.save(dto));
    }

    @Operation(
            operationId = "read",
            summary = "Прочитать список сеансов",
            tags = {"SessionAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Session.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения сеансов")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    public ResponseEntity<List<SessionDto>> read() {
        return ResponseEntity.ok(service.read());
    }
}
