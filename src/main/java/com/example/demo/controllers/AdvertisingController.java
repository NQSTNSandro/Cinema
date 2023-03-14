package com.example.demo.controllers;

import com.example.demo.DTO.AdvertisingDto;
import com.example.demo.moduls.AdType;
import com.example.demo.moduls.Advertising;
import com.example.demo.services.AdvertisingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/advertising", produces = "application/json")
@Tag(name = "AdvertisingApi", description = "Работа с рекламой")
@ResponseBody
public class AdvertisingController extends ControllerInterface<AdvertisingService, AdvertisingDto> {

    public AdvertisingController(AdvertisingService service) {
        super(service);
    }

    @Operation(
            operationId = "create",
            summary = "Создать новую рекламу",
            tags = {"AdvertisingApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody AdvertisingDto dto) {
        return super.save(dto);
    }

    @Operation(
            operationId = "read",
            summary = "Прочитать список реклам",
            tags = {"AdvertisingApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Advertising.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<AdvertisingDto>> read() {
        return super.read();
    }


}
