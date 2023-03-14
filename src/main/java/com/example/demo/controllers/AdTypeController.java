package com.example.demo.controllers;

import com.example.demo.DTO.AdTypeDto;
import com.example.demo.moduls.AdType;
import com.example.demo.services.AdTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/adType", produces = "application/json")
@Tag(name="AdTypeApi",description = "Работа с категориями рекламы")
@ResponseBody
public class AdTypeController extends ControllerInterface<AdTypeService, AdTypeDto> {
    @Operation(
            operationId = "create",
            summary = "Создать новую категорию рекламы",
            tags = {"AdTypeApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания категории")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody AdTypeDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список категорий",
            tags = {"AdTypeApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AdType.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения категорий")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<AdTypeDto>> read() {
        return super.read();
    }

    public AdTypeController(AdTypeService service) {
        super(service);
    }
}
