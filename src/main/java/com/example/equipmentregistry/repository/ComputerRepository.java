package com.example.equipmentregistry.repository;

import com.example.equipmentregistry.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerRepository extends JpaRepository<Computer, UUID> {
}
