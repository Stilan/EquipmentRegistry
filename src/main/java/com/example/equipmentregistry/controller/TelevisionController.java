package com.example.equipmentregistry.controller;

import com.example.equipmentregistry.model.Television;
import com.example.equipmentregistry.service.TelevisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Television_methods")
@RestController
@RequestMapping("/television")
@RequiredArgsConstructor
public class TelevisionController {

    private final TelevisionService televisionService;

    @Operation(
            summary = "Получить список телевизоров",
            description = "Список всех телевизоров"
    )
    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        List<Television> televisions = televisionService.getAllTelevisions();
        return ResponseEntity.ok(televisions);
    }

    @Operation(
            summary = "Получить телевизор по id",
            description = "Получить телевизор по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable UUID id) {
        Television television = televisionService.getTelevisionById(id);
        if (television != null) {
            return ResponseEntity.ok(television);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Сохранить",
            description = "Сохраняет телевизор"
    )
    @PostMapping("/save")
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        televisionService.addTelevision(television);
        return ResponseEntity.status(201).body(television);
    }
}
