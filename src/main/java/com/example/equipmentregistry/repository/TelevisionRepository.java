package com.example.equipmentregistry.repository;

import com.example.equipmentregistry.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelevisionRepository extends JpaRepository<Television, UUID> {
}
