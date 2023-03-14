package com.example.demo.controllers;

import com.example.demo.DTO.CountryDto;
import com.example.demo.moduls.Booking;
import com.example.demo.moduls.Country;
import com.example.demo.services.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/country", produces = "application/json")
@Tag(name = "CountryApi", description = "Работа со странами")
@ResponseBody
public class CountryController extends ControllerInterface<CountryService, CountryDto> {
    public CountryController(CountryService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать новую страну",
            tags = {"CountryApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания страны")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody CountryDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список стран",
            tags = {"CountryApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Country.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка стран")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<CountryDto>> read() {
        return super.read();
    }
}
