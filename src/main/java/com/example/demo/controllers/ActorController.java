package com.example.demo.controllers;

import com.example.demo.DTO.ActorDto;
import com.example.demo.services.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/actor", produces = "application/json")
@Tag(name = "ActorAPI", description = "Работа с актерами")
@ResponseBody
public class ActorController {
    private final ActorService service;
    @Operation(
            operationId = "create",
            summary = "Создать нового актера",
            tags = {"ActorAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания актера")
            }
    )
    @RequestMapping(method = RequestMethod.POST, value = "/create",consumes = {"application/json"})
    public ResponseEntity<Integer> save(@RequestBody ActorDto dto){return ResponseEntity.ok(service.addActor(dto));
    }
}
