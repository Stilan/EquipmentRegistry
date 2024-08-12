package com.example.equipmentregistry.service;

import com.example.equipmentregistry.model.Computer;
import com.example.equipmentregistry.model.VacuumCleaner;
import com.example.equipmentregistry.repository.VacuumCleanerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VacuumCleanerService {

    private final VacuumCleanerRepository vacuumCleanerRepository;

    public List<VacuumCleaner> getAllVacuumCleaners() {
        return vacuumCleanerRepository.findAll();
    }

    public VacuumCleaner getVacuumCleanerById(UUID id) {
        return vacuumCleanerRepository.findById(id).orElse(null);
    }

    public void addVacuumCleaner(VacuumCleaner vacuumCleaner) {
        vacuumCleanerRepository.save(vacuumCleaner);
    }
}
