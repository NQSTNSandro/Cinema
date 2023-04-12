package com.example.demo.controllers;

import com.example.demo.DTO.FilmDto;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/session", produces = "application/json")
@Tag(name = "SessionAPI", description = "Работа с сеансами")
@ResponseBody
public class SessionController extends ControllerInterface<SessionService,SessionDto> {
    public SessionController(SessionService service) {
        super(service);
    }



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
    @Override
    public ResponseEntity<Integer> save(@RequestBody SessionDto dto) {
        return super.save(dto);
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
    @Override
    public ResponseEntity<List<SessionDto>> read() {
        return super.read();
    }
    @Operation(
            operationId = "delete",
            summary = "Удалить сеанс",
            tags = {"SessionAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка удаления сеанса")
            }
    )
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/delete/{id}")
    @Override
    public ResponseEntity<Integer> delete(@PathVariable(name = "id")int id) {
        return super.delete(id);
    }
    @Operation(
            operationId = "update",
            summary = "Обновить информацию о сеансе",
            tags = {"SessionAPI"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка обновления сеанса")
            }
    )

    @RequestMapping(method = RequestMethod.POST,
            value = "/update")
    @Override
    public ResponseEntity<Integer> update(@RequestBody SessionDto dto) {
        return super.update(dto);
    }


}
