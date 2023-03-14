package com.example.demo.controllers;

import com.example.demo.DTO.BookingDto;
import com.example.demo.moduls.Booking;
import com.example.demo.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/booking", produces = "application/json")
@Tag(name = "BookingApi", description = "Работа с записями")
@ResponseBody
public class BookingController extends ControllerInterface<BookingService, BookingDto> {

    public BookingController(BookingService service) {
        super(service);
    }

    @Operation(
            operationId = "create",
            summary = "Создать новую запись",
            tags = {"BookingApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания записи")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody BookingDto dto) {
        return super.save(dto);
    }

    @Operation(
            operationId = "read",
            summary = "Прочитать список записей",
            tags = {"BookingApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения записи")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<BookingDto>> read() {
        return super.read();
    }

}
