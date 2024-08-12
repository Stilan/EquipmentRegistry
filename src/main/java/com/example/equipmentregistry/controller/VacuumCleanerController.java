package com.example.equipmentregistry.controller;

import com.example.equipmentregistry.model.VacuumCleaner;
import com.example.equipmentregistry.service.VacuumCleanerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "VacuumCleaner_methods")
@RestController
@RequestMapping("/vacuumCleaner")
@RequiredArgsConstructor
public class VacuumCleanerController {

    private final VacuumCleanerService vacuumCleanerService;

    @Operation(
            summary = "Получить список пылесосов",
            description = "Список всех пылесосов"
    )
    @GetMapping("/VacuumCleaners")
    public ResponseEntity<List<VacuumCleaner>> getAllTelevisions() {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getAllVacuumCleaners();
        return ResponseEntity.ok(vacuumCleaners);
    }

    @Operation(
            summary = "Получить пылесос по id",
            description = "Получить пылесос по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<VacuumCleaner> getTelevisionById(@PathVariable UUID id) {
        VacuumCleaner vacuumCleaner = vacuumCleanerService.getVacuumCleanerById(id);
        if (vacuumCleaner != null) {
            return ResponseEntity.ok(vacuumCleaner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Сохранить",
            description = "Сохраняет пылесос"
    )
    @PostMapping("/save")
    public ResponseEntity<VacuumCleaner> addTelevision(@RequestBody VacuumCleaner vacuumCleaner) {
        vacuumCleanerService.addVacuumCleaner(vacuumCleaner);
        return ResponseEntity.status(201).body(vacuumCleaner);
    }
}
