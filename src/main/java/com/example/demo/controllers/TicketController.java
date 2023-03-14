package com.example.demo.controllers;

import com.example.demo.DTO.TicketDto;
import com.example.demo.moduls.Booking;
import com.example.demo.moduls.Ticket;
import com.example.demo.services.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/ticket", produces = "application/json")
@Tag(name = "TicketApi", description = "Работа с билетами")
@ResponseBody
public class TicketController extends ControllerInterface<TicketService, TicketDto> {
    public TicketController(TicketService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать новый билет",
            tags = {"TicketApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания билета")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody TicketDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список билетов",
            tags = {"TicketApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка билетов")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<TicketDto>> read() {
        return super.read();
    }
}
