package com.example.equipmentregistry.service;

import com.example.equipmentregistry.model.Computer;
import com.example.equipmentregistry.model.Smartphone;
import com.example.equipmentregistry.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer getComputerById(UUID id) {
        return computerRepository.findById(id).orElse(null);
    }

    public void addComputer(Computer computer) {
        computerRepository.save(computer);
    }
}
