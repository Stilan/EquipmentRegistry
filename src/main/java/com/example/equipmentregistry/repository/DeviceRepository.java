package com.example.equipmentregistry.repository;

import com.example.equipmentregistry.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {

    @Query("SELECT t FROM Device t where t.name LIKE %:name%")
    List<Device> findAllByName(String name);

    @Query("SELECT t FROM Device t where t.color LIKE %:color%")
    List<Device> findAllByColor(String color);

    @Query("SELECT t FROM Device t WHERE (:minPrice IS NULL OR t.price >= :minPrice) " +
            " AND (:maxPrice IS NULL OR t.price <= :maxPrice) ")
    List<Device> findAllBySortByPrice(@Param("minPrice") double minPrice,
                                        @Param("maxPrice") double maxPrice);

    List<Device> findAllByOrderByNameAsc();

    @Query("SELECT t FROM Device t ORDER BY t.price ASC")
    List<Device> findAllByPriceAsc();

    @Query("SELECT t FROM Device t ORDER BY t.price DESC")
    List<Device> findAllByPriceDesc();

}
