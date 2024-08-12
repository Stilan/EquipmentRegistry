package com.example.equipmentregistry.service;


import com.example.equipmentregistry.model.Device;
import com.example.equipmentregistry.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public List<Device> getAllDeviceByName(String name) {
        return deviceRepository.findAllByName(name);
    }

    public List<Device> getAllDeviceByColor(String color) {
        return deviceRepository.findAllByColor(color);
    }

    public List<Device> searchPrice(double minPrice, double maxPrice) {
        return deviceRepository.findAllBySortByPrice(minPrice, maxPrice);
    }

    public List<Device> findAllByOrderByNameAsc(){
        return deviceRepository.findAllByOrderByNameAsc();
    }

    public List<Device> findAllByOrderByPriceAsc() {
        return deviceRepository.findAllByPriceAsc();
    }

    public List<Device> findAllByOrderByPriceDesc() {
        return deviceRepository.findAllByPriceDesc();
    }
}
