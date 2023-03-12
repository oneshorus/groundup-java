package com.wawansetiawan.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wawansetiawan.machine.entity.AnomalyLevelEntity;

public interface AnomalyLevelRepository extends JpaRepository<AnomalyLevelEntity, Long>{
    
}
