package com.example.equipmentregistry.service;

import com.example.equipmentregistry.model.Smartphone;
import com.example.equipmentregistry.repository.SmartphoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;

    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    public Smartphone getSmartphoneById(UUID id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    public void addSmartphone(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }
}
