package com.example.demo.controllers;

import com.example.demo.DTO.RoomDto;
import com.example.demo.moduls.Booking;
import com.example.demo.moduls.Room;
import com.example.demo.services.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/room", produces = "application/json")
@Tag(name = "RoomApi", description = "Работа с залами")
@ResponseBody
public class RoomController extends ControllerInterface<RoomService, RoomDto> {
    public RoomController(RoomService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать новый зал",
            tags = {"RoomApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания зала")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody RoomDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список залов",
            tags = {"RoomApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Room.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка залов")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<RoomDto>> read() {
        return super.read();
    }
}
