package com.example.equipmentregistry.repository;

import com.example.equipmentregistry.model.Refrigerator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefrigeratorRepository extends JpaRepository<Refrigerator, UUID> {
}
