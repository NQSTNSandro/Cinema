package com.example.demo.controllers;

import com.example.demo.DTO.ClientDto;
import com.example.demo.moduls.Client;
import com.example.demo.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/client", produces = "application/json")
@Tag(name = "ClientApi", description = "Работа с заказчиками")
@ResponseBody
public class ClientController extends ControllerInterface<ClientService, ClientDto> {
    public ClientController(ClientService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать нового заказчика",
            tags = {"ClientApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания заказчика")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody ClientDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список заказчиков",
            tags = {"ClientApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка заказчиков")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<ClientDto>> read() {
        return super.read();
    }


}
