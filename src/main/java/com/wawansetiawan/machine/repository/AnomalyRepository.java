package com.wawansetiawan.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wawansetiawan.machine.entity.AnomalyEntity;

public interface AnomalyRepository extends JpaRepository<AnomalyEntity, Long> {
    
}
