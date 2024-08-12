package com.example.equipmentregistry.repository;

import com.example.equipmentregistry.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SmartphoneRepository extends JpaRepository<Smartphone, UUID> {
}
