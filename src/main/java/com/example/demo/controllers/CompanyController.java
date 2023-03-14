package com.example.demo.controllers;

import com.example.demo.DTO.CompanyDto;
import com.example.demo.moduls.Company;
import com.example.demo.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/Company", produces = "application/json")
@Tag(name = "CompanyApi", description = "Работа с кампаниями")
@ResponseBody
public class CompanyController extends ControllerInterface<CompanyService, CompanyDto> {
    public CompanyController(CompanyService service) {
        super(service);
    }
    @Operation(
            operationId = "create",
            summary = "Создать новую кампанию",
            tags = {"CompanyApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка создания кампании")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/create",
            consumes = {"application/json"}
    )
    @Override
    public ResponseEntity<Integer> save(@RequestBody CompanyDto dto) {
        return super.save(dto);
    }
    @Operation(
            operationId = "read",
            summary = "Прочитать список кампаний",
            tags = {"CompanyApi"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Company.class))
                    }),
                    @ApiResponse(responseCode = "5XX", description = "Ошибка чтения списка кампаний")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/read"
    )
    @Override
    public ResponseEntity<List<CompanyDto>> read() {
        return super.read();
    }
}
