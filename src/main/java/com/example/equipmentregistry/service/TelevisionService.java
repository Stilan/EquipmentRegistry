package com.example.equipmentregistry.service;


import com.example.equipmentregistry.model.Television;
import com.example.equipmentregistry.repository.TelevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevisionById(UUID id) {
        return televisionRepository.findById(id).orElse(null);
    }

    public void addTelevision(Television television) {
        televisionRepository.save(television);
    }

}
