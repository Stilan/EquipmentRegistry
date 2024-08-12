package com.example.equipmentregistry.repository;

import com.example.equipmentregistry.model.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, UUID> {
}
