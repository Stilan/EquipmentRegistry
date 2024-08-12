package com.example.equipmentregistry.controller;

import com.example.equipmentregistry.model.Smartphone;
import com.example.equipmentregistry.service.SmartphoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Smartphone_methods")
@RestController
@RequestMapping("/smartphone")
@RequiredArgsConstructor
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    @Operation(
            summary = "Получить список смартфонов",
            description = "Список всех смартфонов"
    )
    @GetMapping("/smartphones")
    public ResponseEntity<List<Smartphone>> getAllSmartphones() {
        List<Smartphone> smartphones = smartphoneService.getAllSmartphones();
        return ResponseEntity.ok(smartphones);
    }

    @Operation(
            summary = "Получить смартфон по id",
            description = "Получить смартфон по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> getSmartphoneById(@PathVariable UUID id) {
        Smartphone smartphone = smartphoneService.getSmartphoneById(id);
        if (smartphone != null) {
            return ResponseEntity.ok(smartphone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Сохранить",
            description = "Сохраняет смартфон"
    )
    @PostMapping("/save")
    public ResponseEntity<Smartphone> addSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneService.addSmartphone(smartphone);
        return ResponseEntity.status(201).body(smartphone);
    }
}
