package com.example.equipmentregistry.controller;

import com.example.equipmentregistry.model.Refrigerator;
import com.example.equipmentregistry.service.RefrigeratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Refrigerator_methods")
@RestController
@RequestMapping("/refrigerator")
@RequiredArgsConstructor
public class RefrigeratorController {

    private final RefrigeratorService refrigeratorService;

    @Operation(
            summary = "Получить список холодильников",
            description = "Список всех холодильников"
    )
    @GetMapping("/refrigerators")
    public ResponseEntity<List<Refrigerator>> getAllComputers() {
        List<Refrigerator> refrigerators = refrigeratorService.getAllRefrigerators();
        return ResponseEntity.ok(refrigerators);
    }

    @Operation(
            summary = "Получить холодильник по id",
            description = "Получить холодильников по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Refrigerator> getComputerById(@PathVariable UUID id) {
        Refrigerator refrigerator = refrigeratorService.getRefrigeratorById(id);
        if (refrigerator != null) {
            return ResponseEntity.ok(refrigerator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Сохранить",
            description = "Сохраняет холодильник"
    )
    @PostMapping("/save")
    public ResponseEntity<Refrigerator> addComputer(@RequestBody Refrigerator refrigerator) {
        refrigeratorService.addRefrigerator(refrigerator);
        return ResponseEntity.status(201).body(refrigerator);
    }
}
