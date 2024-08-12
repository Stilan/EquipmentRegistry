package com.example.equipmentregistry.controller;

import com.example.equipmentregistry.model.Device;
import com.example.equipmentregistry.service.DeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Device_methods")
@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/searchName")
    public ResponseEntity<List<Device>> getAllDevices(@RequestParam String name) {
        List<Device> devices = deviceService.getAllDeviceByName(name);
        return ResponseEntity.ok(devices);
    }

    @GetMapping("searchColor")
    public ResponseEntity<List<Device>> getAllDevicesOrColor(@RequestParam String color) {
        List<Device> devices = deviceService.getAllDeviceByColor(color);
        return ResponseEntity.ok(devices);
    }

    @GetMapping("searchPrice")
    public ResponseEntity<List<Device>> searchPrice( @RequestParam(required = false) double minPrice,
                                                     @RequestParam(required = false) double maxPrice) {
        List<Device> devices = deviceService.searchPrice(minPrice, maxPrice);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("sortAlphabetically")
    public ResponseEntity<List<Device>> sortAlphabetically() {
        List<Device> devices = deviceService.findAllByOrderByNameAsc();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("sortAscending")
    public ResponseEntity<List<Device>> sortAscending() {
        List<Device> devices = deviceService.findAllByOrderByPriceAsc();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("sortDescending")
    public ResponseEntity<List<Device>> sortDescending() {
        List<Device> devices = deviceService.findAllByOrderByPriceDesc();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

}