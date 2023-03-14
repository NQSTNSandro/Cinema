package com.example.demo.controllers;

import com.example.demo.DTO.RowDto;
import com.example.demo.moduls.Booking;
import com.example.demo.moduls.Row;
import com.example.demo.services.RowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/row", produces = "application/json")
@Tag(name = "RowApi", description = "Работа с рядами")
@ResponseBody
public class RowController extends ControllerInterface<RowService, RowDto> {
    public RowController(RowService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать новый ряд",
            tags = {"RowApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания ряда")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody RowDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список рядов",
            tags = {"RowApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Row.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка рядов")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<RowDto>> read() {
        return super.read();
    }
}
