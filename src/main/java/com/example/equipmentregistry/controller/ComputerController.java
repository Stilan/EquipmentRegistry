package com.example.equipmentregistry.controller;

import com.example.equipmentregistry.model.Computer;
import com.example.equipmentregistry.service.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Computer_methods")
@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @Operation(
            summary = "Получить список компьютеров",
            description = "Список всех компьютеров"
    )
    @GetMapping("/computers")
    public ResponseEntity<List<Computer>> getAllComputers() {
        List<Computer> computers = computerService.getAllComputers();
        return ResponseEntity.ok(computers);
    }

    @Operation(
            summary = "Получить компьютер по id",
            description = "Получить компьютер по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable UUID id) {
        Computer computer = computerService.getComputerById(id);
        if (computer != null) {
            return ResponseEntity.ok(computer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Сохранить",
            description = "Сохраняет компьютер"
    )
    @PostMapping("/save")
    public ResponseEntity<Computer> addComputer(@RequestBody Computer computer) {
        computerService.addComputer(computer);
        return ResponseEntity.status(201).body(computer);
    }
}
