package com.example.equipmentregistry.service;

import com.example.equipmentregistry.model.Computer;
import com.example.equipmentregistry.model.Refrigerator;
import com.example.equipmentregistry.repository.RefrigeratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefrigeratorService {

    private final RefrigeratorRepository refrigeratorRepository;

    public List<Refrigerator> getAllRefrigerators() {
        return refrigeratorRepository.findAll();
    }

    public Refrigerator getRefrigeratorById(UUID id) {
        return refrigeratorRepository.findById(id).orElse(null);
    }

    public void addRefrigerator(Refrigerator refrigerator) {
        refrigeratorRepository.save(refrigerator);
    }
}
